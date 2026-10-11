package com.codegym;

/**
 * Ung dung kiem tra thu vien
 * quadratic-equation-lib.jar.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(
                "=== THU VIEN GIAI PHUONG TRINH BAC 2 ==="
        );


        // ===========================================
        // TEST 1:
        //
        // x^2 - 5x + 6 = 0
        //
        // x1 = 3
        // x2 = 2
        // ===========================================

        testEquation(
                1,
                -5,
                6
        );


        // ===========================================
        // TEST 2:
        //
        // x^2 - 2x + 1 = 0
        //
        // x = 1
        // ===========================================

        testEquation(
                1,
                -2,
                1
        );


        // ===========================================
        // TEST 3:
        //
        // x^2 + x + 1 = 0
        //
        // Delta < 0
        // ===========================================

        testEquation(
                1,
                1,
                1
        );


        // ===========================================
        // TEST 4:
        //
        // a = 0
        // ===========================================

        try {

            testEquation(
                    0,
                    2,
                    1
            );

        } catch (IllegalArgumentException exception) {

            System.out.println(
                    "Loi mong doi: "
                    + exception.getMessage()
            );
        }
    }


    private static void testEquation(
            double a,
            double b,
            double c
    ) {

        System.out.println();

        System.out.println(
                "Phuong trinh: "
                + a
                + "x^2 + "
                + b
                + "x + "
                + c
                + " = 0"
        );


        double delta =
                QuadraticEquationSolver.calculateDelta(
                        a,
                        b,
                        c
                );


        System.out.println(
                "Delta = "
                + delta
        );


        double[] roots =
                QuadraticEquationSolver.solve(
                        a,
                        b,
                        c
                );


        if (roots.length == 0) {

            System.out.println(
                    "Phuong trinh vo nghiem thuc."
            );

            return;
        }


        if (roots.length == 1) {

            System.out.println(
                    "Phuong trinh co nghiem kep:"
            );


            System.out.println(
                    "x = "
                    + roots[0]
            );

            return;
        }


        System.out.println(
                "Phuong trinh co 2 nghiem:"
        );


        System.out.println(
                "x1 = "
                + roots[0]
        );


        System.out.println(
                "x2 = "
                + roots[1]
        );
    }
}