package com.codegym;

import java.security.NoSuchAlgorithmException;

/**
 * Ung dung su dung Calculator tu file JAR ben ngoai.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(
                "Ket qua goi tu thu vien dong goi (.jar):"
        );


        System.out.println(
                "Tong 2 so (5, 9): "
                + Calculator.sum(
                        5,
                        9
                )
        );


        System.out.println(
                "Hieu 2 so (5, 9): "
                + Calculator.sub(
                        5,
                        9
                )
        );


        System.out.println(
                "Tich 2 so (5, 9): "
                + Calculator.mul(
                        5,
                        9
                )
        );


        try {

            System.out.println(
                    "Thuong 2 so (10, 5): "
                    + Calculator.divide(
                            10,
                            5
                    )
            );


            /*
             * Bo comment de test chia cho 0:
             *
             * System.out.println(
             *     Calculator.divide(10, 0)
             * );
             */


        } catch (NoSuchAlgorithmException exception) {

            System.err.println(
                    "Loi thuat toan: Khong the chia cho 0!"
            );


            exception.printStackTrace();
        }
    }
}