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
        Product Discount Calculator
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

            max-width: 480px;

            padding: 40px;

            border-radius: 14px;

            background: white;

            box-shadow:
                0 12px 40px
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
        textarea {
            width: 100%;

            padding: 12px 14px;

            border:
                1px solid
                #cbd5e1;

            border-radius: 7px;

            font-family: inherit;

            font-size: 16px;

            outline: none;
        }

        textarea {
            min-height: 90px;

            resize: vertical;
        }

        input:focus,
        textarea:focus {
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

        .formula {
            margin-top: 22px;

            padding: 14px;

            border-radius: 8px;

            background-color: #eff6ff;

            color: #475569;

            font-size: 14px;

            line-height: 1.6;
        }

    </style>

</head>

<body>

    <main class="calculator">

        <h1>
            Product Discount Calculator
        </h1>

        <p class="description">
            Enter product information to calculate
            the discount amount and final price.
        </p>

        <!--
            POST request toi /display-discount
        -->

        <form
            action="display-discount"
            method="POST"
        >

            <div class="form-group">

                <label for="productDescription">
                    Product Description
                </label>

                <textarea
                    id="productDescription"
                    name="productDescription"
                    placeholder="Enter product description"
                    required
                ></textarea>

            </div>

            <div class="form-group">

                <label for="listPrice">
                    List Price
                </label>

                <input
                    type="number"
                    id="listPrice"
                    name="listPrice"
                    placeholder="Example: 1000"
                    min="0"
                    step="any"
                    required
                >

            </div>

            <div class="form-group">

                <label for="discountPercent">
                    Discount Percent (%)
                </label>

                <input
                    type="number"
                    id="discountPercent"
                    name="discountPercent"
                    placeholder="Example: 10"
                    min="0"
                    max="100"
                    step="any"
                    required
                >

            </div>

            <button type="submit">
                Calculate Discount
            </button>

        </form>

        <div class="formula">

            <strong>
                Formula
            </strong>

            <br>

            Discount Amount =
            List Price × Discount Percent × 0.01

            <br>

            Discount Price =
            List Price - Discount Amount

        </div>

    </main>

</body>

</html>
