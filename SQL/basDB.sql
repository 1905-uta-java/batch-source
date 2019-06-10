---------------------------------
----- 2.0 QUERIES AND DML -----
---------------------------------

----- 2.1 SELECT -----
-- a. Select all records from the Employee table
-- Use the SELECT query with the * to select all tables and specify FROM the employee table.
SELECT *
FROM EMPLOYEE;

-- b. Select all records from the Employee table where the last name is King
-- Use SELECT * query to grab all records and use FROM to specify from the the Employee table.
-- Use WHERE to specify the conditoin that the employee record must have the last name King
SELECT *
FROM EMPLOYEE
WHERE EMPLOYEE.LASTNAME = 'King';

-- c. Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
/* Use SELECT * query to grab all the records and use FROM to specify from the Employee table. 
Use WHERE to specify the condition that the employee record must have the first name Andrew
and the reports to must be null */
SELECT *
FROM EMPLOYEE
WHERE EMPLOYEE.FIRSTNAME = 'Andrew' 
AND EMPLOYEE.REPORTSTO IS NULL;

-- d. Select all albums in Album table and sort result sest in descending order by title
/* Use SELECT * to grab all records and use FROM to specify from the Album table.
Use ORDER BY to specify to order the pulled records in descending order by title */
SELECT *
FROM ALBUM
ORDER BY TITLE DESC;

-- e. Select first name from Customer and sort result set in ascending order by city
/* Use SELECT FIRSTNAME to select all the first name records and use FROM to specify
from the Customer table. Use ORDER BY to order the pulled records in ascending order by city */
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;

-- f. Select all invoices with a billing address like "T%"
/* Use SELECT * to grab all records and use FROM to specify from the Invoice table. Use
WHERE to specify the condition that the pulled records must have a Billing Address that starts
with T */
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';


----- 2.2 INSERT INTO -----
-- a. Insert two new records into Genre table
/* Use INSERT to declare inserting a record and use INTO to specify inserting into the Genre table.
Use VALUES to declare which values you are entering, and then enter the values. For Genre, an
ID and a name is entered*/
INSERT INTO GENRE VALUES (26, 'Indie');
INSERT INTO GENRE VALUES (27, 'Country');

-- b. Insert two new records into Employee table
/* Use INSERT to declare inserting a record and use INTO to specify inserting into the Employee table.
Use VALUES to declare which values you are entering, and then enter the values. Follow the Employee 
format when entering the values */
INSERT INTO EMPLOYEE VALUES (9, 'Doe', 'Janet', 'Sales Support Agent', 2, '06-JUL-85', '03-MAY-15', '1001 S Center Street', 'Arlington', 'TX', 'United States', '76010', '+1 (608) 623-2539', '+1 (608) 623-2918', 'janet@chinookcorp.com'); 
INSERT INTO EMPLOYEE VALUES (10, 'Cross', 'Jordan', 'IT Staff', 6, '01-APR-93', '21-SEP-18', '6805 Schubert', 'Colleyville', 'TX', 'United States', '76034', '+1 (817) 538-9658', '+1 (817) 538-7851', 'jordan@chinookcorp.com'); 

-- c. Insert two new records into Customer table
/* Use INSERT to declare inserting a record and use INTO to specify inserting into the Customer table.
use VALUES to declare which values you are entering and then ever the values. Follow the Customer
format when entering the values */
INSERT INTO CUSTOMER VALUES (60, 'Amber', 'Johnson', NULL, '2891 Main Street', 'Rio', 'WI', 'United States', '53960', '+1 (608) 238-2850', NULL, 'johnsamb@gmail.com', 4);
INSERT INTO CUSTOMER VALUES (61, 'Camp', 'Chelsea', NULL, '7801 N Yates Rd', 'Milwaukee', 'WI', 'United States', '53217', '+1 (742) 427-1771', NULL, 'campchel@gmail.com', 3); 


----- 2.3 UPDATE -----
-- a. Update Aaron Mitchell in Customer table to Robert Walter
/* Use UPDATE to declare an update to a previously made record and then specify the Customer table.
Use SET to declare the new data, then enter the column name (FIRSTNAME) that you are changing, and then 
the new value. Seperate changes with a comma. Use WHERE to specify which record these changes are 
happening to, in this case it's for Aaron who has the CustomerID of 32. */
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32; -- (Aaron Mitchell's ID number)

-- b. Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
/* Use UPDATE to declare an update to a previously made record and then specify which table for
the update (ARTIST). Use SET to declare the new data, then enter the column name (NAME) that you
are changing and the new value. Use WHERE to add a condition to specify which record these changes
are happening to, in this case, it's where the Artist's name is Creedence Clearwater Revival. */
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';


-----------------------------------
----- 3.0 JOINS -----
-----------------------------------

----- 3.1 INNER -----
-- a. Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceID
/* Use SELECT and then specify the table and column to get the records of. These are denoted by
TableName.ColumnName and separated by commas. Use FROM to specify from which table you are getting
the records from. Use INNER JOIN to combine all the shared values of the Customer table and the
Invoice table. Use ON to specify the key that they will use to perform the join. */
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;


----- 3.2 OUTER -----
-- a. Create an outer join that joins the  customer and invoice table, sepcifying the CustomerID, first name, last name, invoiceID, and total.
/* Use SELECT and then specify the table and column to get the records of. These are denoted by
TableName.ColumnName. Use FROM to specify from which table to get the information as well as create
an Alias to be used to shorten the table names. use a LEFT JOIN to pull every Customer from the Customer table
as well as the invoices where the customerIDs from both tables match. */
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL
FROM CUSTOMER C
LEFT JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID; -- Left join so you get all customers even if they haven't purchased something yet


----- 3.3 RIGHT -----
-- a. Create a right join that joins album and artist specifying artist anme and title
/* Use SELECT and then specify the table and column to get the records of. Denoted by TableName.ColumnName.
Use FROM to specify which table to get the records of as well as any aliases. Use a RIGHT JOIN to get
all records from the Album table as well as the records from the Artist table as long as the ArtistIDs 
from both tables match */
SELECT AL.TITLE, AR.NAME
FROM ARTIST AR
RIGHT JOIN ALBUM AL ON AR.ARTISTID = AL.ARTISTID; -- ALBUM as the right table so every album is selected


----- 3.4 CROSS -----
-- a. Create a cross join that joins album and artist and sorts by artist name in ascending order.
/* Use SELECT and then specify the table with * to get all records from those tables. Use FROM to
specify which table to get the records of as well as aliases. Use the CROSS JOIN to return every
combination of rows from the two tables specified. Use ORDER BY to return the data in ascending
order by the Artist name. */
SELECT AL.*, AR.*
FROM ALBUM AL
CROSS JOIN ARTIST AR
ORDER BY AR.NAME ASC;


----- 3.5 SELF -----
-- a. Perform a self-join on the employee table, joining on the reportsto column.
/* Use SELECT and then specify the table with table and column name denoted by Table.Column.
Use FROM to specify which table to get the records from. Use the same table with a different 
alias to create a self-join. Use WHERE to specify the self join by linking values from the 
same table */
SELECT E.FIRSTNAME, E.LASTNAME, E2.REPORTSTO
FROM EMPLOYEE E, EMPLOYEE E2
WHERE E2.EMPLOYEEID = E.REPORTSTO;


----- 3.6 JOINED QUERIES -----
-- a. Create a query that shows the customer  first name and last name as FULL_NAME with the total amount of money they have spent as TOTAL.
/* Use SELECT and then declare the tables and columns to pull records from. Use || to concat 
the columns with ' ' acting as a space. Use SUM to get the sum of all the records in the TOTAL 
column and call them TOTAL. Use FROM to specify which tables to use and WHERE to state a condition
to pull records where CustomerID from Customer table is equal to the CustomerID from the Invoice
table. Use GROUP BY to to group the aggregates by FirstName and LastName*/
SELECT C.FIRSTNAME || ' ' || C.LASTNAME AS FULL_NAME, SUM(I.TOTAL) AS TOTAL
FROM INVOICE I, CUSTOMER C
WHERE C.CUSTOMERID = I.CUSTOMERID 
GROUP BY C.FIRSTNAME || ' ' || C.LASTNAME;

SELECT C.FIRSTNAME || ' ' || C.LASTNAME AS FULL_NAME,  SUM(I.TOTAL) AS TOTAL
FROM INVOICE I
JOIN CUSTOMER C
ON I.CUSTOMERID = C.CUSTOMERID
GROUP BY C.FIRSTNAME, C.LASTNAME;

-- b. Create a query that shows the employee that has made the highest total value of sales (total of all invoices)
/* Use SELECT * to select everything from the sub query. Use FROM (...) to specify what's in the 
sub query. The sub query uses select to specify what records to pull. Use SUM to get the sum of the
total from the invoice table and refer to it as Total_Amnt. Call SuppperRepID as REP_ID. Use FROM
to declare the tables being used and their alieses. Use JOIN to create an Inner Join of Customer 
where Invoice CustomerID equals Customer CustomerID. Use GROUP BY to group the aggregated values
by the SupertRepID and then order the data in descending order based on the total amount. Then use
WHERE ROWNUM = 1 to specify choosing the first row. */
SELECT *
FROM (
    SELECT SUM(I.TOTAL) AS TOTAL_AMNT, C.SUPPORTREPID AS REP_ID
    FROM INVOICE I
    JOIN CUSTOMER C
    ON I.CUSTOMERID = C.CUSTOMERID
    GROUP BY C.SUPPORTREPID
    ORDER BY TOTAL_AMNT DESC
) WHERE ROWNUM = 1;

-- c. Create a query which shows the number of purchases per eac genre. Display the name of each genre and number of purchases. 
-- Show the most popular genre first
/* Use SELECT to secify the columns of records to be shown. Use COUNT on quantity to get the
total of units sold from the Invoice Line table. Use FROM to specify from the InvoiceLine table.
Use JOIN to combine the shared values of InvoiceLine and Track tables using the TrackID from each. 
Use JOIN again to link the Genre table with the Track table through the GenreIDs. GROUP BY the
Genre name and display them by the total with the highest first. */

SELECT G.NAME, COUNT(I.QUANTITY) AS TOTAL
FROM INVOICELINE I
JOIN TRACK T ON I.TRACKID = T.TRACKID
JOIN GENRE G ON T.GENREID = G.GENREID
GROUP BY G.NAME
ORDER BY TOTAL DESC;

-------------------------------
-- 4.0 SQL FUNCTIONS
-------------------------------

-- 4.1 SYSTEM DEFINED FUNCTIONS
-- a. Create a function that returns the current time
/* Use CREATE OR REPLACE FUNCTION to create a new function and name it. Declare what you are going
to RETURN (VARCHAR2) and use IS to give it a name and a parameter. BEGIN defines where the code
to execute begins. SELECT and TO_CHAR(CURRENT_TIMESTAMP, 'HH:MM:SS') to get the current system time
and format it to hours, minutes, seconds. INTO to store it in the created CURRENT_TIME variable.
FROM DUAL to use the dummy table. RETURN the stored value. END to end the code. Use SELECT to call 
the function FROM DUAL to run the function and get the time. */

CREATE OR REPLACE FUNCTION GET_TIME
RETURN VARCHAR2
IS CURRENT_TIME VARCHAR2 (10);
    BEGIN
    SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH:MI:SS')
    INTO CURRENT_TIME
    FROM DUAL;
    RETURN CURRENT_TIME;
END;
/

SELECT GET_TIME
FROM DUAL;

-- b. Create a funciton that returns the length of name in MEDIATYPE table
/* Use CREATE OR REPLACE FUNCTION to declare function creation. Specify a name and then a 
variable name and its type. Declare RETURN and TYPE and use IS to name the variable and type. 
BEGIN declares start of executable code. SELECT and use LENGTH function to get the length of
NAME of the MEDIATYPE table. INTO to store result into variable. FROM MEDIATYPE table where 
the name of the MediaType = the name entered. RETURN the length. END. Use SELECT GET_NAME_LENGTH
to call the function and then enter the MEDIATYPE name FROM DUAL.*/

CREATE OR REPLACE FUNCTION GET_NAME_LENGTH (media_name IN VARCHAR2)
RETURN NUMBER
IS NAME_LENGTH NUMBER;
BEGIN
    SELECT LENGTH(MT.NAME)
    INTO NAME_LENGTH
    FROM MEDIATYPE MT
    WHERE MT.NAME = media_name;
    RETURN NAME_LENGTH;
END;
/

SELECT GET_NAME_LENGTH ('MPEG audio file')
FROM DUAL;

SELECT M.NAME
FROM MEDIATYPE M;


-- 4.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
-- a. Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION GET_AVERAGE
RETURN NUMBER
IS AVERAGE NUMBER;
BEGIN
    SELECT AVG (I.TOTAL)
    INTO AVERAGE
    FROM INVOICE I;
    RETURN AVERAGE;
END;
/

SELECT GET_AVERAGE
FROM DUAL;


-- 4.2 SYSTEM DEEFINED AGGREGATE FUNCTIONS
--  b. Create a functioin that returns the most expensive track
SELECT T.NAME, MAX (T.UNITPRICE)
FROM TRACK T;


-- 4.3 USER DEFINED SCALAR FUNCTIONS
-- a. Create a function that returns the average rpcie of invoiceline items in the invoiceline table.

CREATE OR REPLACE FUNCTION GET_INLINE_AVG
RETURN NUMBER
IS AVERAGE NUMBER;
BEGIN
    SELECT AVG (TOTAL) 
    INTO AVERAGE
    FROM (
        SELECT IL.UNITPRICE, AVG (IL.UNITPRICE * IL.QUANTITY) AS TOTAL
        FROM INVOICELINE IL
        JOIN INVOICE I ON I.INVOICEID = IL.INVOICEID
        GROUP BY IL.QUANTITY, IL.UNITPRICE
        );
    RETURN AVERAGE;
END;
/

SELECT GET_INLINE_AVG
FROM DUAL;


-- 4.4 USER DEFINED TABLE VALUED FUNCTIONS
-- a. Create a function that returns all employees who are born after 1968.


CREATE OR REPLACE FUNCTION GET_BIRTHDATE
RETURN SYS_REFCURSOR
IS 
SETOF SYS_REFCURSOR;
BEGIN
OPEN SETOF 
FOR
    SELECT E.*
    FROM EMPLOYEE E
    WHERE E.BIRTHDATE > '31-DEC-68';
    RETURN SETOF;
END;
/

SELECT GET_BIRTHDATE
FROM DUAL;


-----------------------------
-- 5.0 STORED PROCEDURES
-----------------------------
-- a. Create a stored procedure that selects the first and last names of all the employees.
/* Create a Procedure and name it. Create a Cursor. In BEGIN, OPEN the cursor and use SELECT
to get the first and last names FROM the Employee table. END the Procedure. Create a variable
to store the result. Execute the Procedure and store it in the variable. Print out the variable. */

CREATE OR REPLACE PROCEDURE GET_NAMES
(
    C1 OUT SYS_REFCURSOR
)
IS
BEGIN
OPEN C1 FOR
    SELECT E.FIRSTNAME, E.LASTNAME
    FROM EMPLOYEE E;
END;
/

VAR RC REFCURSOR;
EXECUTE GET_NAMES(:RC);

PRINT RC;

-- 5.1 STORED PROCEDURE INPUT PARAMETERS
-- a. Create a stored rocedure that updates the peresonal information of an employee.
/* Create a procedure and name it. Create variables for each piece of employee information you want
to update. In BEGIN, assign all variables to the procedure variables WHERE the id matches. Id makes 
sure you are updating the correct employee. END procedure. Call the procedure and enter the updated
values. Commit to make them final. */
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(
    P_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
    P_FIRSTNAME IN EMPLOYEE.FIRSTNAME%TYPE,
    P_LASTNAME IN EMPLOYEE.LASTNAME%TYPE,
    P_BIRTHDATE IN EMPLOYEE.BIRTHDATE%TYPE,
    P_ADDRESS IN EMPLOYEE.ADDRESS%TYPE,
    P_CITY IN EMPLOYEE.CITY%TYPE,
    P_STATE IN EMPLOYEE.STATE%TYPE,
    P_COUNTRY IN EMPLOYEE.COUNTRY%TYPE,
    P_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE,
    P_PHONE IN EMPLOYEE.PHONE%TYPE,
    P_FAX IN EMPLOYEE.FAX%TYPE,
    P_EMAIL IN EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE
        SET FIRSTNAME = P_FIRSTNAME, LASTNAME = P_LASTNAME, BIRTHDATE = P_BIRTHDATE,
        ADDRESS = P_ADDRESS, CITY = P_CITY, STATE = P_STATE, COUNTRY = P_COUNTRY,
        POSTALCODE = P_POSTALCODE, PHONE = P_PHONE, FAX = P_FAX, EMAIL = P_EMAIL
    WHERE EMPLOYEEID = P_EMPLOYEEID;
END;
/

BEGIN
UPDATE_EMPLOYEE(10, 'Jordan', 'Crosser', '01-APR-93', '6805 Schubert', 'Colleyville', 'TX', 'United States', '76034', '+1 (817) 538-9658', '+1 (817) 538-9658', 'jordan@chinookcorp.com');
END;
/

-- b. Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GET_MANAGER (
    P_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
    P_MANAGERNAME OUT EMPLOYEE.FIRSTNAME%TYPE,
    P_MANAGERLAST OUT EMPLOYEE.LASTNAME%TYPE,
    P_MANAGER OUT EMPLOYEE.REPORTSTO%TYPE)
IS
BEGIN
    SELECT E.REPORTSTO
    INTO P_MANAGER
    FROM EMPLOYEE E
    WHERE E.EMPLOYEEID = P_EMPLOYEEID;
    
    SELECT E.FIRSTNAME, E.LASTNAME
    INTO P_MANAGERNAME, P_MANAGERLAST
    FROM EMPLOYEE E
    WHERE E.EMPLOYEEID = P_MANAGER;
END;
/


-- 5.3 STORED PROCEDURE OUTPUT PARAMETERS
-- a. Create a stored procedure that returns the name and company of customer.
CREATE OR REPLACE PROCEDURE GET_CUSTOMER_INFO(
P_ID IN CUSTOMER.CUSTOMERID%TYPE,
P_FIRSTNAME OUT CUSTOMER.FIRSTNAME%TYPE,
P_LASTNAME OUT CUSTOMER.LASTNAME%TYPE,
P_COMPANY OUT CUSTOMER.COMPANY%TYPE)
AS
BEGIN
    SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, CUSTOMER.COMPANY
    INTO P_FIRSTNAME, P_LASTNAME, P_COMPANY
    FROM CUSTOMER
    WHERE CUSTOMER.CUSTOMERID = P_ID;
END;
/

BEGIN
    GET_CUSTOMER_INFO(1);
END;
/


-------------------------
-- 6.0 TRANSACTIONS
-------------------------




-------------------------
-- 7.0 TRIGGERS
-------------------------
-- a. Create an after insert trigger on the employee table fired after a new record is inserted into the table
Set serveroutput on;

CREATE OR REPLACE TRIGGER EMP_INSERT_TRIGGER
AFTER INSERT
ON EMPLOYEE
DECLARE
    print_action VARCHAR2 (50);
BEGIN
    IF INSERTING THEN
        print_action := 'Added new employee';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(PRINT_ACTION);
END;
/
INSERT INTO EMPLOYEE VALUES (11, 'Cross', 'Jordan', 'IT Staff', 6, '01-APR-93', '21-SEP-18', '6805 Schubert', 'Colleyville', 'TX', 'United States', '76034', '+1 (817) 538-9658', '+1 (817) 538-7851', 'jordan@chinookcorp.com'); 

DELETE FROM EMPLOYEE WHERE EMPLOYEE.EMPLOYEEID = 11;

-- b. Create an update trigger on the album table that first after a row is inserted (updated?) in the table
CREATE OR REPLACE TRIGGER ALBUM_UPDATE_TRIGGER
AFTER UPDATE
ON ALBUM
DECLARE
    print_action VARCHAR2 (50);
BEGIN
    IF UPDATING THEN
        print_action := 'Updated album';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(PRINT_ACTION);
END;
/

-- c. Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER CUST_DELETE_TRIGGER
AFTER DELETE
ON CUSTOMER
DECLARE
    print_action VARCHAR2 (50);
BEGIN
    IF DELETING THEN
        print_action := 'Removed customer';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(PRINT_ACTION);
END;
/

    
    



