# Bài tập - Hiển thị danh sách khách hàng

## Mục tiêu

Luyện tập sử dụng JSTL trong JSP.

## Công nghệ

- Java 17
- Maven
- JSP
- JSTL
- Jakarta Tags 3
- Tomcat 10.1+

## JSTL

Trang index.jsp khai báo:

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

## Danh sách khách hàng

Mỗi khách hàng gồm:

- Họ và tên
- Ngày sinh
- Địa chỉ
- Ảnh

Danh sách được lưu bằng:

List<Map<String, String>>

Sau đó đưa vào request:

request.setAttribute("customers", customers)

## Hiển thị bằng JSTL

Trang JSP sử dụng:

<c:forEach>

để duyệt danh sách.

Sử dụng:

<c:out>

để hiển thị dữ liệu khách hàng.

## Maven JSTL

Sử dụng JSTL API:

jakarta.servlet.jsp.jstl-api

và implementation:

org.glassfish.web:jakarta.servlet.jsp.jstl

## Build

Chạy:

mvn clean package

File WAR:

target/jsp-jstl-customer-list.war

## URL khi deploy Tomcat

http://localhost:8080/jsp-jstl-customer-list/
