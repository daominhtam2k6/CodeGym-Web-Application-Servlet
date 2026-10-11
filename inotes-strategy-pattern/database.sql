CREATE DATABASE IF NOT EXISTS inotes_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE inotes_db;


CREATE TABLE IF NOT EXISTS note_type (

    id INT NOT NULL AUTO_INCREMENT,

    name VARCHAR(100) NOT NULL,

    description VARCHAR(255),

    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS notes (

    id INT NOT NULL AUTO_INCREMENT,

    title VARCHAR(255) NOT NULL,

    content TEXT,

    type_id INT NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_notes_note_type
        FOREIGN KEY (type_id)
        REFERENCES note_type(id)
);


INSERT IGNORE INTO note_type(
    id,
    name,
    description
)
VALUES
(
    1,
    'Cá nhân',
    'Các ghi chú cá nhân'
);


INSERT IGNORE INTO note_type(
    id,
    name,
    description
)
VALUES
(
    2,
    'Công việc',
    'Các ghi chú liên quan đến công việc'
);


INSERT IGNORE INTO note_type(
    id,
    name,
    description
)
VALUES
(
    3,
    'Học tập',
    'Các ghi chú phục vụ học tập'
);


INSERT INTO notes(
    title,
    content,
    type_id
)
SELECT
    'Họp giao ban đầu tuần',
    'Chuẩn bị nội dung cho cuộc họp đầu tuần.',
    2
WHERE NOT EXISTS (

    SELECT 1

    FROM notes

    WHERE title = 'Họp giao ban đầu tuần'
);


INSERT INTO notes(
    title,
    content,
    type_id
)
SELECT
    'Ôn tập Design Pattern Servlet',
    'Ôn lại Strategy Pattern và kiến trúc Servlet JSP.',
    3
WHERE NOT EXISTS (

    SELECT 1

    FROM notes

    WHERE title = 'Ôn tập Design Pattern Servlet'
);


SELECT *
FROM note_type;


SELECT *
FROM notes;