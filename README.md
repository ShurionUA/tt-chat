# Simple online chat
#### This project is a simulator of online chat
#### The application allows log in with any name. If name doesn't exist in DB, application will save it
#### Without log in you can visit only login page ("/login")
#### After log in, you can see last 50 message from DB and send message ("/chat")
## Technologies
- Servlet
- JDBC
- MySql
- Apache Tomcat
- Maven
## Configure before launch
1. Install MySQL and create schema in DB from file src/main/resources/init_db.sql
2. Install TomCat 9.05.56
3. Change data of variables in class src/main/chat/util/ConnectionUtil with your data
4. Launch! 
