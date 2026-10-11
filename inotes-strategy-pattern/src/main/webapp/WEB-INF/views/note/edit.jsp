<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <title>
        Sửa ghi chú
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
            Sửa Ghi Chú
        </h1>


        <form
            action="${pageContext.request.contextPath}/notes?action=edit"
            method="POST"
        >

            <input
                type="hidden"
                name="id"
                value="${requestScope.note.id}"
            >


            <div class="form-group">

                <label>
                    Tiêu đề
                </label>

                <input
                    type="text"
                    name="title"
                    value="<c:out value='${requestScope.note.title}' />"
                    required
                >

            </div>


            <div class="form-group">

                <label>
                    Phân loại
                </label>

                <select
                    name="typeId"
                    required
                >

                    <c:forEach
                        var="type"
                        items="${requestScope.types}"
                    >

                        <option
                            value="${type.id}"
                            ${type.id == requestScope.note.typeId ? 'selected' : ''}
                        >

                            <c:out value="${type.name}" />

                        </option>

                    </c:forEach>

                </select>

            </div>


            <div class="form-group">

                <label>
                    Nội dung
                </label>

                <textarea
                    name="content"
                    required
                ><c:out value="${requestScope.note.content}" /></textarea>

            </div>


            <button type="submit">
                Cập nhật
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