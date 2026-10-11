<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <title>
        Simple Calculator
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


        .calculator {
            width: 100%;

            max-width: 450px;

            padding: 40px;

            border-radius: 14px;

            background-color: white;

            box-shadow:
                0 12px 40px
                rgba(15, 23, 42, 0.12);
        }


        h1 {
            margin-top: 0;

            margin-bottom: 10px;

            color: #1b2a7a;

            text-align: center;
        }


        .description {
            margin-bottom: 28px;

            color: #64748b;

            text-align: center;

            line-height: 1.6;
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


        input,
        select {
            width: 100%;

            padding: 12px 14px;

            border:
                1px solid
                #cbd5e1;

            border-radius: 7px;

            background-color: white;

            font-size: 16px;

            outline: none;
        }


        input:focus,
        select:focus {
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


        .operations {
            margin-top: 22px;

            padding: 13px;

            border-radius: 7px;

            background-color: #f1f5f9;

            color: #64748b;

            text-align: center;

            font-size: 14px;
        }

    </style>

</head>


<body>

    <main class="calculator">

        <h1>
            Simple Calculator
        </h1>


        <p class="description">
            Enter two operands and select
            an arithmetic operator.
        </p>


        <form
            action="calculate"
            method="POST"
        >


            <div class="form-group">

                <label for="firstOperand">
                    First Operand
                </label>

                <input
                    type="number"
                    id="firstOperand"
                    name="firstOperand"
                    step="any"
                    placeholder="Example: 10"
                    required
                >

            </div>


            <div class="form-group">

                <label for="operator">
                    Operator
                </label>

                <select
                    id="operator"
                    name="operator"
                    required
                >

                    <option value="+">
                        Addition (+)
                    </option>

                    <option value="-">
                        Subtraction (-)
                    </option>

                    <option value="*">
                        Multiplication (*)
                    </option>

                    <option value="/">
                        Division (/)
                    </option>

                </select>

            </div>


            <div class="form-group">

                <label for="secondOperand">
                    Second Operand
                </label>

                <input
                    type="number"
                    id="secondOperand"
                    name="secondOperand"
                    step="any"
                    placeholder="Example: 5"
                    required
                >

            </div>


            <button type="submit">
                Calculate
            </button>

        </form>


        <div class="operations">

            Supported operations:

            <strong>
                + &nbsp; - &nbsp; × &nbsp; ÷
            </strong>

        </div>

    </main>

</body>

</html>