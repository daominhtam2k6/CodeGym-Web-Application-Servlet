package com.codegym;

/**
 * Thu vien giai phuong trinh bac hai:
 *
 * ax^2 + bx + c = 0
 */
public final class QuadraticEquationSolver {

    private QuadraticEquationSolver() {
    }


    /**
     * Tinh Delta.
     *
     * delta = b^2 - 4ac
     */
    public static double calculateDelta(
            double a,
            double b,
            double c
    ) {

        return b * b - 4 * a * c;
    }


    /**
     * Giai phuong trinh bac hai.
     *
     * Quy uoc ket qua:
     *
     * - Mang rong:
     *   vo nghiem thuc.
     *
     * - Mang 1 phan tu:
     *   nghiem kep.
     *
     * - Mang 2 phan tu:
     *   hai nghiem phan biet.
     *
     * Neu a = 0:
     * nem IllegalArgumentException.
     */
    public static double[] solve(
            double a,
            double b,
            double c
    ) {

        if (a == 0) {

            throw new IllegalArgumentException(
                    "He so a phai khac 0."
            );
        }


        double delta =
                calculateDelta(
                        a,
                        b,
                        c
                );


        if (delta < 0) {

            return new double[0];
        }


        if (delta == 0) {

            double x =
                    -b / (2 * a);


            return new double[]{
                    x
            };
        }


        double sqrtDelta =
                Math.sqrt(delta);


        double x1 =
                (-b + sqrtDelta)
                / (2 * a);


        double x2 =
                (-b - sqrtDelta)
                / (2 * a);


        return new double[]{
                x1,
                x2
        };
    }
}