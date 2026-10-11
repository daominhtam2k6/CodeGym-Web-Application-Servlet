<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        Xóa ghi chú
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
            Xóa Ghi Chú
        </h1>


        <div class="danger">

            Bạn có chắc muốn xóa:

            <strong>

                <c:out value="${requestScope.note.title}" />

            </strong>

            ?

        </div>


        <form
            action="${pageContext.request.contextPath}/notes?action=delete"
            method="POST"
        >

            <input
                type="hidden"
                name="id"
                value="${requestScope.note.id}"
            >


            <button
                class="red"
                type="submit"
            >
                Xóa
            </button>


            <a
                class="button gray"
                href="${pageContext.request.contextPath}/notes"
            >
                Hủy
            </a>

        </form>

    </div>

</main>

</body>

</html>