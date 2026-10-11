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
                "Danh sách tất cả User"
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
                "Kết quả tìm kiếm theo country"
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
                "Danh sách sắp xếp Name A-Z"
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