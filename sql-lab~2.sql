-- Benjamin Onwenu
-- SQL Lab

-- 2.1 Select

-- a. Select all records from the Employee table.
SELECT *
FROM EMPLOYEE;

-- b. Select all records from the Employee table where last name is King.
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';

-- c. Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- d. Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM ALBUM
ORDER BY TITLE DESC;

-- e. Select first name from Customer and sort result set in ascending order by city.
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;

-- f. Select all invoices with a billing address like “T%”
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

-- 2.2 INSERT INTO

-- a. Insert two new records into Genre table
INSERT INTO GENRE
VALUES(26, 'FPS');

INSERT INTO GENRE
VALUES(27, 'Team-based');

-- b. Insert two new records into Employee table
INSERT INTO EMPLOYEE
VALUES(9, 'Owen', 'Ben', 'IT Staff', 2,default, default, '1234 Curtis', 'Detroit', 'MI', 'USA', default, default, default, default);

INSERT INTO EMPLOYEE
VALUES(10, 'Owen', 'Frank', 'IT Staff', 2,default, default, '1234 Curtis', 'Detroit', 'VA', 'USA', default, default, default, default);

-- c. Insert two new records into Customer table
INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, CITY, CUSTOMERID, EMAIL)
VALUES('Ben', 'O', 'Detroit)', 60, 'ben@gmail.com');

INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, CITY, CUSTOMERID, EMAIL)
VALUES('Frank', 'O', 'Arlington', 61, 'frank@gmail.com');

COMMIT;

-- 2.3 UPDATE---------------------------------------------------------------------------------------

-- a. Update Aaron Mitchell in Customer table to Robert Walter
UpDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

COMMIT;

-- b. Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

UpDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

COMMIT;

-- 3.1 Inner Joins -----------------------------------------------------------------------------------------------------------

-- a. Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT C.FIRSTNAME || ' ' || C.LASTNAME AS NAME, I.INVOICEID AS "INVOICE ID"
FROM CUSTOMER C
JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

-- 3.2 Outer Join ----------------------------------------------------------------------------------------------------------

-- a. Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID AS "INVOICE ID", I.TOTAL
FROM CUSTOMER C
FULL JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

-- 3.3 Right Join

-- a. Create a right join that joins album and artist specifying artist name and title.
SELECT AR.NAME, AL.TITLE
FROM ALBUM AL
RIGHT JOIN ARTIST AR
ON AL.ARTISTID = AR.ARTISTID;

-- 3.4 Cross Join

-- a. Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM ALBUM 
CROSS JOIN ARTIST 
ORDER BY NAME ASC;

-- 3.5 Self Join
SELECT *
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;

-- 3.6 Joined Queries

-- a. Create a query that shows the customer first name and last name as FULL_NAME with the total amount of money they have spent as TOTAL.
SELECT C.FIRSTNAME || ' ' || C.LASTNAME AS FULL_NAME, SUM(I.TOTAL) AS TOTAL
FROM CUSTOMER C
INNER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID
GROUP BY C.FIRSTNAME, C.LASTNAME;

-- b. Create a query that shows the employee that has made the highest total value of sales (total of all invoices).
SELECT EMPLOYEEID, TOTAL
FROM (
SELECT E.EMPLOYEEID, SUM(I.TOTAL) AS TOTAL
FROM CUSTOMER C
INNER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID
INNER JOIN EMPLOYEE E
ON C.SUPPORTREPID = E.EMPLOYEEID
GROUP BY E.EMPLOYEEID
ORDER BY TOTAL DESC
)
WHERE ROWNUM = 1;

-- c.Create a query which shows the number of purchases per each genre. Display the name of each genre and number of purchases. 
--   Show the most popular genre first.

SELECT G.NAME, COUNT(IL.QUANTITY) AS "# OF PURCHASES"
FROM TRACK T
JOIN GENRE G
ON T.GENREID = G.GENREID
JOIN INVOICELINE IL
ON T.TRACKID = IL.TRACKID
GROUP BY G.NAME
ORDER BY "# OF PURCHASES" DESC;

-- 4.1 System Defined Function

-- a. Create a function that returns the current time.

SET SERVEROUTPUT ON;


CREATE OR REPLACE FUNCTION TCURRENT
RETURN VARCHAR2 
IS
BEGIN 
    RETURN LOCALTIMESTAMP;
END;

SELECT TCURRENT
FROM DUAL;

-- b. Create a function that returns the length of name in MEDIATYPE table

CREATE OR REPLACE FUNCTION MEDIATYPE_NAME_LENGTH
RETURN NUMBER
IS
LENGTH_ NUMBER;
BEGIN
SELECT COUNT(MEDIATYPE.NAME)
INTO LENGTH_
FROM MEDIATYPE;
RETURN LENGTH_;
END;

SELECT MEDIATYPE_NAME_LENGTH
FROM DUAL;
-- 4.2 System Defined Aggregate Functions

-- a.  Create a function that returns the average total of all invoices 

CREATE OR REPLACE FUNCTION AVG_INVOICE
    RETURN NUMBER
    IS
    AVERAGE NUMBER;
    BEGIN
        SELECT AVG(I.TOTAL)
        INTO AVERAGE
        FROM INVOICE I;
        RETURN AVERAGE;
    END;
    
SELECT AVG_INVOICE
FROM DUAL;

-- b. Create a function that returns the most expensive track
-- Returns name of most expensive track

CREATE OR REPLACE FUNCTION MOST_EXPENS_TRACK
RETURN VARCHAR2
IS 
EXPENSE NUMBER;
TRACK_ID VARCHAR2(255);
BEGIN
        SELECT MAX(T.UNITPRICE)
        INTO EXPENSE
        FROM TRACK T;
        SELECT T.NAME
        INTO TRACK_ID
        FROM TRACK T
        WHERE T.UNITPRICE = EXPENSE AND ROWNUM = 1;
        RETURN TRACK_ID;
END;

SELECT MOST_EXPENS_TRACK
FROM DUAL;

-- 4.3 User Defined Scalar Functions

-- a. Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICELINE
RETURN NUMBER 
IS
AVERAGE NUMBER;
BEGIN
        SELECT AVG(I.UNITPRICE)
        INTO AVERAGE
        FROM INVOICELINE I;
        RETURN AVERAGE;
END;

SELECT AVG_INVOICELINE 
FROM DUAL;

-- 4.4 User Defined Table Valued Functions

-- a. Create a function that returns a cursor with all employees who are born after 1968.
CREATE OR REPLACE FUNCTION AFTER_EMPLOYEES
RETURN SYS_REFCURSOR
IS
E_CURSOR SYS_REFCURSOR;
BEGIN
        OPEN E_CURSOR FOR
            SELECT *
            FROM EMPLOYEE
            WHERE EMPLOYEE.BIRTHDATE >= TO_DATE('01-JAN-1969', 'DD-MM-YYYY');
        RETURN E_CURSOR;
END;

SELECT AFTER_EMPLOYEES
FRoM DUAL;

-- 5.1 Basic Stored Procedures

-- a. Create a stored procedure that selects the first and last names of all the employees
CREATE OR REPLACE PROCEDURE GET_ALL_EMPLOYEES(S OUT SYS_REFCURSOR)
IS
BEGIN 
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME 
    FROM EMPLOYEE;
END;
/

DECLARE
    SVAR SYS_REFCURSOR;
    TEMP_FiRSTNAME EMPLOYEE.FIRSTNAME%TYPE;
    TEMP_LASTNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN 
    GET_ALL_EMPLOYEES(SVAR);
    LOOP
        FETCH SVAR INTO TEMP_FIRSTNAME, TEMP_LASTNAME;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(TEMP_FIRSTNAME||' IS FIRST NAME, '||TEMP_LASTNAME||' IS LAST NAME');
    END LOOP;
    CLOSE SVAR;
END;

-- 5.2 Stored ProcedureInput Parameters

-- a. Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(EMP IN EMPLOYEE.EMPLOYEEID%TYPE, LN IN EMPLOYEE.LASTNAME%TYPE,
FN IN EMPLOYEE.FIRSTNAME%TYPE, EMP_TITLE IN EMPLOYEE.TITLE%TYPE, BD IN EMPLOYEE.BIRTHDATE%TYPE, AD IN EMPLOYEE.ADDRESS%TYPE,
C IN EMPLOYEE.CITY%TYPE, ST IN EMPLOYEE.STATE%TYPE, EMP_COUNTRY IN EMPLOYEE.COUNTRY%TYPE, 
EMP_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE, EMP_PHONE IN EMPLOYEE.PHONE%TYPE, EMP_FAX IN EMPLOYEE.FAX%TYPE
, EMP_EMAIL IN EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE
    SET FIRSTNAME = FN, LASTNAME = LN, TITLE = EMP_TITLE, BIRTHDATE = BD, ADDRESS = AD, CITY =  C, STATE = ST, 
    COUNTRY = EMP_COUNTRY, POSTALCODE = EMP_POSTALCODE, PHONE = EMP_PHONE, FAX = EMP_FAX, EMAIL= EMP_EMAIL
    WHERE EMPLOYEEID =  EMP;
END;
/

-- b. Create a stored procedure that returns the managers of an employee.ge
CREATE OR REPLACE PROCEDURE EMP_MANAGER(EMP_ID IN EMPLOYEE.EMPLOYEEID%TYPE, MAN_ OUT EMPLOYEE.EMPLOYEEID%TYPE)
IS
BEGIN
    SELECT E.REPORTSTO
    INTO MAN_
    FROM EMPLOYEE E
    WHERE E.EMPLOYEEID = EMP_ID;
END;

DECLARE
    MAN_ NUMBER;
BEGIN
    EMP_MANAGER(2, MAN_);
END;

-- 5.3 Stored Procedure Output Parameters

-- a. Create a stored procedure that returns the name and company of a customer.

CREATE OR REPLACE PROCEDURE CUSTOMER_INFO(C_ID IN CUSTOMER.CUSTOMERID%TYPE, C_FIRSTNAME OUT CUSTOMER.FIRSTNAME%TYPE,
    C_LASTNAME OUT CUSTOMER.LASTNAME%TYPE, C_COMPANY OUT CUSTOMER.COMPANY%TYPE)
IS
BEGIN
    SELECT C.FIRSTNAME, C.LASTNAME, C.COMPANY
    INTO C_FIRSTNAME, C_LASTNAME, C_COMPANY
    FROM CUSTOMER C
    WHERE C.CUSTOMERID = C_ID;
END;

DECLARE
    ID_ NUMBER;
    FIRST_ CUSTOMER.FIRSTNAME%TYPE;
    LAST_ CUSTOMER.LASTNAME%TYPE;
    COMPANY_ CUSTOMER.COMPANY%TYPE;

BEGIN
    
    CUSTOMER_INFO(2, FIRST_ , LAST_, COMPANY_);
    DBMS_OUTPUT.PUT_LINE('NAME: ' || FIRST_ || ' '|| LAST_ || ' COMPANY: ' || COMPANY_);
END;

-- 6.0 Transactions

-- a. Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find 
--     out how to resolve them).
CREATE OR REPLACE PROCEDURE DELITE_INVOICE(INVOICE_ID IN INVOICE.INVOICEID%TYPE)
IS
BEGIN
    DELETE FROM INVOICELINE
    WHERE INVOICELINE.INVOICEID = INVOICE_ID;
    DELETE FROM INVOICE
    WHERE INVOICE.INVOICEID = INVOICE_ID;
    COMMIT;
END;

-- b. Create a transaction nested within a stored procedure that inserts a new record in the Customer table

CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER(C_ID IN CUSTOMER.CUSTOMERID%TYPE, C_FIRSTNAME IN CUSTOMER.FIRSTNAME%TYPE,
    C_LASTNAME IN CUSTOMER.LASTNAME%TYPE, C_COMPANY IN CUSTOMER.COMPANY%TYPE, C_ADDRESS IN CUSTOMER.ADDRESS%TYPE,
    C_CITY IN CUSTOMER.CITY%TYPE, C_STATE IN CUSTOMER.STATE%TYPE, C_COUNTRY IN CUSTOMER.COUNTRY%TYPE,
    C_POSTALCODE IN CUSTOMER.POSTALCODE%TYPE, C_PHONE IN CUSTOMER.PHONE%TYPE, C_FAX IN CUSTOMER.FAX%TYPE,
    C_EMAIL IN CUSTOMER.EMAIL%TYPE, C_SUPP IN CUSTOMER.SUPPORTREPID%TYPE)
IS
BEGIN
    INSERT INTO CUSTOMER
    VALUES(C_ID, C_FIRSTNAME, C_LASTNAME, C_COMPANY, C_ADDRESS, C_CITY, C_STATE, C_COUNTRY, C_POSTALCODE, C_PHONE, C_FAX, C_EMAIL, C_SUPP);
    COMMIT;
END;

-- 7.1 AFTER/FOR
-- a. Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER EMPLOYEE_INSERT
AFTER INSERT ON EMPLOYEE
BEGIN 
    DBMS_OUTPUT.PUT_LINE('Deletion sucessful.');
END;

-- b. Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER ALBUM_UPDATE
AFTER UPDATE ON ALBUM
BEGIN 
    DBMS_OUTPUT.PUT_LINE('Update sucessful.');
END;

-- c. Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER CUSTOMER_DELETE
AFTER DELETE ON ALBUM
BEGIN 
    DBMS_OUTPUT.PUT_LINE('Deletion sucessful.');
END;