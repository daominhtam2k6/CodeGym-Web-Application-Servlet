<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <title>Login Page</title>


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


        .login-container {
            width: 100%;

            max-width: 400px;

            padding: 35px;

            border-radius: 12px;

            background-color: white;

            box-shadow:
                0 10px 35px
                rgba(0, 0, 0, 0.10);

            text-align: center;
        }


        .login-container h1 {
            margin:
                0
                0
                10px;

            color: #1b2a7a;

            font-size: 30px;
        }


        .login-container p {
            margin-bottom: 25px;

            color: #64748b;

            line-height: 1.5;
        }


        .form-group {
            margin-bottom: 16px;

            text-align: left;
        }


        .form-group label {
            display: block;

            margin-bottom: 6px;

            color: #334155;

            font-weight: bold;
        }


        .form-group input {
            width: 100%;

            padding: 12px;

            border:
                1px solid
                #cbd5e1;

            border-radius: 6px;

            outline: none;

            font-size: 16px;
        }


        .form-group input:focus {
            border-color: #1b2a7a;

            box-shadow:
                0 0 0 3px
                rgba(27, 42, 122, 0.1);
        }


        button {
            width: 100%;

            padding: 12px;

            border: none;

            border-radius: 6px;

            background-color: #1b2a7a;

            color: white;

            font-size: 16px;

            font-weight: bold;

            cursor: pointer;
        }


        button:hover {
            background-color: #25399c;
        }


        .hint {
            margin-top: 20px;

            padding: 12px;

            border-radius: 6px;

            background-color: #eff6ff;

            color: #475569;

            font-size: 13px;
        }

    </style>

</head>


<body>

    <main class="login-container">

        <h1>
            System Login
        </h1>


        <p>
            Enter your username and password to continue.
        </p>


        <!--
            Quan trong:
            POST du lieu toi endpoint /login
        -->

        <form
            action="login"
            method="POST"
        >

            <div class="form-group">

                <label for="username">
                    Username
                </label>

                <input
                    type="text"
                    id="username"
                    name="username"
                    placeholder="Enter username"
                    autocomplete="username"
                    required
                >

            </div>


            <div class="form-group">

                <label for="password">
                    Password
                </label>

                <input
                    type="password"
                    id="password"
                    name="password"
                    placeholder="Enter password"
                    autocomplete="current-password"
                    required
                >

            </div>


            <button type="submit">
                Login
            </button>

        </form>


        <div class="hint">

            Practice account:

            <strong>
                admin / admin
            </strong>

        </div>

    </main>

</body>

</html>
