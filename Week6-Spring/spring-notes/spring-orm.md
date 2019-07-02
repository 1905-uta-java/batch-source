# Spring ORM
- Spring ORM is a module used to integrate data access code with spring (object relational mapping)
- allows us to combine hibernate and spring, as well as JPA
Benefits:
- easier testing 
- less boiler plate code 
- easy transaction management
- no longer a hibernate.cfg.xml; those configuration details are in the beans.xml file now
- our hibernate code has no knowledge of spring but we can leverage DI, AOP, etc.

## We Must Define 3 Spring Beans
1. DataSource
    - where we configure our database credentials and driver class name
2. SessionFactory
    - where we configure hibernate specific properties, such as hibernate.dialect, hibernate.hbm2ddl.auto, hibernate.show_sql
3. TransactionManager

- our DataSource is injected into our SessionFactory
- our SessionFactory is injected into the TransactionManager
- our SessionFactory is injected into our DAOs


### Contextual Session
- a session managed by hibernate throughout the scope of a spring managed transaction

### @Repository 
- stereotype annotations for our DAOs 
- also indicates to the PersistanceExceptionTranslationPostProcessor that exceptions thrown by your DAOs should be interpreated as Spring data access exceptions (give you more details than SQL exceptions)


## @Trasactional

#### Transaction Propagation
REQUIRED (default)
- same transaction will be used if one already exists
- otherwise a new transaction will be opened

REQUIRES_NEW
- a new physical transaction will be created
- inner transaction can commit or rollback independently of the outer transaction

NESTED
- inner and outer use the same transaction, but are separated by savepoints 
- inner can roll back or commit with the second

MANDATORY
- existing transaction must already be open or container will throw an IllegalTransactionException

NEVER
- an existing cannot already be open; exception will be thrown if one is
- must execute non-transactionally

SUPPORTED
- executes within the scope of existing transaction, otherwise will execute non-transactionally

NOT_SUPPORTED
- executes outside any existing transaction, existing transaction will be paused


