<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <title>
        Thêm User
    </title>

    <style>

        * {
            box-sizing: border-box;
        }


        body {
            margin: 0;

            padding:
                35px
                20px;

            background: #f8fafc;

            font-family:
                Arial,
                sans-serif;
        }


        .container {
            max-width: 600px;

            margin: auto;

            padding: 35px;

            border-radius: 12px;

            background: white;

            box-shadow:
                0 8px 30px
                rgba(15, 23, 42, 0.1);
        }


        h1 {
            color: #1b2a7a;

            text-align: center;
        }


        .description {
            margin-bottom: 25px;

            color: #64748b;

            text-align: center;

            line-height: 1.6;
        }


        .form-group {
            margin-bottom: 18px;
        }


        .main-label {
            display: block;

            margin-bottom: 7px;

            color: #334155;

            font-weight: bold;
        }


        input[type="text"],
        input[type="email"] {
            width: 100%;

            padding: 11px;

            border:
                1px solid
                #cbd5e1;

            border-radius: 6px;

            font-size: 16px;

            outline: none;
        }


        input[type="text"]:focus,
        input[type="email"]:focus {
            border-color: #1b2a7a;
        }


        .permissions {
            display: grid;

            grid-template-columns:
                repeat(
                    2,
                    minmax(0, 1fr)
                );

            gap: 12px;

            padding: 15px;

            border:
                1px solid
                #e2e8f0;

            border-radius: 8px;

            background: #f8fafc;
        }


        .permission-item {
            display: flex;

            align-items: center;

            gap: 8px;

            padding: 10px;

            border-radius: 6px;

            background: white;

            cursor: pointer;
        }


        .permission-item input {
            width: auto;

            margin: 0;
        }


        button {
            width: 100%;

            padding: 12px;

            border: none;

            border-radius: 6px;

            background: #16a34a;

            color: white;

            font-size: 16px;

            font-weight: bold;

            cursor: pointer;
        }


        .transaction-note {
            margin:
                20px
                0;

            padding: 13px;

            border-radius: 7px;

            background: #eff6ff;

            color: #1e40af;

            line-height: 1.6;

            font-size: 14px;
        }


        .back {
            display: block;

            margin-top: 18px;

            text-align: center;

            color: #1b2a7a;

            text-decoration: none;

            font-weight: bold;
        }


        @media (max-width: 500px) {

            .permissions {

                grid-template-columns: 1fr;
            }
        }

    </style>

</head>

<body>

<main class="container">

    <h1>
        Thêm Mới User
    </h1>


    <p class="description">

        User và Permission sẽ được lưu
        trong cùng một JDBC Transaction.

    </p>


    <form
        action="${pageContext.request.contextPath}/users?action=create"
        method="POST"
    >

        <div class="form-group">

            <label
                class="main-label"
                for="name"
            >
                Tên đầy đủ
            </label>

            <input
                id="name"
                type="text"
                name="name"
                required
            >

        </div>


        <div class="form-group">

            <label
                class="main-label"
                for="email"
            >
                Email
            </label>

            <input
                id="email"
                type="email"
                name="email"
                required
            >

        </div>


        <div class="form-group">

            <label
                class="main-label"
                for="country"
            >
                Quốc gia
            </label>

            <input
                id="country"
                type="text"
                name="country"
                required
            >

        </div>


        <!-- ===============================================
             PERMISSIONS
             =============================================== -->

        <div class="form-group">

            <span class="main-label">
                Quyền hạn (Permissions)
            </span>


            <div class="permissions">

                <label class="permission-item">

                    <input
                        type="checkbox"
                        name="permissions"
                        value="1"
                    >

                    Thêm (Add)

                </label>


                <label class="permission-item">

                    <input
                        type="checkbox"
                        name="permissions"
                        value="2"
                    >

                    Sửa (Edit)

                </label>


                <label class="permission-item">

                    <input
                        type="checkbox"
                        name="permissions"
                        value="3"
                    >

                    Xóa (Delete)

                </label>


                <label class="permission-item">

                    <input
                        type="checkbox"
                        name="permissions"
                        value="4"
                    >

                    Xem (View)

                </label>

            </div>

        </div>


        <div class="transaction-note">

            Khi nhấn Lưu, ứng dụng sẽ:

            <br>

            1. INSERT User.

            <br>

            2. Lấy ID User vừa sinh.

            <br>

            3. INSERT các quyền vào user_permission.

            <br>

            4. Commit nếu tất cả thành công.

            <br>

            5. Rollback nếu có lỗi.

        </div>


        <button type="submit">
            Lưu thông tin
        </button>

    </form>


    <a
        class="back"
        href="${pageContext.request.contextPath}/users"
    >
        Quay lại danh sách
    </a>

</main>

</body>

</html>