<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        Cập nhật khách hàng
    </title>

    <style>

        body {
            margin: 0;
            padding: 30px 20px;
            background: #f8fafc;
            font-family: Arial, sans-serif;
        }

        .form-container {
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

        .message {
            margin-bottom: 20px;
            padding: 12px;
            border-radius: 7px;
            background: #ecfdf5;
            color: #15803d;
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
            color: #1b2a7a;
            text-align: center;
            text-decoration: none;
        }

    </style>

</head>

<body>

<main class="form-container">

    <h1>
        Cập nhật khách hàng
    </h1>


    <c:if test="${not empty requestScope.message}">

        <div class="message">
            ${requestScope.message}
        </div>

    </c:if>


    <form
        action="${pageContext.request.contextPath}/customers?action=edit"
        method="POST"
    >

        <input
            type="hidden"
            name="id"
            value="${requestScope.customer.id}"
        >


        <div class="form-group">

            <label for="name">
                Họ và tên
            </label>

            <input
                id="name"
                name="name"
                type="text"
                value="${requestScope.customer.name}"
                required
            >

        </div>


        <div class="form-group">

            <label for="email">
                Email
            </label>

            <input
                id="email"
                name="email"
                type="email"
                value="${requestScope.customer.email}"
                required
            >

        </div>


        <div class="form-group">

            <label for="address">
                Địa chỉ
            </label>

            <input
                id="address"
                name="address"
                type="text"
                value="${requestScope.customer.address}"
                required
            >

        </div>


        <button type="submit">
            Cập nhật
        </button>

    </form>


    <a
        class="back"
        href="${pageContext.request.contextPath}/customers"
    >
        Quay lại danh sách
    </a>

</main>

</body>

</html>