# User Management - JDBC Transaction

ÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚Â»Ãƒâ€šÃ‚Â¨ng dÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚Â»Ãƒâ€šÃ‚Â¥ng User Management sÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚Â»Ãƒâ€šÃ‚Â­ dÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚Â»Ãƒâ€šÃ‚Â¥ng:

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

## ChÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚Â»Ãƒâ€šÃ‚Â©c nÃƒÆ’Ã¢â‚¬Å¾Ãƒâ€ Ã¢â‚¬â„¢ng

- List User
- Create User
- Edit User
- Delete User
- Search theo Country
- Sort theo Name
- Stored Procedure
- Transaction User + Permission

## Transaction Database

ChÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚ÂºÃƒâ€šÃ‚Â¡y:

transaction-setup.sql

File nÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â y tÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚ÂºÃƒâ€šÃ‚Â¡o:

permission

user_permission

Permission mÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚ÂºÃƒâ€šÃ‚Â«u:

1 = add

2 = edit

3 = delete

4 = view

## Transaction

Method:

addUserTransaction(User user, int[] permissionIds)

CÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¡c bÃƒÆ’Ã¢â‚¬Â Ãƒâ€šÃ‚Â°ÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚Â»ÃƒÂ¢Ã¢â€šÂ¬Ã‚Âºc:

1. connection.setAutoCommit(false)

2. INSERT INTO users

3. Statement.RETURN_GENERATED_KEYS

4. getGeneratedKeys()

5. INSERT INTO user_permission

6. connection.commit()

NÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚ÂºÃƒâ€šÃ‚Â¿u lÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚Â»ÃƒÂ¢Ã¢â€šÂ¬Ã¢â‚¬Âi:

connection.rollback()

## Create User

create.jsp cÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³ checkbox:

permissions

Servlet ÃƒÆ’Ã¢â‚¬Å¾ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“ÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚Â»Ãƒâ€šÃ‚Âc bÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚ÂºÃƒâ€šÃ‚Â±ng:

request.getParameterValues("permissions")

Sau ÃƒÆ’Ã¢â‚¬Å¾ÃƒÂ¢Ã¢â€šÂ¬Ã‹Å“ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³ chuyÃƒÆ’Ã‚Â¡Ãƒâ€šÃ‚Â»Ãƒâ€ Ã¢â‚¬â„¢n thÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â nh int[].

## URL

http://localhost:8080/user-management/users

Create:

http://localhost:8080/user-management/users?action=create

## Build

mvn clean package

WAR:

target/user-management.war
# Without Transaction Demo

BÃƒÆ’Ã‚Â i thÃƒÂ¡Ã‚Â»Ã‚Â±c hÃƒÆ’Ã‚Â nh mÃƒÆ’Ã‚Â´ phÃƒÂ¡Ã‚Â»Ã‚Âng nhiÃƒÂ¡Ã‚Â»Ã‚Âu cÃƒÆ’Ã‚Â¢u SQL phÃƒÂ¡Ã‚Â»Ã‚Â¥ thuÃƒÂ¡Ã‚Â»Ã¢â€žÂ¢c nhau nhÃƒâ€ Ã‚Â°ng khÃƒÆ’Ã‚Â´ng sÃƒÂ¡Ã‚Â»Ã‚Â­ dÃƒÂ¡Ã‚Â»Ã‚Â¥ng Transaction.

## Method

IUserDAO:

insertUpdateWithoutTransaction()

UserDAO:

insertUpdateWithoutTransaction()

## LuÃƒÂ¡Ã‚Â»Ã¢â‚¬Å“ng

1. DROP Employee

2. CREATE Employee

3. INSERT Quynh

4. INSERT Ngan

5. CÃƒÂ¡Ã‚Â»Ã¢â‚¬Ëœ tÃƒÆ’Ã‚Â¬nh thÃƒÂ¡Ã‚Â»Ã‚Â±c thi UPDATE lÃƒÂ¡Ã‚Â»Ã¢â‚¬â€i

VÃƒÆ’Ã‚Â¬ khÃƒÆ’Ã‚Â´ng gÃƒÂ¡Ã‚Â»Ã‚Âi:

connection.setAutoCommit(false)

nÃƒÆ’Ã‚Âªn JDBC sÃƒÂ¡Ã‚Â»Ã‚Â­ dÃƒÂ¡Ã‚Â»Ã‚Â¥ng autoCommit mÃƒÂ¡Ã‚ÂºÃ‚Â·c Ãƒâ€žÃ¢â‚¬ËœÃƒÂ¡Ã‚Â»Ã¢â‚¬Â¹nh.

Hai INSERT Ãƒâ€žÃ¢â‚¬ËœÃƒâ€ Ã‚Â°ÃƒÂ¡Ã‚Â»Ã‚Â£c commit trÃƒâ€ Ã‚Â°ÃƒÂ¡Ã‚Â»Ã¢â‚¬Âºc khi UPDATE bÃƒÂ¡Ã‚Â»Ã¢â‚¬Â¹ lÃƒÂ¡Ã‚Â»Ã¢â‚¬â€i.

## URL test

http://localhost:8080/user-management/users?action=test-without-tran

## KiÃƒÂ¡Ã‚Â»Ã†â€™m tra MySQL

SELECT *
FROM Employee;

KÃƒÂ¡Ã‚ÂºÃ‚Â¿t quÃƒÂ¡Ã‚ÂºÃ‚Â£ mong Ãƒâ€žÃ¢â‚¬ËœÃƒÂ¡Ã‚Â»Ã‚Â£i:

Quynh - 10

Ngan - 20

Quynh KHÃƒÆ’Ã¢â‚¬ÂNG Ãƒâ€žÃ¢â‚¬ËœÃƒâ€ Ã‚Â°ÃƒÂ¡Ã‚Â»Ã‚Â£c update thÃƒÆ’Ã‚Â nh 999.99.

## ÃƒÆ’Ã‚Â nghÃƒâ€žÃ‚Â©a

KhÃƒÆ’Ã‚Â´ng cÃƒÆ’Ã‚Â³ Transaction:

INSERT thÃƒÆ’Ã‚Â nh cÃƒÆ’Ã‚Â´ng Ãƒâ€žÃ¢â‚¬ËœÃƒâ€ Ã‚Â°ÃƒÂ¡Ã‚Â»Ã‚Â£c commit ngay.

SQL tiÃƒÂ¡Ã‚ÂºÃ‚Â¿p theo thÃƒÂ¡Ã‚ÂºÃ‚Â¥t bÃƒÂ¡Ã‚ÂºÃ‚Â¡i khÃƒÆ’Ã‚Â´ng thÃƒÂ¡Ã‚Â»Ã†â€™ tÃƒÂ¡Ã‚Â»Ã‚Â± Ãƒâ€žÃ¢â‚¬ËœÃƒÂ¡Ã‚Â»Ã¢â€žÂ¢ng hoÃƒÆ’Ã‚Â n tÃƒÆ’Ã‚Â¡c cÃƒÆ’Ã‚Â¡c lÃƒÂ¡Ã‚Â»Ã¢â‚¬Â¡nh trÃƒâ€ Ã‚Â°ÃƒÂ¡Ã‚Â»Ã¢â‚¬Âºc.

Ãƒâ€žÃ‚ÂÃƒÆ’Ã‚Â¢y lÃƒÆ’Ã‚Â  tÃƒÆ’Ã‚Â¬nh huÃƒÂ¡Ã‚Â»Ã¢â‚¬Ëœng dÃƒÂ¡Ã‚Â»Ã‚Â¯ liÃƒÂ¡Ã‚Â»Ã¢â‚¬Â¡u Ãƒâ€žÃ¢â‚¬ËœÃƒâ€ Ã‚Â°ÃƒÂ¡Ã‚Â»Ã‚Â£c cÃƒÂ¡Ã‚ÂºÃ‚Â­p nhÃƒÂ¡Ã‚ÂºÃ‚Â­t mÃƒÂ¡Ã‚Â»Ã¢â€žÂ¢t phÃƒÂ¡Ã‚ÂºÃ‚Â§n.
# JDBC Transaction Employee Test

## KhÃƒÂ´ng Transaction

URL:

http://localhost:8080/user-management/users?action=test-without-tran

KÃ¡ÂºÂ¿t quÃ¡ÂºÂ£ khi UPDATE lÃ¡Â»â€”i:

Quynh = 10

Ngan = 20

Hai INSERT vÃ¡ÂºÂ«n tÃ¡Â»â€œn tÃ¡ÂºÂ¡i.

## CÃƒÂ³ Transaction

URL:

http://localhost:8080/user-management/users?action=test-use-tran

LuÃ¡Â»â€œng:

connection.setAutoCommit(false)

INSERT Quynh

INSERT Ngan

UPDATE Quynh

NÃ¡ÂºÂ¿u tÃ¡ÂºÂ¥t cÃ¡ÂºÂ£ thÃƒÂ nh cÃƒÂ´ng:

connection.commit()

NÃ¡ÂºÂ¿u cÃƒÂ³ lÃ¡Â»â€”i:

connection.rollback()

## LÃ¡ÂºÂ§n 1 - cÃ¡Â»â€˜ tÃƒÂ¬nh gÃƒÂ¢y lÃ¡Â»â€”i

Code:

psUpdate.setBigDecimal(2, new BigDecimal("999.99"));

Parameter 1 bÃ¡Â»â€¹ thiÃ¡ÂºÂ¿u.

KÃ¡ÂºÂ¿t quÃ¡ÂºÂ£:

SELECT * FROM Employee;

BÃ¡ÂºÂ£ng rÃ¡Â»â€”ng.

## LÃ¡ÂºÂ§n 2 - sÃ¡Â»Â­a lÃ¡Â»â€”i

Ã„ÂÃ¡Â»â€¢i thÃƒÂ nh:

psUpdate.setBigDecimal(1, new BigDecimal("999.99"));

Sau Ã„â€˜ÃƒÂ³ build vÃƒÂ  deploy lÃ¡ÂºÂ¡i.

KÃ¡ÂºÂ¿t quÃ¡ÂºÂ£:

Quynh = 999.99

Ngan = 20

Hai INSERT vÃƒÂ  mÃ¡Â»â„¢t UPDATE Ã„â€˜Ã†Â°Ã¡Â»Â£c commit cÃƒÂ¹ng nhau.
# Stored Procedure CRUD Update

CÃ¡c chá»©c nÄƒng User Management hiá»‡n sá»­ dá»¥ng Stored Procedure:

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

ÄÆ°á»£c dÃ¹ng khi má»Ÿ Edit vÃ  Delete confirmation.

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

Project váº«n giá»¯:

insert_user(...)

vÃ  bÃ i JDBC Transaction User + Permission.

Luá»“ng Create hiá»‡n táº¡i cÃ³ thá»ƒ tiáº¿p tá»¥c sá»­ dá»¥ng addUserTransaction()
Ä‘á»ƒ báº£o toÃ n bÃ i Transaction trÆ°á»›c.

## Stored Procedure File

stored-procedures.sql

Pháº£i cháº¡y láº¡i file nÃ y trong database demo trÆ°á»›c khi test.

## URL

http://localhost:8080/user-management/users
# JDBC Transaction Rollback Practice

Bài tập cập nhật phương thức:

addUserTransaction()

## Mục tiêu

Quan sát commit() và rollback() trong JDBC.

## Kịch bản

1. connection.setAutoCommit(false)

2. INSERT User

3. Lấy generated User ID

4. INSERT các Permission đã chọn

5. Cố tình INSERT permission_id = 999999

6. Foreign Key sinh SQLException

7. connection.rollback()

## Kết quả

User đã INSERT ở bước đầu KHÔNG được lưu.

Các dòng user_permission trước lỗi cũng KHÔNG được lưu.

Đây là nguyên lý:

All-or-Nothing

và Atomicity trong ACID.

## Test

Mở:

http://localhost:8080/user-management/users?action=create

Nhập ví dụ:

Name:

Transaction Test

Email:

transaction-test@codegym.vn

Country:

Viet Nam

Chọn:

Add

View

Sau khi Submit, ứng dụng cố tình phát sinh lỗi SQL.

## Kiểm tra

SELECT *
FROM users
WHERE email = 'transaction-test@codegym.vn';

Kết quả mong đợi:

0 rows

## File kiểm tra

transaction-practice-check.sql