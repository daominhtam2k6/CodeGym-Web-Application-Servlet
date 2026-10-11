# User Management - JSP Servlet JDBC MySQL

Ứng dụng quản lý User theo mô hình MVC + DAO.

## Công nghệ

- Java 17
- Maven
- JSP
- Jakarta Servlet 6
- JSTL 3
- JDBC
- MySQL
- PreparedStatement
- CallableStatement
- Stored Procedure
- Tomcat 10.1+

## Chức năng

- Hiển thị danh sách User
- Thêm User
- Sửa User
- Xóa User
- Tìm theo country
- Sắp xếp theo name

## Stored Procedures

File:

stored-procedures.sql

Có 2 procedure:

get_user_by_id

insert_user

## get_user_by_id

SQL:

CALL get_user_by_id(?)

Java:

CallableStatement

Được sử dụng khi mở form Edit.

## insert_user

SQL:

CALL insert_user(?, ?, ?)

Java:

CallableStatement

Được sử dụng khi tạo User mới.

## PRG Pattern

Sau khi insert thành công:

POST

-> Redirect

-> GET

Giúp tránh insert trùng khi người dùng nhấn F5.

## Các chức năng vẫn dùng PreparedStatement

- Danh sách
- Update
- Delete
- Search Country
- Sort Name

## Chạy Stored Procedures

Mở MySQL Workbench hoặc DBeaver.

Chạy file:

stored-procedures.sql

Hoặc từ Windows CMD:

mysql -u root -p < stored-procedures.sql

## Build

mvn clean package

WAR:

target/user-management.war

## URL

http://localhost:8080/user-management/users