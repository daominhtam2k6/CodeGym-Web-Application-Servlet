<%@ page
    import="java.util.HashMap"
%>

<%@ page
    import="java.util.Map"
%>

<%@ page
    contentType="text/html"
    pageEncoding="UTF-8"
%>

<%
    request.setCharacterEncoding("UTF-8");

    String searchWord =
            request.getParameter("search");


    Map<String, String> dictionary =
            new HashMap<>();


    dictionary.put(
            "hello",
            "Xin chào"
    );

    dictionary.put(
            "how",
            "Thế nào"
    );

    dictionary.put(
            "book",
            "Quyển sách"
    );

    dictionary.put(
            "computer",
            "Máy tính"
    );

    dictionary.put(
            "student",
            "Sinh viên"
    );


    String result = null;

    String normalizedWord = null;


    if (
            searchWord != null
            && !searchWord.trim().isEmpty()
    ) {

        normalizedWord =
                searchWord
                        .trim()
                        .toLowerCase();

        result =
                dictionary.get(
                        normalizedWord
                );
    }
%>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <title>
        Kết quả tra cứu
    </title>

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;

            min-height: 100vh;

            display: flex;

            align-items: center;

            justify-content: center;

            padding: 20px;

            background-color: #f8fafc;

            font-family:
                Arial,
                sans-serif;
        }

        .result-container {
            width: 100%;

            max-width: 500px;

            padding: 40px;

            border-radius: 14px;

            background-color: white;

            box-shadow:
                0 12px 40px
                rgba(15, 23, 42, 0.12);

            text-align: center;
        }

        h1 {
            margin-top: 0;

            color: #1b2a7a;
        }

        .success {
            margin:
                25px
                0;

            padding: 22px;

            border-radius: 10px;

            background-color: #ecfdf5;
        }

        .success h2 {
            margin-bottom: 0;

            color: #16a34a;
        }

        .error {
            margin:
                25px
                0;

            padding: 22px;

            border-radius: 10px;

            background-color: #fef2f2;

            color: #dc2626;
        }

        .back-btn {
            display: inline-block;

            margin-top: 20px;

            padding:
                11px
                22px;

            border-radius: 6px;

            background-color: #1b2a7a;

            color: white;

            text-decoration: none;

            font-weight: bold;
        }

    </style>

</head>

<body>

    <main class="result-container">

        <h1>
            KẾT QUẢ TRA CỨU
        </h1>


        <%
            if (result != null) {
        %>


        <p>
            Từ cần tra:

            <strong style="color: #1b2a7a;">
                <%= searchWord %>
            </strong>
        </p>


        <div class="success">

            <p>
                Nghĩa tiếng Việt
            </p>

            <h2>
                <%= result %>
            </h2>

        </div>


        <%
            } else {
        %>


        <div class="error">

            <h2>
                Không tìm thấy!
            </h2>

            <p>
                Từ khóa

                <strong>
                    <%= searchWord %>
                </strong>

                không có trong từ điển.
            </p>

        </div>


        <%
            }
        %>


        <a
            href="index.jsp"
            class="back-btn"
        >
            Quay lại trang chủ
        </a>

    </main>

</body>

</html>
