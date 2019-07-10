# Spring Projects
- Spring Projects are built on Spring modules and provide solutions to other issues faced by enterprise applications
- there are a variety spring project, take a look at what they have to offer here https://spring.io/projects
- the spring projects are also open source so you can take a look at their source code here https://github.com/spring-projects

# Spring Boot
- Spring Boot is the first project we'll be working with
- Spring Boot takes an opinionated view of building Spring applications in order to get an application up and running as quickly as possible
- using Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run"

### Benefits and Features of Spring Boot
- embedded Tomcat server
- provided 'starter' dependencies
- necessary pre-configuration 
    - no xml configuration for additional config
- Spring Boot Actuator
- Spring Boot Development tools

#### Running a Spring Boot Application
- annotate the class with your main method with @SpringBootApplication
    - @Configuration 
    - @EnableAutoConfiguration 
    - @ComponentScan
- in main method SpringApplication.run(Driver.class, args);



# Spring Data JPA
- Spring Data JPA is a Spring Boot project which abstracts away our data persistence layer
- provides repository support for the Java Persistence API (JPA)
- eases development of applications that need to access JPA data sources

### Important Interfaces
- CrudRepository
    - PagingAndSortingRepository
        - JpaRepository