package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet tra cuu tu dien Anh - Viet.
 *
 * Endpoint:
 * /translate
 */
@WebServlet(
        name = "DictionaryServlet",
        urlPatterns = {"/translate"}
)
public class DictionaryServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType(
                "text/html;charset=UTF-8"
        );


        Map<String, String> dictionary =
                new HashMap<>();


        dictionary.put(
                "hello",
                "Xin chào"
        );

        dictionary.put(
                "how",
                "Thế nào"
        );

        dictionary.put(
                "book",
                "Quyển sách"
        );

        dictionary.put(
                "computer",
                "Máy tính"
        );

        dictionary.put(
                "student",
                "Sinh viên"
        );


        String searchWord =
                request.getParameter("word");


        try (PrintWriter out = response.getWriter()) {

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
                    "<title>Kết quả tra cứu</title>"
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


            if (
                    searchWord != null
                    && !searchWord.trim().isEmpty()
            ) {

                String normalizedWord =
                        searchWord
                                .trim()
                                .toLowerCase();


                String result =
                        dictionary.get(normalizedWord);


                if (result != null) {

                    out.println(
                            "<div style='" +
                            "font-size:55px;" +
                            "color:#16a34a;" +
                            "margin-bottom:12px;" +
                            "'>" +
                            "&#10003;" +
                            "</div>"
                    );


                    out.println(
                            "<h1 style='" +
                            "color:#1b2a7a;" +
                            "'>" +
                            "Kết quả tra cứu" +
                            "</h1>"
                    );


                    out.println(
                            "<p style='" +
                            "font-size:18px;" +
                            "color:#475569;" +
                            "'>" +
                            "Từ khóa: " +
                            "<strong>" +
                            searchWord +
                            "</strong>" +
                            "</p>"
                    );


                    out.println(
                            "<div style='" +
                            "margin:25px 0;" +
                            "padding:22px;" +
                            "border-radius:10px;" +
                            "background:#ecfdf5;" +
                            "'>"
                    );


                    out.println(
                            "<p style='" +
                            "margin-top:0;" +
                            "color:#64748b;" +
                            "'>" +
                            "Nghĩa tiếng Việt" +
                            "</p>"
                    );


                    out.println(
                            "<h2 style='" +
                            "margin-bottom:0;" +
                            "color:#16a34a;" +
                            "'>" +
                            result +
                            "</h2>"
                    );


                    out.println("</div>");
                }


                if (result == null) {

                    out.println(
                            "<div style='" +
                            "font-size:55px;" +
                            "color:#dc2626;" +
                            "margin-bottom:12px;" +
                            "'>" +
                            "&#10007;" +
                            "</div>"
                    );


                    out.println(
                            "<h1 style='" +
                            "color:#dc2626;" +
                            "'>" +
                            "Không tìm thấy từ: " +
                            searchWord +
                            "</h1>"
                    );


                    out.println(
                            "<p style='" +
                            "color:#64748b;" +
                            "'>" +
                            "Từ bạn nhập chưa có trong từ điển." +
                            "</p>"
                    );
                }
            }


            if (
                    searchWord == null
                    || searchWord.trim().isEmpty()
            ) {

                out.println(
                        "<h1 style='" +
                        "color:#f59e0b;" +
                        "'>" +
                        "Vui lòng nhập từ khóa hợp lệ!" +
                        "</h1>"
                );
            }


            out.println(
                    "<a href='index.jsp' style='" +
                    "display:inline-block;" +
                    "margin-top:20px;" +
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
        }
    }
}
