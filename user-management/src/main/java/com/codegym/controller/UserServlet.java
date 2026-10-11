package com.codegym.controller;

import com.codegym.dao.UserDAO;
import com.codegym.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Controller cho User Management.
 *
 * Ho tro:
 * - CRUD
 * - Search Country
 * - Sort Name
 * - Stored Procedure
 * - JDBC Transaction
 */
@WebServlet(
        name = "UserServlet",
        urlPatterns = {"/users"}
)
public class UserServlet extends HttpServlet {

    private UserDAO userDAO;


    @Override
    public void init() {

        userDAO =
                new UserDAO();
    }


    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding(
                "UTF-8"
        );


        String action =
                request.getParameter(
                        "action"
                );


        if (action == null) {

            action = "";
        }


        try {

            switch (action) {

                case "create":

                    showNewForm(
                            request,
                            response
                    );

                    break;


                case "edit":

                    showEditForm(
                            request,
                            response
                    );

                    break;


                case "delete":

                    showDeleteForm(
                            request,
                            response
                    );

                    break;


                case "search":

                    searchByCountry(
                            request,
                            response
                    );

                    break;


                case "sort":

                    sortByName(
                            request,
                            response
                    );

                    break;


                
                case "test-without-tran":

                    testWithoutTran(
                            request,
                            response
                    );

                    break;

                default:

                    listUsers(
                            request,
                            response
                    );

                    break;
            }

        } catch (SQLException exception) {

            throw new ServletException(
                    "Database error",
                    exception
            );
        }
    }


    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding(
                "UTF-8"
        );


        String action =
                request.getParameter(
                        "action"
                );


        if (action == null) {

            action = "";
        }


        try {

            switch (action) {

                case "create":

                    insertUser(
                            request,
                            response
                    );

                    break;


                case "edit":

                    updateUser(
                            request,
                            response
                    );

                    break;


                case "delete":

                    deleteUser(
                            request,
                            response
                    );

                    break;


                default:

                    response.sendRedirect(
                            request.getContextPath()
                            + "/users"
                    );

                    break;
            }

        } catch (SQLException exception) {

            throw new ServletException(
                    "Database transaction error",
                    exception
            );
        }
    }


    // =======================================================
    // LIST
    // =======================================================

    
    // =======================================================
    // TEST SQL KHONG SU DUNG TRANSACTION
    // =======================================================

    private void testWithoutTran(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        userDAO.insertUpdateWithoutTransaction();


        System.out.println(
                "Da chay xong testWithoutTran. "
                + "Hay kiem tra bang Employee trong MySQL."
        );


        response.setContentType(
                "text/html;charset=UTF-8"
        );


        response.getWriter().println(
                "<!DOCTYPE html>"
                + "<html lang='vi'>"
                + "<head>"
                + "<meta charset='UTF-8'>"
                + "<title>Test Without Transaction</title>"
                + "</head>"
                + "<body style='font-family:Arial;"
                + "padding:40px;"
                + "background:#f8fafc;'>"
                + "<div style='max-width:700px;"
                + "margin:auto;"
                + "background:white;"
                + "padding:30px;"
                + "border-radius:12px;'>"
                + "<h1 style='color:#1b2a7a;'>"
                + "Đã chạy test không sử dụng Transaction"
                + "</h1>"
                + "<p>Hai INSERT được thực thi trước khi UPDATE bị lỗi.</p>"
                + "<p>Hãy kiểm tra Console Tomcat và chạy:</p>"
                + "<pre>SELECT * FROM Employee;</pre>"
                + "<p>Kết quả mong đợi:</p>"
                + "<ul>"
                + "<li>Quynh - salary 10</li>"
                + "<li>Ngan - salary 20</li>"
                + "</ul>"
                + "<p>Quynh không được cập nhật lên 999.99.</p>"
                + "<a href='"
                + request.getContextPath()
                + "/users'>Quay lại User Management</a>"
                + "</div>"
                + "</body>"
                + "</html>"
        );
    }

    private void listUsers(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws SQLException,
            ServletException,
            IOException {

        List<User> listUser =
                userDAO.selectAllUsers();


        request.setAttribute(
                "listUser",
                listUser
        );


        request.setAttribute(
                "pageTitle",
                "Danh sÃ¡ch táº¥t cáº£ User"
        );


        forwardToList(
                request,
                response
        );
    }


    // =======================================================
    // SEARCH COUNTRY
    // =======================================================

    private void searchByCountry(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws SQLException,
            ServletException,
            IOException {

        String country =
                request.getParameter(
                        "country"
                );


        if (
                country == null
                || country.trim().isEmpty()
        ) {

            listUsers(
                    request,
                    response
            );

            return;
        }


        List<User> listUser =
                userDAO.searchByCountry(
                        country
                );


        request.setAttribute(
                "listUser",
                listUser
        );


        request.setAttribute(
                "countryKeyword",
                country
        );


        request.setAttribute(
                "pageTitle",
                "Káº¿t quáº£ tÃ¬m kiáº¿m theo country"
        );


        forwardToList(
                request,
                response
        );
    }


    // =======================================================
    // SORT NAME
    // =======================================================

    private void sortByName(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws SQLException,
            ServletException,
            IOException {

        List<User> listUser =
                userDAO.sortByName();


        request.setAttribute(
                "listUser",
                listUser
        );


        request.setAttribute(
                "sortedByName",
                true
        );


        request.setAttribute(
                "pageTitle",
                "Danh sÃ¡ch sáº¯p xáº¿p Name A-Z"
        );


        forwardToList(
                request,
                response
        );
    }


    private void forwardToList(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException,
            IOException {

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/user/list.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    // =======================================================
    // CREATE FORM
    // =======================================================

    private void showNewForm(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException,
            IOException {

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/user/create.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    // =======================================================
    // EDIT FORM
    //
    // Van dung Stored Procedure cua bai truoc.
    // =======================================================

    private void showEditForm(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws SQLException,
            ServletException,
            IOException {

        int id;


        try {

            id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"
                            )
                    );

        } catch (NumberFormatException exception) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/users"
            );

            return;
        }


        User existingUser =
                userDAO.getUserById(id);


        if (existingUser == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/users"
            );

            return;
        }


        request.setAttribute(
                "user",
                existingUser
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/user/edit.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    // =======================================================
    // DELETE FORM
    // =======================================================

    private void showDeleteForm(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws SQLException,
            ServletException,
            IOException {

        int id;


        try {

            id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"
                            )
                    );

        } catch (NumberFormatException exception) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/users"
            );

            return;
        }


        User user =
                userDAO.selectUser(id);


        if (user == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/users"
            );

            return;
        }


        request.setAttribute(
                "user",
                user
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/user/delete.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    // =======================================================
    // CREATE USER BANG JDBC TRANSACTION
    // =======================================================

    private void insertUser(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws SQLException,
            IOException {

        String name =
                request.getParameter(
                        "name"
                );


        String email =
                request.getParameter(
                        "email"
                );


        String country =
                request.getParameter(
                        "country"
                );


        // ===============================================
        // NHAN NHIEU CHECKBOX:
        //
        // permissions=1
        // permissions=4
        //
        // ->
        //
        // String[] {"1", "4"}
        // ===============================================

        String[] permissionsString =
                request.getParameterValues(
                        "permissions"
                );


        int[] permissions =
                null;


        if (permissionsString != null) {

            permissions =
                    new int[
                            permissionsString.length
                    ];


            for (
                    int i = 0;
                    i < permissionsString.length;
                    i++
            ) {

                permissions[i] =
                        Integer.parseInt(
                                permissionsString[i]
                        );
            }
        }


        User newUser =
                new User(
                        name,
                        email,
                        country
                );


        // ===============================================
        // TRANSACTION:
        //
        // INSERT users
        // +
        // INSERT user_permission
        //
        // commit / rollback
        // ===============================================

        userDAO.addUserTransaction(
                newUser,
                permissions
        );


        // ===============================================
        // PRG:
        //
        // POST -> REDIRECT -> GET
        // ===============================================

        response.sendRedirect(
                request.getContextPath()
                + "/users"
        );
    }


    // =======================================================
    // UPDATE USER
    // =======================================================

    private void updateUser(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws SQLException,
            IOException {

        int id =
                Integer.parseInt(
                        request.getParameter(
                                "id"
                        )
                );


        String name =
                request.getParameter(
                        "name"
                );


        String email =
                request.getParameter(
                        "email"
                );


        String country =
                request.getParameter(
                        "country"
                );


        User user =
                new User(
                        id,
                        name,
                        email,
                        country
                );


        userDAO.updateUser(
                user
        );


        response.sendRedirect(
                request.getContextPath()
                + "/users"
        );
    }


    // =======================================================
    // DELETE USER
    // =======================================================

    private void deleteUser(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws SQLException,
            IOException {

        int id =
                Integer.parseInt(
                        request.getParameter(
                                "id"
                        )
                );


        userDAO.deleteUser(id);


        response.sendRedirect(
                request.getContextPath()
                + "/users"
        );
    }
}