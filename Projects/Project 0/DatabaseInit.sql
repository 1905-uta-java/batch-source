/* Create Banking Database */

--CREATE USER project0
--IDENTIFIED BY yO60$qKFo#RT
--DEFAULT TABLESPACE users
--TEMPORARY TABLESPACE temp
--QUOTA 10M ON users;

--GRANT connect to project0;
--GRANT resource to project0;
--GRANT create session TO project0;
--GRANT create table TO project0;
--GRANT create view TO project0;

--conn project0/yO60$qKFo#RT;
--/

/* Create Tables */

CREATE TABLE BANK_USER(
    USERNAME VARCHAR2(60) NOT NULL,
    EMAIL VARCHAR2(60) NOT NULL,
    PASS_HASH RAW(100) NOT NULL,
    PASS_SALT RAW(100) NOT NULL,
    CONSTRAINT PK_USER PRIMARY KEY (USERNAME)
);

CREATE TABLE BANK_ACCOUNT(
    ACCOUNT_ID NUMBER NOT NULL,
    CURRENT_BAL NUMBER DEFAULT 0 NOT NULL,
    CONSTRAINT PK_ACCOUNT PRIMARY KEY (ACCOUNT_ID)
);

CREATE TABLE USER_ACCESS(
    ACCOUNT_ID NUMBER NOT NULL,
    USERNAME VARCHAR2(60) NOT NULL,
    CONSTRAINT PK_USER_ACCESS PRIMARY KEY (ACCOUNT_ID, USERNAME)
);

CREATE TABLE TRANSACTION(
    TRANSACTION_ID NUMBER NOT NULL,
    TRANSACTION_TYPE VARCHAR2(60) NOT NULL,
    AMOUNT NUMBER DEFAULT(0) NOT NULL,
    FROM_ACCOUNT NUMBER,
    TO_ACCOUNT NUMBER,
    CONSTRAINT PK_TRANSACTION PRIMARY KEY (TRANSACTION_ID),
    CONSTRAINT TRANSACTION_TYPE_RESTRICTION CHECK (
           TRANSACTION_TYPE = 'DEPOSIT' AND TO_ACCOUNT IS NOT NULL
        OR TRANSACTION_TYPE = 'WITHDRAWAL' AND FROM_ACCOUNT IS NOT NULL
        OR TRANSACTION_TYPE = 'TRANSFER' AND FROM_ACCOUNT IS NOT NULL AND TO_ACCOUNT IS NOT NULL
    ),
    CONSTRAINT TRANSACTION_AMOUNT_POSITIVE CHECK (AMOUNT > 0)
);

/* Foreign Key Constraints */

ALTER TABLE USER_ACCESS
    ADD CONSTRAINT FK_USER_ACCESS_USERNAME
    FOREIGN KEY (USERNAME) REFERENCES BANK_USER (USERNAME);

ALTER TABLE USER_ACCESS
    ADD CONSTRAINT FK_USER_ACCESS_ACCOUNT_ID
    FOREIGN KEY (ACCOUNT_ID) REFERENCES BANK_ACCOUNT (ACCOUNT_ID);

-- forgot this constraint
ALTER TABLE BANK_ACCOUNT
    ADD CONSTRAINT BANK_ACCOUNT_NON_ZERO_BAL
    CHECK (CURRENT_BAL >= 0);

/
/* Create Stored Procedures */

CREATE OR REPLACE FUNCTION GET_BALANCE(CHECK_ACCOUNT_ID IN NUMBER)
RETURN NUMBER
IS
    BALANCE NUMBER;
BEGIN
    SELECT CURRENT_BAL
        INTO BALANCE
        FROM BANK_ACCOUNT
        WHERE ACCOUNT_ID = CHECK_ACCOUNT_ID;
    
    RETURN BALANCE;
END;
/

CREATE OR REPLACE PROCEDURE ADD_TRANSACTION(NEW_TRANSACTION_TYPE IN VARCHAR2, NEW_AMOUNT IN NUMBER, NEW_FROM_ACCOUNT IN NUMBER, NEW_TO_ACCOUNT IN NUMBER, NEW_ID OUT NUMBER)
IS
BEGIN
    SELECT COALESCE(MAX(TRANSACTION_ID), 0) + 1
        INTO NEW_ID
        FROM TRANSACTION;
    
    INSERT
        INTO TRANSACTION
        VALUES(NEW_ID, NEW_TRANSACTION_TYPE, NEW_AMOUNT, NEW_FROM_ACCOUNT, NEW_TO_ACCOUNT);
END;
/

--CREATE OR REPLACE PROCEDURE WITHDRAW(TARGET_ACCOUNT_ID IN NUMBER, AMOUNT IN NUMBER)
--IS
--    BAL_TO_CHANGE NUMBER;
--    TRANSACTION_ID NUMBER;
--BEGIN
--    BAL_TO_CHANGE := GET_BALANCE(TARGET_ACCOUNT_ID);
--    
--    ADD_TRANSACTION('WITHDRAWAL', AMOUNT, TARGET_ACCOUNT_ID, NULL, TRANSACTION_ID);
--    
--    UPDATE BANK_ACCOUNT
--        SET CURRENT_BAL = BAL_TO_CHANGE - AMOUNT
--        WHERE ACCOUNT_ID = TARGET_ACCOUNT_ID;
--    
--    COMMIT;
--END;
--/
--
--CREATE OR REPLACE PROCEDURE DEPOSIT(TARGET_ACCOUNT_ID IN NUMBER, AMOUNT IN NUMBER)
--IS
--    BAL_TO_CHANGE NUMBER;
--    TRANSACTION_ID;
--BEGIN
--    BAL_TO_CHANGE := GET_BALANCE(TARGET_ACCOUNT_ID);
--    
--    ADD_TRANSACTION('DEPOSIT', AMOUNT, NULL, TARGET_ACCOUNT_ID);
--    
--    UPDATE BANK_ACCOUNT
--        SET CURRENT_BAL = BAL_TO_CHANGE + AMOUNT
--        WHERE ACCOUNT_ID = TARGET_ACCOUNT_ID;
--    
--    COMMIT;
--END;
--/
--
--CREATE OR REPLACE PROCEDURE TRANSFER(FROM_ACCOUNT IN NUMBER, TO_ACCOUNT IN NUMBER, AMOUNT IN NUMBER)
--IS
--    ACCOUNT_EXISTS NUMBER;
--    FROM_BAL NUMBER;
--    TO_BAL NUMBER;
--BEGIN
--    FROM_BAL := GET_BALANCE(FROM_ACCOUNT);
--    TO_BAL := GET_BALANCE(TO_ACCOUNT);
--    
--    ADD_TRANSACTION('TRANSFER', AMOUNT, FROM_ACCOUNT, TO_ACCOUNT);
--    
--    UPDATE BANK_ACCOUNT
--        SET CURRENT_BAL = FROM_BAL - AMOUNT
--        WHERE ACCOUNT_ID = FROM_ACCOUNT;
--    
--    UPDATE BANK_ACCOUNT
--        SET CURRENT_BAL = TO_BAL + AMOUNT
--        WHERE ACCOUNT_ID = TO_ACCOUNT;
--    
--    COMMIT;
--END;
--/

CREATE OR REPLACE PROCEDURE CREATE_NEW_ACCOUNT(NEW_ID OUT NUMBER)
IS
BEGIN
    SELECT COALESCE(MAX(ACCOUNT_ID), 0) + 1
        INTO NEW_ID
        FROM BANK_ACCOUNT;
        
    INSERT
        INTO BANK_ACCOUNT
        VALUES(NEW_ID, 0);
END;
/

CREATE OR REPLACE PROCEDURE CREATE_NEW_ACCOUNT_FOR_USER(USERNAME IN VARCHAR2, ACCOUNT_ID OUT NUMBER)
IS
BEGIN
    CREATE_NEW_ACCOUNT(ACCOUNT_ID);
    
    GRANT_USER_ACCESS(ACCOUNT_ID, USERNAME);
    
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE CREATE_NEW_USER(NEW_USERNAME IN VARCHAR2, NEW_EMAIL IN VARCHAR2, NEW_PASS_HASH IN RAW, NEW_PASS_SALT IN RAW)
IS
    ACCOUNT_ID NUMBER;
BEGIN
    INSERT
        INTO BANK_USER
        VALUES(NEW_USERNAME, NEW_EMAIL, NEW_PASS_HASH, NEW_PASS_SALT);
    
    CREATE_NEW_ACCOUNT_FOR_USER(NEW_USERNAME, ACCOUNT_ID);
END;
/

CREATE OR REPLACE PROCEDURE GRANT_USER_ACCESS(ACCOUNT_ID IN NUMBER, USERNAME IN VARCHAR2)
IS
BEGIN
    INSERT
        INTO USER_ACCESS
        VALUES(ACCOUNT_ID, USERNAME);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE DELETE_USER(USERNAME_TO_DELETE IN VARCHAR2)
IS
BEGIN
    DELETE
        FROM USER_ACCESS
        WHERE USERNAME = USERNAME_TO_DELETE;
    
    DELETE
        FROM BANK_USER
        WHERE USERNAME = USERNAME_TO_DELETE;
    
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE DELETE_ACCOUNT(ACCOUNT_TO_DELETE_ID IN NUMBER)
IS
BEGIN
    DELETE
        FROM USER_ACCESS
        WHERE ACCOUNT_ID = ACCOUNT_TO_DELETE_ID;
    
    DELETE
        FROM BANK_ACCOUNT
        WHERE ACCOUNT_ID = ACCOUNT_TO_DELETE_ID;
END;
/