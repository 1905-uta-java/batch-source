/*
	Queries and DML
*/

-- 2.1 SELECT
--a
SELECT * FROM EMPLOYEE;

--b
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

--c
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;

--d
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

--e
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;

--f
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';


-- 2.2 INSERT INTO
--a
INSERT INTO GENRE VALUES(26, 'Anime');
INSERT INTO GENRE VALUES(27, 'K-Pop');

--b
INSERT INTO EMPLOYEE VALUES(9, 'Lockheart', 'Cassie', 'IT Staff', 7, '01-JAN-80', '05-FEB-11', '1234 Nova St', 'Austin', 'TX', 'US',
                                'T1K 2T4', '1 (512) 999-777', '1 (512) 999-1412', 'cassielockheart@gmail.com');

INSERT INTO EMPLOYEE VALUES(10, 'Chiffon', 'Fairchild', 'IT Staff', 7, '01-JUN-81', '05-AUG-10', '6789 Lena St', 'Houston', 'TX', 'US',
                                'T2K 2T5', '1 (512) 999-123', '1 (512) 999-456', 'chiffonfairchild@gmail.com');

--c
INSERT INTO CUSTOMER VALUES(60, 'Elizabeth', 'Mably', 'West Genetics', 'Pandoras 13 Ave', 'Florence', 'KY', 'US', 
                                '50100', '1 (512) 586-1234', '1 (512)_ 586-6789', 'elizabethmably@gmail.com', 6);

INSERT INTO CUSTOMER VALUES(61, 'Rana', 'Linchen', 'West Genetics', 'Pandoras 14 Ave', 'Florence', 'KY', 'US', 
                                '50100', '1 (512) 586-1122', '1 (512)_ 586-1212', 'ranalinchen@gmail.com', 6);


-- 2.3 UPDATE
-- a
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

-- b
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';


/* ----------------
    3.0 JOINS
*/ ----------------

-- 3.1 INNER
SELECT CUSTOMER.CUSTOMERID, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- 3.2 OUTER
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- 3.3 RIGHT
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

-- 3.4 CROSS
SELECT * FROM ARTIST
CROSS JOIN ALBUM 
ORDER BY ARTIST.NAME DESC;

-- 3.5 SELF
SELECT * 
FROM EMPLOYEE a, EMPLOYEE b
WHERE a.REPORTSTO = b.REPORTSTO;

-- 3.6 JOINED QUERIES

-- a
SELECT CUSTOMER.FIRSTNAME ||  ' ' || CUSTOMER.LASTNAME AS FULL_NAME, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- b
SELECT CUSTOMER.FIRSTNAME ||  ' ' || CUSTOMER.LASTNAME AS FULL_NAME, INVOICE.TOTAL
FROM CUSTOMER c
WHERE INVOICE.TOTAL = (SELECT MAX(INVOICE.TOTAL) 
                        FROM INVOICE i
                        WHERE c.CUSTOMERID = i.CUSTOMERID);
                        
-- c
 SELECT T2.name, T1.counter
FROM (  SELECT track.genreid, COUNT(track.genreid) as counter FROM track
        GROUP BY track.genreid
        ORDER BY track.genreid) T1
INNER JOIN
     (  SELECT genre.name, genre.genreid FROM genre) T2
ON T1.genreid = T2.genreid
ORDER BY counter DESC;


/*
    4.0
*/

-- 4.1
-- a
CREATE OR REPLACE FUNCTION GETCURRENTIME
RETURN TIMESTAMP
IS
BEGIN
    RETURN CURRENT_TIMESTAMP;
END;
/

BEGIN 
    DBMS_OUTPUT.PUT_LINE(GETCURRENTIME());
END;
/

-- b
CREATE OR REPLACE FUNCTION GETLENGTH(getName VARCHAR2)
RETURN NUMBER
AS
    len NUMBER;
BEGIN
    SELECT LENGTH(name) INTO len FROM mediatype WHERE mediatype.name = getName;
    RETURN len;
END;
/

SELECT GETLENGTH(name) FROM MEDIATYPE;


-- 4.2
-- a
CREATE OR REPLACE FUNCTION GETAVG
RETURN FLOAT 
AS
    avg_total FLOAT;
BEGIN
    SELECT AVG(total) INTO avg_total FROM Invoice;
    RETURN avg_total;
END GETAVG;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(GETAVG());
END;
/

-- b
CREATE OR REPLACE FUNCTION GET_MAX_PRICE
RETURN FLOAT
AS
    max_price FLOAT;
BEGIN
    SELECT MAX(unitprice) INTO max_price FROM Track;
    RETURN max_price;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(GET_MAX_PRICE());
END;
/

-- 4.3
CREATE OR REPLACE FUNCTION AVG_INVOICELINE
RETURN FLOAT
AS
    avg_invoiceline FLOAT;
    sum_invoiceline FLOAT;
    count_invoiceline FLOAT;
BEGIN
    SELECT SUM(unitprice) INTO sum_invoiceline FROM Invoiceline;
    SELECT COUNT(unitprice) INTO count_invoiceline FROM Invoiceline;
    avg_invoiceline:= sum_invoiceline / count_invoiceline;
    RETURN avg_invoiceline;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(AVG_INVOICELINE());
END;
/

-- 4.4
CREATE OR REPLACE FUNCTION born_after
RETURN SYS_REFCURSOR
AS
    rc SYS_REFCURSOR;
BEGIN
    OPEN rc FOR SELECT * FROM employee WHERE EXTRACT(YEAR FROM employee.birthdate) > 1968;
    return rc;
END;
/

SELECT born_after FROM DUAL;

/*
CREATE OR REPLACE FUNCTION BORN_AFTER
RETURN born_table
AS
    b_table born_table;
    num_employee NUMBER;
BEGIN
    b_table := born_table();
    SELECT COUNT(employeeid) INTO num_employee FROM employee;
    FOR i in 1 .. num_employee
    LOOP
        IF EXTRACT(YEAR FROM employee.birthdate) > 1968
        THEN
            counter.extend;
            counter(i) := tabs(employee.employeeid, employee.LASTNAME, employee.firstname, employee.title, employee.reportsto, employee.birthdate, employee.hiredate, employee.address,
                        employee.city, employee.state, employee.country, employee.postalcode, employee.phone, employee.fax, employee.email);
        END IF;
    END LOOP;    
END;
/
*/

/*
    5.0 STORED PROCEDURES
*/

-- 5.1
CREATE OR REPLACE PROCEDURE employee_name
AS
    fname employee.firstname%TYPE;
    lname employee.lastname%TYPE;
    counter NUMBER;
BEGIN
    SELECT COUNT(employee.employeeid) INTO counter FROM employee;
    FOR i IN 1..counter 
    LOOP
        SELECT firstname, lastname INTO fname, lname FROM employee WHERE employee.employeeid = i;
        DBMS_OUTPUT.PUT_LINE(fname || ' ' || lname);
    END LOOP;
END;
/

BEGIN
    employee_name();
END;
/

-- 5.2
-- a
CREATE OR REPLACE PROCEDURE update_address(addr IN employee.address%TYPE, id IN employee.employeeid%TYPE)
AS
BEGIN
    UPDATE employee
    SET address = addr
    WHERE employeeid = id;
END;
/

BEGIN
    update_address('923 7 ST NW', 8);
END;
/

-- b
CREATE OR REPLACE PROCEDURE show_manager(id IN employee.employeeid%TYPE)
AS
    emp_id employee.reportsto%TYPE;
    f_name employee.firstname%TYPE;
    l_name employee.lastname%TYPE;
BEGIN
    SELECT employee.reportsto INTO emp_id FROM employee 
    WHERE employee.employeeid = id;
    
    SELECT firstname, lastname INTO f_name, l_name FROM employee
    WHERE employee.employeeid = emp_id;
    DBMS_OUTPUT.PUT_LINE(f_name || ' ' || l_name);
END;
/

EXECUTE show_manager(8);

-- TO DO

-- 5.3
CREATE OR REPLACE PROCEDURE customer_info(id IN customer.customerid%TYPE)
AS
    cur SYS_REFCURSOR;
    fname customer.firstname%TYPE;
    lname customer.lastname%TYPE;
    comp customer.company%TYPE;
BEGIN
    OPEN cur FOR 
        SELECT firstname, lastname, company FROM customer WHERE customer.customerid = id;
    LOOP
        FETCH cur INTO fname, lname, comp;
        EXIT WHEN cur%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer name: ' || fname || ' ' || lname || '. Company: ' || comp);
    END LOOP;
    CLOSE cur;    
END;
/

EXECUTE customer_info(1);


/*
    6.0 TRANSACTIONS
*/

-- a
ALTER TABLE invoiceline
DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoiceline
ADD CONSTRAINT fk_invoicelineinvoiceid
    FOREIGN KEY (invoiceid)
    REFERENCES invoice(invoiceid)
    ON DELETE CASCADE;
    

CREATE OR REPLACE PROCEDURE delete_invoice(id IN invoice.invoiceid%TYPE)
IS
BEGIN
    SET TRANSACTION READ WRITE;
    DELETE FROM invoice WHERE invoiceid = id;   
    COMMIT;
END;
/

EXECUTE delete_invoice(1);

-- b
CREATE OR REPLACE PROCEDURE add_customer(id IN customer.customerid%TYPE, 
                    f IN customer.firstname%TYPE, l IN customer.lastname%TYPE, e IN customer.email%TYPE)
AS
BEGIN
    SET TRANSACTION READ WRITE NAME 'hehe';
    INSERT INTO customer(customerid, firstname, lastname, email) VALUES (id, f, l, e);
    COMMIT;
END;
/

EXECUTE add_customer(60, 'Mantu', 'Nguyen', 'abcdef@gmail.com');

  
/*
    7.0 TRIGGERS
*/

-- a
CREATE OR REPLACE TRIGGER insert_notification
AFTER INSERT ON employee
FOR EACH ROW
ENABLE
BEGIN
    DBMS_OUTPUT.PUT_LINE('You just inserted a new record');
END;
/

INSERT INTO employee(employeeid, lastname, firstname, reportsto) VALUES(9, 'Nguyen', 'Cuong', 6);

-- b
CREATE OR REPLACE TRIGGER update_notification
AFTER UPDATE ON album
FOR EACH ROW
ENABLE
BEGIN
    DBMS_OUTPUT.PUT_LINE('You just updated the table');
END;
/

-- c
CREATE OR REPLACE TRIGGER delete_notification
AFTER DELETE ON customer
FOR EACH ROW
ENABLE
BEGIN
    DBMS_OUTPUT.PUT_LINE('You just deleted a record');
END;
/













