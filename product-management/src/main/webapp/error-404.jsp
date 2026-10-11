<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        404 - Product Not Found
    </title>

    <style>

        body {
            margin: 0;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: #f8fafc;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 500px;
            padding: 45px;
            background: white;
            border-radius: 14px;
            box-shadow: 0 10px 35px rgba(15,23,42,0.1);
            text-align: center;
        }

        h1 {
            margin: 0;
            color: #dc2626;
            font-size: 64px;
        }

        h2 {
            color: #334155;
        }

        p {
            color: #64748b;
            line-height: 1.6;
        }

        a {
            display: inline-block;
            margin-top: 15px;
            padding: 11px 20px;
            border-radius: 6px;
            background: #1b2a7a;
            color: white;
            text-decoration: none;
            font-weight: bold;
        }

    </style>

</head>

<body>

<main class="container">

    <h1>
        404
    </h1>

    <h2>
        Không tìm thấy sản phẩm
    </h2>

    <p>
        Sản phẩm bạn yêu cầu không tồn tại
        hoặc đã bị xóa.
    </p>

    <a href="${pageContext.request.contextPath}/products">
        Quay lại danh sách
    </a>

</main>

</body>

</html>