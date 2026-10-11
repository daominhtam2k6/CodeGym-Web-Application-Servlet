package com.codegym.dao;

import com.codegym.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO truy cap MySQL bang JDBC.
 *
 * PreparedStatement:
 * - CRUD cu
 * - Search Country
 * - Sort Name
 *
 * CallableStatement:
 * - get_user_by_id
 * - insert_user
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


    private static final String SEARCH_BY_COUNTRY_SQL =
            "SELECT id, name, email, country "
            + "FROM users "
            + "WHERE country LIKE ? "
            + "ORDER BY id";


    private static final String SORT_BY_NAME_SQL =
            "SELECT id, name, email, country "
            + "FROM users "
            + "ORDER BY name ASC";


    /*
     * Stored Procedure:
     *
     * get_user_by_id(IN user_id INT)
     */
    private static final String CALL_GET_USER_BY_ID =
            "{CALL get_user_by_id(?)}";


    /*
     * Stored Procedure:
     *
     * insert_user(
     *     IN user_name,
     *     IN user_email,
     *     IN user_country
     * )
     */
    private static final String CALL_INSERT_USER =
            "{CALL insert_user(?, ?, ?)}";


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


    // =======================================================
    // CRUD CU - PREPAREDSTATEMENT
    // =======================================================

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


    // =======================================================
    // SEARCH COUNTRY
    // =======================================================

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


    // =======================================================
    // SORT NAME
    // =======================================================

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


    // =======================================================
    // STORED PROCEDURE:
    // get_user_by_id
    // =======================================================

    @Override
    public User getUserById(int id) {

        User user = null;


        try (
                Connection connection =
                        getConnection();

                CallableStatement callableStatement =
                        connection.prepareCall(
                                CALL_GET_USER_BY_ID
                        )
        ) {

            /*
             * Tham so thu 1 tuong ung:
             *
             * IN user_id INT
             */
            callableStatement.setInt(
                    1,
                    id
            );


            try (
                    ResultSet resultSet =
                            callableStatement.executeQuery()
            ) {

                if (resultSet.next()) {

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


                    user =
                            new User(
                                    id,
                                    name,
                                    email,
                                    country
                            );
                }
            }

        } catch (SQLException exception) {

            exception.printStackTrace();
        }


        return user;
    }


    // =======================================================
    // STORED PROCEDURE:
    // insert_user
    // =======================================================

    @Override
    public void insertUserStore(User user)
            throws SQLException {

        try (
                Connection connection =
                        getConnection();

                CallableStatement callableStatement =
                        connection.prepareCall(
                                CALL_INSERT_USER
                        )
        ) {

            /*
             * Thu tu parameter phai trung voi:
             *
             * insert_user(
             *     user_name,
             *     user_email,
             *     user_country
             * )
             */

            callableStatement.setString(
                    1,
                    user.getName()
            );

            callableStatement.setString(
                    2,
                    user.getEmail()
            );

            callableStatement.setString(
                    3,
                    user.getCountry()
            );


            callableStatement.executeUpdate();
        }
    }


    // =======================================================
    // RESULTSET -> USER
    // =======================================================

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