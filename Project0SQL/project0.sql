CREATE TABLE USERACCOUNT(
    USERID NUMBER NOT NULL,
    USERNAME VARCHAR2 (15) NOT NULL,
    USERPASS VARCHAR2 (15) NOT NULL,
    CONSTRAINT USERFK
    FOREIGN KEY (USERID) REFERENCES CUSTOMER (CUSTOMERID)
);

CREATE TABLE CUSTOMER (
    CUSTOMERID NUMBER NOT NULL,
    FIRSTNAME VARCHAR2 (15) NOT NULL,
    LASTNAME VARCHAR2 (20) NOT NULL,
    EMAIL VARCHAR2 (50) NOT NULL,
    BIRTHDATE DATE NOT NULL,
    ADDRESS VARCHAR2 (50) NOT NULL,
    STREET VARCHAR (20) NOT NULL,
    CITY VARCHAR (20) NOT NULL,
    ASTATE VARCHAR (2) NOT NULL,
    ZIP NUMBER (5) NOT NULL,
    SS NUMBER (9) NOT NULL,
    CONSTRAINT CUSTOMERPK PRIMARY KEY (CUSTOMERID)
);



CREATE TABLE ACCOUNTS (
    CUSTOMERID NUMBER NOT NULL,
    ACCOUNTNUM NUMBER NOT NULL,
    ACCOUNTTYPE VARCHAR2 (10) NOT NULL,
    ACCOUNTBALANCE NUMBER NOT NULL,
    CONSTRAINT ACCOUNTSFK
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER (CUSTOMERID),
    CONSTRAINT ACCOUNTPK PRIMARY KEY (ACCOUNTNUM)
);

drop table transactionlog;
drop table accounts;
drop table useraccount;
drop table customer;

CREATE TABLE TRANSACTIONLOG (
    ACCOUNTNUM NUMBER NOT NULL,
    TRANSTYPE VARCHAR (15) NOT NULL,
    TRANSTIME DATE NOT NULL,
    CONSTRAINT TRANSACTIONLOGFK
    FOREIGN KEY (ACCOUNTNUM) REFERENCES ACCOUNTS (ACCOUNTNUM)
);

INSERT INTO CUSTOMER VALUES (1, 'Nissa', 'Blackey', 'nblackey0@techcrunch.com', '23-DEC-75', '280',
    'Service Crossing', 'Seattle', 'WA', 98140, 638552911, 0000001);
INSERT INTO CUSTOMER  VALUES (2, 'Nefen', 'Wenden', 'nwenden1@wired.com', '10-JULY-88', 36680, 
    'Eastwood Park', 'Evansville', 'IN', 47725, 970903914, 9167399);
INSERT INTO CUSTOMER VALUES (3, 'Jimmie', 'Vauter', 'jvauter2@nymag.com', '22-SEP-84', '47', 
    'Vahlen Parkway', 'Montgomery', 'AL', 36104, 831391813, 0000003);
INSERT INTO CUSTOMER VALUES (4, 'Ricard', 'Milsap', 'rmilsap3@cdbaby.com', '8-JUN-73', '04560', 
    '4th Center', 'Pittsburgh', 'PA', 15215, 718535550, 8326399);
    
INSERT INTO ACCOUNTS VALUES (1, 0000001, 'Checking', 100.00);

SELECT ACCOUNTS.*
FROM ACCOUNTS
INNER JOIN CUSTOMER ON CUSTOMER.CUSTOMERID = ACCOUNTS.CUSTOMERID
WHERE CUSTOMER.CUSTOMERID = 1;

SELECT CUSTOMER.*, ACCOUNTS.ACCOUNTTYPE, ACCOUNTS.ACCOUNTBALANCE
FROM CUSTOMER
INNER JOIN ACCOUNTS ON ACCOUNTS.CUSTOMERID = CUSTOMER.CUSTOMERID
WHERE ACCOUNTS.CUSTOMERID = 1;

SELECT C.*
FROM CUSTOMER C;

SELECT A.*
FROM ACCOUNTS A;

SELECT U.*
FROM USERACCOUNT U;

SELECT C.*
FROM CUSTOMER C
INNER JOIN USERACCOUNT U ON U.USERID = C.CUSTOMERID
WHERE U.USERID = 1;

SELECT COUNT(A.ACCOUNTNUM) AS TOTAL
FROM ACCOUNTS A;

DELETE FROM CUSTOMER C WHERE C.CUSTOMERID = 4;
DELETE FROM ACCOUNTS A WHERE A.CUSTOMERID = 4;
DELETE FROM USERACCOUNT U WHERE U.USERID = 4;

COMMIT;

UPDATE ACCOUNTS SET ACCOUNTBALANCE = ACCOUNTBALANCE + 50.0
WHERE ACCOUNTNUM = 3;