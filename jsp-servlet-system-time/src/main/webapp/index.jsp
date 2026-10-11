<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <title>CodeGym JSP Demo</title>

</head>


<body
    style="
        margin: 0;
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        background-color: #f8fafc;
        font-family: Arial, sans-serif;
    "
>

    <main
        style="
            width: min(700px, 90%);
            padding: 40px;
            text-align: center;
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 10px 35px rgba(0, 0, 0, 0.08);
        "
    >

        <p
            style="
                color: #64748b;
                font-size: 14px;
                font-weight: bold;
                text-transform: uppercase;
            "
        >
            Java Web - JSP / Servlet
        </p>


        <h1
            style="
                color: #1b2a7a;
                font-size: 36px;
            "
        >
            Chào mừng tới lớp học Java Web!
        </h1>


        <p
            style="
                color: #475569;
                font-size: 18px;
            "
        >
            Đây là trang JSP động được xử lý trực tiếp từ Tomcat Server.
        </p>


        <%
            java.util.Date date = new java.util.Date();
        %>


        <section
            style="
                margin: 30px 0;
                padding: 25px;
                border-radius: 10px;
                background-color: #eff6ff;
            "
        >

            <p style="color: #64748b;">
                Thời gian hệ thống hiện tại:
            </p>

            <strong
                style="
                    color: #f15a24;
                    font-size: 22px;
                "
            >
                <%= date %>
            </strong>

        </section>


        <p style="color: #64748b;">
            Thời gian trên được tạo bởi Java trên máy chủ
            khi Tomcat xử lý trang JSP.
        </p>


        <a
            href="hello"
            style="
                display: inline-block;
                margin-top: 15px;
                padding: 12px 22px;
                border-radius: 6px;
                background-color: #1b2a7a;
                color: white;
                text-decoration: none;
                font-weight: bold;
            "
        >
            Đi tới HelloServlet
        </a>

    </main>

</body>

</html>
