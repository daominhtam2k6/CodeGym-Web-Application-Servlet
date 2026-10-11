# iNotes - Strategy Pattern

Ứng dụng quản lý ghi chú sử dụng JSP, Servlet, JDBC, MySQL và Strategy Pattern.

## Chức năng

- Hiển thị danh sách ghi chú
- Thêm ghi chú
- Xem chi tiết
- Sửa ghi chú
- Xóa ghi chú
- Phân loại ghi chú
- Tìm kiếm theo title hoặc content
- Runtime switch MySQL / File TXT

## Strategy Pattern

Interface:

NoteStrategy

Các implementation:

NoteDBStrategy

NoteFileStrategy

Context:

NoteManagement

NoteManagement có:

private NoteStrategy strategy

và:

setStrategy(NoteStrategy strategy)

## MySQL Strategy

Database:

inotes_db

Tables:

note_type

notes

Khởi tạo:

database.sql

## File Strategy

File:

USER_HOME/inotes-data/notes.txt

Format:

id|title|content|typeId

## Runtime Switch

MySQL:

/notes?storage=db

File:

/notes?storage=file

Storage đang chọn được lưu trong HTTP Session.

## MySQL Configuration

Mặc định:

user=root

password=password

Có thể đặt Environment Variables:

INOTES_DB_USER

INOTES_DB_PASSWORD

## Build

mvn clean package

WAR:

target/inotes.war

## URL

http://localhost:8080/inotes/notes