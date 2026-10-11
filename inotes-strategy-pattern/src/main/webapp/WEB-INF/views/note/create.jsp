<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        Thêm ghi chú
    </title>

    <link
        rel="stylesheet"
        href="${pageContext.request.contextPath}/assets/style.css"
    >

</head>

<body>

<main class="container">

    <div class="card">

        <h1>
            Thêm Mới Ghi Chú
        </h1>


        <p>

            Storage:

            <span class="badge">

                <c:out value="${requestScope.storage}" />

            </span>

        </p>


        <form
            action="${pageContext.request.contextPath}/notes?action=create"
            method="POST"
        >

            <div class="form-group">

                <label for="title">
                    Tiêu đề
                </label>

                <input
                    id="title"
                    name="title"
                    type="text"
                    required
                >

            </div>


            <div class="form-group">

                <label for="typeId">
                    Phân loại
                </label>

                <select
                    id="typeId"
                    name="typeId"
                    required
                >

                    <c:forEach
                        var="type"
                        items="${requestScope.types}"
                    >

                        <option value="${type.id}">

                            <c:out value="${type.name}" />

                        </option>

                    </c:forEach>

                </select>

            </div>


            <div class="form-group">

                <label for="content">
                    Nội dung
                </label>

                <textarea
                    id="content"
                    name="content"
                    required
                ></textarea>

            </div>


            <button type="submit">
                Lưu ghi chú
            </button>


            <a
                class="button gray"
                href="${pageContext.request.contextPath}/notes"
            >
                Hủy bỏ
            </a>

        </form>

    </div>

</main>

</body>

</html>