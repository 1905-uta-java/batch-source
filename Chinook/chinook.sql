/* Chinook */



/* - Section 2 Queries and DML - */


/* -- Section 2.1 Select -- */

-- Part a.
SELECT *
    FROM EMPLOYEE;
/

-- Part b.
SELECT *
    FROM EMPLOYEE
    WHERE LASTNAME = 'King';
/

-- Part c.
SELECT *
    FROM EMPLOYEE
    WHERE FIRSTNAME = 'Andrew'
    AND REPORTSTO IS NULL;
/

-- Part d.
SELECT *
    FROM ALBUM
    ORDER BY TITLE DESC;
/

-- Part e.
SELECT FIRSTNAME
    FROM CUSTOMER
    ORDER BY CITY ASC;
/

-- Part f.
SELECT *
    FROM INVOICE
    WHERE BILLINGADDRESS LIKE 'T%';
/


/* -- Section 2.2 Insert Into -- */

-- Part a.
INSERT INTO GENRE VALUES(26, 'Chiptune');
INSERT INTO GENRE VALUES(27, 'Big Band');

COMMIT;
/

-- Part b.
INSERT INTO EMPLOYEE
    VALUES(
        9,
        'Schmitt',
        'John',
        'Hiring Manager',
        1,
        TO_DATE('1950-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'),
        TO_DATE('2017-1-15 00:00:00','yyyy-mm-dd hh24:mi:ss'),
        '111 Road ST.',
        'Townsville',
        'VA',
        'USA',
        '70000',
        '+1 (918) 867-5309',
        '+1 (918) 867-5308',
        'john.schmitt@chinookcorp.com'
    );
    
INSERT INTO EMPLOYEE
    VALUES(
        10,
        'Foster',
        'Jane',
        'Hiring Agent',
        9,
        TO_DATE('1995-5-20 00:00:00','yyyy-mm-dd hh24:mi:ss'),
        TO_DATE('2019-6-6 00:00:00','yyyy-mm-dd hh24:mi:ss'),
        '1001 Grand Ave.',
        'Chillwater',
        'VA',
        'USA',
        '70044',
        '+1 (901) 123-4567',
        '+1 (901) 123-4578',
        'jane.foster@chinookcorp.com'
    );

COMMIT;
/

-- Part c.
INSERT INTO CUSTOMER (
        CUSTOMERID,
        FIRSTNAME,
        LASTNAME,
        ADDRESS,
        CITY,
        STATE,
        COUNTRY,
        POSTALCODE,
        PHONE,
        EMAIL,
        SUPPORTREPID
    )
    VALUES(
        60,
        'Ryan',
        'Young',
        '5678 DriveName Road',
        'Branson',
        'Missouri',
        'USA',
        '65615',
        '+1 (417) 417-4174',
        'ryanyoung2002@gmail.com',
        4
    );

INSERT INTO CUSTOMER (
        CUSTOMERID,
        FIRSTNAME,
        LASTNAME,
        ADDRESS,
        CITY,
        STATE,
        COUNTRY,
        POSTALCODE,
        PHONE,
        EMAIL,
        SUPPORTREPID
    )
    VALUES(
        61,
        'Jeremy',
        'Oldman',
        '1234 StreetName Drive',
        'Saint Louis',
        'Missouri',
        'USA',
        '63101',
        '+1 (314) 159-2654',
        'jeremyoldman@hotmail.com',
        5
    );

COMMIT;
/



/* - Section 3 Joins- */


/* -- Section 3.1 Inner -- */

-- Part a.
SELECT C.FIRSTNAME AS FIRSTNAME, C.LASTNAME AS LASTNAME, I.INVOICEID AS INVOICEID
    FROM CUSTOMER C
    JOIN INVOICE I
    ON C.CUSTOMERID = I.CUSTOMERID;
/


/* -- Section 3.2 Outer -- */

-- Part a.
SELECT C.CUSTOMERID AS CUSTOMERID, C.FIRSTNAME AS CUSTOMERFIRSTNAME, C.LASTNAME AS CUSTOMERLASTNAME, I.INVOICEID AS INVOICEID, I.TOTAL AS TOTAL
    FROM CUSTOMER C
    FULL JOIN INVOICE I
    ON C.CUSTOMERID = I.CUSTOMERID;
/


/* -- Section 3.3 Right -- */

-- Part a.
SELECT AR.NAME AS ARTISTNAME, AL.TITLE AS ALBUMTITLE
    FROM ALBUM AL
    RIGHT JOIN ARTIST AR
    ON AL.ARTISTID = AR.ARTISTID;
/


/* -- Section 3.4 Cross -- */

-- Part a.
SELECT *
    FROM ALBUM AL
    CROSS JOIN ARTIST AR
    ORDER BY AR.NAME ASC;
/


/* -- Section 3.5 Self -- */

-- Part a.
SELECT *
    FROM EMPLOYEE A, EMPLOYEE B
    WHERE A.REPORTSTO = B.EMPLOYEEID;
/


/* -- Section 3.6 Joined Queries -- */

-- Part a.
SELECT C.FIRSTNAME || ' ' || C.LASTNAME AS FULL_NAME, SUM(I.TOTAL) AS TOTAL
    FROM CUSTOMER C
    JOIN INVOICE I
    ON C.CUSTOMERID = I.CUSTOMERID
    GROUP BY C.FIRSTNAME, C.LASTNAME;
/

-- Part b.
SELECT SUBQUERY.EMPLOYEEID AS EMPLOYEEID, SUBQUERY.FIRSTNAME AS FIRSTNAME, SUBQUERY.LASTNAME AS LASTNAME, SUBQUERY.TOTAL AS TOTAL
    FROM (
        SELECT E.EMPLOYEEID AS EMPLOYEEID, E.FIRSTNAME AS FIRSTNAME, E.LASTNAME AS LASTNAME, SUM(I.TOTAL) AS TOTAL
            FROM EMPLOYEE E
            JOIN CUSTOMER C
                JOIN INVOICE I
                ON I.CUSTOMERID = C.CUSTOMERID
            ON E.EMPLOYEEID = C.SUPPORTREPID
            GROUP BY E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME
        ) SUBQUERY
    WHERE TOTAL = (
        SELECT MAX(SUBQUERY.TOTAL)
        FROM (
            SELECT SUM(I.TOTAL) AS TOTAL
                FROM EMPLOYEE E
                JOIN CUSTOMER C
                    JOIN INVOICE I
                    ON I.CUSTOMERID = C.CUSTOMERID
                ON E.EMPLOYEEID = C.SUPPORTREPID
                GROUP BY E.EMPLOYEEID
                ) SUBQUERY
        );
/

-- Part c.
SELECT G.NAME AS GENRE, COUNT(L.INVOICELINEID) AS TOTAL
    FROM
        GENRE G
        JOIN
            TRACK T
            JOIN
                INVOICELINE L
            ON T.TRACKID = L.TRACKID
        ON G.GENREID = T.GENREID
    GROUP BY G.GENREID, G.NAME
    ORDER BY COUNT(L.INVOICELINEID) DESC;
/



/* - Section 4 SQL Functions - */


/* -- Section 4.1 Defined Functions -- */


-- Part a.
CREATE OR REPLACE FUNCTION GET_TIME
    RETURN VARCHAR
    IS MYTIME VARCHAR(40);
    BEGIN
        SELECT
            TO_CHAR(CURRENT_TIMESTAMP, 'HH:MI:SS AM')
        INTO
            MYTIME
        FROM 
            DUAL;
            
        RETURN(MYTIME);
    END;
/

SELECT
    GET_TIME()
FROM 
    DUAL;
/

-- Part b.
CREATE OR REPLACE FUNCTION GET_MEDIATYPE_NAME_LENGTH(M_ID IN NUMBER) 
    RETURN NUMBER 
    IS NAME_LENGTH NUMBER;
    BEGIN
        SELECT LENGTH(M.NAME)
            INTO NAME_LENGTH
            FROM MEDIATYPE M
            WHERE M.MEDIATYPEID = M_ID;
        RETURN(NAME_LENGTH);
    END;
/

SELECT GET_MEDIATYPE_NAME_LENGTH(5)
    FROM DUAL;
/


/* -- Section 4.2 System Defined Aggregate Functions -- */

-- Part a.
CREATE OR REPLACE FUNCTION GET_AVG_TOTAL_INVOICE
    RETURN NUMBER
    IS AVG_TOTAL NUMBER(10,2);
    BEGIN
        SELECT AVG(I.TOTAL)
        INTO AVG_TOTAL
        FROM INVOICE I;
        RETURN AVG_TOTAL;
    END;
/

SELECT GET_AVG_TOTAL_INVOICE()
    FROM DUAL;
/

-- Part b.
CREATE OR REPLACE FUNCTION GET_MOST_EXPENSIVE_TRACK
    RETURN NUMBER
    IS T_ID NUMBER;
    BEGIN
        SELECT SUBQUERY.TRACKID
            INTO T_ID
            FROM (
                SELECT T.TRACKID
                FROM TRACK T
                ORDER BY T.UNITPRICE DESC
            ) SUBQUERY
            WHERE ROWNUM = 1;
        RETURN T_ID;
    END;
/

SELECT GET_MOST_EXPENSIVE_TRACK()
    FROM DUAL;
/


/* -- Section 4.3 User Defined Scalar Functions -- */

-- Part a.
CREATE OR REPLACE FUNCTION GET_AVG_INVOICELINE_PRICE
    RETURN NUMBER
    IS AVG_PRICE NUMBER;
    BEGIN
        SELECT AVG(L.UNITPRICE)
        INTO AVG_PRICE
        FROM INVOICELINE L;
        
        RETURN AVG_PRICE;
    END;
/

SELECT GET_AVG_INVOICELINE_PRICE
    FROM DUAL;
/


/* -- Section 4.4 User Defined Table Valued Functions -- */

-- Part a.
CREATE OR REPLACE FUNCTION EMPLOYEE_AFTER_1968
    RETURN SYS_REFCURSOR
    IS C SYS_REFCURSOR;
    BEGIN
         OPEN C FOR
            SELECT *
            FROM EMPLOYEE E
            WHERE BIRTHDATE >= TO_DATE('1969-01-01','yyyy-mm-dd'); 
        RETURN C;
    END;
/

SET SERVEROUTPUT ON;

DECLARE
    C SYS_REFCURSOR := EMPLOYEE_AFTER_1968;
    EMPID EMPLOYEE.EMPLOYEEID%TYPE;
    EMPLAST EMPLOYEE.LASTNAME%TYPE;
    EMPFIRST EMPLOYEE.FIRSTNAME%TYPE;
    EMPTITLE EMPLOYEE.TITLE%TYPE;
    EMPREPORT EMPLOYEE.REPORTSTO%TYPE;
    EMPBDAY EMPLOYEE.BIRTHDATE%TYPE;
    EMPHIREDATE EMPLOYEE.HIREDATE%TYPE;
    EMPADDRESS EMPLOYEE.ADDRESS%TYPE;
    EMPCITY EMPLOYEE.CITY%TYPE;
    EMPSTATE EMPLOYEE.STATE%TYPE;
    EMPCOUNTRY EMPLOYEE.COUNTRY%TYPE;
    EMPPOSTCODE EMPLOYEE.POSTALCODE%TYPE;
    EMPPHONE EMPLOYEE.PHONE%TYPE;
    EMPFAX EMPLOYEE.FAX%TYPE;
    EMPEMAIL EMPLOYEE.EMAIL%TYPE;
BEGIN
    LOOP
        FETCH C INTO EMPID, EMPLAST, EMPFIRST, EMPTITLE, EMPREPORT, EMPBDAY, EMPHIREDATE, EMPADDRESS, EMPCITY, EMPSTATE, EMPCOUNTRY, EMPPOSTCODE, EMPPHONE, EMPFAX, EMPEMAIL;
        EXIT WHEN C%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(EMPFIRST||' '||EMPLAST||' was born on '||EMPBDAY);
    END LOOP;
    CLOSE C;
END;
/



/* - Section 5 Stored Procedures - */


/* -- Section 5.1 Basic Stored Procedure -- */

-- Part a.
CREATE OR REPLACE PROCEDURE GET_EMPLOYEE_NAMES(RESULT OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN RESULT FOR
        SELECT FIRSTNAME, LASTNAME
            FROM EMPLOYEE;
END;
/

DECLARE
    C SYS_REFCURSOR;
    FIRSTNAME VARCHAR2(20);
    LASTNAME VARCHAR2(20);
BEGIN
    GET_EMPLOYEE_NAMES(C);
    
    LOOP
        FETCH C INTO FIRSTNAME, LASTNAME;
        EXIT WHEN C%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||LASTNAME);
    END LOOP;
END;
/


/* -- Section 5.2 Stored Procedure Input Parameters -- */

-- Part a.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(EMPID IN NUMBER, EMPLAST IN VARCHAR2, EMPFIRST IN VARCHAR2, EMPTITLE IN VARCHAR2, EMPREPORTS IN NUMBER, EMPADDRESS IN VARCHAR2, EMPCITY IN VARCHAR2, EMPSTATE IN VARCHAR2, EMPCOUNTRY IN VARCHAR2, EMPPOST IN VARCHAR2, EMPPHONE IN VARCHAR2, EMPFAX IN VARCHAR2, EMPEMAIL IN VARCHAR2)
IS
BEGIN
    UPDATE EMPLOYEE
        SET LASTNAME = EMPLAST,
            FIRSTNAME = EMPFIRST,
            TITLE = EMPTITLE,
            REPORTSTO = EMPREPORTS,
            ADDRESS = EMPADDRESS,
            CITY = EMPCITY,
            STATE = EMPSTATE,
            COUNTRY = EMPCOUNTRY,
            POSTALCODE = EMPPOST,
            PHONE = EMPPHONE,
            FAX = EMPFAX,
            EMAIL = EMPEMAIL
        WHERE EMPLOYEEID = EMPID;
        COMMIT;
END;
/

BEGIN
    UPDATE_EMPLOYEE (
        10,
        'Foster',
        'Jane',
        'Advertising Manager',
        1,
        '111 Top Blvd.',
        'Chillwater',
        'VA',
        'USA',
        '70045',
        '+1 (901) 123-4567',
        '+1 (901) 123-4578',
        'jane.foster@chinookcorp.com'
    );
END;
/

SELECT *
    FROM EMPLOYEE
    where EMPLOYEEID = 10;
/

-- Part b.
CREATE GLOBAL TEMPORARY TABLE EMPLOYEETEMP (
    EMPLOYEEID NUMBER NOT NULL,
    LASTNAME VARCHAR2(20) NOT NULL,
    FIRSTNAME VARCHAR2(20) NOT NULL,
    TITLE VARCHAR2(30),
    REPORTSTO NUMBER,
    BIRTHDATE DATE,
    HIREDATE DATE,
    ADDRESS VARCHAR2(70),
    CITY VARCHAR2(40),
    STATE VARCHAR2(40),
    COUNTRY VARCHAR2(40),
    POSTALCODE VARCHAR2(10),
    PHONE VARCHAR2(24),
    FAX VARCHAR2(24),
    EMAIL VARCHAR2(60),
    CONSTRAINT PK_EMPLOYEETEMP PRIMARY KEY  (EMPLOYEEID)
);

COMMIT;
/

CREATE OR REPLACE PROCEDURE GET_MANAGERS(MANAGERS OUT SYS_REFCURSOR, EMPID NUMBER)
IS
    REPORTS NUMBER;
BEGIN
    
    -- Return -1, indicating failure, if no employee with the given id was found
    IF((SELECT COUNT(*) FROM EMPLOYEE WHERE EMPLOYEEID = EMPID) = 0)
    THEN
        RETURN -1;
    END IF;
    
    SELECT REPORTSTO
        INTO REPORTS
        FROM EMPLOYEE
        WHERE EMPLOYEEID = EMPID;
    
    -- Return -1, indicating failure, if the employee associated with the id
    -- has no immediate supervisor or their REPORTSTO field was set to their
    -- own id (which would loop endlessly)
    IF(REPORTS IS NULL OR REPORTS = EMPID)
    THEN
        RETURN -1;
    END IF;
    
    -- set our current employee to the specified
    -- employee's immediate supervisor
    EMPID := REPORTS;
    
    -- clear our temp table
    EXECUTE IMMEDIATE 'TRUNCATE TABLE EMPLOYEETEMP';
    
    -- First, add the entry for the employees immediate superviser,
    -- then add the entry of that employees superviser and so on, until the
    -- loop reaches an employee with no superviser, or one who's superviser is
    -- set to themself
    LOOP
        EXIT WHEN EMPID IS NULL OR EMPID = (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = EMPID);
        
        INSERT INTO EMPLOYEETEMP
            SELECT *
                FROM EMPLOYEE
                WHERE EMPLOYEEID = EMPID;
        
        SELECT REPORTSTO
            INTO EMPID
            FROM EPLOYEE
            WHERE EMPLOYEEID = EMPID;
        
    END LOOP;
    
    OPEN MANAGERS FOR
        SELECT *
            FROM EMPLOYEETEMP;
    
    RETURN 1;
END;
/


/* -- Section 5.3 Stored Procedure Output Parameters -- */

-- Part a.
CREATE OR REPLACE PROCEDURE GET_CUSTOMER_NAME_AND_COMPANY(ID NUMBER, NAME OUT VARCHAR2, CUSTOMERCOMPANY OUT VARCHAR2)
IS
BEGIN
    SELECT C.FIRSTNAME||' '||C.LASTNAME, C.COMPANY
        INTO NAME, CUSTOMERCOMPANY
        FROM CUSTOMER C
        WHERE C.CUSTOMERID = ID;
END;
/

SET SERVEROUTPUT ON;

DECLARE
    NAME VARCHAR2(80);
    COMPANY VARCHAR2(80);
BEGIN
    GET_CUSTOMER_NAME_AND_COMPANY(1, NAME, COMPANY);
    DBMS_OUTPUT.PUT_LINE(NAME||' with '||COMPANY);
END;
/


/* - Section 6 Transactions - */


/* -- Section 6.0 -- */

-- Part a.
CREATE OR REPLACE PROCEDURE REMOVE_INVOICE(DELETEID NUMBER)
IS
BEGIN
    -- Delete all invoice lines that reference this invoice
    DELETE
        FROM INVOICELINE
        WHERE INVOICEID = DELETEID;
    
    -- Then delete the invoice itself
    DELETE
        FROM INVOICE
        WHERE INVOICEID = DELETEID;
    
    -- uppon successfull completion, commit changes
    COMMIT;
EXCEPTION
    -- Handle all exceptions by rolling back the changes
    WHEN OTHERS THEN
        ROLLBACK;
END;
/

INSERT 
    INTO INVOICE (INVOICEID, CUSTOMERID, INVOICEDATE, BILLINGADDRESS, BILLINGCITY, BILLINGCOUNTRY, BILLINGPOSTALCODE, TOTAL)
    VALUES (413, 2, TO_DATE('2009-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), 'Theodor-Heuss-Straﬂe 34', 'Stuttgart', 'Germany', '70174', 1.99);

INSERT
    INTO INVOICELINE
    VALUES(2241, 413, 3177, 1.99, 1);

COMMIT;

SELECT *
    FROM INVOICE
    WHERE INVOICEID = 413;
/

BEGIN
    REMOVE_INVOICE(413);
END;
/

SELECT *
    FROM INVOICE
    WHERE INVOICEID = 413;

SELECT *
    FROM INVOICELINE
    WHERE INVOICEID = 413;

-- Part b.
CREATE OR REPLACE PROCEDURE ADD_CUSTOMER(NEW_CUSTOMERID NUMBER, NEW_FIRSTNAME VARCHAR2, NEW_LASTNAME VARCHAR2, NEW_COMPANY VARCHAR2, NEW_ADDRESS VARCHAR2, NEW_CITY VARCHAR2, NEW_STATE VARCHAR2, NEW_COUNTRY VARCHAR2, NEW_POSTALCODE VARCHAR2, NEW_PHONE VARCHAR2, NEW_FAX VARCHAR2, NEW_EMAIL VARCHAR2, NEW_SUPPORTREPID NUMBER)
IS
    REPEXISTS NUMBER;
    CUSTOMEREXISTS NUMBER;
BEGIN
    SELECT COUNT(*)
        INTO REPEXISTS
        FROM EMPLOYEE 
        WHERE EMPLOYEEID = NEW_SUPPORTREPID;
    
    SELECT COUNT(*)
        INTO CUSTOMEREXISTS
        FROM CUSTOMER
        WHERE CUSTOMERID = NEW_CUSTOMERID;
    
    IF (
        NEW_CUSTOMERID IS NULL
        OR NEW_FIRSTNAME IS NULL
        OR NEW_LASTNAME IS NULL
        OR NEW_EMAIL IS NULL
        OR REPEXISTS < 1
        OR CUSTOMEREXISTS > 0
    )
    THEN
        RETURN;
    END IF;
    
    INSERT
        INTO CUSTOMER
        VALUES(NEW_CUSTOMERID, NEW_FIRSTNAME, NEW_LASTNAME, NEW_COMPANY, NEW_ADDRESS, NEW_CITY, NEW_STATE, NEW_COUNTRY, NEW_POSTALCODE, NEW_PHONE, NEW_FAX, NEW_EMAIL, NEW_SUPPORTREPID);
    
    COMMIT;
END;
/

SELECT *
    FROM CUSTOMER
    WHERE CUSTOMERID = 62;

BEGIN
    ADD_CUSTOMER(62, 'Peter', 'Smith', NULL, '3,Raj Bhavan Road', 'Bangalore', NULL, 'India', '560001', '+91 080 22289999', NULL, 'peter_smith@yahoo.in', 3);
END;
/

SELECT *
    FROM CUSTOMER
    WHERE CUSTOMERID = 62;
/


/* - Section 7 Triggers - */


/* -- Section 7.1 After/For -- */

-- Part a.
SET SERVEROUTPUT ON;
/

CREATE OR REPLACE TRIGGER AFTER_INSERT_EMP
    AFTER INSERT
    ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('After insert on the employee table');
END;
/

INSERT
    INTO EMPLOYEE
    VALUES(11, 'Foster', 'John', 'Advertising Staff', 10, TO_DATE('1995-6-23 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2019-6-30 00:00:00','yyyy-mm-dd hh24:mi:ss'), '111 Top Blvd.', 'Chillwater', 'VA', 'USA', '70045', NULL, '+1 (901) 765-4321', 'john.foster@chinookcorp.com');
/

-- Part b.
SET SERVEROUTPUT ON;
/

CREATE OR REPLACE TRIGGER AFTER_UPDATE_ALBUM
    AFTER UPDATE
    ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('After updating the album table');
END;
/

UPDATE ALBUM
    SET ARTISTID = 146
    WHERE ALBUMID = 226;

UPDATE ALBUM
    SET ARTISTID = 147
    WHERE ALBUMID = 226;
/

-- Part c.
SET SERVEROUTPUT ON;
/

CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER
    AFTER DELETE
    ON CUSTOMER
BEGIN
    DBMS_OUTPUT.PUT_LINE('After deleting a row in the customer table');
END;
/

DELETE
    FROM CUSTOMER
    WHERE CUSTOMERID = 62;
/