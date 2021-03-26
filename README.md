# springbootspockfeigngradle-customer-client

Author: Jose Alfonso Corominas
email:  jatcorominas@gmail.com
cell:   (647) 618-2080

Demo application that integrates springboot feign spock and gradle

1. Download the project

2. Import the gradle project into your IDE

3. Build the project

4. Run the unit tests


SPOCK, FEIGN TOOLS AND REFERENCES

I. Tools

1. Spring Initializr

   https://start.spring.io/

   Create a skeleton with Java 8, Gradle, with dependencies on Spring Web, OpenFeign and if applicable the Eureka client or Eureka server

2. Spock

   https://spockframework.org/ Very useful for determining what should go in to the gradle.build file. But it is not springboot specific

   The sample project is the best quick practical introduction to Spock for beginners

II. Reading References

   Time saving tips:

   (a) For Feign it is enough to understand "8. Introduction to Feign | Java Development Journal - https://www.javadevjournal.com/spring/feign/"
   (b) For Spock it is enough to get the sample project running on IntelliJ
   (c) For integrating Spock with springboot it is enough to understand "4. Spring @WebMvcTest with Spock Framework - allegro.tech https://blog.allegro.tech/2018/04/Spring-WebMvcTest-with-Spock.html"
       and the github source code "5. mvctet-spock/WebMvcTestApplicationSpecs.groovy at master https://github.com/rafal-glowinski/mvctest-spock/blob/master/src/test/groovy/com/rg/webmvctest/WebMvcTestApplicationSpecs.groovy'


1. Testing with Spring and Spock | Baeldung https://www.baeldung.com/spring-spock-testing

2. Testing Spring Boot Applications with Spock | Tomas Lin's Programming Brain Dump https://fbflex.wordpress.com/2013/09/18/testing-spring-boot-applications-with-spock/

3. Writing Unit Tests With Spock Framework: Creating a Gradle Project https://fbflex.wordpress.com/2013/09/18/testing-spring-boot-applications-with-spock/

4. Spring @WebMvcTest with Spock Framework - allegro.tech https://blog.allegro.tech/2018/04/Spring-WebMvcTest-with-Spock.html

   The best introduction to spring boot and spock for those who are not familiar with Spock

5. mvctet-spock/WebMvcTestApplicationSpecs.groovy at master https://github.com/rafal-glowinski/mvctest-spock/blob/master/src/test/groovy/com/rg/webmvctest/WebMvcTestApplicationSpecs.groovy

   Very useful for identifying the spring boot specific spock dependency in gradle that is not mentioned in the Apache spock documentation in I.2 above, i.e. org.spockframework:spock-spring:${spockVersion}

6. Spring RestTemlate.getForEntity() https://www.concretepage.com/spring-5/spring-resttemplate-getforentity

7. java-Spring Rest Template mocking with Spock - Stack Overflow https://stackoverflow.com/questions/47288305/spring-rest-template-mocking-with-spock

8. Introduction to Feign | Java Development Journal - https://www.javadevjournal.com/spring/feign/

   The easiest practical introduction to Feign for those unfamiliar with it.

9. Introduction to Spring Cloud OpenFeign | Baeldung https://www.baeldung.com/spring-cloud-openfeign

10. Spring Cloud Tutorial- REST Client using Netflix Feign Simple Example | JavaInUse https://www.javainuse.com/spring/spring-cloud-netflix-feign-tutorial

