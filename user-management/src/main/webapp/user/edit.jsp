<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        Chỉnh sửa User
    </title>

    <style>

        body {
            margin: 0;
            padding: 35px 20px;
            background: #f8fafc;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 520px;
            margin: auto;
            padding: 35px;
            border-radius: 12px;
            background: white;
            box-shadow: 0 8px 30px rgba(15,23,42,0.1);
        }

        h1 {
            color: #1b2a7a;
            text-align: center;
        }

        .form-group {
            margin-bottom: 17px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
        }

        input {
            box-sizing: border-box;
            width: 100%;
            padding: 11px;
            border: 1px solid #cbd5e1;
            border-radius: 6px;
            font-size: 16px;
        }

        button {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 6px;
            background: #0284c7;
            color: white;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
        }

        .back {
            display: block;
            margin-top: 18px;
            text-align: center;
            color: #1b2a7a;
            text-decoration: none;
        }

    </style>

</head>

<body>

<main class="container">

    <h1>
        Cập Nhật User
    </h1>


    <form
        action="${pageContext.request.contextPath}/users?action=edit"
        method="POST"
    >

        <input
            type="hidden"
            name="id"
            value="<c:out value='${requestScope.user.id}' />"
        >


        <div class="form-group">

            <label>
                Tên đầy đủ
            </label>

            <input
                type="text"
                name="name"
                value="<c:out value='${requestScope.user.name}' />"
                required
            >

        </div>


        <div class="form-group">

            <label>
                Email
            </label>

            <input
                type="email"
                name="email"
                value="<c:out value='${requestScope.user.email}' />"
                required
            >

        </div>


        <div class="form-group">

            <label>
                Quốc gia
            </label>

            <input
                type="text"
                name="country"
                value="<c:out value='${requestScope.user.country}' />"
                required
            >

        </div>


        <button type="submit">
            Cập nhật
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