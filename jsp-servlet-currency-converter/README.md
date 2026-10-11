# Thực hành - Ứng dụng chuyển đổi tiền tệ Servlet

## Mục tiêu

Luyện tập tạo Servlet và xử lý dữ liệu từ HTML Form.

## Công nghệ

- Java 17
- Maven
- JSP
- Jakarta Servlet 6
- Tomcat 10.1+

## Chức năng

Ứng dụng chuyển đổi USD sang VNĐ.

Công thức:

VND = USD * Rate

## Form

Trang:

src/main/webapp/index.jsp

Form sử dụng:

method="POST"

action="convert"

## Tham số

Tỉ giá:

name="rate"

Số USD:

name="usd"

## Servlet

File:

src/main/java/com/codegym/ConverterServlet.java

Endpoint:

/convert

Servlet lấy dữ liệu bằng:

request.getParameter("rate")

request.getParameter("usd")

Sau đó chuyển sang float và tính:

float vnd = rate * usd

## Xử lý lỗi

Nếu dữ liệu không thể chuyển sang số, Servlet bắt:

NumberFormatException

và thông báo:

Lỗi: Vui lòng nhập số hợp lệ!

## Build

Chạy:

mvn clean package

Sau khi build thành công:

target/jsp-servlet-currency-converter.war

## URL khi deploy Tomcat

http://localhost:8080/jsp-servlet-currency-converter/

## Lưu ý

Tomcat 10 trở lên sử dụng:

jakarta.servlet

Không sử dụng:

javax.servlet
