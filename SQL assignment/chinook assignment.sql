--------------------------------
-- QUESTION 2
--------------------------------

-- #2.1
-- a
SELECT * 
FROM CHINOOK.EMPLOYEE;

--b
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';

--c
SELECT *
FROM CHINOOK.EMPLOYEE 
WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;


--d
SELECT *
FROM CHINOOK.ALBUM
ORDER BY TITLE DESC;

--e
SELECT FIRSTNAME
FROM CHINOOK.CUSTOMER
ORDER BY CITY ASC;

--f
SELECT *
FROM CHINOOK.INVOICE
WHERE billingaddress LIKE 'T%';

--2.2
--a
INSERT INTO CHINOOK.GENRE VALUES (26, 'Indie');
INSERT INTO CHINOOK.GENRE VALUES (27, 'Spoken Word');

--b
INSERT INTO CHINOOK.EMPLOYEE VALUES(9, 'Regan', 'Charles', 'Grounds Keeper', 1, '01-APR-24', '10-JUL-96', 
'2100 S Main St', 'Los Angeles', 'CA', 'US', '90007', '(213) 747-9555', ' (213) 747-9555', 'info@abcsewingmachine.com');

INSERT INTO CHINOOK.EMPLOYEE VALUES(10, 'Baily', 'George', 'Banker', 4, '02-FEB-80', '11-OCT-00', 
'94-20 Guy R Brewer Blvd', ', Jamaica', 'NY', 'US', '11451', '(718) 262-2000', '(718) 262-2001', 'info@yorkcollege.com');

--c
INSERT INTO CHINOOK.CUSTOMER VALUES(60, 'Jaquan', 'The Jequel', 'YouTube LLC', '901 Cherry Avenue', 'San Bruno', 
'CA', 'US', '94066', '(650) 131-8943', '(650) 457-2412', 'youtube@youtube.com',3);

INSERT INTO CHINOOK.CUSTOMER VALUES(61, 'Davidson', 'Derek', 'Fly By Night Feeds', '601 Jordan Ave', 'Jordan', 
'MT', 'US', '59337', '(650) 131-8943', '(650) 457-2412', 'dereksavage@gmail.com',3);

--2.3
--a
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME ='Walker'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--b
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE CHINOOK.ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';


--------------------------------
-- QUESTION 3
--------------------------------
--3.1
--customers and orders and specifies the name of the customer and the invoiceId
SELECT C.CUSTOMERID, I.INVOICEID
FROM CHINOOK.CUSTOMER C
INNER JOIN CHINOOK.INVOICE I ON 
C.CUSTOMERID = I.CUSTOMERID;

--3.2
-- Create an outer join that joins the customer and invoice table, 
-- specifying the CustomerId, firstname, lastname, invoiceId, and total
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL
FROM CHINOOK.CUSTOMER C
FULL OUTER JOIN CHINOOK.INVOICE I ON 
C.CUSTOMERID = I.CUSTOMERID;


--3.3
-- Create a right join that joins album and artist specifying artist name and title.
SELECT AR.NAME, AL.TITLE
FROM CHINOOK.ALBUM AL
RIGHT JOIN CHINOOK.ARTIST AR ON 
AR.ARTISTID=AL.ARTISTID;

--3.4
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT DISTINCT *
FROM CHINOOK.ALBUM 
CROSS JOIN CHINOOK.ARTIST 
ORDER BY CHINOOK.ARTIST.NAME ASC;


--3.5
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT E1.EMPLOYEEID AS EMPLOYEE, E2.REPORTSTO AS REPORTSTO
FROM CHINOOK.EMPLOYEE E1, CHINOOK.EMPLOYEE E2
WHERE E1.REPORTSTO = E2.EMPLOYEEID;


--3.6
--a
-- Create a query that shows the customer first name and last name as FULL_NAME 
-- with the total amount of money they have spent as TOTAL.
SELECT CONCAT(CONCAT(C.FIRSTNAME, ' '),C.LASTNAME) AS FULL_NAME, SUM(I.TOTAL) AS TOTAL
FROM CHINOOK.CUSTOMER C
INNER JOIN CHINOOK.INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID
GROUP BY CONCAT(CONCAT(C.FIRSTNAME, ' '),C.LASTNAME);

--b
-- Create a query that shows the employee that has made the highest total value of sales (total of all invoices).
SELECT EMPLOYEEID, SUMS.TOTAL
FROM (
    SELECT E.EMPLOYEEID, SUM(I.TOTAL) AS TOTAL
    FROM CHINOOK.CUSTOMER C
    INNER JOIN CHINOOK.INVOICE I ON C.CUSTOMERID = I.CUSTOMERID 
    INNER JOIN CHINOOK.EMPLOYEE E ON E.EMPLOYEEID = C.SUPPORTREPID
    GROUP BY E.EMPLOYEEID
    ORDER BY TOTAL DESC
) SUMS
WHERE ROWNUM =1;

--c
/*
Create a query which shows the number of purchases per each genre. Display the name of each genre and number of purchases. 
Show the most popular genre first.
*/
SELECT G.NAME AS GENRE, COUNT(I.INVOICEID) AS PURCHASES
FROM CHINOOK.GENRE G
FULL OUTER JOIN CHINOOK.TRACK T ON G.GENREID = T.GENREID
FULL OUTER JOIN CHINOOK.INVOICELINE I ON T.TRACKID = I.TRACKID 
GROUP BY G.NAME
ORDER BY PURCHASES DESC;




--------------------------------
-- QUESTION 4
--------------------------------

--4.1
--a
-- Create a function that returns the current time.
CREATE OR REPLACE FUNCTION CURR_TIME
    RETURN VARCHAR
        IS RET_TIME VARCHAR(11);
     BEGIN
        SELECT TO_CHAR(CURRENT_DATE , 'HH:MI:SS AM')
        INTO RET_TIME
        FROM DUAL;
    RETURN RET_TIME;
END CURR_TIME;

SELECT CURR_TIME
FROM DUAL;

--b
-- create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION NAME_LENGTH
RETURN VARCHAR2
    IS RET VARCHAR2(255);
BEGIN
    FOR NAM IN(
        SELECT *
        FROM CHINOOK.MEDIATYPE M
    )
    LOOP
        RET:= CONCAT(RET,('Length of ' || NAM.NAME || ' is ' || LENGTH(NAM.NAME)|| '           '));
    END LOOP;
    RETURN RET;
END NAME_LENGTH; 

SELECT NAME_LENGTH FROM DUAL;


--4.2
--a
--Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION AVG_INVOICE 
RETURN NUMBER
IS
AVG_NUM NUMBER(4,2);
BEGIN 
    SELECT AVG(I.TOTAL) AS AVERAGE
    INTO AVG_NUM
    FROM CHINOOK.INVOICE I
    ORDER BY AVG(I.TOTAL);
    
    RETURN AVG_NUM;
END AVG_INVOICE;

SELECT AVG_INVOICE FROM DUAL;

--b
--Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE
RETURN varchar2
IS
MOST_EXP varchar2(300);
BEGIN 
    SELECT SUB.NAME
    INTO MOST_EXP
    FROM (
        SELECT *
        FROM CHINOOK.TRACK T 
        ORDER BY T.UNITPRICE DESC
    ) SUB
    WHERE ROWNUM = 1;
    RETURN MOST_EXP;
END MOST_EXPENSIVE;

SELECT MOST_EXPENSIVE FROM DUAL;

--4.3
--Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICELINE
RETURN NUMBER
IS
AVG_LINE NUMBER(4,2);
BEGIN 
    SELECT AVG(I.UNITPRICE) AS AVERAGE
    INTO AVG_LINE
    FROM CHINOOK.INVOICELINE I
    ORDER BY AVG(I.UNITPRICE);
    
    RETURN AVG_LINE;
END AVG_INVOICELINE;

SELECT AVG_INVOICELINE FROM DUAL;
    
    
--4.4
-- Create a function that returns a cursor with all employees who are born after 1968.

CREATE OR REPLACE PROCEDURE YOUNG_EMPLOYEE(S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT E.FIRSTNAME, E.LASTNAME, E.BIRTHDATE
        FROM CHINOOK.EMPLOYEE E
        WHERE to_date(E.BIRTHDATE) > to_date('01-JAN-68');
END;

DECLARE
    SVAR SYS_REFCURSOR;
    E_FNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
    E_LNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
    E_BDAY CHINOOK.EMPLOYEE.BIRTHDATE%TYPE;
BEGIN
    YOUNG_EMPLOYEE(SVAR);
    LOOP
    FETCH SVAR INTO E_FNAME, E_LNAME, E_BDAY;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(E_FNAME || ' ' || E_LNAME || ' ' || E_BDAY);
    END LOOP;
    CLOSE SVAR;
END;



--------------------------------
-- QUESTION 5
--------------------------------
--5.1
-- Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE E_FIRST_LAST(S OUT SYS_REFCURSOR)    
IS
BEGIN
    OPEN S FOR
    SELECT E.FIRSTNAME, E.LASTNAME
        FROM CHINOOK.EMPLOYEE E;
END;     

DECLARE
    SVAR SYS_REFCURSOR;
    E_FNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
    E_LNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    E_FIRST_LAST(SVAR);
    LOOP
    FETCH SVAR INTO E_FNAME, E_LNAME;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(E_FNAME || ' ' || E_LNAME);
    END LOOP;
    CLOSE SVAR;
END;


--5.2
-- a
--Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPD_EMP_INFO(EMP_ID IN CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE, 
                                         UPD_FNAME IN CHINOOK.EMPLOYEE.FIRSTNAME%TYPE, 
                                         UPD_LNAME IN EMPLOYEE.LASTNAME%TYPE, 
                                         UPD_BDAY IN EMPLOYEE.BIRTHDATE%TYPE, 
                                         UPD_ADDR IN EMPLOYEE.ADDRESS%TYPE, 
                                         UPD_CITY IN EMPLOYEE.CITY%TYPE, 
                                         UPD_ST IN EMPLOYEE.STATE%TYPE, 
                                         UPD_COUNTRY IN EMPLOYEE.COUNTRY%TYPE, 
                                         UPD_POSTCODE IN EMPLOYEE.POSTALCODE%TYPE, 
                                         UPD_PHONE IN EMPLOYEE.PHONE%TYPE, 
                                         UPD_EMAIL IN EMPLOYEE.EMAIL%TYPE)
AS
BEGIN
    UPDATE CHINOOK.EMPLOYEE E
    SET E.LASTNAME = UPD_LNAME, E.FIRSTNAME = UPD_FNAME, E.BIRTHDATE = UPD_BDAY,
        E.ADDRESS = UPD_ADDR, E.CITY = UPD_CITY, E.STATE = UPD_ST, E.COUNTRY = UPD_COUNTRY, 
        E.POSTALCODE = UPD_POSTCODE, E.PHONE = UPD_PHONE, E.EMAIL = UPD_EMAIL
    WHERE E.EMPLOYEEID = EMP_ID;
END; 

SET SERVEROUTPUT ON;
DECLARE 
BEGIN

    UPD_EMP_INFO(9, 'George', 'Newmann', '03-OCT-90', '1400 E Main Street', 'Garden City', 
    'KS', 'US', '12345', '(219) 319-2491', 'gnewman401@gmail.com');
    DBMS_OUTPUT.PUT_LINE('Employee edited');
END;

--b
--Create a stored procedure that returns the managers of an employee.ge
CREATE OR REPLACE PROCEDURE GET_EMP_MAN(EMP_ID IN CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE,
                                        E_FNAME OUT CHINOOK.EMPLOYEE.FIRSTNAME%TYPE,
                                        E_LNAME OUT CHINOOK.EMPLOYEE.LASTNAME%TYPE,
                                        E_ID OUT CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE,
                                        M_FNAME OUT CHINOOK.EMPLOYEE.FIRSTNAME%TYPE,
                                        M_LNAME OUT CHINOOK.EMPLOYEE.LASTNAME%TYPE,
                                        M_ID OUT CHINOOK.EMPLOYEE.REPORTSTO%TYPE)
AS
BEGIN
    SELECT E1.EMPLOYEEID, E1.FIRSTNAME, E1.LASTNAME, E2.EMPLOYEEID, E2.FIRSTNAME, E2.LASTNAME
    INTO E_ID, E_FNAME, E_LNAME, M_ID, M_FNAME, M_LNAME
    FROM CHINOOK.EMPLOYEE E1, CHINOOK.EMPLOYEE E2
    WHERE E1.REPORTSTO = E2.EMPLOYEEID AND E1.EMPLOYEEID = EMP_ID;
END;

SET SERVEROUTPUT ON;
DECLARE
    MAN_FNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
    MAN_LNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
    MAN_ID CHINOOK.EMPLOYEE.REPORTSTO%TYPE;
    EMP_FNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
    EMP_LNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
    EMP_ID CHINOOK.EMPLOYEE.REPORTSTO%TYPE;
    
BEGIN
    GET_EMP_MAN(3, EMP_FNAME, EMP_LNAME, EMP_ID, MAN_FNAME, MAN_LNAME, MAN_ID);
    DBMS_OUTPUT.PUT_LINE('Employee: ' || EMP_FNAME || ' ' || EMP_LNAME || ' (ID:' || EMP_ID || ')  reports to ' ||
        MAN_FNAME || ' ' || MAN_LNAME || ' (ID:' || MAN_ID || ')');
END;


--5.3
-- Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GET_CUST_COMP(C_ID IN OUT CHINOOK.CUSTOMER.CUSTOMERID%TYPE,
                                        C_FNAME OUT CHINOOK.CUSTOMER.FIRSTNAME%TYPE,
                                        C_LNAME OUT CHINOOK.CUSTOMER.LASTNAME%TYPE,
                                        CCO_NAME OUT CHINOOK.CUSTOMER.COMPANY%TYPE)
AS
BEGIN
    SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, C.COMPANY
    INTO C_ID, C_FNAME, C_LNAME, CCO_NAME 
    FROM CHINOOK.CUSTOMER C
    WHERE C.CUSTOMERID = C_ID;
END;

SET SERVEROUTPUT ON;
DECLARE
    CUST_FNAME CHINOOK.CUSTOMER.FIRSTNAME%TYPE;
    CUST_LNAME CHINOOK.CUSTOMER.LASTNAME%TYPE;
    CUST_ID CHINOOK.CUSTOMER.CUSTOMERID%TYPE;
    CUST_CO_NAME CHINOOK.CUSTOMER.COMPANY%TYPE;
    
BEGIN
    CUST_ID := 5;
    GET_CUST_COMP(CUST_ID, CUST_FNAME, CUST_LNAME, CUST_CO_NAME);
    DBMS_OUTPUT.PUT_LINE('Customer ' || CUST_FNAME || ' ' || CUST_LNAME || ' works at ' || CUST_CO_NAME);
END;



--------------------------------
-- QUESTION 6
--------------------------------
--6
--In this section you will be working with transactions. 
--Transactions are usually nested within a stored procedure.
-- a
-- Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them).
INSERT INTO CHINOOK.INVOICE VALUES (413, 60, '08-JUN-19', '123 Seaseme Street', 'New York', 'NY', 'US', '12345', 10.43);


CREATE OR REPLACE PROCEDURE DEL_INVOICE(I_ID IN CHINOOK.INVOICE.INVOICEID%TYPE)
AS
BEGIN
    DELETE FROM CHINOOK.INVOICE
    WHERE INVOICEID = I_ID;
    
    COMMIT;
END;

SET SERVEROUTPUT ON;
DECLARE
    INV_ID CHINOOK.INVOICE.INVOICEID%TYPE;
    
BEGIN
    INV_ID := 413;
    DEL_INVOICE(INV_ID);
    DBMS_OUTPUT.PUT_LINE('Invoice with id ' || INV_ID || ' has been deleted.');
END;



--b
--Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE NEW_CUSTOMER(
                        C_NEW_ID IN CHINOOK.CUSTOMER.CUSTOMERID%TYPE,
                        C_FNAME IN CHINOOK.CUSTOMER.FIRSTNAME%TYPE,
                        C_LNAME IN CHINOOK.CUSTOMER.LASTNAME%TYPE,
                        C_COMPANY IN CHINOOK.CUSTOMER.COMPANY%TYPE,
                        C_ADDR IN CHINOOK.CUSTOMER.ADDRESS%TYPE,
                        C_CITY IN CHINOOK.CUSTOMER.CITY%TYPE,
                        C_STATE IN CHINOOK.CUSTOMER.STATE%TYPE,
                        C_CTRY IN CHINOOK.CUSTOMER.COUNTRY%TYPE,
                        C_POSTCODE IN CHINOOK.CUSTOMER.POSTALCODE%TYPE,
                        C_PHONE IN CHINOOK.CUSTOMER.PHONE%TYPE,
                        C_FAX IN CHINOOK.CUSTOMER.FAX%TYPE,
                        C_EMAIL IN CHINOOK.CUSTOMER.EMAIL%TYPE,
                        C_SUPID IN CHINOOK.CUSTOMER.SUPPORTREPID%TYPE)
AS
BEGIN
    INSERT INTO CHINOOK.CUSTOMER VALUES (C_NEW_ID, C_FNAME, C_LNAME, C_COMPANY, C_ADDR, C_CITY, C_STATE, 
                                C_CTRY, C_POSTCODE, C_PHONE, C_FAX, C_EMAIL, C_SUPID);
    COMMIT;                            
END;

SET SERVEROUTPUT ON;
DECLARE
BEGIN
    NEW_CUSTOMER(61, 'Indiana', 'Jones', 'University of Chicago', '5801 S Ellis Ave','Chicago', 
                'IL', 'US','60637', '(773) 702-1234', '(773) 702-1235', 'iamindiejones@indianajones.com', 3);
    DBMS_OUTPUT.PUT_LINE('Added New Customer');
END;



--------------------------------
-- QUESTION 7
--------------------------------
--7.1
--a 
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER EMP_INSERT
    AFTER INSERT ON CHINOOK.EMPLOYEE
DECLARE
BEGIN
    DBMS_OUTPUT.PUT_LINE('New employee added. Trigger is working!');
END;    

INSERT INTO CHINOOK.EMPLOYEE VALUES (16, 'Page', 'Larry', 'CEO', null, '26-MAR-73', '01-JAN-98', '123 Seaseme Stree', 
            'New York', 'NY', 'US', '12345', '(123) 456-7890', '(123) 456-7891' , 'icreatedgoogle@google.com');


--b
-- Create an after update trigger on the album table that fires after a row is inserted in the table
SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER ALBUM_INSERT
    AFTER INSERT ON CHINOOK.ALBUM
DECLARE
BEGIN
    DBMS_OUTPUT.PUT_LINE('Added a new album!');
END;

INSERT INTO CHINOOK.ALBUM VALUES (350, 'My New EP', 1);

--c
-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER CUST_DEL
    AFTER DELETE ON CHINOOK.CUSTOMER
DECLARE
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer entry deleted!');
END;

DELETE FROM CHINOOK.CUSTOMER
WHERE CHINOOK.CUSTOMER.CUSTOMERID = 61;