# Spring Boot Login example with Spring Security, MySQL and JWT
Build a Spring Boot Login and Registration example (Rest API) that supports JWT with HttpOnly Cookie. You’ll know:

- Appropriate Flow for User Login and Registration with JWT and HttpOnly Cookies
- Spring Boot Rest Api Architecture with Spring Security
- How to configure Spring Security to work with JWT
- How to define Data Models and association for Authentication and Authorization
- Way to use Spring Data JPA to interact with MySQL Database

## User Registration, Login and Authorization process.

![spring-boot-login-example-flow](spring-boot-login-example-flow.png)

## Spring Boot Server Architecture with Spring Security
You can have an overview of our Spring Boot Server with the diagram below:

![spring-boot-login-example-architecture](spring-boot-login-example-architecture.png)

For more detail, please visit:
> [Spring Boot Login example with MySQL and JWT](https://www.vcoder.com/spring-boot-login-example-mysql/)

> [For H2 Embedded database](https://www.vcoder.com/spring-boot-security-login-jwt/)

> [For MongoDB](https://www.vcoder.com/spring-boot-jwt-auth-mongodb/)

Working with Front-end:
> [Angular 12](https://www.vcoder.com/angular-12-jwt-auth-httponly-cookie/) / [Angular 13](https://www.vcoder.com/angular-13-jwt-auth-httponly-cookie/) / [Angular 14](https://www.vcoder.com/angular-14-jwt-auth/) / [Angular 15](https://www.vcoder.com/angular-15-jwt-auth/) / [Angular 16](https://www.vcoder.com/angular-16-jwt-auth/) / [Angular 17](https://www.vcoder.com/angular-17-jwt-auth/)

> [React](https://www.vcoder.com/react-login-example-jwt-hooks/) / [React Redux](https://www.vcoder.com/redux-toolkit-auth/)

## Dependency
– If you want to use PostgreSQL:
```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>
```
– or MySQL:
```xml
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <scope>runtime</scope>
</dependency>
```
## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`
- For PostgreSQL:
```
spring.datasource.url= jdbc:postgresql://localhost:5432/testdb
spring.datasource.username= postgres
spring.datasource.password= 123

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update

# App Properties
vcoder.app.jwtCookieName= vcoder
vcoder.app.jwtSecret= ======================vcoder=Spring===========================
vcoder.app.jwtExpirationMs= 86400000
```
- For MySQL
```
spring.datasource.url= jdbc:mysql://localhost:3306/testdb?useSSL=false
spring.datasource.username= root
spring.datasource.password= 123456

spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto= update

# App Properties
vcoder.app.jwtCookieName= vcoder
vcoder.app.jwtSecret= ======================vcoder=Spring===========================
vcoder.app.jwtExpirationMs= 86400000
```
## Run Spring Boot application
```
mvn spring-boot:run
```

## Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');



#use login_db1;

select * from roles;
INSERT INTO roles(id,name) VALUES(1,'ROLE_USER');
INSERT INTO roles(id,name) VALUES(2,'ROLE_ADMIN');
INSERT INTO roles(id,name) VALUES(3,'ROLE_MODERATOR');

#------------------------------------------- 

select * from users;
select * from user_roles;


#-- --------------To Delete the Corresponding User-------------------- ->
delete from user_roles where user_id=2;
delete from users where id=2;

delete from user_roles;
delete from users;
```

## Refresh Token

[Spring Boot Refresh Token with JWT example](https://www.vcoder.com/spring-boot-refresh-token-jwt/)

## More Practice:
> [Spring Boot File upload example with Multipart File](https://vcoder.com/spring-boot-file-upload/)

> [Exception handling: @RestControllerAdvice example in Spring Boot](https://vcoder.com/spring-boot-restcontrolleradvice/)

> [Spring Boot Repository Unit Test with @DataJpaTest](https://vcoder.com/spring-boot-unit-test-jpa-repo-datajpatest/)

> [Spring Boot Rest Controller Unit Test with @WebMvcTest](https://www.vcoder.com/spring-boot-webmvctest/)

> [Spring Boot Pagination & Sorting example](https://www.vcoder.com/spring-boot-pagination-sorting-example/)

> Validation: [Spring Boot Validate Request Body](https://www.vcoder.com/spring-boot-validate-request-body/)

> Documentation: [Spring Boot and Swagger 3 example](https://www.vcoder.com/spring-boot-swagger-3/)

> Caching: [Spring Boot Redis Cache example](https://www.vcoder.com/spring-boot-redis-cache-example/)

Associations:
> [JPA/Hibernate One To Many example in Spring Boot](https://www.vcoder.com/jpa-one-to-many/)

> [JPA/Hibernate Many To Many example in Spring Boot](https://www.vcoder.com/jpa-many-to-many/)

> [JPA/Hibernate One To One example in Spring Boot](https://www.vcoder.com/jpa-one-to-one/)

Deployment:
> [Deploy Spring Boot App on AWS – Elastic Beanstalk](https://www.vcoder.com/deploy-spring-boot-aws-eb/)

> [Docker Compose Spring Boot and MySQL example](https://www.vcoder.com/docker-compose-spring-boot-mysql/)

## Fullstack CRUD App

> [Vue.js + Spring Boot + H2 Embedded database example](https://www.vcoder.com/spring-boot-vue-js-crud-example/)

> [Vue.js + Spring Boot + MySQL example](https://www.vcoder.com/spring-boot-vue-js-mysql/)

> [Vue.js + Spring Boot + PostgreSQL example](https://www.vcoder.com/spring-boot-vue-js-postgresql/)

> [Angular 8 + Spring Boot + Embedded database example](https://www.vcoder.com/angular-spring-boot-crud/)

> [Angular 8 + Spring Boot + MySQL example](https://www.vcoder.com/angular-spring-boot-crud/)

> [Angular 8 + Spring Boot + PostgreSQL example](https://www.vcoder.com/angular-spring-boot-postgresql/)

> [Angular 10 + Spring Boot + MySQL example](https://www.vcoder.com/angular-10-spring-boot-crud/)

> [Angular 10 + Spring Boot + PostgreSQL example](https://www.vcoder.com/angular-10-spring-boot-postgresql/)

> [Angular 11 + Spring Boot + MySQL example](https://www.vcoder.com/angular-11-spring-boot-crud/)

> [Angular 11 + Spring Boot + PostgreSQL example](https://www.vcoder.com/angular-11-spring-boot-postgresql/)

> [Angular 12 + Spring Boot + Embedded database example](https://www.vcoder.com/angular-12-spring-boot-crud/)

> [Angular 12 + Spring Boot + MySQL example](https://www.vcoder.com/angular-12-spring-boot-mysql/)

> [Angular 12 + Spring Boot + PostgreSQL example](https://www.vcoder.com/angular-12-spring-boot-postgresql/)

> [Angular 13 + Spring Boot + H2 Embedded Database example](https://www.vcoder.com/spring-boot-angular-13-crud/)

> [Angular 13 + Spring Boot + MySQL example](https://www.vcoder.com/spring-boot-angular-13-mysql/)

> [Angular 13 + Spring Boot + PostgreSQL example](https://www.vcoder.com/spring-boot-angular-13-postgresql/)

> [Angular 14 + Spring Boot + H2 Embedded Database example](https://www.vcoder.com/spring-boot-angular-14-crud/)

> [Angular 14 + Spring Boot + MySQL example](https://www.vcoder.com/spring-boot-angular-14-mysql/)

> [Angular 14 + Spring Boot + PostgreSQL example](https://www.vcoder.com/spring-boot-angular-14-postgresql/)

> [Angular 15 + Spring Boot + H2 Embedded Database example](https://www.vcoder.com/spring-boot-angular-15-crud/)

> [Angular 15 + Spring Boot + MySQL example](https://www.vcoder.com/spring-boot-angular-15-mysql/)

> [Angular 15 + Spring Boot + PostgreSQL example](https://www.vcoder.com/spring-boot-angular-15-postgresql/)

> [Angular 16 + Spring Boot + H2 Embedded Database example](https://www.vcoder.com/spring-boot-angular-16-crud/)

> [Angular 16 + Spring Boot + MySQL example](https://www.vcoder.com/spring-boot-angular-16-mysql/)

> [Angular 16 + Spring Boot + PostgreSQL example](https://www.vcoder.com/spring-boot-angular-16-postgresql/)

> [Angular 17 + Spring Boot + H2 Embedded Database example](https://www.vcoder.com/spring-boot-angular-17-crud/)

> [Angular 17 + Spring Boot + MySQL example](https://www.vcoder.com/spring-boot-angular-17-mysql/)

> [Angular 17 + Spring Boot + PostgreSQL example](https://www.vcoder.com/spring-boot-angular-17-postgresql/)

> [React + Spring Boot + MySQL example](https://www.vcoder.com/react-spring-boot-crud/)

> [React + Spring Boot + PostgreSQL example](https://www.vcoder.com/spring-boot-react-postgresql/)

> [React + Spring Boot + MongoDB example](https://www.vcoder.com/react-spring-boot-mongodb/)

Run both Back-end & Front-end in one place:
> [Integrate Angular with Spring Boot Rest API](https://www.vcoder.com/integrate-angular-spring-boot/)

> [Integrate React.js with Spring Boot Rest API](https://www.vcoder.com/integrate-reactjs-spring-boot/)

> [Integrate Vue.js with Spring Boot Rest API](https://www.vcoder.com/integrate-vue-spring-boot/)

Some More Tips
==============
To skip tests using below System Property:

eclipse:eclipse -DdownloadSources -DskipTests=false clean install


# PostMan API Test To Import:
> ![Login DB 1.postman_collection.json](Login DB 1.postman_collection.json)