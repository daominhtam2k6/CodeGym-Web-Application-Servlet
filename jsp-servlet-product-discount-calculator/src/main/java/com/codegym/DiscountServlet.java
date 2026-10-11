package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Product Discount Calculator.
 *
 * Discount Amount =
 * List Price * Discount Percent * 0.01
 *
 * Discount Price =
 * List Price - Discount Amount
 */
@WebServlet(
        name = "DiscountServlet",
        urlPatterns = {"/display-discount"}
)
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType(
                "text/html;charset=UTF-8"
        );

        String productDescription =
                request.getParameter(
                        "productDescription"
                );

        try (PrintWriter out = response.getWriter()) {

            try {

                double listPrice =
                        Double.parseDouble(
                                request.getParameter(
                                        "listPrice"
                                )
                        );

                double discountPercent =
                        Double.parseDouble(
                                request.getParameter(
                                        "discountPercent"
                                )
                        );

                double discountAmount =
                        listPrice
                        * discountPercent
                        * 0.01;

                double discountPrice =
                        listPrice
                        - discountAmount;


                NumberFormat moneyFormat =
                        NumberFormat.getCurrencyInstance(
                                Locale.US
                        );


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
                        "<title>Discount Result</title>"
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
                        "width:min(600px,100%);" +
                        "padding:40px;" +
                        "background:white;" +
                        "border-radius:14px;" +
                        "box-shadow:0 12px 40px rgba(0,0,0,0.10);" +
                        "'>"
                );


                out.println(
                        "<h1 style='" +
                        "margin-top:0;" +
                        "color:#1b2a7a;" +
                        "text-align:center;" +
                        "'>" +
                        "Product Discount Result" +
                        "</h1>"
                );


                out.println(
                        "<div style='" +
                        "margin-top:30px;" +
                        "padding:22px;" +
                        "background:#f8fafc;" +
                        "border-radius:10px;" +
                        "'>"
                );


                out.println(
                        "<p>" +
                        "<strong>Product Description:</strong> " +
                        productDescription +
                        "</p>"
                );


                out.println(
                        "<p>" +
                        "<strong>List Price:</strong> " +
                        moneyFormat.format(listPrice) +
                        "</p>"
                );


                out.println(
                        "<p>" +
                        "<strong>Discount Percent:</strong> " +
                        discountPercent +
                        "%" +
                        "</p>"
                );


                out.println(
                        "<p style='" +
                        "color:#dc2626;" +
                        "font-size:18px;" +
                        "'>" +
                        "<strong>Discount Amount:</strong> " +
                        moneyFormat.format(discountAmount) +
                        "</p>"
                );


                out.println(
                        "<p style='" +
                        "color:#16a34a;" +
                        "font-size:22px;" +
                        "'>" +
                        "<strong>Discount Price:</strong> " +
                        moneyFormat.format(discountPrice) +
                        "</p>"
                );


                out.println("</div>");


                out.println(
                        "<p style='" +
                        "margin-top:20px;" +
                        "color:#64748b;" +
                        "text-align:center;" +
                        "'>" +
                        "Discount Amount = List Price × Discount Percent × 0.01" +
                        "</p>"
                );


                out.println(
                        "<div style='text-align:center;'>"
                );


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


                out.println("</div>");

                out.println("</main>");

                out.println("</body>");

                out.println("</html>");

            } catch (NumberFormatException exception) {

                out.println("<!DOCTYPE html>");

                out.println("<html lang='en'>");

                out.println("<head>");

                out.println(
                        "<meta charset='UTF-8'>"
                );

                out.println(
                        "<title>Invalid Data</title>"
                );

                out.println("</head>");


                out.println(
                        "<body style='" +
                        "font-family:Arial,sans-serif;" +
                        "text-align:center;" +
                        "margin-top:100px;" +
                        "'>"
                );


                out.println(
                        "<h1 style='color:red;'>" +
                        "Invalid price or discount percent!" +
                        "</h1>"
                );


                out.println(
                        "<p>Please enter valid numeric values.</p>"
                );


                out.println(
                        "<a href='index.jsp'>" +
                        "Go back" +
                        "</a>"
                );


                out.println("</body>");

                out.println("</html>");
            }
        }
    }
}
