# User Management - JSP Servlet JDBC MySQL

Ứng dụng CRUD User theo kiến trúc MVC + DAO.

## Công nghệ

- Java 17
- Maven
- JSP
- Jakarta Servlet 6
- JSTL 3
- JDBC
- MySQL
- Tomcat 10.1+

## Database

Database:

demo

Table:

users

Columns:

- id
- name
- email
- country

## Chức năng

- Hiển thị danh sách User
- Thêm User
- Sửa User
- Xóa User
- Tìm kiếm theo country
- Sắp xếp theo name

## Search by Country

Ví dụ:

/users?action=search&country=Viet

DAO sử dụng:

WHERE country LIKE ?

PreparedStatement parameter:

%Viet%

Vì vậy có thể tìm được:

Viet Nam

## Sort by Name

URL:

/users?action=sort

SQL:

ORDER BY name ASC

## DAO

IUserDAO có:

insertUser

selectUser

selectAllUsers

deleteUser

updateUser

searchByCountry

sortByName

## URL

http://localhost:8080/user-management/users

## Build

mvn clean package

WAR:

target/user-management.war

## MySQL

Kiểm tra cấu hình trong:

src/main/java/com/codegym/dao/UserDAO.java

Các giá trị cần đúng với máy:

jdbcURL

jdbcUsername

jdbcPassword