package com.codegym;

/**
 * Lop thuc hien cac phep tinh co ban.
 */
public class Calculator {

    /**
     * Tinh toan dua tren hai toan hang va toan tu.
     *
     * @param firstOperand  toan hang thu nhat
     * @param secondOperand toan hang thu hai
     * @param operator      +, -, *, /
     * @return ket qua phep tinh
     * @throws Exception neu chia cho 0 hoac toan tu khong hop le
     */
    public static double calculate(
            double firstOperand,
            double secondOperand,
            String operator
    ) throws Exception {

        switch (operator) {

            case "+":
                return firstOperand + secondOperand;

            case "-":
                return firstOperand - secondOperand;

            case "*":
                return firstOperand * secondOperand;

            case "/":

                if (secondOperand == 0) {

                    throw new Exception(
                            "Cannot divide by zero"
                    );
                }

                return firstOperand / secondOperand;

            default:

                throw new Exception(
                        "Invalid operator"
                );
        }
    }
}