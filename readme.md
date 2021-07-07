# Spring-retail-website

**Task :**
On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.

Write a **Spring Boot** Java application with test cases, which exposes an API such that given a
bill, it finds the net payable amount.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- IDE of Your Choice 

## Running the application locally

Clone the project in local.
Run ```mvn clean install```

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.springboot.retail.SpringRetailWebsiteApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```


## Testing Steps

Once the application is up and running :
The SpringBoot can be accessed from localhost:8080 (default port 8080 is used , so please free up the port before running the application)

2 endpoints are exposed from each of the 2 controllers namely **AccountCreationController** & **OrderPlaceController**

Please execute the endpoints in below specified order :

**Endpoint 1 :**
```/account/create```

Input Sample :
``` 
{ 
	"name":"Mansoor", 
	"role":"BUYER" 
}
```
Output Success :
``` 
Hurray!! Thank you for Signing Up : Mansoor Your Officially A Member Of Our Retail Website. Your Customer Id Is : 1
```
Output Exception For MissingField : 
```
Name & Role Fields Cannot Be Empty
```

**Endpoint 2 :**
```/order/placeorder```

Input Sample :
``` 
{
   "customerId":1,
   "order":
      {
         "products":[
            {
               "name":"Rice",
               "price":500,
               "productType":"GROCERY"
            },
            {
               "name":"Apple",
               "price":200,
               "productType":"FRUITS"
            }
         ]
      }
}
```
Output Success :
``` 
Hi Mansoor Your Order Has Been SuccessFully Placed. And Your Total Payable Amount Is :665.0
```
Output Exception For Wrong Id :
```
Customer Id is invalid , Please provide a valid Id
```

## For Documenting and to display the endpoints Swagger is used

Access the Swagger endpoint url in this fashion 

```http://localhost:8080/swagger-ui.html```

## Testing Report and Diagram
Run as > ```mvn clean install```  (Will build and install a project and also generates the jacoco test reports inside target > site directory . Can be viewed using **index.html**)

ER Diagram and Eclemma Report can be found [HERE](https://github.com/callmemansoor/spring-retail-website/tree/master/reportsAndDiagrams)

## Contact Me 

Please reach out to the developer incase of any doubts regarding Code or Running of an application .

Email Id : pslv786@gmail.com
Contact No : 9448656986

[Linkedin    ](https://www.linkedin.com/in/callmemansoor)
[Hackerrank](https://www.hackerrank.com/callmemansoor)

