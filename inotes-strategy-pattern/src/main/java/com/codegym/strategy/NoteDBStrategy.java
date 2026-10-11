package com.codegym.strategy;

import com.codegym.model.Note;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * Strategy luu Note vao MySQL.
 */
public class NoteDBStrategy
        implements NoteStrategy {

    private static final String JDBC_URL =
            "jdbc:mysql://localhost:3306/inotes_db"
            + "?useSSL=false"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=UTC"
            + "&characterEncoding=UTF-8";


    /*
     * Co the cau hinh bang Environment Variable:
     *
     * INOTES_DB_USER
     * INOTES_DB_PASSWORD
     *
     * Neu khong co:
     *
     * user = root
     * password = password
     */

    private final String username =
            System.getenv()
                    .getOrDefault(
                            "INOTES_DB_USER",
                            "root"
                    );


    private final String password =
            System.getenv()
                    .getOrDefault(
                            "INOTES_DB_PASSWORD",
                            "password"
                    );


    private Connection getConnection()
            throws SQLException {

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver"
            );

        } catch (ClassNotFoundException exception) {

            throw new SQLException(
                    "Khong tim thay MySQL Driver.",
                    exception
            );
        }


        return DriverManager.getConnection(
                JDBC_URL,
                username,
                password
        );
    }


    @Override
    public void save(Note note)
            throws Exception {

        if (note.getId() <= 0) {

            insert(note);

            return;
        }


        update(note);
    }


    private void insert(Note note)
            throws SQLException {

        String sql =
                "INSERT INTO notes "
                + "(title, content, type_id) "
                + "VALUES (?, ?, ?)";


        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        )
        ) {

            statement.setString(
                    1,
                    note.getTitle()
            );

            statement.setString(
                    2,
                    note.getContent()
            );

            statement.setInt(
                    3,
                    note.getTypeId()
            );


            statement.executeUpdate();


            try (
                    ResultSet keys =
                            statement.getGeneratedKeys()
            ) {

                if (keys.next()) {

                    note.setId(
                            keys.getInt(1)
                    );
                }
            }
        }
    }


    private void update(Note note)
            throws SQLException {

        String sql =
                "UPDATE notes "
                + "SET title = ?, "
                + "content = ?, "
                + "type_id = ? "
                + "WHERE id = ?";


        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                sql
                        )
        ) {

            statement.setString(
                    1,
                    note.getTitle()
            );

            statement.setString(
                    2,
                    note.getContent()
            );

            statement.setInt(
                    3,
                    note.getTypeId()
            );

            statement.setInt(
                    4,
                    note.getId()
            );


            statement.executeUpdate();
        }
    }


    @Override
    public void delete(int id)
            throws Exception {

        String sql =
                "DELETE FROM notes "
                + "WHERE id = ?";


        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                sql
                        )
        ) {

            statement.setInt(
                    1,
                    id
            );


            statement.executeUpdate();
        }
    }


    @Override
    public List<Note> findAll()
            throws Exception {

        String sql =
                "SELECT "
                + "n.id, "
                + "n.title, "
                + "n.content, "
                + "n.type_id, "
                + "t.name AS type_name "
                + "FROM notes n "
                + "JOIN note_type t "
                + "ON n.type_id = t.id "
                + "ORDER BY n.id DESC";


        List<Note> notes =
                new ArrayList<>();


        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                sql
                        );

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            while (resultSet.next()) {

                notes.add(
                        mapNote(
                                resultSet
                        )
                );
            }
        }


        return notes;
    }


    @Override
    public List<Note> search(
            String keyword
    ) throws Exception {

        String sql =
                "SELECT "
                + "n.id, "
                + "n.title, "
                + "n.content, "
                + "n.type_id, "
                + "t.name AS type_name "
                + "FROM notes n "
                + "JOIN note_type t "
                + "ON n.type_id = t.id "
                + "WHERE LOWER(n.title) LIKE ? "
                + "OR LOWER(n.content) LIKE ? "
                + "ORDER BY n.id DESC";


        List<Note> notes =
                new ArrayList<>();


        String searchValue =
                "%"
                + keyword
                        .trim()
                        .toLowerCase()
                + "%";


        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                sql
                        )
        ) {

            statement.setString(
                    1,
                    searchValue
            );

            statement.setString(
                    2,
                    searchValue
            );


            try (
                    ResultSet resultSet =
                            statement.executeQuery()
            ) {

                while (resultSet.next()) {

                    notes.add(
                            mapNote(
                                    resultSet
                            )
                    );
                }
            }
        }


        return notes;
    }


    private Note mapNote(
            ResultSet resultSet
    ) throws SQLException {

        return new Note(
                resultSet.getInt(
                        "id"
                ),
                resultSet.getString(
                        "title"
                ),
                resultSet.getString(
                        "content"
                ),
                resultSet.getInt(
                        "type_id"
                ),
                resultSet.getString(
                        "type_name"
                )
        );
    }
}