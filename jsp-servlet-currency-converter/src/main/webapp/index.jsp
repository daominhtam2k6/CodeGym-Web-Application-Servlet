<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <title>Currency Converter</title>


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

            padding: 38px;

            border-radius: 14px;

            background-color: white;

            box-shadow:
                0 12px 40px
                rgba(15, 23, 42, 0.12);
        }


        h1 {
            margin-top: 0;

            margin-bottom: 8px;

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

            padding: 12px 14px;

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
                rgba(27, 42, 122, 0.10);
        }


        button {
            width: 100%;

            margin-top: 5px;

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


        .formula {
            margin-top: 22px;

            padding: 12px;

            border-radius: 7px;

            background-color: #eff6ff;

            color: #475569;

            text-align: center;

            font-size: 14px;
        }

    </style>

</head>


<body>

    <main class="converter-container">

        <h1>
            Chuyển đổi USD sang VNĐ
        </h1>


        <p class="description">
            Nhập tỉ giá và số USD cần chuyển đổi.
        </p>


        <!--
            Form POST den endpoint /convert
        -->

        <form
            action="convert"
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
                Chuyển đổi
            </button>

        </form>


        <div class="formula">
            Công thức:
            <strong>
                VND = USD × Rate
            </strong>
        </div>

    </main>

</body>

</html>
