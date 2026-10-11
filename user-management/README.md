# User Management - JDBC Transaction

á»¨ng dá»¥ng User Management sá»­ dá»¥ng:

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

## Chá»©c nÄƒng

- List User
- Create User
- Edit User
- Delete User
- Search theo Country
- Sort theo Name
- Stored Procedure
- Transaction User + Permission

## Transaction Database

Cháº¡y:

transaction-setup.sql

File nÃ y táº¡o:

permission

user_permission

Permission máº«u:

1 = add

2 = edit

3 = delete

4 = view

## Transaction

Method:

addUserTransaction(User user, int[] permissionIds)

CÃ¡c bÆ°á»›c:

1. connection.setAutoCommit(false)

2. INSERT INTO users

3. Statement.RETURN_GENERATED_KEYS

4. getGeneratedKeys()

5. INSERT INTO user_permission

6. connection.commit()

Náº¿u lá»—i:

connection.rollback()

## Create User

create.jsp cÃ³ checkbox:

permissions

Servlet Ä‘á»c báº±ng:

request.getParameterValues("permissions")

Sau Ä‘Ã³ chuyá»ƒn thÃ nh int[].

## URL

http://localhost:8080/user-management/users

Create:

http://localhost:8080/user-management/users?action=create

## Build

mvn clean package

WAR:

target/user-management.war
# Without Transaction Demo

Bài thực hành mô phỏng nhiều câu SQL phụ thuộc nhau nhưng không sử dụng Transaction.

## Method

IUserDAO:

insertUpdateWithoutTransaction()

UserDAO:

insertUpdateWithoutTransaction()

## Luồng

1. DROP Employee

2. CREATE Employee

3. INSERT Quynh

4. INSERT Ngan

5. Cố tình thực thi UPDATE lỗi

Vì không gọi:

connection.setAutoCommit(false)

nên JDBC sử dụng autoCommit mặc định.

Hai INSERT được commit trước khi UPDATE bị lỗi.

## URL test

http://localhost:8080/user-management/users?action=test-without-tran

## Kiểm tra MySQL

SELECT *
FROM Employee;

Kết quả mong đợi:

Quynh - 10

Ngan - 20

Quynh KHÔNG được update thành 999.99.

## Ý nghĩa

Không có Transaction:

INSERT thành công được commit ngay.

SQL tiếp theo thất bại không thể tự động hoàn tác các lệnh trước.

Đây là tình huống dữ liệu được cập nhật một phần.