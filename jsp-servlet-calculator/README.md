# Bài tập - Ứng dụng Calculator

## Mục tiêu

Luyện tập tạo ứng dụng Java Web với Servlet và JSP.

## Công nghệ

- Java 17
- Maven
- JSP
- Jakarta Servlet 6
- Tomcat 10.1+

## Chức năng

Ứng dụng hỗ trợ:

- Cộng
- Trừ
- Nhân
- Chia

Người dùng nhập hai toán hạng và chọn toán tử.

## index.jsp

Form gửi dữ liệu bằng:

method="POST"

Endpoint:

action="calculate"

Các tham số:

firstOperand

operator

secondOperand

## Calculator

File:

src/main/java/com/codegym/Calculator.java

Lớp Calculator có phương thức:

calculate()

Phương thức thực hiện:

+

-

*

/

Nếu phép chia có mẫu số bằng 0:

throw new Exception("Cannot divide by zero")

## CalculatorServlet

File:

src/main/java/com/codegym/CalculatorServlet.java

Mapping:

/calculate

Servlet nhận dữ liệu bằng:

request.getParameter("firstOperand")

request.getParameter("operator")

request.getParameter("secondOperand")

Sau đó gọi:

Calculator.calculate(...)

## Xử lý lỗi

Servlet sử dụng try/catch.

NumberFormatException:

Dữ liệu không phải số hợp lệ.

Exception:

Hiển thị lỗi do Calculator ném ra.

Ví dụ:

Cannot divide by zero

## Build

Chạy:

mvn clean package

File WAR:

target/jsp-servlet-calculator.war

## URL khi deploy Tomcat

http://localhost:8080/jsp-servlet-calculator/