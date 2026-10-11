package com.codegym.dao;

import com.codegym.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 * Trien khai CRUD, Search va Sort
 * bang JDBC + MySQL.
 *
 * LUU Y:
 * Kiem tra jdbcUsername va jdbcPassword
 * cho dung voi MySQL tren may.
 */
public class UserDAO implements IUserDAO {

    private final String jdbcURL =
            "jdbc:mysql://localhost:3306/demo"
            + "?useSSL=false"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=UTC"
            + "&characterEncoding=UTF-8";

    private final String jdbcUsername =
            "root";

    private final String jdbcPassword =
            "password";


    private static final String INSERT_USERS_SQL =
            "INSERT INTO users "
            + "(name, email, country) "
            + "VALUES (?, ?, ?)";


    private static final String SELECT_USER_BY_ID =
            "SELECT id, name, email, country "
            + "FROM users "
            + "WHERE id = ?";


    private static final String SELECT_ALL_USERS =
            "SELECT id, name, email, country "
            + "FROM users "
            + "ORDER BY id";


    private static final String DELETE_USERS_SQL =
            "DELETE FROM users "
            + "WHERE id = ?";


    private static final String UPDATE_USERS_SQL =
            "UPDATE users "
            + "SET name = ?, email = ?, country = ? "
            + "WHERE id = ?";


    /*
     * Tim country bang LIKE.
     *
     * Vi dung PreparedStatement nen
     * tranh noi truc tiep input vao SQL.
     */
    private static final String SEARCH_BY_COUNTRY_SQL =
            "SELECT id, name, email, country "
            + "FROM users "
            + "WHERE country LIKE ? "
            + "ORDER BY id";


    /*
     * Sap xep name tang dan A-Z.
     */
    private static final String SORT_BY_NAME_SQL =
            "SELECT id, name, email, country "
            + "FROM users "
            + "ORDER BY name ASC";


    public UserDAO() {
    }


    protected Connection getConnection()
            throws SQLException {

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver"
            );

        } catch (ClassNotFoundException exception) {

            throw new SQLException(
                    "MySQL JDBC Driver not found.",
                    exception
            );
        }


        return DriverManager.getConnection(
                jdbcURL,
                jdbcUsername,
                jdbcPassword
        );
    }


    @Override
    public void insertUser(User user)
            throws SQLException {

        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                INSERT_USERS_SQL
                        )
        ) {

            statement.setString(
                    1,
                    user.getName()
            );

            statement.setString(
                    2,
                    user.getEmail()
            );

            statement.setString(
                    3,
                    user.getCountry()
            );

            statement.executeUpdate();
        }
    }


    @Override
    public User selectUser(int id)
            throws SQLException {

        User user = null;


        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                SELECT_USER_BY_ID
                        )
        ) {

            statement.setInt(
                    1,
                    id
            );


            try (
                    ResultSet resultSet =
                            statement.executeQuery()
            ) {

                if (resultSet.next()) {

                    user =
                            mapUser(
                                    resultSet
                            );
                }
            }
        }


        return user;
    }


    @Override
    public List<User> selectAllUsers()
            throws SQLException {

        List<User> users =
                new ArrayList<>();


        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                SELECT_ALL_USERS
                        );

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            while (resultSet.next()) {

                users.add(
                        mapUser(
                                resultSet
                        )
                );
            }
        }


        return users;
    }


    @Override
    public boolean deleteUser(int id)
            throws SQLException {

        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                DELETE_USERS_SQL
                        )
        ) {

            statement.setInt(
                    1,
                    id
            );


            return statement.executeUpdate() > 0;
        }
    }


    @Override
    public boolean updateUser(User user)
            throws SQLException {

        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                UPDATE_USERS_SQL
                        )
        ) {

            statement.setString(
                    1,
                    user.getName()
            );

            statement.setString(
                    2,
                    user.getEmail()
            );

            statement.setString(
                    3,
                    user.getCountry()
            );

            statement.setInt(
                    4,
                    user.getId()
            );


            return statement.executeUpdate() > 0;
        }
    }


    @Override
    public List<User> searchByCountry(
            String country
    ) throws SQLException {

        List<User> users =
                new ArrayList<>();


        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                SEARCH_BY_COUNTRY_SQL
                        )
        ) {

            /*
             * Vi du:
             *
             * country = Viet
             *
             * SQL nhan:
             *
             * %Viet%
             *
             * => tim duoc Viet Nam.
             */
            statement.setString(
                    1,
                    "%"
                    + country.trim()
                    + "%"
            );


            try (
                    ResultSet resultSet =
                            statement.executeQuery()
            ) {

                while (resultSet.next()) {

                    users.add(
                            mapUser(
                                    resultSet
                            )
                    );
                }
            }
        }


        return users;
    }


    @Override
    public List<User> sortByName()
            throws SQLException {

        List<User> users =
                new ArrayList<>();


        try (
                Connection connection =
                        getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                SORT_BY_NAME_SQL
                        );

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            while (resultSet.next()) {

                users.add(
                        mapUser(
                                resultSet
                        )
                );
            }
        }


        return users;
    }


    /**
     * Chuyen mot dong ResultSet thanh User.
     */
    private User mapUser(
            ResultSet resultSet
    ) throws SQLException {

        int id =
                resultSet.getInt(
                        "id"
                );

        String name =
                resultSet.getString(
                        "name"
                );

        String email =
                resultSet.getString(
                        "email"
                );

        String country =
                resultSet.getString(
                        "country"
                );


        return new User(
                id,
                name,
                email,
                country
        );
    }
}