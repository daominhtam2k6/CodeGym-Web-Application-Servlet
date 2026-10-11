<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
        Danh sách khách hàng
    </title>

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 35px 20px;
            background: #f8fafc;
            font-family: Arial, sans-serif;
            color: #334155;
        }

        .container {
            max-width: 1100px;
            margin: auto;
        }

        .header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            gap: 20px;
            margin-bottom: 25px;
        }

        h1 {
            margin: 0;
            color: #1b2a7a;
        }

        .btn-create {
            display: inline-block;
            padding: 11px 18px;
            border-radius: 7px;
            background: #16a34a;
            color: white;
            text-decoration: none;
            font-weight: bold;
        }

        .table-wrapper {
            overflow-x: auto;
            background: white;
            border-radius: 12px;
            box-shadow: 0 8px 30px rgba(15,23,42,0.08);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            padding: 14px 16px;
            background: #1b2a7a;
            color: white;
            text-align: left;
        }

        td {
            padding: 14px 16px;
            border-bottom: 1px solid #e2e8f0;
        }

        tbody tr:hover {
            background: #f8fafc;
        }

        .name-link {
            color: #1b2a7a;
            text-decoration: none;
            font-weight: bold;
        }

        .actions {
            white-space: nowrap;
        }

        .actions a {
            margin-right: 10px;
            font-weight: bold;
            text-decoration: none;
        }

        .view {
            color: #1b2a7a;
        }

        .edit {
            color: #0284c7;
        }

        .delete {
            color: #dc2626;
        }

        .empty {
            padding: 30px;
            text-align: center;
            color: #64748b;
        }

        @media (max-width: 650px) {

            .header {
                align-items: flex-start;
                flex-direction: column;
            }

        }

    </style>

</head>

<body>

<main class="container">

    <div class="header">

        <div>

            <h1>
                Danh Sách Khách Hàng
            </h1>

            <p>
                Customer Management - MVC
            </p>

        </div>

        <a
            href="${pageContext.request.contextPath}/customers?action=create"
            class="btn-create"
        >
            + Thêm khách hàng
        </a>

    </div>


    <div class="table-wrapper">

        <table>

            <thead>

            <tr>

                <th>ID</th>

                <th>Họ và Tên</th>

                <th>Email</th>

                <th>Địa chỉ</th>

                <th>Hành động</th>

            </tr>

            </thead>


            <tbody>

            <c:forEach
                items="${requestScope.customers}"
                var="customer"
            >

                <tr>

                    <td>
                        ${customer.id}
                    </td>

                    <td>

                        <a
                            href="${pageContext.request.contextPath}/customers?action=view&id=${customer.id}"
                            class="name-link"
                        >
                            ${customer.name}
                        </a>

                    </td>

                    <td>
                        ${customer.email}
                    </td>

                    <td>
                        ${customer.address}
                    </td>

                    <td class="actions">

                        <a
                            class="view"
                            href="${pageContext.request.contextPath}/customers?action=view&id=${customer.id}"
                        >
                            View
                        </a>

                        <a
                            class="edit"
                            href="${pageContext.request.contextPath}/customers?action=edit&id=${customer.id}"
                        >
                            Edit
                        </a>

                        <a
                            class="delete"
                            href="${pageContext.request.contextPath}/customers?action=delete&id=${customer.id}"
                        >
                            Delete
                        </a>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>


        <c:if test="${empty requestScope.customers}">

            <div class="empty">
                Chưa có khách hàng nào.
            </div>

        </c:if>

    </div>

</main>

</body>

</html>