# JDBC
- Java Database Connectivity
- a means for accessing our DB with a Java application
- oracle provides a dependency for doing this with an oracle database -- this is the ojdbc jar file we downloaded
- this will allow us to use classes and interfaces 

## Connection 
- a connection or a session with the database, which allows us to execute sql statements and retrieve their results 
- create using a DriverManager's static getConnection method, along with our database credentials

## Statement 
- used for executing a static SQL statement and returning the results it produces
- execution methods will execute them in the database
- autocommit by default is true
- creating a new statement
> Connection con = ConnectionUtil.getConnection();

> Statement s = con.createStatement();

> ResultSet rs = s.executeQuery(sql);

## PreparedStatement
- subinterface of statement, but it is compiled separately from the parameters to prevent sql injection

> con.prepareStatement(sql)

> statement.set[type]([1 based index],[value])

## CallableStatement
- subinterface of prepared statement
- used in order to execute stored procedures
		
> Connection con = ConnectionUtil.getHardCodedConnection();

> CallableStatement cs = con.prepareCall("{call PROCEDURE_NAME(?,?,...)}"));
			
> cs.set[type]([index], [value]);

> cs.execute();

## ResultSet 
- table of data representing a database result set, returned from a statement
- maintains a cursor pointing to its current row of data
- initially the cursor is positioned before the first row
- next method moves the cursor to the next row, returns false when there are no more rows in the ResultSet object

> statement.executeQuery()

> rs.next();

> rs.get[type]([column index]/[column name])


# DAO Design Pattern
- provides a standard interface for performing data access operations
- promotes loose coupling and allows for interchangeability between data access code

# Isolation Levels

|                   | dirty read |  non repeatable read |  phantom read  |
|:-----------------:|:----------:|:--------------------:|:--------------:|
|  read uncommitted |            |                      |                |  
|  read committed   |     X      |                      |                |   
|  repeatable read  |     X      |           X          |                |   
|  serializable     |     X      |           X          |        X       |   

- X indicates that the phenomena are prevented at that level of isolation
- the default level in an oracle db is read committed
- we actually only have 

# Transaction Phenomena

### Dirty Read
- when a second transaction reads uncommitted data from the first transaction
- the first transaction could rollback and the data read in the second would no longer be valid

### NonRepeatable read
- when the first transaction reads data before a second transaction modifies that data
- the original read from the first transaction cannot be repeated and get the same result

### Phantom Read
- the first transaction reads data before a second transaction adds or removes data
- if the first transaction repeats the query it will have more or less data

