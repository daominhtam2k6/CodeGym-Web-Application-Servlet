# Thực hành - Tạo trang web hiển thị thời gian hệ thống

## Mục tiêu

Tạo ứng dụng Java Web đầu tiên sử dụng JSP và Servlet.

## Công nghệ

- Java 17
- Maven
- JSP
- Jakarta Servlet 6
- Tomcat 10.1+

## Chức năng

Trang index.jsp hiển thị thời gian hiện tại của máy chủ bằng:

java.util.Date

Servlet HelloServlet xử lý URL:

/hello

## Cấu trúc

pom.xml

src/main/java/com/codegym/HelloServlet.java

src/main/webapp/index.jsp

src/main/webapp/WEB-INF/web.xml

## Build

Chạy:

mvn clean package

Sau khi build thành công:

target/jsp-servlet-demo.war

## URL sau khi deploy Tomcat

Trang JSP:

http://localhost:8080/jsp-servlet-demo/

Servlet:

http://localhost:8080/jsp-servlet-demo/hello

## Lưu ý

Tomcat 10 trở lên sử dụng package:

jakarta.servlet

Không sử dụng:

javax.servlet
