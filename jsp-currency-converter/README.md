# Thực hành - Ứng dụng chuyển đổi tiền tệ JSP

## Mục tiêu

Luyện tập tạo và xử lý dữ liệu với JSP.

## Công nghệ

- Java 17
- Maven
- JSP
- Tomcat 10.1+
- Jakarta Servlet / JSP API

## Điểm khác với phiên bản Servlet

Bài này không dùng ConverterServlet.

index.jsp gửi dữ liệu trực tiếp tới:

converter.jsp

converter.jsp vừa nhận dữ liệu, xử lý Java và hiển thị kết quả.

## Form

File:

src/main/webapp/index.jsp

Form:

method="POST"

action="converter.jsp"

Input:

name="rate"

name="usd"

## JSP Scriptlet

converter.jsp dùng Scriptlet:

<% Java code %>

để:

- request.getParameter
- Float.parseFloat
- tính toán

Công thức:

VND = USD * Rate

## JSP Expression

Kết quả được hiển thị bằng:

<%= value %>

## Build

Chạy:

mvn clean package

File WAR:

target/jsp-currency-converter.war

## URL khi deploy Tomcat

http://localhost:8080/jsp-currency-converter/
