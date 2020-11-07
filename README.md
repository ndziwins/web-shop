## Description

Final project for postgraduate studies "Java EE - software production" at the Warsaw University of Technology creaded in small developers team of two.
It's simple e-commerce wireframe: web shop created mainly in Java. 
Used technology: **Spring Boot**, **Spring Security**, **Spring Data JPA**, **H2 database**, **Thymeleaf**, **Bootstrap**.

## Installation

You can clone this repository and use it localy:
```sh
$ git clone https://github.com/ndziwins/web-shop.git
```

**Using Maven plugin**

First you should do clean installation:
```sh
$ mvn clean install
```
You can start application using Spring Boot custom command:
```sh
$ mvn spring-boot:run
```

**Using Maven plugin and running JAR**

You can create JAR file using:
```sh
$ mvn clean package
```
and then run it with:
```sh
$ java -jar target/shop-x.x.x.jar
```

## License

Project is based on **MIT License**. You can read about the license <a href="LICENSE">here</a>.
