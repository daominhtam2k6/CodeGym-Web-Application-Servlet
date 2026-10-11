# User Management - JDBC Transaction

Ứng dụng User Management sử dụng:

- Java 17
- JSP
- Servlet
- JSTL
- JDBC
- MySQL
- DAO
- MVC
- Stored Procedure
- CallableStatement
- JDBC Transaction

## Chức năng

- List User
- Create User
- Edit User
- Delete User
- Search theo Country
- Sort theo Name
- Stored Procedure
- Transaction User + Permission

## Transaction Database

Chạy:

transaction-setup.sql

File này tạo:

permission

user_permission

Permission mẫu:

1 = add

2 = edit

3 = delete

4 = view

## Transaction

Method:

addUserTransaction(User user, int[] permissionIds)

Các bước:

1. connection.setAutoCommit(false)

2. INSERT INTO users

3. Statement.RETURN_GENERATED_KEYS

4. getGeneratedKeys()

5. INSERT INTO user_permission

6. connection.commit()

Nếu lỗi:

connection.rollback()

## Create User

create.jsp có checkbox:

permissions

Servlet đọc bằng:

request.getParameterValues("permissions")

Sau đó chuyển thành int[].

## URL

http://localhost:8080/user-management/users

Create:

http://localhost:8080/user-management/users?action=create

## Build

mvn clean package

WAR:

target/user-management.war