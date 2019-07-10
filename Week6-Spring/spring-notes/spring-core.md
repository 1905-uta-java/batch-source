# Spring Framework 
- a framework built on java which relies on dependency injection as an implementation of inversion of control
- Spring = Framework, also Spring = projects built on the framework
- need jdk8, support for jdk9 

## IOC
- inversion of control:
    - inverts control of the application flow and object creation to a framework to achieve loose coupling
    - abstract design where behavior is injected into your classes
    - "Hollywood principle" -> "don't call us, we'll call you"
- service locator:
    - bean controls the instantiation of its dependencies

### Dependency Injection 
- an implementation of IOC
    - dependency: some object to be used
    - injection: passing dependency to a dependent object at creation time
    - spring bean is provided its dependencies by the framework
    - decouples configuration from implementation

In spring this is done with the "spring container" (IOC, or Inversion of Control, Container) which injects our registered objects, or our "spring beans"
- IOC container is represented by an ApplicationContext or BeanFactory
- we can register beans with the IOC so that it may manage the lifecycle of objects, providing dependencies where necessary 

## Spring Modules
The Spring Framework is subdivided into different modules.

- Spring Core
- Spring Beans
- Spring Context 

Spring Core + Beans provide the essential DI features with the BeanFactory interface

Spring Contexts builds on core and beans to add additional functionality; access to ApplicationContext 

Additional Modules:
- Web module
- AOP module
- JDBC module
- ORM module

#### Spring Projects
Spring Projects are built on top of a set of modules 
- Spring Boot
- Spring Data
- Spring Security

## BeanFactory vs. ApplicationContext
- both represent the IOC container, manage the lifecycle of spring managed objects

BeanFactory
- older
- lazily instantiates our spring beans
- must provide a resource object configured for our beans.xml

Ex
- XmlBeanFactory

```java
      XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("Beans.xml")); 
```

ApplicationContext 
- newer
- eagerly instantiates spring beans
- provides support for annotations 
- creates and manages its own resource object 

ApplicationContext is a sub-interface which adds more enterprise-specific functionality on top of the basic functionality of the BeanFactory.
- Easier integration with Spring’s AOP features
- Message resource handling (for use in internationalization)
- Event publication
- Application-layer specific contexts such as the WebApplicationContext for use in web applications.

Ex
- ClassPathXmlApplicationContext
- FileSystemXmlApplicationContext
- XmlWebApplicationContext

```java
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
```

## Spring Bean
In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container. Otherwise, a bean is simply one of many objects in your application. Beans, and the dependencies among them, are reflected in the configuration metadata used by a container.
- an object whose lifecycle is managed by spring's IOC container 

<img src="https://docs.spring.io/spring/docs/current/spring-framework-reference/images/container-magic.png" alt="role of the IOC container" >

#### Configuration
**XML config**

- defined in beans.xml (src > main > resources > beans.xml)
```xml
<bean name="beanA" class="com.revature.BeanA"></bean>
``` 

**annotation config**
1. enable Component Scanning in beans.xml

2. annotate classes with stereotype annotations 
    - @Component: general spring-managed component 
    - @Repository DAO
    - @Controller 
    - @Service


- there's also a way of creating a class with the @Configuration, with methods @Bean to register beans in a centralized location without having a beans.xml file

## Bean Lifecycle
0. request bean from ApplicationContext
    - instantiation 
    - populate properties
1. BeanNameAware's setBeanName method
2. BeanClassLoaderAware's setBeanClassLoader method
3. BeanFactoryAware's setBeanFactory method
4. EnvironmentAware's setEnvironment method
5. BeanPostProcessors' postProcessBeforeInitialization method
6. InitializingBean's afterPropertiesSet method
7. custom init method
    - init-method in our bean declaration (beans.xml)
    - @PostConstruct
8. BeanPostProcessors' postProcessAfterInitialization method

-- On Shutdown
1. DestructionAwareBeanPostProcessors' postProcessBeforeDestruction method
2. DisposableBean's destroy
3. custom destroy method
    - destroy-method in our bean declaration (beans.xml)
    - @PreDestroy

## Bean Scopes
1. Singleton - single object instance in the IOC container, each consecutive call for this bean from the AC will return the same object *DEFAULT* 
2. Prototype - many instances of the bean a new instance is created whenever requeted from A.C.

For web-aware:
3. request (http)
4. session (http session)
5. global session (global http session; has to do with portlets)

## Bean Wiring 
- just as there are various ways to register beans with our IOC container, there are a few ways we can wire our beans together
- bean wiring is the process of providing configuration to our application to indicate which 
- how we connect our beans via DI

### Setter Injection
- uses set___() methods to provide dependencies 
- more readable
- doesn't ensure DI because an instance can be created without configuring a particular field (no issue if we don't configure), will still be created (@Required will make sure there is configuration for that dependency -- prevents NullPointerExceptions later down the line)

### Constructor
- uses constructor injection, similarly to Angular, when we provide a constructor with the necessary dependencies as constructor arguments
- does not allow you to create objects until dependencies are ready

### Autowiring
- let spring figure out dependencies itself ("automagically")

#### By Type
- automagically determines DI based on the type of the dependencies and the setters in the class

```xml
<bean name="beanA" class="com.ex.BeanA" autowire="byType"></bean>
<bean name="beanB" class="com.ex.BeanB"></bean>
```

```java
public class BeanA{
    private BeanB beanB;

    public void setBeanB(BeanB beanB){
        this.beanB=beanB;
    }
    // looks to inject based on the type of object 
}
```
#### By Name
- automagically determines DI based on the name of the dependencies and the setters in the class

```xml
<bean name="beanA" class="com.ex.BeanA" autowire="byName"></bean>
<bean name="beanB" class="com.ex.BeanB"></bean>
```

```java
public class BeanA{
    private BeanB beanB;

    public void setBeanB(BeanB beanB){
        this.beanB=beanB;
    }
    // looks to inject based on the name of the field and name of the setter 
}
```

### Autowiring using Annotations
- enable component scanning
```xml
<context:component-scan base-package="com.ex"></context:component-scan>
```

- include @Autowired over the field which needs to be injected
```java
@Component
public class BeanA{
    
    @Autowired
    private BeanB beanB;


    // looks to perform type based setter injection
}
```

@Qualifier annotation can be used if there is more than one bean of the same type to identify