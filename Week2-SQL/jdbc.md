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

## PreparedStatement
- subinterface of statement, but it is compiled separately from the parameters to prevent sql injection

> con.prepareStatement(sql)

> statement.set[value]

## CallableStatement
- subinterface of prepared statement

## ResultSet 
- table of data representing a database result set, returned from a statement
- maintains a cursor pointing to its current row of data
- onitially the cursor is positioned before the first row
- next method moves the cursor to the next row, returns false when there are no more rows in the ResultSet object

> statement.executeQuery()

> rs.get[type]([column index]/ [column name])


# DAO Design Pattern
- Data Access Object 
