
/*********************************************
2.0 Queries and DML
2.1 SELECT
a Select all records from the Employee table.
b Select all records from the Employee table where last name is King.
c Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
d Select all albums in Album table and sort result set in descending order by title.
e Select first name from Customer and sort result set in ascending order by city.
f Select all invoices with a billing address like “T%”
**********************************************/
SELECT *
FROM EMPLOYEE

SELECT * 
FROM EMPLOYEE
WHERE LASTNAME = 'King';

SELECT * 
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO = NULL;

SELECT * 
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND
REPORTSTO IS NULL;

SELECT * 
FROM ALBUM
ORDER BY TITLE;

SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

/*********************************************
2.2 INSERT INTO
a Insert two new records into Genre table
b Insert two new records into Employee table
c Insert two new records into Customer table 

**********************************************/
INSERT INTO GENRE(GENREID, NAME)
VALUES (26, 'Electronic');

INSERT INTO GENRE(GENREID, NAME)
VALUES (27, 'Left Field Hip Hop');


INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, 
TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, 
STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Navarro', 'Omar',
'trainee', 5, '03-FEB-90', '01-JUN-19', '204 Second St', 'Arlington',
'TX', 'United States', '76010', '+1 (512) 385-5571', '+1 (512) 385-5572', 
'omar@gmail.com'); 

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, 
TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, 
STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Yang', 'Ed',
'candidate', 3, '03-JAN-70', '04-JUN-19', '1001 S Center St', 'Reston',
'VA', 'United States', '90020', '+1 (979) 383-5271', '+1 (979) 383-5272', 
'yang@gmail.com');

INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, 
ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, 
EMAIL, SUPPORTREPID)
VALUES (60, 'Mike', 'Parsley', 'ATT',
'1001 S Center', 'Arlington', 'TX', 'United States', '76010', '+1 (512) 385-5571',
'+1 (512) 385-5572', 'mike@gmail.com', 4);

INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, 
ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, 
EMAIL, SUPPORTREPID)
VALUES (61, 'Darshan', 'Patel', 'Visa',
'1001 S Center', 'Arlington', 'TX', 'United States', '76010', '+1 (512) 312-5123',
'+1 (512) 312-5124', 'darshan@gmail.com', 3);
/*********************************************
2.3 UPDATE
Update Aaron Mitchell in Customer table to Robert Walter
Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

**********************************************/
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert'
WHERE FIRSTNAME = 'Aaron';

UPDATE CUSTOMER
SET LASTNAME = 'Walter'
WHERE LASTNAME = 'Mitchell';

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

/*********************************************
3.0 Joins
In this section you will be working with combining various tables
 through the use of joins. You will work with outer, inner, right,
  left, cross, and self joins.
3.1 INNER
Create an inner join that joins customers and orders 
and specifies the name of the customer and the invoiceId.

**********************************************/
SELECT I.INVOICEID AS "invoiceId", C.FIRSTNAME AS "first name", 
C.LASTNAME AS "last name"
FROM CUSTOMER C
JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

/*********************************************
3.2 OUTER
Create an outer join that joins the customer and 
invoice table, specifying the CustomerId,
firstname, lastname, invoiceId, and total.

**********************************************/
SELECT C.CUSTOMERID AS "CustomerId", C.FIRSTNAME as "first name", 
C.LASTNAME as "last name", I.INVOICEID as "invoiceId",
 I.TOTAL as "total"
FROM CUSTOMER C
FULL JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

/*********************************************
3.3 RIGHT
Create a right join that joins album and artist 
specifying artist name and title.

**********************************************/
SELECT ARTIST.NAME AS "artist name", ALBUM.TITLE AS "title"
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;


/*********************************************
3.4 CROSS
Create a cross join that joins album and artist a
and sorts by artist name in ascending order.

**********************************************/
SELECT * 
FROM ALBUM 
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;
/*********************************************
3.5 SELF
Perform a self-join on the 
employee table, joining on the reportsto column.

**********************************************/
SELECT A.FIRSTNAME AS "first name", A.LASTNAME AS "last name", 
  B.REPORTSTO AS "id of supervisor"
FROM EMPLOYEE A, EMPLOYEE B;

/*********************************************
3.6 Joined Queries
a Create a query that shows the customer first name
 and last name as FULL_NAME with the total amount
  of money they have spent as TOTAL.
b Create a query that shows the employee that has
 made the highest total value of
  sales (total of all invoices).
c Create a query which shows the number
 of purchases per each genre. Display the name
  of each genre and number of purchases. Show
   the most popular genre first.

**********************************************/
--a
-- SELECT CONCAT(Concat(Customer.Firstname,' '),Customer.Lastname) AS "full name"
-- FROM CUSTOMER;
-- SELECT I.CUSTOMERID, SUM(TOTAL) AS TOTAL
-- FROM INVOICE I
-- JOIN CUSTOMER C
-- ON I.CUSTOMERID = C.CUSTOMERID
-- GROUP BY I.CUSTOMERID;

--CHINOOK.EMPLOYEE.LASTNAME || ` ´ || CHINOOK.EMPLOYEE.FIRSTNAME FULL_NAME

SELECT CU.FIRSTNAME || ' ' || CU.LASTNAME FULL_NAME, SUM(INVOICE.TOTAL) TOTAL
FROM CUSTOMER CU
INNER JOIN INVOICE
ON CU.CUSTOMERID = INVOICE.CUSTOMERID
GROUP BY CU.LASTNAME, CU.FIRSTNAME;


--b

SELECT EMPLOYEEID, TOTAL
FROM (
    SELECT E.EMPLOYEEID, SUM(I.TOTAL) AS TOTAL
    FROM CUSTOMER C
    INNER JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID
    INNER JOIN EMPLOYEE E ON E.EMPLOYEEID = C.SUPPORTREPID
    GROUP BY E.EMPLOYEEID
    ORDER BY TOTAL DESC
)
WHERE ROWNUM = 1;

-- USE WHERE TOTAL = ( MAX CALL HERE) t;

-- SELECT EMPLOYEEID, TOTAL
-- FROM (
--     SELECT SUM(CHINOOK.INVOICE.TOTAL) TOTAL, CHINOOK.EMPLOYEE.EMPLOYEEID
--     FROM CHINOOK.CUSTOMER
--     INNER JOIN CHINOOK.INVOICE
--     ON CHINOOK.CUSTOMER.CUSTOMERID = CHINOOK.INVOICE.CUSTOMERID
--     INNER JOIN CHINOOK.EMPLOYEE
--     ON CHINOOK.CUSTOMER.SUPPORTREPID = CHINOOK.EMPLOYEE.EMPLOYEEID
--     GROUP BY CHINOOK.EMPLOYEE.EMPLOYEEID
--     ORDER BY TOTAL ASC
-- ) TOTALS
-- -- WITHOUT ROWNUM IT SHOWS ALL THREE EMPLOYEES WITH TOTALS
-- WHERE ROWNUM = 1;


--c
-- c Create a query which shows the number of
-- purchases per each genre. 
--     Display the name of each genre and 
-- number of purchases. 
--     Show the most popular genre first.
-- use invoice line
SELECT G.NAME GENRE, COUNT(IL.INVOICEID) PURCHASES
FROM GENRE G
FULL OUTER JOIN TRACK T
ON G.GENREID = T.GENREID
FULL OUTER JOIN INVOICELINE IL
ON IL.TRACKID = T.TRACKID
GROUP BY G.NAME
ORDER BY PURCHASES DESC;

/*********************************************
4.0 SQL Functions
In this section you will be using the Oracle 
system functions, 
as well as your own functions, 
to perform various actions against 
the database
4.1 System Defined Functions
Create a function that returns the current time.	
create a function that returns the length of 
name in MEDIATYPE table

**********************************************/
CREATE OR REPLACE FUNCTION GET_CURRENT_TIME 
RETURN TIMESTAMP
IS 
CURRENT_TIME TIMESTAMP;
BEGIN 
    SELECT CURRENT_TIMESTAMP INTO CURRENT_TIME FROM DUAL;
    RETURN CURRENT_TIME;
END;
/
SELECT GET_CURRENT_TIME FROM DUAL;

CREATE OR REPLACE FUNCTION GET_STRING_LENGTH(ROWNUMBER IN INT)
RETURN INT
IS
STRINGLENGTH INT;
BEGIN
    SELECT LENGTH(NAME)
    INTO STRINGLENGTH
    FROM MEDIATYPE
    WHERE MEDIATYPEID = ROWNUMBER;
    RETURN STRINGLENGTH;
END;
/
SELECT GET_STRING_LENGTH(3) FROM DUAL;
/*********************************************
4.2 System Defined Aggregate Functions
Create a function that returns the average total 
of all invoices 
Create a function that returns the most expensive track
**********************************************/
CREATE OR REPLACE FUNCTION AVG_TOTAL_OF_INVOICES
RETURN NUMBER
IS
AVG_TOTAL NUMBER;
BEGIN
    SELECT ROUND(AVG(TOTAL),3)
    INTO AVG_TOTAL
    FROM INVOICE;
    RETURN AVG_TOTAL;
END;
/
SELECT AVG_TOTAL_OF_INVOICES as AVG_INVOICE_TOTAL
FROM DUAL;

CREATE OR REPLACE FUNCTION FIND_MAXPRICE_TRACK
RETURN INT
IS 
MAXPRICE INT;
BEGIN
    SELECT MAX(UNITPRICE)
    INTO MAXPRICE
    FROM INVOICELINE;
    RETURN MAXPRICE;
END;
/
SELECT FIND_MAXPRICE_TRACK AS "MOST COSTLY TRACKS COST IN USD"
FROM DUAL;
/*********************************************
4.3 User Defined Scalar Functions
Create a function that returns the
 average price of invoiceline items 
 in the invoiceline table
**********************************************/
CREATE OR REPLACE FUNCTION CALC_AVG_PRICE
RETURN NUMBER
IS
AVG_PRICE NUMBER;
BEGIN
    SELECT ROUND(AVG(UNITPRICE),4)
    INTO AVG_PRICE
    FROM INVOICELINE;
    RETURN AVG_PRICE;
END;
/
SELECT CALC_AVG_PRICE AS "AVG UNIT PRICE"
FROM DUAL;
/*********************************************
4.4 User Defined Table Valued Functions
Create a function that returns all employees who are born after 1968.

**********************************************/
CREATE OR REPLACE FUNCTION POST_68_EMPLOYEES
RETURN SYS_REFCURSOR
IS
CURS SYS_REFCURSOR;
BEGIN
    OPEN CURS FOR
    SELECT EMPLOYEEID, LASTNAME, FIRSTNAME, BIRTHDATE
    FROM EMPLOYEE
    WHERE EMPLOYEE.BIRTHDATE >= TO_DATE('01-JAN-1969', 'DD-MM-YYYY');
    RETURN CURS;
END;
/
SELECT POST_68_EMPLOYEES
FROM DUAL;

/*********************************************
5.0 Stored Procedures
In this section you will be creating and
 executing stored procedures. You will be 
 creating various types of stored procedures
  that take input and output parameters.
5.1 Basic Stored Procedure
Create a stored procedure that selects the first and last names of all the employees.

**********************************************/
CREATE OR REPLACE PROCEDURE GET_FULL_NAMES (CURS OUT SYS_REFCURSOR)
AS
BEGIN
OPEN CURS FOR
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
/*********************************************
5.2 Stored Procedure Input Parameters
Create a stored procedure that updates the personal information of an employee.
Create a stored procedure that returns the managers of an employee.

**********************************************/
CREATE OR REPLACE PROCEDURE CHANGE_EMPLOYEE_TITLE(EMPID IN INT, NEW_TITLE VARCHAR2)
AS
BEGIN 
    UPDATE EMPLOYEE
    SET TITLE = NEW_TITLE
    WHERE EMPLOYEEID = EMPID;
 END;

CREATE OR REPLACE PROCEDURE SHOW_MANAGER(EMPID IN NUMBER, MANAGERS_ID OUT NUMBER)
IS
BEGIN
    SELECT REPORTSTO
    INTO MANAGERS_ID
    FROM EMPLOYEE
    WHERE EMPLOYEEID = EMPID;
END;
/
/*********************************************
5.3 Stored Procedure Output Parameters
Create a stored procedure that returns the name and company of a customer.

**********************************************/
CREATE OR REPLACE PROCEDURE GET_CUSTOMER_INFO(EMPID INT, LNAME OUT VARCHAR2,
FNAME OUT VARCHAR2, COMP OUT VARCHAR2)
IS
BEGIN
    SELECT LASTNAME, FIRSTNAME, COMPANY
    INTO LNAME, FNAME, COMP
    FROM CUSTOMER
    WHERE CUSTOMERID = EMPID;
END;
/


/*********************************************
6.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Create a transaction that given a invoiceId will delete
 that invoice (There may be constraints that rely on this
 , find out how to resolve them).
Create a transaction nested within a stored procedure that inserts a new record in the Customer table

**********************************************/
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICENUM INT)
AS
BEGIN
    DELETE FROM INVOICE
    WHERE INVOICEID = INVOICENUM;
    COMMIT;
END;

CREATE OR REPLACE PROCEDURE CREATE_CUSTOMER(
  CUSTOMERSID INT, FNAME VARCHAR2, LNAME VARCHAR2, COMPNAME VARCHAR2, 
  ADDRES VARCHAR2, CITY VARCHAR2, ST VARCHAR2, COUNTR VARCHAR2, POST VARCHAR2, 
  PHON VARCHAR2, FAX VARCHAR2, EMAIL VARCHAR2, REPSID NUMBER)
IS
BEGIN
    INSERT INTO CUSTOMER VALUES(CUSTOMERSID, FNAME, LNAME, COMPNAME, 
    ADDRES, CITY, ST, COUNTR, POST, 
    PHON, FAX, EMAIL, REPSID);
END;

/*********************************************
7.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
7.1 AFTER/FOR
Create an after insert trigger on the employee table
 fired after a new record is inserted into the table.
Create an after update trigger on the album table that 
fires after a row is inserted in the table
Create an after delete trigger on the customer table that
 fires after a row is deleted from the table.

**********************************************/
CREATE OR REPLACE TRIGGER EMPLOYEE_WAS_ADDED
    AFTER INSERT ON EMPLOYEE
DECLARE
BEGIN
    IF INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('An employee has been added.');
    END IF;
END;

CREATE OR REPLACE TRIGGER NEW_ALBUM_ADDED
    AFTER UPDATE ON ALBUM
DECLARE
BEGIN
    IF UPDATING THEN
        DBMS_OUTPUT.PUT_LINE('A new album was added.');
    END IF;
END;

CREATE OR REPLACE TRIGGER CUSTOMER_WAS_DELETED
    AFTER DELETE ON CUSTOMER
DECLARE
BEGIN
    IF DELETING THEN
        DBMS_OUTPUT.PUT_LINE('A customer was deleted.');
    END IF;
END;
