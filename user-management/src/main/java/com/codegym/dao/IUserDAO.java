package com.codegym.dao;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * DAO Interface cho User.
 *
 * Bao gom:
 * - CRUD
 * - Search Country
 * - Sort Name
 * - Stored Procedures
 */
public interface IUserDAO {

    void insertUser(User user)
            throws SQLException;

    User selectUser(int id)
            throws SQLException;

    List<User> selectAllUsers()
            throws SQLException;

    boolean deleteUser(int id)
            throws SQLException;

    boolean updateUser(User user)
            throws SQLException;

    List<User> searchByCountry(
            String country
    ) throws SQLException;

    List<User> sortByName()
            throws SQLException;


    /**
     * Goi Stored Procedure:
     *
     * get_user_by_id
     */
    User getUserById(int id);


    /**
     * Goi Stored Procedure:
     *
     * insert_user
     */
    void insertUserStore(User user)
            throws SQLException;
}