<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        Thêm sản phẩm
    </title>

    <style>

        body {
            margin: 0;
            padding: 30px 20px;
            background: #f8fafc;
            font-family: Arial, sans-serif;
        }

        .form-container {
            max-width: 560px;
            margin: auto;
            padding: 35px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 8px 30px rgba(15,23,42,0.1);
        }

        h1 {
            text-align: center;
            color: #1b2a7a;
        }

        .form-group {
            margin-bottom: 17px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
        }

        input,
        textarea {
            box-sizing: border-box;
            width: 100%;
            padding: 11px;
            border: 1px solid #cbd5e1;
            border-radius: 6px;
            font: inherit;
        }

        textarea {
            min-height: 100px;
        }

        button {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 6px;
            background: #16a34a;
            color: white;
            font-weight: bold;
            cursor: pointer;
        }

        .message {
            margin-bottom: 18px;
            padding: 12px;
            border-radius: 6px;
            background: #ecfdf5;
            color: #15803d;
            text-align: center;
        }

        .error {
            margin-bottom: 18px;
            padding: 12px;
            border-radius: 6px;
            background: #fef2f2;
            color: #dc2626;
            text-align: center;
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

<main class="form-container">

    <h1>
        Thêm sản phẩm
    </h1>


    <c:if test="${not empty requestScope.message}">

        <div class="message">
            ${requestScope.message}
        </div>

    </c:if>


    <c:if test="${not empty requestScope.error}">

        <div class="error">
            ${requestScope.error}
        </div>

    </c:if>


    <form
        action="${pageContext.request.contextPath}/products?action=create"
        method="POST"
    >

        <div class="form-group">

            <label for="name">
                Tên sản phẩm
            </label>

            <input
                id="name"
                name="name"
                type="text"
                required
            >

        </div>


        <div class="form-group">

            <label for="price">
                Giá sản phẩm
            </label>

            <input
                id="price"
                name="price"
                type="number"
                step="any"
                min="0"
                required
            >

        </div>


        <div class="form-group">

            <label for="description">
                Mô tả
            </label>

            <textarea
                id="description"
                name="description"
                required
            ></textarea>

        </div>


        <div class="form-group">

            <label for="manufacturer">
                Nhà sản xuất
            </label>

            <input
                id="manufacturer"
                name="manufacturer"
                type="text"
                required
            >

        </div>


        <button type="submit">
            Lưu sản phẩm
        </button>

    </form>


    <a
        class="back"
        href="${pageContext.request.contextPath}/products"
    >
        Quay lại danh sách
    </a>

</main>

</body>

</html>