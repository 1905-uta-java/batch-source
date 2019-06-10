/*
Question 2.1
*/ 
SELECT * FROM CHINOOK.employee;

SELECT * FROM CHINOOK.employee WHERE lastname = 'King';

SELECT * FROM CHINOOK.employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

SELECT * FROM CHINOOK.album ORDER BY title DESC;

SELECT firstname FROM CHINOOK.customer ORDER BY city ASC;

SELECT * from CHINOOK.invoice WHERE billingaddress LIKE 'T%';

/*
Question 2.2
*/

INSERT INTO CHINOOK.genre VALUES (26, 'POTS AND PANS');
INSERT INTO CHINOOK.genre VALUES (27, 'MISCELANIOUS');

INSERT INTO CHINOOK.employee(EmployeeID, LastName, FirstName, Title, ReportsTo)
VALUES (9, 'JONES', 'BILLY', 'Ad Manager', 1);
INSERT INTO CHINOOK.employee(EmployeeID, LastName, FirstName, Title, ReportsTo)
VALUES (10, 'JONES', 'SALLY', 'Advertiser', 9);

INSERT INTO CHINOOK.customer(customerid, firstname, lastname, email) 
VALUES (60, 'ABC', 'DEF', 'ghi@jkl.com');
INSERT INTO CHINOOK.customer(customerid, firstname, lastname, email) 
VALUES (61, 'MNO', 'PQR', 'stu@vwx.com');

/*
Question 2.3
*/

UPDATE CHINOOK.customer SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

UPDATE CHINOOK.artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

/*
Questions 3.1 - 3.5
*/

SELECT CHINOOK.customer.firstname, CHINOOK.customer.lastname, CHINOOK.invoice.invoiceid 
FROM CHINOOK.customer INNER JOIN CHINOOK.invoice
ON CHINOOK.customer.customerid = CHINOOK.invoice.customerid;

SELECT CHINOOK.invoice.customerid, CHINOOK.customer.firstname, CHINOOK.customer.lastname, 
CHINOOK.invoice.invoiceid, CHINOOK.invoice.total 
FROM CHINOOK.customer LEFT OUTER JOIN CHINOOK.invoice 
ON CHINOOK.customer.customerid = CHINOOK.invoice.customerid;

SELECT CHINOOK.artist.name, CHINOOK.album.title
FROM CHINOOK.artist RIGHT OUTER JOIN CHINOOK.album
ON CHINOOK.artist.artistid = CHINOOK.album.artistid;

SELECT * FROM CHINOOK.artist CROSS JOIN CHINOOK.album ORDER BY CHINOOK.artist.name ASC;

SELECT E1.firstname, E1.lastname, E2.firstname, E2.lastname 
FROM CHINOOK.employee E1, CHINOOK.employee E2 WHERE E1.reportsto = E2.employeeid;

/*
Question 3.6
*/

SELECT CONCAT(CONCAT(C.firstname, ' '), C.lastname) AS FULL_NAME, SUM(I.total) AS TOTAL 
FROM CHINOOK.customer C INNER JOIN CHINOOK.invoice I on C.customerid = I.customerid 
GROUP BY C.customerid, FULL_NAME, CONCAT(CONCAT(C.firstname, ' '), C.lastname) ORDER BY TOTAL;

SELECT A.firstname, A.lastname, A.TOTAL FROM 
(SELECT E.firstname, E.lastname, SUM(I.total) AS TOTAL FROM CHINOOK.employee E
INNER JOIN CHINOOK.customer C ON E.employeeid = C.supportrepid
INNER JOIN CHINOOK.invoice I ON C.customerid = I.customerid
GROUP BY E.firstname, E.lastname ORDER BY TOTAL DESC) A
WHERE ROWNUM = 1;

SELECT G.name AS GENRE, COUNT(I.invoicelineid) AS Purchases FROM CHINOOK.invoiceline I
INNER JOIN CHINOOK.track T ON I.trackid = T.trackid
INNER JOIN CHINOOK.genre G on T.genreid = G.genreid 
GROUP BY T.genreid, G.name
ORDER BY Purchases DESC;

/*
Question 4.1
*/

SELECT CURRENT_TIMESTAMP FROM DUAL;

SELECT LENGTH(name) FROM CHINOOK.mediatype;

/*
Question 4.2
*/

SELECT AVG(I.total) FROM CHINOOK.invoice I;

SELECT T.name FROM CHINOOK.track T 
WHERE T.unitprice = (SELECT MAX(T.unitprice) FROM CHINOOK.track T);

/*
Questions 4.3, 4.4
*/

CREATE OR REPLACE FUNCTION getInvoiceLineAverage 
RETURN FLOAT
IS 
ret FLOAT;
BEGIN
    SELECT AVG(I.unitprice) INTO ret FROM CHINOOK.invoiceline I;
    RETURN ret;
END;
/
SELECT getInvoiceLineAverage() FROM DUAL;

SELECT * FROM CHINOOK.employee;

CREATE OR REPLACE FUNCTION getEmployeesBorn1968Later
RETURN SYS_REFCURSOR
IS
my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR SELECT * FROM CHINOOK.employee E 
    WHERE E.birthdate >= to_date('1968-01-01');
    RETURN my_cursor;
END;
/

/*
Question 5.1
*/

CREATE OR REPLACE PROCEDURE getFirstAndLastEmpName(S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT E.firstname, E.lastname FROM CHINOOK.employee E;
END;
/
SET SERVEROUTPUT ON;
DECLARE
    SVAR SYS_REFCURSOR;
    TEMP_FN CHINOOK.employee.firstname%TYPE;
    TEMP_LN CHINOOK.employee.lastname%TYPE;
BEGIN
    getFirstAndLastEmpName(SVAR);
    LOOP
        FETCH SVAR INTO TEMP_FN, TEMP_LN;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(TEMP_FN||' '||TEMP_LN);
    END LOOP;
    CLOSE SVAR;
END;
/

/*
Question 5.2
*/

CREATE OR REPLACE PROCEDURE updateEmpCity(idt IN CHINOOK.employee.employeeid%TYPE, 
city IN CHINOOK.employee.city%TYPE)
IS
BEGIN
    UPDATE CHINOOK.employee E
    SET E.city = city
    WHERE E.employeeid = idt;
END;
/

CREATE OR REPLACE PROCEDURE getManagers (idt IN CHINOOK.employee.employeeid%TYPE, 
ret OUT CHINOOK.employee.firstname%type)
IS
BEGIN
    SELECT E.firstname INTO ret FROM CHINOOK.employee A
    JOIN CHINOOK.employee E ON A.reportsTo = E.employeeID
    WHERE A.employeeid = idt;
END;
/

/*
Question 5.3
*/

SELECT * FROM CHINOOK.customer;

CREATE OR REPLACE PROCEDURE getNameAndCompanyOfCust(cust IN CHINOOK.customer.customerid%type,
nam OUT CHINOOK.customer.firstname%TYPE, company OUT CHINOOK.customer.company%type)
IS
BEGIN
    SELECT C.firstname, C.company INTO nam, company FROM CHINOOK.customer C
    WHERE C.customerid = cust;
END;
/

/*
Question 6
*/

CREATE OR REPLACE PROCEDURE deleteInvoice(iid IN CHINOOK.invoice.invoiceid%TYPE)
IS
BEGIN
    DELETE FROM CHINOOK.invoiceline IL WHERE IL.invoiceid = iid;
    DELETE FROM CHINOOK.invoice I WHERE I.invoiceid = iid;
END;
/

SELECT * FROM CHINOOK.customer;

CREATE OR REPLACE PROCEDURE addCustomer(cid IN CHINOOK.customer.customerid%TYPE,
fn IN CHINOOK.customer.firstname%TYPE,
ln IN CHINOOK.customer.lastname%TYPE,
eml IN CHINOOK.customer.email%TYPE)
IS
BEGIN
    INSERT INTO CHINOOK.customer(customerid, firstname, lastname, email)
    VALUES (cid, fn, ln, eml);
END;
/

/*
Question 7
*/

SELECT * FROM CHINOOK.artist;

CREATE OR REPLACE TRIGGER TR_AFTER_INSERT_EMP
AFTER INSERT ON CHINOOK.employee
FOR EACH ROW
BEGIN
    IF(:NEW.state IS NULL) THEN
        UPDATE CHINOOK.employee E SET E.state = 'AB' WHERE E.employeeid = :NEW.employeeid;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER TR_AFTER_UPDATE_ALBUM
AFTER UPDATE ON CHINOOK.album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album updated.');
END;
/

CREATE OR REPLACE TRIGGER TR_AFTER_DELETE_CUSTOMER
AFTER DELETE ON CHINOOK.customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer deleted.');
END;
/

commit;
exit;