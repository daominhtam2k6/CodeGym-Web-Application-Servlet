USE demo;

-- ==========================================================
-- Stored Procedure 1:
-- Tim User theo ID
-- ==========================================================

DROP PROCEDURE IF EXISTS get_user_by_id;

DELIMITER $$

CREATE PROCEDURE get_user_by_id(
    IN user_id INT
)
BEGIN

    SELECT
        users.name,
        users.email,
        users.country

    FROM users

    WHERE users.id = user_id;

END$$

DELIMITER ;


-- ==========================================================
-- Stored Procedure 2:
-- Them User
-- ==========================================================

DROP PROCEDURE IF EXISTS insert_user;

DELIMITER $$

CREATE PROCEDURE insert_user(
    IN user_name VARCHAR(50),
    IN user_email VARCHAR(50),
    IN user_country VARCHAR(50)
)
BEGIN

    INSERT INTO users(
        name,
        email,
        country
    )

    VALUES(
        user_name,
        user_email,
        user_country
    );

END$$

DELIMITER ;


-- ==========================================================
-- KIEM TRA
-- ==========================================================

SHOW PROCEDURE STATUS
WHERE Db = 'demo';

-- Vi du:
--
-- CALL get_user_by_id(1);
--
-- CALL insert_user(
--     'Stored Procedure User',
--     'stored@codegym.vn',
--     'Viet Nam'
-- );