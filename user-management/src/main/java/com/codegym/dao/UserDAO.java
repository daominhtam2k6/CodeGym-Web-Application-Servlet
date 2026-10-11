package com.codegym.dao;

import com.codegym.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO User.
 *
 * Demo:
 * - PreparedStatement
 * - CallableStatement
 * - JDBC Transaction
 * - commit()
 * - rollback()
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


    // =======================================================
    // SQL CRUD
    // =======================================================

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


    // =======================================================
    // SEARCH / SORT
    // =======================================================

    private static final String SEARCH_BY_COUNTRY_SQL =
            "SELECT id, name, email, country "
            + "FROM users "
            + "WHERE country LIKE ? "
            + "ORDER BY id";


    private static final String SORT_BY_NAME_SQL =
            "SELECT id, name, email, country "
            + "FROM users "
            + "ORDER BY name ASC";


    // =======================================================
    // STORED PROCEDURE
    // =======================================================

    private static final String CALL_GET_USER_BY_ID =
            "{CALL get_user_by_id(?)}";


    private static final String CALL_INSERT_USER =
            "{CALL insert_user(?, ?, ?)}";


    // =======================================================
    // TRANSACTION SQL
    // =======================================================

    private static final String INSERT_USER_TRANSACTION_SQL =
            "INSERT INTO users "
            + "(name, email, country) "
            + "VALUES (?, ?, ?)";


    private static final String INSERT_USER_PERMISSION_SQL =
            "INSERT INTO user_permission "
            + "(user_id, permission_id) "
            + "VALUES (?, ?)";


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
    // INSERT CU
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


    // =======================================================
    // SELECT USER CU
    // =======================================================

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


    // =======================================================
    // SELECT ALL
    // =======================================================

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


    // =======================================================
    // DELETE
    // =======================================================

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


    // =======================================================
    // UPDATE
    // =======================================================

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
    //
    // Van giu lai de bao toan bai truoc.
    //
    // Luong CREATE hien tai se dung
    // addUserTransaction().
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
    // JDBC TRANSACTION
    //
    // 1. setAutoCommit(false)
    //
    // 2. INSERT users
    //
    // 3. Lay generated user ID
    //
    // 4. INSERT user_permission
    //
    // 5. commit()
    //
    // Neu loi:
    //
    // rollback()
    // =======================================================

    @Override
    public void addUserTransaction(
            User user,
            int[] permissionIds
    ) throws SQLException {

        Connection connection = null;


        try {

            connection =
                    getConnection();


            // ===============================================
            // BAT DAU TRANSACTION
            // ===============================================

            connection.setAutoCommit(
                    false
            );


            int userId;


            // ===============================================
            // INSERT USER
            // VA LAY GENERATED ID
            // ===============================================

            try (
                    PreparedStatement userStatement =
                            connection.prepareStatement(
                                    INSERT_USER_TRANSACTION_SQL,
                                    Statement.RETURN_GENERATED_KEYS
                            )
            ) {

                userStatement.setString(
                        1,
                        user.getName()
                );

                userStatement.setString(
                        2,
                        user.getEmail()
                );

                userStatement.setString(
                        3,
                        user.getCountry()
                );


                int affectedRows =
                        userStatement.executeUpdate();


                if (affectedRows != 1) {

                    throw new SQLException(
                            "Khong the them User."
                    );
                }


                try (
                        ResultSet generatedKeys =
                                userStatement.getGeneratedKeys()
                ) {


                    if (!generatedKeys.next()) {

                        throw new SQLException(
                                "Khong lay duoc ID User moi."
                        );
                    }


                    userId =
                            generatedKeys.getInt(1);
                }
            }


            // ===============================================
            // INSERT USER_PERMISSION
            // ===============================================

            if (
                    permissionIds != null
                    && permissionIds.length > 0
            ) {

                try (
                        PreparedStatement permissionStatement =
                                connection.prepareStatement(
                                        INSERT_USER_PERMISSION_SQL
                                )
                ) {

                    for (
                            int permissionId
                            : permissionIds
                    ) {

                        permissionStatement.setInt(
                                1,
                                userId
                        );

                        permissionStatement.setInt(
                                2,
                                permissionId
                        );


                        permissionStatement.addBatch();
                    }


                    permissionStatement.executeBatch();
                }
            }


            // ===============================================
            // TAT CA THANH CONG
            // ===============================================

            connection.commit();


            System.out.println(
                    "Transaction committed successfully."
            );

        } catch (SQLException exception) {


            // ===============================================
            // CO BAT KY LOI NAO -> ROLLBACK
            // ===============================================

            if (connection != null) {

                try {

                    connection.rollback();


                    System.out.println(
                            "Transaction rolled back."
                    );

                } catch (SQLException rollbackException) {

                    exception.addSuppressed(
                            rollbackException
                    );
                }
            }


            /*
             * Khong nuot loi.
             *
             * Nem lai exception de Servlet biet
             * transaction that bai.
             */
            throw exception;

        } finally {


            if (connection != null) {

                try {

                    connection.setAutoCommit(
                            true
                    );

                } catch (SQLException autoCommitException) {

                    autoCommitException.printStackTrace();
                }


                try {

                    connection.close();

                } catch (SQLException closeException) {

                    closeException.printStackTrace();
                }
            }
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