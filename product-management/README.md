# Product Management

Ứng dụng quản lý sản phẩm sử dụng kiến trúc MVC.

## Model

Product gồm:

- id
- name
- price
- description
- manufacturer

## Service

ProductService

ProductServiceImpl

Dữ liệu được giả lập bằng Map.

## Controller

ProductServlet

URL:

/products

## View

product/list.jsp

product/create.jsp

product/edit.jsp

product/delete.jsp

product/view.jsp

error-404.jsp

## Chức năng

- Hiển thị danh sách
- Thêm sản phẩm
- Cập nhật sản phẩm
- Xóa sản phẩm
- Xem chi tiết
- Tìm kiếm sản phẩm theo tên

## Search

GET:

/products?action=search&keyword=laptop

## Build

mvn clean package

WAR:

target/product-management.war

## URL

http://localhost:8080/product-management/products