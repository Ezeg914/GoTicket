Repository for Programming 2 course, year 2023
Project: "GoTicket" simulates a mobile app for selling long-distance bus tickets.
Tech Stack:
Java
Spring Boot
Team Members:
Ezequiel Garcia
Bruno Rosales
Enzo Fernandez
Generic application.properties model:

#db
server.port= "your_port"
spring.datasource.url="db_url/db_name"
spring.datasource.username="your_username"
spring.datasource.password="your_password"
spring.jpa.hibernate.ddl-auto=update

#JWT
security.jwt.secret="secret_key"
security.jwt.issuer=Main
security.jwt.ttlMillis="token_lifetime"
