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

                
                case "test-use-tran":

                    testUseTran(
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
                + "Ã„ÂÃƒÂ£ chÃ¡ÂºÂ¡y test khÃƒÂ´ng sÃ¡Â»Â­ dÃ¡Â»Â¥ng Transaction"
                + "</h1>"
                + "<p>Hai INSERT Ã„â€˜Ã†Â°Ã¡Â»Â£c thÃ¡Â»Â±c thi trÃ†Â°Ã¡Â»â€ºc khi UPDATE bÃ¡Â»â€¹ lÃ¡Â»â€”i.</p>"
                + "<p>HÃƒÂ£y kiÃ¡Â»Æ’m tra Console Tomcat vÃƒÂ  chÃ¡ÂºÂ¡y:</p>"
                + "<pre>SELECT * FROM Employee;</pre>"
                + "<p>KÃ¡ÂºÂ¿t quÃ¡ÂºÂ£ mong Ã„â€˜Ã¡Â»Â£i:</p>"
                + "<ul>"
                + "<li>Quynh - salary 10</li>"
                + "<li>Ngan - salary 20</li>"
                + "</ul>"
                + "<p>Quynh khÃƒÂ´ng Ã„â€˜Ã†Â°Ã¡Â»Â£c cÃ¡ÂºÂ­p nhÃ¡ÂºÂ­t lÃƒÂªn 999.99.</p>"
                + "<a href='"
                + request.getContextPath()
                + "/users'>Quay lÃ¡ÂºÂ¡i User Management</a>"
                + "</div>"
                + "</body>"
                + "</html>"
        );
    }

    
    // =======================================================
    // TEST JDBC TRANSACTION
    // =======================================================

    private void testUseTran(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws SQLException,
            IOException {

        userDAO.insertUpdateUseTransaction();


        System.out.println(
                "Hoan tat goi testUseTran."
        );


        response.setContentType(
                "text/html;charset=UTF-8"
        );


        response.getWriter().println(
                "<!DOCTYPE html>"
                + "<html lang='vi'>"
                + "<head>"
                + "<meta charset='UTF-8'>"
                + "<title>JDBC Transaction Test</title>"
                + "</head>"
                + "<body style='"
                + "font-family:Arial;"
                + "padding:40px;"
                + "background:#f8fafc;"
                + "'>"
                + "<main style='"
                + "max-width:750px;"
                + "margin:auto;"
                + "background:white;"
                + "padding:35px;"
                + "border-radius:12px;"
                + "box-shadow:0 8px 30px rgba(15,23,42,.1);"
                + "'>"
                + "<h1 style='color:#1b2a7a;'>"
                + "JDBC Transaction Test"
                + "</h1>"
                + "<p>ÄÃ£ thá»±c thi ká»‹ch báº£n INSERT + INSERT + UPDATE.</p>"
                + "<p>HÃ£y kiá»ƒm tra Console Tomcat vÃ  MySQL.</p>"
                + "<pre>"
                + "USE demo;\n"
                + "SELECT * FROM Employee;"
                + "</pre>"
                + "<p><strong>Láº§n 1:</strong> "
                + "UPDATE Ä‘ang cá»‘ tÃ¬nh lá»—i nÃªn báº£ng Employee pháº£i rá»—ng.</p>"
                + "<p><strong>Láº§n 2:</strong> "
                + "sá»­a parameter index thÃ nh 1, "
                + "báº£ng sáº½ cÃ³ Quynh=999.99 vÃ  Ngan=20.</p>"
                + "<a href='"
                + request.getContextPath()
                + "/users'>Quay láº¡i User Management</a>"
                + "</main>"
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
                userDAO.selectAllUsersStore();


        request.setAttribute(
                "listUser",
                listUser
        );


        request.setAttribute(
                "pageTitle",
                "Danh sÃƒÆ’Ã‚Â¡ch tÃƒÂ¡Ã‚ÂºÃ‚Â¥t cÃƒÂ¡Ã‚ÂºÃ‚Â£ User"
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
                "KÃƒÂ¡Ã‚ÂºÃ‚Â¿t quÃƒÂ¡Ã‚ÂºÃ‚Â£ tÃƒÆ’Ã‚Â¬m kiÃƒÂ¡Ã‚ÂºÃ‚Â¿m theo country"
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
                "Danh sÃƒÆ’Ã‚Â¡ch sÃƒÂ¡Ã‚ÂºÃ‚Â¯p xÃƒÂ¡Ã‚ÂºÃ‚Â¿p Name A-Z"
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
                userDAO.getUserById(id);


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


        userDAO.updateUserStore(
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


        userDAO.deleteUserStore(id);


        response.sendRedirect(
                request.getContextPath()
                + "/users"
        );
    }
}