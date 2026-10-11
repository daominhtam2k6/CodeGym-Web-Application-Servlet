# Customer Management

Ứng dụng quản lý khách hàng sử dụng mô hình MVC.

## Công nghệ

- Java 17
- Maven
- Jakarta Servlet 6
- JSP 3.1
- JSTL 3
- Tomcat 10.1+

## Kiến trúc

Model:

Customer

Service:

CustomerService

CustomerServiceImpl

Controller:

CustomerServlet

View:

customer/list.jsp

customer/create.jsp

customer/edit.jsp

customer/delete.jsp

customer/view.jsp

error-404.jsp

## Chức năng

- Hiển thị danh sách khách hàng
- Thêm khách hàng
- Sửa khách hàng
- Xóa khách hàng
- Xem chi tiết khách hàng

## URL

/customer-management/customers

## Build

mvn clean package

Kết quả:

target/customer-management.war