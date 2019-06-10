--2.0 Queries and DML

--2.1 SELECT


--A-- Select all records from the Employee table.   --A--


select * from CHINOOK.EMPLOYEE;



--B--Select all records from the Employee table where last name is King. --B--

select * from CHINOOK.EMPLOYEE WHERE LASTNAME LIKE 'K%';


--C-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. --C--

select * from CHINOOK.EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;


--D-- Select all albums in Album table and sort result set in descending order by title. --D--

SELECT * FROM CHINOOK.ALBUM ORDER BY TITLE DESC;


--E-- Select first name from Customer and sort result set in ascending order by city. --E--

SELECT * FROM CHINOOK.CUSTOMER ORDER BY CITY ASC;


--F-- Select all invoices with a billing address like “T%” --F--

select * from CHINOOK.INVOICE WHERE BILLINGADDRESS LIKE 'T%';



/*

2.2 INSERT INTO
Insert two new records into Genre table
Insert two new records into Employee table
Insert two new records into Customer table 

*/

--A--
SELECT * FROM CHINOOK.genre;

INSERT INTO CHINOOK.GENRE VALUES(26,'Fionna');

INSERT INTO CHINOOK.GENRE VALUES(27,'Joe');

--B--
SELECT * FROM CHINOOK.EMPLOYEE;

INSERT INTO CHINOOK.EMPLOYEE VALUES (9,'Kharel','Imoj','IT Staff','6','09-JAN-95','06-JUN-10','123 Example AVE','Garland','TX','Canada','T2P 5G3','+1 (123) 456-7890','+1 (123) 456-7890','john@example.com');

INSERT INTO CHINOOK.EMPLOYEE VALUES (10,'Sharma','Aman','IT Staff','6','01-JAN-96','06-JUN-11','124 Example DR','Garland','TX','canada','T2P 5G3','+1 (111) 456-7899','+1 (111) 456-7899','joe123@gmail.com');


--C--

SELECT * FROM CHINOOK.CUSTOMER;

INSERT INTO chinook.customer VALUES (60,'Aman','Sharma','null','123 Avenue Dr','Gujarat','AMD','India',462001,'+91 1234567890','+91 1234567890','Aman@example.com',3);



/*

2.3 UPDATE.

Update Aaron Mitchell in Customer table to Robert Walter.
Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”.

*/

--A--

update customer set firstname ='Robert',lastname='Walter' where customerid = 32;

select customerid from customer where firstname ='Robert';

--B--

update artist set name ='CCR' where artistid = 76;

select * from artist where name ='Creedence Clearwater Revival';

/*

3.0 Joins

In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

3.1 INNER
Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

3.2
Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

3.3 RIGHT
Create a right join that joins album and artist specifying artist name and title.

3.4 CROSS
Create a cross join that joins album and artist and sorts by artist name in ascending order.

3.5 SELF
Perform a self-join on the employee table, joining on the reportsto column.
*/


--3.1--


select customer.firstname,customer.lastname,invoice.invoiceid from customer
inner join invoice
on customer.customerid=invoice.customerid 
order by invoice.invoiceid,customer.firstname;


--3.2--

select customer.customerid, customer.firstname,customer.lastname,invoice.invoiceid,invoice.total from customer
full join invoice
on customer.customerid=invoice.customerid
order by customer.customerid;


--3.3--

select artist.name,album.title from album
right join artist
on album.artistid=artist.artistid
order by artist.name;

--3.4--

select * from album
cross join artist
order by artist.name;

--3.5--

select E1.REPORTSTO as employees , E2.REPORTSTO as manager 
from employee E1, employee E2 
where e1.employeeid=e2.reportsto;





--3.6 A--

select concat(customer.firstname,customer.lastname) as FULL_NAME,sum(invoice.total)
from customer , employee
inner join invoice 
on customer.customerid=invoice.customerid, 
on customer.supportrepid=
group by concat(customer.firstname,customer.lastname),sum(invoice.total)
order BY FULL_NAME;

--3.6 B--

SELECT EMPLOYEEID,TOTAL 
FROM (
SELECT E.EMPLOYEEID,SUM(I.TOTAL) AS TOTAL FROM CUSTOMER C
INNER JOIN INVOICE I 
ON C.CUSTOMERID=I.CUSTOMERID
INNER JOIN EMPLOYEE E
ON E.EMPLOYEEID=c.supportrepid
GROUP BY E.EMPLOYEEID
ORDER BY TOTAL DESC) A
WHERE ROWNUM =1;


--3.6 C--


SELECT G.NAME AS GENRE , COUNT(IL.INVOICEID) AS PURCHASES
FROM GENRE G
FULL OUTER JOIN TRACK T
ON G.GENREID= T.GENREID
FULL OUTER JOIN INVOICELINE IL
ON IL.TRACKID=T.TRACKID
GROUP BY G.NAME
ORDER BY PURCHASES DESC;




--4.1-A--

--SELECT sysdate,'MM/DD/YYYY HH:MM:SS' FROM DUAL;

create or replace function getSysdate

return varchar is

  l_sysdate varchar(50);

begin

  select to_char(current_timestamp,'DD/MM/YYYY HH:MM:SS')
    into l_sysdate
    from dual;

  return l_sysdate;

end;

select getSysdate() as time from dual;


--4.1-B--

SELECT * FROM MEDIATYPE;

create or replace FUNCTION LNTH(N_ID IN NUMBER)
RETURN NUMBER

IS
    V_LENGTH NUMBER(38);

BEGIN
    SELECT LENGTH(NAME)
    INTO V_LENGTH
    FROM MEDIATYPE
    WHERE MEDIATYPEID=N_ID;

RETURN V_LENGTH;

END ;

SELECT LNTH(MEDIATYPEID) AS NAME_LENGTH FROM MEDIATYPE;
--select all total from invoice;

--4.2.A--

--select round(avg(  ALL total)) total from invoice;

create or replace FUNCTION INVOICE_AVG
RETURN NUMBER

IS
    V_AVG NUMBER(38);

BEGIN
    SELECT ROUND(AVG(TOTAL))
    INTO V_AVG
    FROM INVOICE;

RETURN V_AVG;

END;

SELECT INVOICE_AVG FROM INVOICE;

--4.2.B--

--select max(total) track from invoice;

create or replace FUNCTION INVOICE_MAX_TRACK
RETURN NUMBER

IS
    V_MAX NUMBER(38);

BEGIN
    SELECT MAX(TOTAL)AS TRACK
    INTO V_MAX
    FROM INVOICE;

RETURN V_MAX;

END;

SELECT INVOICE_MAX_TRACK FROM INVOICE;


/*

5.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
5.1 Basic Stored Procedure
Create a stored procedure that selects the first and last names of all the employees.
5.2 Stored Procedure Input Parameters
Create a stored procedure that updates the personal information of an employee.
Create a stored procedure that returns the managers of an employee.ge
5.3 Stored Procedure Output Parameters
Create a stored procedure that returns the name and company of a customer.


*/



CREATE OR REPLACE PROCEDURE GET_NAME(EMPLOYEE_ID IN NUMBER)
IS

LAST_NAME EMPLOYEE.LASTNAME%TYPE;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;

BEGIN 

SELECT LASTNAME,FIRSTNAME
INTO LAST_NAME,FIRST_NAME
FROM EMPLOYEE
WHERE EMPLOYEEID=EMPLOYEE_ID;

DBMS_OUTPUT.PUT_LINE(LAST_NAME||FIRST_NAME);


END;


--5.2--

CREATE OR REPLACE PROCEDURE UPDATE_EMP(EMP_ID NUMBER)
AS 
BEGIN
UPDATE EMPLOYEE 
SET 
STATE ='GA'
WHERE EMPLOYEEID=EMP_ID;
END;


--5.3--
CREATE OR REPLACE PROCEDURE EMPLOYEE_ID (EMP_ID NUMBER)
AS 
MANAGER VARCHAR(50);
BEGIN
SELECT REPORTSTO
INTO MANAGER
FROM EMPLOYEE
WHERE EMPLOYEEID = EMP_ID;
END;


--5.4


CREATE OR REPLACE PROCEDURE CUSTOMER_COMPANY(CUSTOMER_ID IN NUMBER)
IS

LAST_NAME CUSTOMER.LASTNAME%TYPE;
FIRST_NAME CUSTOMER.FIRSTNAME%TYPE;
V_COMPANY customer.company %TYPE;

BEGIN 

SELECT LASTNAME,FIRSTNAME,COMPANY
INTO LAST_NAME,FIRST_NAME,V_COMPANY
FROM CUSTOMER
WHERE CUSTOMERID=CUSTOMER_ID;

DBMS_OUTPUT.PUT_LINE(LAST_NAME||' '||FIRST_NAME||' '||V_COMPANY);

END;


--6.1--


CREATE OR REPLACE PROCEDURE EMPLOYEE_ID_DELETE (EMP_ID NUMBER)
AS 
BEGIN
DELETE FROM EMPLOYEE
WHERE EMPLOYEEID = EMP_ID;
END;




