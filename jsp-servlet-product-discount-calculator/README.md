# Product Discount Calculator

## Mục tiêu

Luyện tập tạo ứng dụng Java Web và xử lý dữ liệu nhập từ Form.

## Công nghệ

- Java 17
- Maven
- JSP
- Jakarta Servlet 6
- Tomcat 10.1+

## Form

Trang:

src/main/webapp/index.jsp

Form sử dụng:

method="POST"

Endpoint:

action="display-discount"

## Dữ liệu nhập

Product Description:

name="productDescription"

List Price:

name="listPrice"

Discount Percent:

name="discountPercent"

## Servlet

File:

src/main/java/com/codegym/DiscountServlet.java

Endpoint:

/display-discount

## Công thức

Discount Amount = List Price * Discount Percent * 0.01

Discount Price = List Price - Discount Amount

## Ví dụ

Product Description:

Laptop

List Price:

1000

Discount Percent:

10

Kết quả:

Discount Amount = 100

Discount Price = 900

## Build

Chạy:

mvn clean package

File WAR:

target/jsp-servlet-product-discount-calculator.war

## URL khi deploy Tomcat

http://localhost:8080/jsp-servlet-product-discount-calculator/

## Lưu ý

Tomcat 10 trở lên sử dụng:

jakarta.servlet

Không sử dụng:

javax.servlet
