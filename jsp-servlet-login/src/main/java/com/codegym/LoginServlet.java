package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Xu ly request POST tu form dang nhap.
 *
 * Endpoint:
 * /login
 */
@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType(
                "text/html;charset=UTF-8"
        );


        String user =
                request.getParameter("username");

        String pass =
                request.getParameter("password");


        boolean loginSuccess =
                "admin".equals(user)
                && "admin".equals(pass);


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
                    "<title>Login Result</title>"
            );

            out.println("</head>");


            out.println(
                    "<body style='" +
                    "margin:0;" +
                    "min-height:100vh;" +
                    "display:flex;" +
                    "align-items:center;" +
                    "justify-content:center;" +
                    "background:#f8fafc;" +
                    "font-family:Arial,sans-serif;" +
                    "'>"
            );


            out.println(
                    "<main style='" +
                    "width:min(500px,90%);" +
                    "padding:40px;" +
                    "background:white;" +
                    "border-radius:12px;" +
                    "box-shadow:0 10px 35px rgba(0,0,0,0.10);" +
                    "text-align:center;" +
                    "'>"
            );


            if (loginSuccess) {

                out.println(
                        "<div style='" +
                        "font-size:60px;" +
                        "margin-bottom:15px;" +
                        "color:#16a34a;" +
                        "'>" +
                        "&#10003;" +
                        "</div>"
                );

                out.println(
                        "<h1 style='" +
                        "color:green;" +
                        "'>" +
                        "Welcome admin to website" +
                        "</h1>"
                );

                out.println(
                        "<p style='" +
                        "color:#64748b;" +
                        "'>" +
                        "Login successfully." +
                        "</p>"
                );
            }


            if (!loginSuccess) {

                out.println(
                        "<div style='" +
                        "font-size:60px;" +
                        "margin-bottom:15px;" +
                        "color:#dc2626;" +
                        "'>" +
                        "&#10007;" +
                        "</div>"
                );

                out.println(
                        "<h1 style='" +
                        "color:red;" +
                        "'>" +
                        "Login Error" +
                        "</h1>"
                );

                out.println(
                        "<p style='" +
                        "color:#64748b;" +
                        "'>" +
                        "Username or password is incorrect." +
                        "</p>"
                );
            }


            out.println(
                    "<a href='index.jsp' style='" +
                    "display:inline-block;" +
                    "margin-top:20px;" +
                    "padding:11px 20px;" +
                    "border-radius:6px;" +
                    "background:#1b2a7a;" +
                    "color:white;" +
                    "text-decoration:none;" +
                    "'>" +
                    "Go back" +
                    "</a>"
            );


            out.println("</main>");

            out.println("</body>");

            out.println("</html>");
        }
    }
}

