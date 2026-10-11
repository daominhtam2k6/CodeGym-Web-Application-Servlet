# User Management - JSP Servlet JDBC MySQL

## Mục tiêu

Thực hành CRUD bằng:

- JSP
- Servlet
- JDBC
- MySQL
- JSTL
- MVC
- DAO

## Database

Database:

demo

Table:

users

Các cột:

- id
- name
- email
- country

File SQL:

database.sql

Chạy bằng MySQL:

mysql -u root -p < database.sql

## Model

User.java

## DAO

IUserDAO.java

UserDAO.java

UserDAO dùng:

- Connection
- DriverManager
- PreparedStatement
- ResultSet

## Controller

UserServlet.java

Mapping:

/users

## Chức năng

- Danh sách User
- Thêm User
- Sửa User
- Xóa User

## MySQL Configuration

Mở:

src/main/java/com/codegym/dao/UserDAO.java

Kiểm tra:

jdbcURL

jdbcUsername

jdbcPassword

Mặc định source đang dùng:

Database: demo

Username: root

Password: password

Hãy thay password bằng password MySQL trên máy nếu khác.

## Build

mvn clean package

WAR:

target/user-management.war

## URL

http://localhost:8080/user-management/users