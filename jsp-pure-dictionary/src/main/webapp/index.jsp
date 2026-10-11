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
        Từ điển Anh - Việt
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

        .dictionary-container {
            width: 100%;

            max-width: 430px;

            padding: 40px;

            border-radius: 14px;

            background-color: white;

            box-shadow:
                0 12px 40px
                rgba(15, 23, 42, 0.12);

            text-align: center;
        }

        .icon {
            width: 72px;

            height: 72px;

            margin:
                0
                auto
                18px;

            display: flex;

            align-items: center;

            justify-content: center;

            border-radius: 50%;

            background-color: #eff6ff;

            color: #1b2a7a;

            font-size: 32px;

            font-weight: bold;
        }

        h1 {
            margin:
                0
                0
                10px;

            color: #1b2a7a;
        }

        .description {
            margin-bottom: 24px;

            color: #64748b;

            line-height: 1.6;
        }

        input {
            width: 100%;

            padding: 13px 14px;

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

            margin-top: 15px;

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

        .examples {
            margin-top: 22px;

            padding: 13px;

            border-radius: 7px;

            background-color: #f1f5f9;

            color: #64748b;

            font-size: 14px;

            line-height: 1.6;
        }

    </style>

</head>

<body>

    <main class="dictionary-container">

        <div class="icon">
            A
        </div>

        <h1>
            Từ Điển Anh - Việt
        </h1>

        <p class="description">
            Nhập một từ tiếng Anh để tra cứu
            nghĩa tiếng Việt.
        </p>

        <!--
            POST truc tiep sang dictionary.jsp
            Khong dung Servlet.
        -->

        <form
            action="dictionary.jsp"
            method="POST"
        >

            <input
                type="text"
                id="search"
                name="search"
                placeholder="Nhập từ tiếng Anh..."
                autocomplete="off"
                required
                autofocus
            >

            <button type="submit">
                Tìm kiếm
            </button>

        </form>

        <div class="examples">

            Từ mẫu:

            <strong>
                hello, how, book, computer, student
            </strong>

        </div>

    </main>

</body>

</html>
