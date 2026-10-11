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
        Quản lý sản phẩm
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
            max-width: 1200px;
            margin: auto;
        }

        h1 {
            color: #1b2a7a;
        }

        .toolbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 20px;
            margin-bottom: 25px;
            flex-wrap: wrap;
        }

        .search-form {
            display: flex;
            gap: 8px;
            flex: 1;
            max-width: 500px;
        }

        .search-form input {
            flex: 1;
            padding: 11px 13px;
            border: 1px solid #cbd5e1;
            border-radius: 7px;
            font-size: 15px;
        }

        .search-form button {
            padding: 11px 17px;
            border: none;
            border-radius: 7px;
            background: #1b2a7a;
            color: white;
            font-weight: bold;
            cursor: pointer;
        }

        .create {
            padding: 11px 17px;
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
            padding: 14px;
            background: #1b2a7a;
            color: white;
            text-align: left;
        }

        td {
            padding: 14px;
            border-bottom: 1px solid #e2e8f0;
            vertical-align: top;
        }

        tbody tr:hover {
            background: #f8fafc;
        }

        .product-name {
            color: #1b2a7a;
            font-weight: bold;
            text-decoration: none;
        }

        .price {
            color: #16a34a;
            font-weight: bold;
        }

        .actions {
            white-space: nowrap;
        }

        .actions a {
            margin-right: 8px;
            text-decoration: none;
            font-weight: bold;
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

    </style>

</head>

<body>

<main class="container">

    <h1>
        Quản lý sản phẩm
    </h1>


    <div class="toolbar">

        <form
            class="search-form"
            action="${pageContext.request.contextPath}/products"
            method="GET"
        >

            <input
                type="hidden"
                name="action"
                value="search"
            >

            <input
                type="text"
                name="keyword"
                value="${requestScope.keyword}"
                placeholder="Tìm kiếm sản phẩm theo tên..."
            >

            <button type="submit">
                Tìm kiếm
            </button>

        </form>


        <a
            class="create"
            href="${pageContext.request.contextPath}/products?action=create"
        >
            + Thêm sản phẩm
        </a>

    </div>


    <div class="table-wrapper">

        <table>

            <thead>

            <tr>

                <th>ID</th>

                <th>Tên sản phẩm</th>

                <th>Giá</th>

                <th>Mô tả</th>

                <th>Nhà sản xuất</th>

                <th>Hành động</th>

            </tr>

            </thead>


            <tbody>

            <c:forEach
                items="${requestScope.products}"
                var="product"
            >

                <tr>

                    <td>
                        ${product.id}
                    </td>

                    <td>

                        <a
                            class="product-name"
                            href="${pageContext.request.contextPath}/products?action=view&id=${product.id}"
                        >
                            ${product.name}
                        </a>

                    </td>

                    <td class="price">
                        $${product.price}
                    </td>

                    <td>
                        ${product.description}
                    </td>

                    <td>
                        ${product.manufacturer}
                    </td>

                    <td class="actions">

                        <a
                            class="view"
                            href="${pageContext.request.contextPath}/products?action=view&id=${product.id}"
                        >
                            View
                        </a>

                        <a
                            class="edit"
                            href="${pageContext.request.contextPath}/products?action=edit&id=${product.id}"
                        >
                            Edit
                        </a>

                        <a
                            class="delete"
                            href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}"
                        >
                            Delete
                        </a>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>


        <c:if test="${empty requestScope.products}">

            <div class="empty">

                Không tìm thấy sản phẩm phù hợp.

            </div>

        </c:if>

    </div>

</main>

</body>

</html>