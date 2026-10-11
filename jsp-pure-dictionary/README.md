# Thực hành - Ứng dụng Từ điển đơn giản JSP

## Mục tiêu

Luyện tập tạo JSP và xử lý dữ liệu trực tiếp bằng JSP.

## Công nghệ

- Java 17
- Maven
- JSP
- Jakarta Servlet / JSP API
- Tomcat 10.1+

## Luồng xử lý

index.jsp

POST

dictionary.jsp

dictionary.jsp xử lý dữ liệu bằng JSP Scriptlet.

Không sử dụng Servlet Java.

## Form

File:

src/main/webapp/index.jsp

Form:

method="POST"

action="dictionary.jsp"

Input:

name="search"

## Dictionary

dictionary.jsp sử dụng:

Map<String, String>

HashMap

Dữ liệu:

hello = Xin chào

how = Thế nào

book = Quyển sách

computer = Máy tính

student = Sinh viên

## JSP Scriptlet

Scriptlet được sử dụng để:

- request.getParameter("search")
- trim()
- toLowerCase()
- dictionary.get()

## JSP Expression

Expression được sử dụng để hiển thị:

<%= searchWord %>

<%= result %>

## Kết quả

Nếu từ tồn tại:

Hiển thị nghĩa tiếng Việt.

Nếu không tồn tại:

Không tìm thấy.

## Build

Chạy:

mvn clean package

File WAR:

target/jsp-pure-dictionary.war

## URL khi deploy Tomcat

http://localhost:8080/jsp-pure-dictionary/
