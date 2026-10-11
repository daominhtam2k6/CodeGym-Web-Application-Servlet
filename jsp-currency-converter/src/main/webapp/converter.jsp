<%@ page
    contentType="text/html"
    pageEncoding="UTF-8"
%>

<%@ page
    import="java.text.NumberFormat"
%>

<%@ page
    import="java.util.Locale"
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
        Kết quả chuyển đổi
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

            background-color: white;

            border-radius: 12px;

            box-shadow:
                0 10px 35px
                rgba(15, 23, 42, 0.12);

            text-align: center;
        }

        h1 {
            margin-top: 0;

            color: #1b2a7a;
        }

        .result-box {
            margin:
                25px
                0;

            padding: 22px;

            background-color: #ecfdf5;

            border-radius: 10px;
        }

        .result-box h2 {
            margin-bottom: 0;

            color: #16a34a;
        }

        .error-box {
            margin:
                25px
                0;

            padding: 22px;

            background-color: #fef2f2;

            border-radius: 10px;

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
            KẾT QUẢ CHUYỂN ĐỔI
        </h1>

        <%--
            Scriptlet:
            Java code duoc nhung truc tiep vao JSP.
        --%>

        <%

            try {

                String rateParameter =
                        request.getParameter("rate");

                String usdParameter =
                        request.getParameter("usd");


                float rate =
                        Float.parseFloat(
                                rateParameter
                        );


                float usd =
                        Float.parseFloat(
                                usdParameter
                        );


                float vnd =
                        rate * usd;


                NumberFormat vndFormat =
                        NumberFormat.getNumberInstance(
                                new Locale("vi", "VN")
                        );


                NumberFormat usdFormat =
                        NumberFormat.getNumberInstance(
                                Locale.US
                        );

        %>


        <p>
            Tỉ giá hiện tại:
            <strong>
                <%= vndFormat.format(rate) %>
            </strong>
            VND/USD
        </p>


        <p>
            Lượng USD yêu cầu:

            <strong>
                $<%= usdFormat.format(usd) %>
            </strong>
        </p>


        <div class="result-box">

            <p>
                Thành tiền
            </p>

            <h2>
                <%= vndFormat.format(vnd) %> VNĐ
            </h2>

        </div>


        <p style="color: #64748b;">
            <%= usdFormat.format(usd) %>
            USD ×
            <%= vndFormat.format(rate) %>
            =
            <%= vndFormat.format(vnd) %>
            VNĐ
        </p>


        <%

            } catch (Exception exception) {

        %>


        <div class="error-box">

            <h2>
                Lỗi xử lý!
            </h2>

            <p>
                Dữ liệu đầu vào không hợp lệ.
                Vui lòng kiểm tra lại.
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
