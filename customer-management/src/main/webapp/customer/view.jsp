<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        Chi tiết khách hàng
    </title>

    <style>

        body {
            margin: 0;
            padding: 40px 20px;
            background: #f8fafc;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 550px;
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

        table {
            width: 100%;
            margin-top: 25px;
            border-collapse: collapse;
        }

        td {
            padding: 13px;
            border-bottom: 1px solid #e2e8f0;
        }

        .label {
            width: 35%;
            color: #64748b;
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
        Chi tiết khách hàng
    </h1>


    <table>

        <tr>

            <td class="label">
                ID
            </td>

            <td>
                ${requestScope.customer.id}
            </td>

        </tr>

        <tr>

            <td class="label">
                Họ và tên
            </td>

            <td>
                ${requestScope.customer.name}
            </td>

        </tr>

        <tr>

            <td class="label">
                Email
            </td>

            <td>
                ${requestScope.customer.email}
            </td>

        </tr>

        <tr>

            <td class="label">
                Địa chỉ
            </td>

            <td>
                ${requestScope.customer.address}
            </td>

        </tr>

    </table>


    <a
        class="back"
        href="${pageContext.request.contextPath}/customers"
    >
        ← Quay lại danh sách
    </a>

</main>

</body>

</html>