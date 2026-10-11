# Thực hành - Ứng dụng Từ điển đơn giản Servlet

## Mục tiêu

Luyện tập tạo Servlet và xử lý dữ liệu nhận từ HTML Form.

## Công nghệ

- Java 17
- Maven
- JSP
- Jakarta Servlet 6
- Tomcat 10.1+

## Chức năng

Ứng dụng tra cứu từ Anh sang Việt.

## Form

Trang giao diện:

src/main/webapp/index.jsp

Form sử dụng:

method="POST"

Endpoint:

action="translate"

Input:

name="word"

## Servlet

File:

src/main/java/com/codegym/DictionaryServlet.java

Mapping:

/translate

## Dictionary

Dữ liệu được lưu bằng:

Map<String, String>

Các từ mẫu:

hello = Xin chào

how = Thế nào

book = Quyển sách

computer = Máy tính

student = Sinh viên

## Xử lý

Servlet lấy từ khóa:

request.getParameter("word")

Sau đó:

trim()

toLowerCase()

và tìm bằng:

dictionary.get(...)

## Kết quả

Nếu tìm thấy:

Hiển thị nghĩa tiếng Việt.

Nếu không tìm thấy:

Không tìm thấy từ: [từ khóa]

Nếu không nhập từ:

Vui lòng nhập từ khóa hợp lệ!

## Build

Chạy:

mvn clean package

File WAR:

target/jsp-servlet-dictionary.war

## URL khi deploy Tomcat

http://localhost:8080/jsp-servlet-dictionary/

## Lưu ý

Tomcat 10 trở lên sử dụng:

jakarta.servlet

Không sử dụng:

javax.servlet
