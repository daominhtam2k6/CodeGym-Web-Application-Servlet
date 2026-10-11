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
        Quản lý User
    </title>

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 35px 20px;
            background: #f8fafc;
            color: #334155;
            font-family: Arial, sans-serif;
        }

        .container {
            width: 100%;
            max-width: 1050px;
            margin: auto;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 20px;
            margin-bottom: 25px;
        }

        h1 {
            margin: 0;
            color: #1b2a7a;
        }

        .subtitle {
            color: #64748b;
        }

        .add {
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
            border-radius: 12px;
            background: white;
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

        .actions {
            white-space: nowrap;
        }

        .actions a {
            display: inline-block;
            margin-right: 8px;
            text-decoration: none;
            font-weight: bold;
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
                Danh Sách Người Dùng
            </h1>

            <p class="subtitle">
                JSP - Servlet - JDBC - MySQL
            </p>

        </div>


        <a
            class="add"
            href="${pageContext.request.contextPath}/users?action=create"
        >
            + Thêm User
        </a>

    </div>


    <div class="table-wrapper">

        <table>

            <thead>

            <tr>

                <th>ID</th>

                <th>Tên User</th>

                <th>Email</th>

                <th>Quốc gia</th>

                <th>Hành động</th>

            </tr>

            </thead>


            <tbody>

            <c:forEach
                var="user"
                items="${requestScope.listUser}"
            >

                <tr>

                    <td>
                        <c:out
                            value="${user.id}"
                        />
                    </td>

                    <td>
                        <c:out
                            value="${user.name}"
                        />
                    </td>

                    <td>
                        <c:out
                            value="${user.email}"
                        />
                    </td>

                    <td>
                        <c:out
                            value="${user.country}"
                        />
                    </td>

                    <td class="actions">

                        <a
                            class="edit"
                            href="${pageContext.request.contextPath}/users?action=edit&id=${user.id}"
                        >
                            Sửa
                        </a>

                        <a
                            class="delete"
                            href="${pageContext.request.contextPath}/users?action=delete&id=${user.id}"
                        >
                            Xóa
                        </a>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>


        <c:if test="${empty requestScope.listUser}">

            <div class="empty">
                Chưa có User trong cơ sở dữ liệu.
            </div>

        </c:if>

    </div>

</main>

</body>

</html>