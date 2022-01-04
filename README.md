# swagger-documentation

A Swagger is an open-source tool. It builds around the OpenAPI Specification that helps developers to design, build, document, and consume RESTful APIs.
It is the most popular API documentation format for RESTful Web Services.

Step 1: Open pom.xml and add springfox-swagger2 dependency.
<dependency>  
    <groupId>io.springfox</groupId>  
    <artifactId>springfox-swagger2</artifactId>  
    <version>2.9.2</version>  
</dependency>  

<dependency>  
    <groupId>io.springfox</groupId>  
    <artifactId>springfox-swagger-ui</artifactId>  
    <version>2.9.2</version>  
</dependency>  

Step 2: Create a class with the name SwaggerConfig.java and write the following code.
@Configuration  
//Enable Swagger  
@EnableSwagger2  
public class SwaggerConfig   
{  
//creating bean  
@Bean  
public Docket api()  
{  
//creating constructor of Docket class that accepts parameter DocumentationType  
return new Docket(DocumentationType.SWAGGER_2);  
}  
}  
Step 3: make changes in application.properties file
server.port=9856
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER


Step 4: Open the browser and type the URI http://localhost:9856/v2/api-docs

Step 5:http://localhost:8080/swagger-ui.html

