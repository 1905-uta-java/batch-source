/*******************************
   bankdb
   Script: CREATE_DB.sql
   Description: Creates and populates the bankdb database.
   DB Server: Oracle
   Author: Omar Navarro
********************************/

/*******************************
   Drop database if it exists
********************************/
DROP USER BANK_DB CASCADE;


/*******************************
   Create database
********************************/
CREATE USER BANK_DB
IDENTIFIED BY password
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to BANK_DB;
GRANT resource to BANK_DB;
GRANT create session TO BANK_DB;
GRANT create table TO BANK_DB;
GRANT create view TO BANK_DB;


conn BANK_DB/password

/*******************************
   Create Tables
********************************/
CREATE TABLE BANK_USER (
    USER_EMAIL VARCHAR2(255) NOT NULL PRIMARY KEY,
    USER_PASSWORD VARCHAR2(255) NOT NULL,
    USER_BALANCE NUMBER
);
/*******************************
   Create stored procedure
********************************/
CREATE OR REPLACE PROCEDURE deposit(userEmailForDeposit IN VARCHAR2, amount IN NUMBER)
IS
BEGIN
	UPDATE BANK_USER 
   SET USER_BALANCE = USER_BALANCE + amount 
   WHERE USER_EMAIL = userEmailForDeposit;
END;
/

CREATE OR REPLACE PROCEDURE withdraw(userEmailForWithdrawal IN VARCHAR2, amount IN NUMBER)
IS
BEGIN
	UPDATE BANK_USER 
   SET USER_BALANCE = USER_BALANCE - amount 
   WHERE USER_EMAIL = userEmailForWithdrawal;
END;
/

