package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet nhan du lieu tu form Calculator.
 */
@WebServlet(
        name = "CalculatorServlet",
        urlPatterns = {"/calculate"}
)
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType(
                "text/html;charset=UTF-8"
        );


        String firstValue =
                request.getParameter(
                        "firstOperand"
                );

        String secondValue =
                request.getParameter(
                        "secondOperand"
                );

        String operator =
                request.getParameter(
                        "operator"
                );


        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");

            out.println("<html lang='en'>");

            out.println("<head>");

            out.println(
                    "<meta charset='UTF-8'>"
            );

            out.println(
                    "<meta name='viewport' " +
                    "content='width=device-width, initial-scale=1.0'>"
            );

            out.println(
                    "<title>Calculator Result</title>"
            );

            out.println("</head>");


            out.println(
                    "<body style='" +
                    "margin:0;" +
                    "min-height:100vh;" +
                    "display:flex;" +
                    "align-items:center;" +
                    "justify-content:center;" +
                    "padding:20px;" +
                    "background:#f8fafc;" +
                    "font-family:Arial,sans-serif;" +
                    "'>"
            );


            out.println(
                    "<main style='" +
                    "width:min(520px,100%);" +
                    "padding:40px;" +
                    "background:white;" +
                    "border-radius:14px;" +
                    "box-shadow:0 12px 40px rgba(15,23,42,0.12);" +
                    "text-align:center;" +
                    "'>"
            );


            out.println(
                    "<h1 style='" +
                    "margin-top:0;" +
                    "color:#1b2a7a;" +
                    "'>" +
                    "Calculator Result" +
                    "</h1>"
            );


            try {

                double firstOperand =
                        Double.parseDouble(
                                firstValue
                        );

                double secondOperand =
                        Double.parseDouble(
                                secondValue
                        );


                double result =
                        Calculator.calculate(
                                firstOperand,
                                secondOperand,
                                operator
                        );


                out.println(
                        "<div style='" +
                        "margin:25px 0;" +
                        "padding:25px;" +
                        "background:#ecfdf5;" +
                        "border-radius:10px;" +
                        "'>"
                );


                out.println(
                        "<p style='" +
                        "color:#64748b;" +
                        "font-size:18px;" +
                        "'>" +
                        "Expression" +
                        "</p>"
                );


                out.println(
                        "<h2 style='" +
                        "color:#16a34a;" +
                        "font-size:30px;" +
                        "'>" +
                        firstOperand +
                        " " +
                        operator +
                        " " +
                        secondOperand +
                        " = " +
                        result +
                        "</h2>"
                );


                out.println("</div>");

            } catch (NumberFormatException exception) {

                out.println(
                        "<div style='" +
                        "margin:25px 0;" +
                        "padding:22px;" +
                        "background:#fef2f2;" +
                        "border-radius:10px;" +
                        "'>"
                );


                out.println(
                        "<h2 style='color:#dc2626;'>" +
                        "Invalid number!" +
                        "</h2>"
                );


                out.println(
                        "<p>" +
                        "Please enter valid numeric operands." +
                        "</p>"
                );


                out.println("</div>");

            } catch (Exception exception) {

                out.println(
                        "<div style='" +
                        "margin:25px 0;" +
                        "padding:22px;" +
                        "background:#fef2f2;" +
                        "border-radius:10px;" +
                        "'>"
                );


                out.println(
                        "<h2 style='color:#dc2626;'>" +
                        "Calculation Error" +
                        "</h2>"
                );


                out.println(
                        "<p style='" +
                        "color:#dc2626;" +
                        "font-size:18px;" +
                        "'>" +
                        exception.getMessage() +
                        "</p>"
                );


                out.println("</div>");
            }


            out.println(
                    "<a href='index.jsp' style='" +
                    "display:inline-block;" +
                    "margin-top:15px;" +
                    "padding:11px 22px;" +
                    "border-radius:6px;" +
                    "background:#1b2a7a;" +
                    "color:white;" +
                    "text-decoration:none;" +
                    "font-weight:bold;" +
                    "'>" +
                    "Calculate Again" +
                    "</a>"
            );


            out.println("</main>");

            out.println("</body>");

            out.println("</html>");
        }
    }
}