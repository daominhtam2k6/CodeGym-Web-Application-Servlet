<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        Xóa User
    </title>

    <style>

        body {
            margin: 0;
            padding: 40px 20px;
            background: #f8fafc;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 500px;
            margin: auto;
            padding: 35px;
            border-radius: 12px;
            background: white;
            box-shadow: 0 8px 30px rgba(15,23,42,0.1);
            text-align: center;
        }

        h1 {
            color: #dc2626;
        }

        .info {
            margin: 25px 0;
            padding: 20px;
            border-radius: 8px;
            background: #fef2f2;
            line-height: 1.8;
        }

        button {
            padding: 11px 20px;
            border: none;
            border-radius: 6px;
            background: #dc2626;
            color: white;
            font-weight: bold;
            cursor: pointer;
        }

        .cancel {
            display: inline-block;
            margin-left: 10px;
            padding: 11px 20px;
            border-radius: 6px;
            background: #e2e8f0;
            color: #334155;
            text-decoration: none;
            font-weight: bold;
        }

    </style>

</head>

<body>

<main class="container">

    <h1>
        Xác Nhận Xóa User
    </h1>


    <p>
        User sẽ bị xóa khỏi cơ sở dữ liệu MySQL.
    </p>


    <div class="info">

        <strong>
            ${requestScope.user.name}
        </strong>

        <br>

        ${requestScope.user.email}

        <br>

        ${requestScope.user.country}

    </div>


    <form
        action="${pageContext.request.contextPath}/users?action=delete"
        method="POST"
    >

        <input
            type="hidden"
            name="id"
            value="${requestScope.user.id}"
        >


        <button type="submit">
            Đồng ý Xóa
        </button>


        <a
            class="cancel"
            href="${pageContext.request.contextPath}/users"
        >
            Hủy bỏ
        </a>

    </form>

</main>

</body>

</html>