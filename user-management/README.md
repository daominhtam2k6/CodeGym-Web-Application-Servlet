# User Management - JDBC Transaction

Ã¡Â»Â¨ng dÃ¡Â»Â¥ng User Management sÃ¡Â»Â­ dÃ¡Â»Â¥ng:

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

## ChÃ¡Â»Â©c nÃ„Æ’ng

- List User
- Create User
- Edit User
- Delete User
- Search theo Country
- Sort theo Name
- Stored Procedure
- Transaction User + Permission

## Transaction Database

ChÃ¡ÂºÂ¡y:

transaction-setup.sql

File nÃƒÂ y tÃ¡ÂºÂ¡o:

permission

user_permission

Permission mÃ¡ÂºÂ«u:

1 = add

2 = edit

3 = delete

4 = view

## Transaction

Method:

addUserTransaction(User user, int[] permissionIds)

CÃƒÂ¡c bÃ†Â°Ã¡Â»â€ºc:

1. connection.setAutoCommit(false)

2. INSERT INTO users

3. Statement.RETURN_GENERATED_KEYS

4. getGeneratedKeys()

5. INSERT INTO user_permission

6. connection.commit()

NÃ¡ÂºÂ¿u lÃ¡Â»â€”i:

connection.rollback()

## Create User

create.jsp cÃƒÂ³ checkbox:

permissions

Servlet Ã„â€˜Ã¡Â»Âc bÃ¡ÂºÂ±ng:

request.getParameterValues("permissions")

Sau Ã„â€˜ÃƒÂ³ chuyÃ¡Â»Æ’n thÃƒÂ nh int[].

## URL

http://localhost:8080/user-management/users

Create:

http://localhost:8080/user-management/users?action=create

## Build

mvn clean package

WAR:

target/user-management.war
# Without Transaction Demo

BÃ i thá»±c hÃ nh mÃ´ phá»ng nhiá»u cÃ¢u SQL phá»¥ thuá»™c nhau nhÆ°ng khÃ´ng sá»­ dá»¥ng Transaction.

## Method

IUserDAO:

insertUpdateWithoutTransaction()

UserDAO:

insertUpdateWithoutTransaction()

## Luá»“ng

1. DROP Employee

2. CREATE Employee

3. INSERT Quynh

4. INSERT Ngan

5. Cá»‘ tÃ¬nh thá»±c thi UPDATE lá»—i

VÃ¬ khÃ´ng gá»i:

connection.setAutoCommit(false)

nÃªn JDBC sá»­ dá»¥ng autoCommit máº·c Ä‘á»‹nh.

Hai INSERT Ä‘Æ°á»£c commit trÆ°á»›c khi UPDATE bá»‹ lá»—i.

## URL test

http://localhost:8080/user-management/users?action=test-without-tran

## Kiá»ƒm tra MySQL

SELECT *
FROM Employee;

Káº¿t quáº£ mong Ä‘á»£i:

Quynh - 10

Ngan - 20

Quynh KHÃ”NG Ä‘Æ°á»£c update thÃ nh 999.99.

## Ã nghÄ©a

KhÃ´ng cÃ³ Transaction:

INSERT thÃ nh cÃ´ng Ä‘Æ°á»£c commit ngay.

SQL tiáº¿p theo tháº¥t báº¡i khÃ´ng thá»ƒ tá»± Ä‘á»™ng hoÃ n tÃ¡c cÃ¡c lá»‡nh trÆ°á»›c.

ÄÃ¢y lÃ  tÃ¬nh huá»‘ng dá»¯ liá»‡u Ä‘Æ°á»£c cáº­p nháº­t má»™t pháº§n.
# JDBC Transaction Employee Test

## Không Transaction

URL:

http://localhost:8080/user-management/users?action=test-without-tran

Kết quả khi UPDATE lỗi:

Quynh = 10

Ngan = 20

Hai INSERT vẫn tồn tại.

## Có Transaction

URL:

http://localhost:8080/user-management/users?action=test-use-tran

Luồng:

connection.setAutoCommit(false)

INSERT Quynh

INSERT Ngan

UPDATE Quynh

Nếu tất cả thành công:

connection.commit()

Nếu có lỗi:

connection.rollback()

## Lần 1 - cố tình gây lỗi

Code:

psUpdate.setBigDecimal(2, new BigDecimal("999.99"));

Parameter 1 bị thiếu.

Kết quả:

SELECT * FROM Employee;

Bảng rỗng.

## Lần 2 - sửa lỗi

Đổi thành:

psUpdate.setBigDecimal(1, new BigDecimal("999.99"));

Sau đó build và deploy lại.

Kết quả:

Quynh = 999.99

Ngan = 20

Hai INSERT và một UPDATE được commit cùng nhau.