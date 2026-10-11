# Thực hành - Đăng nhập và hiển thị lời chào

## Mục tiêu

Luyện tập:

- HTML Form
- POST request
- Servlet
- request.getParameter
- xử lý điều kiện đăng nhập

## Công nghệ

- Java 17
- Maven
- JSP
- Jakarta Servlet 6
- Tomcat 10.1+

## Form đăng nhập

Trang:

src/main/webapp/index.jsp

Form gửi dữ liệu bằng:

method="POST"

Endpoint:

action="login"

## Dữ liệu Form

Username:

name="username"

Password:

name="password"

## LoginServlet

Servlet:

src/main/java/com/codegym/LoginServlet.java

Mapping:

/login

Servlet đọc dữ liệu bằng:

request.getParameter("username")

request.getParameter("password")

## Tài khoản kiểm thử

Username:

admin

Password:

admin

## Kết quả

Nếu đúng:

Welcome admin to website

Nếu sai:

Login Error

## Build

Chạy:

mvn clean package

File WAR:

target/jsp-servlet-login.war

## URL khi deploy Tomcat

http://localhost:8080/jsp-servlet-login/

## Lưu ý

Tomcat 10 trở lên sử dụng:

jakarta.servlet

không sử dụng:

javax.servlet
