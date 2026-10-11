# User Management - JDBC Transaction

ÃƒÂ¡Ã‚Â»Ã‚Â¨ng dÃƒÂ¡Ã‚Â»Ã‚Â¥ng User Management sÃƒÂ¡Ã‚Â»Ã‚Â­ dÃƒÂ¡Ã‚Â»Ã‚Â¥ng:

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

## ChÃƒÂ¡Ã‚Â»Ã‚Â©c nÃƒâ€žÃ†â€™ng

- List User
- Create User
- Edit User
- Delete User
- Search theo Country
- Sort theo Name
- Stored Procedure
- Transaction User + Permission

## Transaction Database

ChÃƒÂ¡Ã‚ÂºÃ‚Â¡y:

transaction-setup.sql

File nÃƒÆ’Ã‚Â y tÃƒÂ¡Ã‚ÂºÃ‚Â¡o:

permission

user_permission

Permission mÃƒÂ¡Ã‚ÂºÃ‚Â«u:

1 = add

2 = edit

3 = delete

4 = view

## Transaction

Method:

addUserTransaction(User user, int[] permissionIds)

CÃƒÆ’Ã‚Â¡c bÃƒâ€ Ã‚Â°ÃƒÂ¡Ã‚Â»Ã¢â‚¬Âºc:

1. connection.setAutoCommit(false)

2. INSERT INTO users

3. Statement.RETURN_GENERATED_KEYS

4. getGeneratedKeys()

5. INSERT INTO user_permission

6. connection.commit()

NÃƒÂ¡Ã‚ÂºÃ‚Â¿u lÃƒÂ¡Ã‚Â»Ã¢â‚¬â€i:

connection.rollback()

## Create User

create.jsp cÃƒÆ’Ã‚Â³ checkbox:

permissions

Servlet Ãƒâ€žÃ¢â‚¬ËœÃƒÂ¡Ã‚Â»Ã‚Âc bÃƒÂ¡Ã‚ÂºÃ‚Â±ng:

request.getParameterValues("permissions")

Sau Ãƒâ€žÃ¢â‚¬ËœÃƒÆ’Ã‚Â³ chuyÃƒÂ¡Ã‚Â»Ã†â€™n thÃƒÆ’Ã‚Â nh int[].

## URL

http://localhost:8080/user-management/users

Create:

http://localhost:8080/user-management/users?action=create

## Build

mvn clean package

WAR:

target/user-management.war
# Without Transaction Demo

BÃƒÂ i thÃ¡Â»Â±c hÃƒÂ nh mÃƒÂ´ phÃ¡Â»Âng nhiÃ¡Â»Âu cÃƒÂ¢u SQL phÃ¡Â»Â¥ thuÃ¡Â»â„¢c nhau nhÃ†Â°ng khÃƒÂ´ng sÃ¡Â»Â­ dÃ¡Â»Â¥ng Transaction.

## Method

IUserDAO:

insertUpdateWithoutTransaction()

UserDAO:

insertUpdateWithoutTransaction()

## LuÃ¡Â»â€œng

1. DROP Employee

2. CREATE Employee

3. INSERT Quynh

4. INSERT Ngan

5. CÃ¡Â»â€˜ tÃƒÂ¬nh thÃ¡Â»Â±c thi UPDATE lÃ¡Â»â€”i

VÃƒÂ¬ khÃƒÂ´ng gÃ¡Â»Âi:

connection.setAutoCommit(false)

nÃƒÂªn JDBC sÃ¡Â»Â­ dÃ¡Â»Â¥ng autoCommit mÃ¡ÂºÂ·c Ã„â€˜Ã¡Â»â€¹nh.

Hai INSERT Ã„â€˜Ã†Â°Ã¡Â»Â£c commit trÃ†Â°Ã¡Â»â€ºc khi UPDATE bÃ¡Â»â€¹ lÃ¡Â»â€”i.

## URL test

http://localhost:8080/user-management/users?action=test-without-tran

## KiÃ¡Â»Æ’m tra MySQL

SELECT *
FROM Employee;

KÃ¡ÂºÂ¿t quÃ¡ÂºÂ£ mong Ã„â€˜Ã¡Â»Â£i:

Quynh - 10

Ngan - 20

Quynh KHÃƒâ€NG Ã„â€˜Ã†Â°Ã¡Â»Â£c update thÃƒÂ nh 999.99.

## ÃƒÂ nghÃ„Â©a

KhÃƒÂ´ng cÃƒÂ³ Transaction:

INSERT thÃƒÂ nh cÃƒÂ´ng Ã„â€˜Ã†Â°Ã¡Â»Â£c commit ngay.

SQL tiÃ¡ÂºÂ¿p theo thÃ¡ÂºÂ¥t bÃ¡ÂºÂ¡i khÃƒÂ´ng thÃ¡Â»Æ’ tÃ¡Â»Â± Ã„â€˜Ã¡Â»â„¢ng hoÃƒÂ n tÃƒÂ¡c cÃƒÂ¡c lÃ¡Â»â€¡nh trÃ†Â°Ã¡Â»â€ºc.

Ã„ÂÃƒÂ¢y lÃƒÂ  tÃƒÂ¬nh huÃ¡Â»â€˜ng dÃ¡Â»Â¯ liÃ¡Â»â€¡u Ã„â€˜Ã†Â°Ã¡Â»Â£c cÃ¡ÂºÂ­p nhÃ¡ÂºÂ­t mÃ¡Â»â„¢t phÃ¡ÂºÂ§n.
# JDBC Transaction Employee Test

## KhÃ´ng Transaction

URL:

http://localhost:8080/user-management/users?action=test-without-tran

Káº¿t quáº£ khi UPDATE lá»—i:

Quynh = 10

Ngan = 20

Hai INSERT váº«n tá»“n táº¡i.

## CÃ³ Transaction

URL:

http://localhost:8080/user-management/users?action=test-use-tran

Luá»“ng:

connection.setAutoCommit(false)

INSERT Quynh

INSERT Ngan

UPDATE Quynh

Náº¿u táº¥t cáº£ thÃ nh cÃ´ng:

connection.commit()

Náº¿u cÃ³ lá»—i:

connection.rollback()

## Láº§n 1 - cá»‘ tÃ¬nh gÃ¢y lá»—i

Code:

psUpdate.setBigDecimal(2, new BigDecimal("999.99"));

Parameter 1 bá»‹ thiáº¿u.

Káº¿t quáº£:

SELECT * FROM Employee;

Báº£ng rá»—ng.

## Láº§n 2 - sá»­a lá»—i

Äá»•i thÃ nh:

psUpdate.setBigDecimal(1, new BigDecimal("999.99"));

Sau Ä‘Ã³ build vÃ  deploy láº¡i.

Káº¿t quáº£:

Quynh = 999.99

Ngan = 20

Hai INSERT vÃ  má»™t UPDATE Ä‘Æ°á»£c commit cÃ¹ng nhau.
# Stored Procedure CRUD Update

Các chức năng User Management hiện sử dụng Stored Procedure:

## List

Procedure:

get_all_users()

Java:

CallableStatement

Method:

selectAllUsersStore()

## Find by ID

Procedure:

get_user_by_id(?)

Method:

getUserById()

Được dùng khi mở Edit và Delete confirmation.

## Update

Procedure:

update_user(?, ?, ?, ?)

Method:

updateUserStore(User user)

Parameters:

1. id
2. name
3. email
4. country

## Delete

Procedure:

delete_user(?)

Method:

deleteUserStore(int id)

## Create

Project vẫn giữ:

insert_user(...)

và bài JDBC Transaction User + Permission.

Luồng Create hiện tại có thể tiếp tục sử dụng addUserTransaction()
để bảo toàn bài Transaction trước.

## Stored Procedure File

stored-procedures.sql

Phải chạy lại file này trong database demo trước khi test.

## URL

http://localhost:8080/user-management/users