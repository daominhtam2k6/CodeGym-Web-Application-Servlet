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
        Chuyển đổi tiền tệ
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

            background:
                linear-gradient(
                    135deg,
                    #eff6ff,
                    #f8fafc
                );

            font-family:
                Arial,
                sans-serif;
        }

        .converter-container {
            width: 100%;

            max-width: 430px;

            padding: 40px;

            background-color: white;

            border-radius: 12px;

            box-shadow:
                0 10px 35px
                rgba(15, 23, 42, 0.12);
        }

        h1 {
            margin-top: 0;

            color: #1b2a7a;

            text-align: center;
        }

        .description {
            margin-bottom: 28px;

            color: #64748b;

            text-align: center;

            line-height: 1.5;
        }

        .form-group {
            margin-bottom: 18px;
        }

        label {
            display: block;

            margin-bottom: 7px;

            color: #334155;

            font-weight: bold;
        }

        input {
            width: 100%;

            padding: 12px;

            border:
                1px solid
                #cbd5e1;

            border-radius: 7px;

            outline: none;

            font-size: 16px;
        }

        input:focus {
            border-color: #1b2a7a;

            box-shadow:
                0 0 0 3px
                rgba(27, 42, 122, 0.1);
        }

        button {
            width: 100%;

            padding: 13px;

            border: none;

            border-radius: 7px;

            background-color: #1b2a7a;

            color: white;

            font-size: 16px;

            font-weight: bold;

            cursor: pointer;
        }

        button:hover {
            background-color: #121c54;
        }

        .note {
            margin-top: 22px;

            padding: 12px;

            border-radius: 7px;

            background-color: #eff6ff;

            color: #475569;

            font-size: 14px;

            text-align: center;
        }

    </style>

</head>

<body>

    <main class="converter-container">

        <h1>
            USD to VND Converter
        </h1>

        <p class="description">
            Nhập tỉ giá và lượng USD cần chuyển đổi.
        </p>

        <!--
            JSP -> JSP

            Khong gui den Servlet.

            POST truc tiep sang converter.jsp
        -->

        <form
            action="converter.jsp"
            method="POST"
        >

            <div class="form-group">

                <label for="rate">
                    Tỉ giá (VND/USD)
                </label>

                <input
                    type="number"
                    id="rate"
                    name="rate"
                    value="25000"
                    placeholder="Ví dụ: 25000"
                    min="0"
                    step="any"
                    required
                >

            </div>

            <div class="form-group">

                <label for="usd">
                    Lượng USD cần đổi
                </label>

                <input
                    type="number"
                    id="usd"
                    name="usd"
                    placeholder="Ví dụ: 100"
                    min="0"
                    step="any"
                    required
                >

            </div>

            <button type="submit">
                Tính toán
            </button>

        </form>

        <div class="note">

            Công thức:

            <strong>
                VND = USD × Rate
            </strong>

        </div>

    </main>

</body>

</html>
