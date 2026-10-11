<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <title>
        iNotes
    </title>

    <link
        rel="stylesheet"
        href="${pageContext.request.contextPath}/assets/style.css"
    >

</head>

<body>

<main class="container">

    <div class="header">

        <div class="brand">

            <h1>
                iNotes
            </h1>

            <p>
                Quản lý ghi chú với Strategy Pattern
            </p>

        </div>


        <a
            class="button green"
            href="${pageContext.request.contextPath}/notes?action=create"
        >
            + Thêm mới
        </a>

    </div>


    <div class="card">

        <div class="toolbar">

            <form
                class="search-form"
                action="${pageContext.request.contextPath}/notes"
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
                    value="<c:out value='${requestScope.keyword}' />"
                    placeholder="Tìm trong tiêu đề hoặc nội dung..."
                >

                <button type="submit">
                    Tìm kiếm
                </button>

            </form>


            <div class="storage">

                <span>
                    Lưu trữ:
                </span>

                <a
                    class="${requestScope.storage == 'db' ? 'active' : ''}"
                    href="${pageContext.request.contextPath}/notes?storage=db"
                >
                    MySQL
                </a>

                <a
                    class="${requestScope.storage == 'file' ? 'active' : ''}"
                    href="${pageContext.request.contextPath}/notes?storage=file"
                >
                    File TXT
                </a>

            </div>

        </div>


        <p>

            Strategy hiện tại:

            <span class="badge">

                <c:choose>

                    <c:when test="${requestScope.storage == 'file'}">
                        NoteFileStrategy
                    </c:when>

                    <c:otherwise>
                        NoteDBStrategy
                    </c:otherwise>

                </c:choose>

            </span>

        </p>


        <table>

            <thead>

            <tr>

                <th>
                    #
                </th>

                <th>
                    Tiêu đề
                </th>

                <th>
                    Phân loại
                </th>

                <th>
                    Thao tác
                </th>

            </tr>

            </thead>


            <tbody>

            <c:forEach
                var="note"
                items="${requestScope.notes}"
            >

                <tr>

                    <td>
                        <c:out value="${note.id}" />
                    </td>

                    <td>
                        <c:out value="${note.title}" />
                    </td>

                    <td>

                        <span class="badge">
                            <c:out value="${note.typeName}" />
                        </span>

                    </td>

                    <td class="actions">

                        <a
                            href="${pageContext.request.contextPath}/notes?action=view&id=${note.id}"
                        >
                            Xem
                        </a>

                        <a
                            href="${pageContext.request.contextPath}/notes?action=edit&id=${note.id}"
                        >
                            Sửa
                        </a>

                        <a
                            href="${pageContext.request.contextPath}/notes?action=delete&id=${note.id}"
                        >
                            Xóa
                        </a>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>


        <c:if test="${empty requestScope.notes}">

            <div class="empty">

                Chưa có ghi chú phù hợp.

            </div>

        </c:if>

    </div>

</main>

</body>

</html>