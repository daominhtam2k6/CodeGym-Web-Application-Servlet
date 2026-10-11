<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        Chi tiết sản phẩm
    </title>

    <style>

        body {
            margin: 0;
            padding: 40px 20px;
            background: #f8fafc;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 650px;
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

        table {
            width: 100%;
            margin-top: 25px;
            border-collapse: collapse;
        }

        td {
            padding: 13px;
            border-bottom: 1px solid #e2e8f0;
            vertical-align: top;
        }

        .label {
            width: 32%;
            color: #64748b;
            font-weight: bold;
        }

        .price {
            color: #16a34a;
            font-weight: bold;
        }

        .back {
            display: block;
            margin-top: 25px;
            text-align: center;
            color: #1b2a7a;
            text-decoration: none;
            font-weight: bold;
        }

    </style>

</head>

<body>

<main class="container">

    <h1>
        Chi tiết sản phẩm
    </h1>


    <table>

        <tr>

            <td class="label">
                ID
            </td>

            <td>
                ${requestScope.product.id}
            </td>

        </tr>


        <tr>

            <td class="label">
                Tên sản phẩm
            </td>

            <td>
                ${requestScope.product.name}
            </td>

        </tr>


        <tr>

            <td class="label">
                Giá
            </td>

            <td class="price">
                $${requestScope.product.price}
            </td>

        </tr>


        <tr>

            <td class="label">
                Mô tả
            </td>

            <td>
                ${requestScope.product.description}
            </td>

        </tr>


        <tr>

            <td class="label">
                Nhà sản xuất
            </td>

            <td>
                ${requestScope.product.manufacturer}
            </td>

        </tr>

    </table>


    <a
        class="back"
        href="${pageContext.request.contextPath}/products"
    >
        ← Quay lại danh sách
    </a>

</main>

</body>

</html>