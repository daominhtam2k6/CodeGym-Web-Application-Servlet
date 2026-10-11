USE demo;

-- ==========================================================
-- TRUOC KHI TEST
-- ==========================================================

SELECT *
FROM permission
ORDER BY id;

SELECT *
FROM users
ORDER BY id DESC;

SELECT *
FROM user_permission
ORDER BY user_id DESC;


-- ==========================================================
-- SAU KHI SUBMIT FORM CREATE
-- VA TRANSACTION BI ROLLBACK
--
-- Tim email ma ban vua nhap vao form.
--
-- Vi du:
--
-- transaction-test@codegym.vn
-- ==========================================================

SELECT *
FROM users
WHERE email = 'transaction-test@codegym.vn';


-- KET QUA MONG DOI:
--
-- 0 rows
--
-- Vi INSERT User da bi rollback.


SELECT up.*
FROM user_permission up
JOIN users u
    ON u.id = up.user_id
WHERE u.email = 'transaction-test@codegym.vn';


-- KET QUA MONG DOI:
--
-- 0 rows


-- ==========================================================
-- PERMISSION KHONG TON TAI
-- ==========================================================

SELECT *
FROM permission
WHERE id = 999999;


-- KET QUA:
--
-- 0 rows
--
-- Day la ly do INSERT vao user_permission bi loi.