# SpringBoot Google Social Login OAuth2

SpringBoot JWT Google Login 

# SpringBoot Start

> Mysql Database

mysql> create database spring_social

> application.yml

spring:
datasource:
url: jdbc:mysql://localhost:3306/spring_social?useSSL=false
username: <YOUR_DB_USERNAME>
password: <YOUR_DB_PASSWORD>

> ClientSecrets

```shell
security:
   oauth2:
     client:
       registration:
         google:
           clientId: <GOOGLE_CLIENT_ID>
           clientSecret: <GOOGLE_CLIENT_SECRET>
           redirectUriTemplate: "{baseUrl}/oauth2/callback/{registrationId}"
           scope:
             - email
             - profile
```

# React Start

```shell
npm install && npm start
```