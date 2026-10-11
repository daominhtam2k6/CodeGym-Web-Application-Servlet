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

            padding:
                35px
                20px;

            background: #f8fafc;

            color: #334155;

            font-family:
                Arial,
                sans-serif;
        }


        .container {
            width: 100%;

            max-width: 1100px;

            margin: auto;
        }


        .header {
            display: flex;

            justify-content: space-between;

            align-items: center;

            gap: 20px;

            margin-bottom: 20px;

            flex-wrap: wrap;
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

            padding:
                11px
                18px;

            border-radius: 7px;

            background: #16a34a;

            color: white;

            text-decoration: none;

            font-weight: bold;
        }


        .toolbar {
            display: flex;

            gap: 12px;

            align-items: center;

            justify-content: space-between;

            margin-bottom: 20px;

            flex-wrap: wrap;
        }


        .search-form {
            display: flex;

            gap: 8px;

            flex: 1;

            max-width: 520px;
        }


        .search-form input {
            flex: 1;

            padding:
                11px
                13px;

            border:
                1px solid
                #cbd5e1;

            border-radius: 7px;

            font-size: 15px;

            outline: none;
        }


        .search-form input:focus {
            border-color: #1b2a7a;
        }


        .search-form button {
            padding:
                11px
                17px;

            border: none;

            border-radius: 7px;

            background: #1b2a7a;

            color: white;

            font-weight: bold;

            cursor: pointer;
        }


        .toolbar-actions {
            display: flex;

            gap: 8px;
        }


        .sort-btn,
        .reset-btn {
            display: inline-block;

            padding:
                11px
                15px;

            border-radius: 7px;

            text-decoration: none;

            font-weight: bold;
        }


        .sort-btn {
            background: #7c3aed;

            color: white;
        }


        .reset-btn {
            background: #e2e8f0;

            color: #334155;
        }


        .status {
            margin-bottom: 16px;

            padding: 12px;

            border-radius: 7px;

            background: #eff6ff;

            color: #1e40af;
        }


        .table-wrapper {
            overflow-x: auto;

            border-radius: 12px;

            background: white;

            box-shadow:
                0 8px 30px
                rgba(15, 23, 42, 0.08);
        }


        table {
            width: 100%;

            border-collapse: collapse;
        }


        th {
            padding:
                14px
                16px;

            background: #1b2a7a;

            color: white;

            text-align: left;
        }


        td {
            padding:
                14px
                16px;

            border-bottom:
                1px solid
                #e2e8f0;
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


        @media (max-width: 700px) {

            .header {
                align-items: flex-start;

                flex-direction: column;
            }


            .search-form {
                width: 100%;

                max-width: none;
            }

        }

    </style>

</head>


<body>

<main class="container">

    <div class="header">

        <div>

            <h1>
                Quản lý User
            </h1>

            <p class="subtitle">

                <c:choose>

                    <c:when test="${not empty requestScope.pageTitle}">
                        <c:out value="${requestScope.pageTitle}" />
                    </c:when>

                    <c:otherwise>
                        JSP - Servlet - JDBC - MySQL
                    </c:otherwise>

                </c:choose>

            </p>

        </div>


        <a
            class="add"
            href="${pageContext.request.contextPath}/users?action=create"
        >
            + Thêm User
        </a>

    </div>


    <!-- ===================================================
         SEARCH COUNTRY
         =================================================== -->

    <div class="toolbar">

        <form
            class="search-form"
            action="${pageContext.request.contextPath}/users"
            method="GET"
        >

            <input
                type="hidden"
                name="action"
                value="search"
            >


            <input
                type="text"
                name="country"
                value="<c:out value='${requestScope.countryKeyword}' />"
                placeholder="Nhập country, ví dụ: Viet Nam"
            >


            <button type="submit">
                Tìm theo Country
            </button>

        </form>


        <div class="toolbar-actions">

            <a
                class="sort-btn"
                href="${pageContext.request.contextPath}/users?action=sort"
            >
                Sắp xếp Name A-Z
            </a>


            <a
                class="reset-btn"
                href="${pageContext.request.contextPath}/users"
            >
                Tất cả
            </a>

        </div>

    </div>


    <!-- ===================================================
         SEARCH STATUS
         =================================================== -->

    <c:if test="${not empty requestScope.countryKeyword}">

        <div class="status">

            Đang tìm User có country chứa:

            <strong>
                <c:out
                    value="${requestScope.countryKeyword}"
                />
            </strong>

        </div>

    </c:if>


    <!-- ===================================================
         SORT STATUS
         =================================================== -->

    <c:if test="${requestScope.sortedByName}">

        <div class="status">
            Danh sách đang được sắp xếp theo
            <strong>Name A-Z</strong>.
        </div>

    </c:if>


    <!-- ===================================================
         USER TABLE
         =================================================== -->

    <div class="table-wrapper">

        <table>

            <thead>

            <tr>

                <th>
                    ID
                </th>

                <th>
                    Tên User
                </th>

                <th>
                    Email
                </th>

                <th>
                    Country
                </th>

                <th>
                    Hành động
                </th>

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

                Không tìm thấy User phù hợp.

            </div>

        </c:if>

    </div>

</main>

</body>

</html>