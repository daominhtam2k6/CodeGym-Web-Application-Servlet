<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        Chi tiết ghi chú
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

            <c:out value="${requestScope.note.title}" />

        </h1>


        <p>

            <span class="badge">

                <c:out value="${requestScope.note.typeName}" />

            </span>

        </p>


        <div class="note-content">

            <c:out value="${requestScope.note.content}" />

        </div>


        <p>

            <a
                class="button"
                href="${pageContext.request.contextPath}/notes?action=edit&id=${requestScope.note.id}"
            >
                Sửa
            </a>

            <a
                class="button gray"
                href="${pageContext.request.contextPath}/notes"
            >
                Quay lại
            </a>

        </p>

    </div>

</main>

</body>

</html>