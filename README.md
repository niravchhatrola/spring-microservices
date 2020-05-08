# spring-microservices

## Applicatoin and Ports Details
| Application |	Port|	
| ------------- |:-------------:|
|	Limits Service	|	8080, 8081 |
|	Spring Cloud Config Server	|	8888|	
|	Currency Exchange Service	|	8000, 8001, 8002|	
|	Currency Conversion Service	|	8100 |	
|	Netflix Eureka Naming Server	|	8761|	
|	Netflix Zuul API Gateway Server	|	8765|	

## imits-service-config
This artifact contains limits service configurations files like application.properties for multiple environments like dev qa..

## spring-cloud-config-server
This artifact does have details git repo url of config artifact. And it fetches config from git and provides to cloud config clients.
Need to Consider below things for cloud config server.

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-config-server</artifactId>
</dependency>

And also Enable config server on main class
@EnableConfigServer

In application.properties add git repo details of config project
spring.cloud.config.server.git.uri=https://github.com/niravchhatrola/spring-microservices/tree/master/limits-service-config

```
## imits-service
This artifact contains simple code to show config details. so using cloud config server it will fetch profile wise config from git and show.
```
Add below depencendy of config client
<dependency>
 <groupId>org.springframework.cloud</groupId>
 <artifactId>spring-cloud-starter-config</artifactId>
</dependency>

Updated application.properties as below
spring.cloud.config.uri=http://localhost:8888
spring.profiles.active=qa   
```
## netflix-eureka-naming-server
Its naming server contains all service detials 
```
Add below dependency in pom
<dependency>
 <groupId>org.springframework.cloud</groupId>
 <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>

Add in main class
@EnableEurekaServer
```

## currency-exchange-service
In this artifact we do have in memory db that contains details of curreynt from and to with its value.

```
Need to add eureka dependncy to register it with eureka naming server.
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

Update application.properties as below
eureka.client.service-url.default-zone=http://localhost:8761/eureka

Enable discory client by adding below to main class
@EnableDiscoveryClient
```

## currency-conversion-service
In this artifact we are going to use multiple things 
1) we will register it to eureka
2) create feign client to access currency-exchange-service
3) For enabling client side load balancing we will add ribbon
```
Add below dependency 
<dependency>
 <groupId>org.springframework.cloud</groupId>
 <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

<dependency>
 <groupId>org.springframework.cloud</groupId>
 <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>

Need to create proxy for feign client
@FeignClient(name = "netflix-zuul-api-gateway-server")    // Its api gateway for filter perspective, can log , authenticate or do any bussiness logic
@RibbonClient(name = "currency-exchange-service")

Add below annotation in main class
@EnableFeignClients
```
## netflix-zuul-api-gateway-server
This componant is gateway so it can be configured with any component and it will work as filter.
```
Add below dependency
<dependency>
 <groupId>org.springframework.cloud</groupId>
 <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency>
Add below in main class
@EnableZuulProxy
Need to extend zuulfilter for filter logic
public class ZuulLoggingFilter extends ZuulFilter {
---
---
}
```


















