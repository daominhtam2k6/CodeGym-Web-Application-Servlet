USE demo;

-- ==========================================================
-- 1. BANG PERMISSION
-- ==========================================================

CREATE TABLE IF NOT EXISTS permission (
    id INT NOT NULL,
    name VARCHAR(50),
    PRIMARY KEY (id)
);


-- ==========================================================
-- 2. BANG USER_PERMISSION
-- ==========================================================

CREATE TABLE IF NOT EXISTS user_permission (
    user_id INT NOT NULL,
    permission_id INT NOT NULL,

    PRIMARY KEY (
        user_id,
        permission_id
    ),

    CONSTRAINT fk_user_permission_user
        FOREIGN KEY (user_id)
        REFERENCES users(id),

    CONSTRAINT fk_user_permission_permission
        FOREIGN KEY (permission_id)
        REFERENCES permission(id)
);


-- ==========================================================
-- 3. DU LIEU PERMISSION MAU
-- ==========================================================

INSERT IGNORE INTO permission(id, name)
VALUES (1, 'add');

INSERT IGNORE INTO permission(id, name)
VALUES (2, 'edit');

INSERT IGNORE INTO permission(id, name)
VALUES (3, 'delete');

INSERT IGNORE INTO permission(id, name)
VALUES (4, 'view');


-- ==========================================================
-- KIEM TRA
-- ==========================================================

SELECT *
FROM permission
ORDER BY id;

SELECT *
FROM user_permission
ORDER BY user_id, permission_id;