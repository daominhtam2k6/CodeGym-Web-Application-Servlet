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
 * Servlet xu ly chuyen doi USD sang VND.
 *
 * Formula:
 * VND = USD * Rate
 *
 * Endpoint:
 * /convert
 */
@WebServlet(
        name = "ConverterServlet",
        urlPatterns = {"/convert"}
)
public class ConverterServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType(
                "text/html;charset=UTF-8"
        );

        try (PrintWriter out = response.getWriter()) {

            try {

                float rate = Float.parseFloat(
                        request.getParameter("rate")
                );

                float usd = Float.parseFloat(
                        request.getParameter("usd")
                );

                float vnd = rate * usd;


                NumberFormat vndFormat =
                        NumberFormat.getNumberInstance(
                                new Locale("vi", "VN")
                        );

                NumberFormat usdFormat =
                        NumberFormat.getNumberInstance(
                                Locale.US
                        );


                out.println("<!DOCTYPE html>");

                out.println("<html lang='vi'>");

                out.println("<head>");

                out.println(
                        "<meta charset='UTF-8'>"
                );

                out.println(
                        "<meta name='viewport' " +
                        "content='width=device-width, initial-scale=1.0'>"
                );

                out.println(
                        "<title>Currency Converter Result</title>"
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
                        "box-shadow:0 12px 40px rgba(0,0,0,0.10);" +
                        "text-align:center;" +
                        "'>"
                );


                out.println(
                        "<div style='" +
                        "font-size:55px;" +
                        "color:#16a34a;" +
                        "margin-bottom:10px;" +
                        "'>" +
                        "&#36; &#8594; &#8363;" +
                        "</div>"
                );


                out.println(
                        "<h1 style='" +
                        "color:#1b2a7a;" +
                        "'>" +
                        "KẾT QUẢ CHUYỂN ĐỔI" +
                        "</h1>"
                );


                out.println(
                        "<div style='" +
                        "margin:25px 0;" +
                        "padding:20px;" +
                        "background:#f1f5f9;" +
                        "border-radius:10px;" +
                        "'>"
                );


                out.println(
                        "<p style='font-size:18px;'>" +
                        "Tỉ giá: " +
                        vndFormat.format(rate) +
                        " VND/USD" +
                        "</p>"
                );


                out.println(
                        "<p style='font-size:18px;'>" +
                        "Số tiền USD: $" +
                        usdFormat.format(usd) +
                        "</p>"
                );


                out.println(
                        "<h2 style='" +
                        "color:#16a34a;" +
                        "font-size:28px;" +
                        "'>" +
                        "Thành tiền VNĐ: " +
                        vndFormat.format(vnd) +
                        " VNĐ" +
                        "</h2>"
                );


                out.println("</div>");


                out.println(
                        "<p style='color:#64748b;'>" +
                        "Công thức: VND = USD × Rate" +
                        "</p>"
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
                        "Quay lại" +
                        "</a>"
                );


                out.println("</main>");

                out.println("</body>");

                out.println("</html>");

            } catch (NumberFormatException exception) {

                out.println("<!DOCTYPE html>");

                out.println("<html lang='vi'>");

                out.println("<head>");

                out.println(
                        "<meta charset='UTF-8'>"
                );

                out.println(
                        "<title>Lỗi dữ liệu</title>"
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
                        "Lỗi: Vui lòng nhập số hợp lệ!" +
                        "</h1>"
                );


                out.println(
                        "<a href='index.jsp'>" +
                        "Quay lại" +
                        "</a>"
                );


                out.println("</body>");

                out.println("</html>");
            }
        }
    }
}
