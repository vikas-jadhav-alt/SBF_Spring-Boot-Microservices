



========================












========================

#Urls

## Service Registery:

> http://localhost:8761/

## Question-Service
> http://localhost:8080/

for further instances, creater multiple instance passing -Dserver.port=8081 in VArguments while executing the next instance.

> http://localhost:8081/

## API GateWay
http://localhost:8765/quiz-service
http://localhost:8765/question-service



http://localhost:8765/question-service/question/allQuestions

# TroubleShooting

## Right way of Building Project
Always follow below steps:whenever youo do some change in pom.xml and code before executing...

1. Refresh Project
2. Maven Build >mvn clean install
3. Maven Update [Optional]
4. Then Execute/Run Project

## API Gateway:
Spring MVC found on classpath, which is incompatible with Spring Cloud Gateway.

...don't add Spring Web or Swagger dependency in pom.xml of API-Gateway

# Testing

## Swagger URLs:

No Need to Remember, we can get those port number directory from the service registery,....


Question-Service
> http://localhost:8080/swagger-ui/index.html


Quiz Service:

http://localhost:8090/swagger-ui/index.html

## configure DB
1. Do start service of PostGreSQL
2. Connect to posgresql localhost server:
.....username: postgres
.....password: <your> [for me: "password"]
.....port: 5432


## Sequesce of Running Apps
1. First run the *service-registery* and then other services otherwise we will found error while running the other services, as other services will have some dependencies added for service registery (Eureka Server) that will stop executing the current service.....

Order of Running Application:
1. service-registery

after that you can run any service like you can go with below order
2. question-service
3. quiz-service
4. api-gateway




