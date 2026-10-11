package com.codegym.controller;

import com.codegym.model.Note;
import com.codegym.model.NoteType;

import com.codegym.service.NoteManagement;

import com.codegym.strategy.NoteDBStrategy;
import com.codegym.strategy.NoteFileStrategy;
import com.codegym.strategy.NoteStrategy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;

/**
 * Controller cho iNotes.
 */
@WebServlet(
        name = "NoteServlet",
        urlPatterns = {"/notes"}
)
public class NoteServlet
        extends HttpServlet {

    private NoteStrategy dbStrategy;

    private NoteStrategy fileStrategy;


    @Override
    public void init()
            throws ServletException {

        try {

            dbStrategy =
                    new NoteDBStrategy();


            fileStrategy =
                    new NoteFileStrategy();


        } catch (Exception exception) {

            throw new ServletException(
                    "Khong khoi tao duoc Storage Strategy.",
                    exception
            );
        }
    }


    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException,
            IOException {

        request.setCharacterEncoding(
                "UTF-8"
        );


        String action =
                request.getParameter(
                        "action"
                );


        if (action == null) {

            action =
                    "list";
        }


        try {

            switch (action) {

                case "create":

                    showCreate(
                            request,
                            response
                    );

                    break;


                case "view":

                    showView(
                            request,
                            response
                    );

                    break;


                case "edit":

                    showEdit(
                            request,
                            response
                    );

                    break;


                case "delete":

                    showDelete(
                            request,
                            response
                    );

                    break;


                case "search":

                    search(
                            request,
                            response
                    );

                    break;


                default:

                    list(
                            request,
                            response
                    );

                    break;
            }


        } catch (Exception exception) {

            throw new ServletException(
                    "iNotes error",
                    exception
            );
        }
    }


    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException,
            IOException {

        request.setCharacterEncoding(
                "UTF-8"
        );


        String action =
                request.getParameter(
                        "action"
                );


        if (action == null) {

            action =
                    "";
        }


        try {

            switch (action) {

                case "create":

                    create(
                            request,
                            response
                    );

                    break;


                case "edit":

                    update(
                            request,
                            response
                    );

                    break;


                case "delete":

                    delete(
                            request,
                            response
                    );

                    break;


                default:

                    response.sendRedirect(
                            request.getContextPath()
                            + "/notes"
                    );

                    break;
            }


        } catch (Exception exception) {

            throw new ServletException(
                    "iNotes error",
                    exception
            );
        }
    }


    private void list(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {

        NoteManagement management =
                managementFor(
                        request
                );


        request.setAttribute(
                "notes",
                management.findAll()
        );


        prepareCommonAttributes(
                request
        );


        forward(
                request,
                response,
                "/WEB-INF/views/note/list.jsp"
        );
    }


    private void search(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {

        String keyword =
                request.getParameter(
                        "keyword"
                );


        NoteManagement management =
                managementFor(
                        request
                );


        request.setAttribute(
                "notes",
                management.searchNotes(
                        keyword
                )
        );


        request.setAttribute(
                "keyword",
                keyword
        );


        prepareCommonAttributes(
                request
        );


        forward(
                request,
                response,
                "/WEB-INF/views/note/list.jsp"
        );
    }


    private void showCreate(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {

        /*
         * Goi managementFor de cap nhat Storage
         * neu URL co ?storage=db/file.
         */
        managementFor(
                request
        );


        prepareCommonAttributes(
                request
        );


        forward(
                request,
                response,
                "/WEB-INF/views/note/create.jsp"
        );
    }


    private void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {

        String title =
                request.getParameter(
                        "title"
                );


        String content =
                request.getParameter(
                        "content"
                );


        int typeId =
                Integer.parseInt(
                        request.getParameter(
                                "typeId"
                        )
                );


        NoteManagement management =
                managementFor(
                        request
                );


        management.addNote(
                title,
                content,
                typeId
        );


        response.sendRedirect(
                request.getContextPath()
                + "/notes"
        );
    }


    private void showView(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {

        int id =
                parseId(
                        request
                );


        Note note =
                managementFor(
                        request
                ).findById(id);


        if (note == null) {

            response.sendError(
                    HttpServletResponse.SC_NOT_FOUND
            );

            return;
        }


        request.setAttribute(
                "note",
                note
        );


        prepareCommonAttributes(
                request
        );


        forward(
                request,
                response,
                "/WEB-INF/views/note/view.jsp"
        );
    }


    private void showEdit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {

        int id =
                parseId(
                        request
                );


        Note note =
                managementFor(
                        request
                ).findById(id);


        if (note == null) {

            response.sendError(
                    HttpServletResponse.SC_NOT_FOUND
            );

            return;
        }


        request.setAttribute(
                "note",
                note
        );


        prepareCommonAttributes(
                request
        );


        forward(
                request,
                response,
                "/WEB-INF/views/note/edit.jsp"
        );
    }


    private void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {

        int id =
                parseId(
                        request
                );


        String title =
                request.getParameter(
                        "title"
                );


        String content =
                request.getParameter(
                        "content"
                );


        int typeId =
                Integer.parseInt(
                        request.getParameter(
                                "typeId"
                        )
                );


        managementFor(
                request
        ).updateNote(
                id,
                title,
                content,
                typeId
        );


        response.sendRedirect(
                request.getContextPath()
                + "/notes"
        );
    }


    private void showDelete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {

        int id =
                parseId(
                        request
                );


        Note note =
                managementFor(
                        request
                ).findById(id);


        if (note == null) {

            response.sendError(
                    HttpServletResponse.SC_NOT_FOUND
            );

            return;
        }


        request.setAttribute(
                "note",
                note
        );


        prepareCommonAttributes(
                request
        );


        forward(
                request,
                response,
                "/WEB-INF/views/note/delete.jsp"
        );
    }


    private void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {

        int id =
                parseId(
                        request
                );


        managementFor(
                request
        ).deleteNote(
                id
        );


        response.sendRedirect(
                request.getContextPath()
                + "/notes"
        );
    }


    /**
     * Tao Context moi cho moi Request.
     *
     * Tranh chia se NoteManagement mutable strategy
     * giua nhieu HTTP request.
     */
    private NoteManagement managementFor(
            HttpServletRequest request
    ) {

        NoteStrategy strategy =
                resolveStrategy(
                        request
                );


        return new NoteManagement(
                strategy
        );
    }


    /**
     * Runtime Strategy Switching.
     *
     * ?storage=db
     *
     * hoac
     *
     * ?storage=file
     */
    private NoteStrategy resolveStrategy(
            HttpServletRequest request
    ) {

        HttpSession session =
                request.getSession();


        String storage =
                request.getParameter(
                        "storage"
                );


        if (
                "db".equals(storage)
                ||
                "file".equals(storage)
        ) {

            session.setAttribute(
                    "storage",
                    storage
            );
        }


        Object current =
                session.getAttribute(
                        "storage"
                );


        if (current == null) {

            session.setAttribute(
                    "storage",
                    "db"
            );


            current =
                    "db";
        }


        if (
                "file".equals(
                        current.toString()
                )
        ) {

            return fileStrategy;
        }


        return dbStrategy;
    }


    private void prepareCommonAttributes(
            HttpServletRequest request
    ) {

        request.setAttribute(
                "types",
                noteTypes()
        );


        Object storage =
                request.getSession()
                        .getAttribute(
                                "storage"
                        );


        request.setAttribute(
                "storage",
                storage
        );
    }


    private List<NoteType> noteTypes() {

        return Arrays.asList(

                new NoteType(
                        1,
                        "Cá nhân",
                        "Ghi chú cá nhân"
                ),

                new NoteType(
                        2,
                        "Công việc",
                        "Ghi chú công việc"
                ),

                new NoteType(
                        3,
                        "Học tập",
                        "Ghi chú học tập"
                )
        );
    }


    private int parseId(
            HttpServletRequest request
    ) {

        return Integer.parseInt(
                request.getParameter(
                        "id"
                )
        );
    }


    private void forward(
            HttpServletRequest request,
            HttpServletResponse response,
            String path
    ) throws ServletException,
            IOException {

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        path
                );


        dispatcher.forward(
                request,
                response
        );
    }
}