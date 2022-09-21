# Price API
This repository contains all backend code made for the Price API service. Features:

* **Programming Language:** Java11.
* **Framework:** SpringBoot.
* **Software Architecture:** Hexagonal Architecture.
* **Development methodology:** Test Driven Development (TDD)


## Testing the REST api
### Pre-Requisites
* **Docker:** You'll need to have docker installed on your machine.
* **REST client:** A REST client is required to make the test request. Example: *Insomnia*, *Postman*. 

Personally I've used [Httpie](https://httpie.io/) which is a terminal based REST Client very simple to use.

### Test Process
- First of all, it is required to download the code and build the docker image. 
To do this, after the code has been successfully downloaded, go to the project folder and execute the following command:
`docker build -t price-api .`
- Once the build process has finished, to run the application just execute:
`docker run -p 8080:8080 price-api` 


Below I'm listing the different requests that can be made
- `> http GET http://localhost:8080/prices/brand/1/product/35455/date/2020-06-14T10:00:00`
- `> http GET http://localhost:8080/prices/brand/1/product/35455/date/2020-06-14T16:00:00`
- `> http GET http://localhost:8080/prices/brand/1/product/35455/date/2020-06-14T21:00:00`
- `> http GET http://localhost:8080/prices/brand/1/product/35455/date/2020-06-15T10:00:00`
- `> http GET http://localhost:8080/prices/brand/1/product/35455/date/2020-06-16T21:00:00`

Example of one of the request and its response from the application.
~~~
> http GET http://localhost:8080/prices/brand/1/product/35455/date/2020-06-14T10:00:00

HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Wed, 21 Sep 2022 20:20:32 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "brandId": 1,
    "endDate": "2020-12-31T23:59:59",
    "price": {
        "currency": "EUR",
        "value": 35.5
    },
    "priceList": 1,
    "productId": 35455,
    "startDate": "2020-06-14T00:00:00"
}
 
~~~

In you have any doubt, please, contact with francisco.lop.nav@gmail.com

Happy hacking! :computer: :fire:
