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
 * - Stored Procedure
 * - JDBC Transaction
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


    User getUserById(int id);


    void insertUserStore(User user)
            throws SQLException;


    /**
     * Them User va gan Permission
     * trong cung mot JDBC Transaction.
     *
     * Neu bat ky thao tac nao loi:
     *
     * rollback toan bo transaction.
     */
    void addUserTransaction(
            User user,
            int[] permissionIds
    ) throws SQLException;

    /**
     * Demo thuc thi nhieu SQL
     * KHONG su dung Transaction.
     *
     * Hai INSERT se thanh cong,
     * UPDATE sau do co tinh bi loi.
     */
    void insertUpdateWithoutTransaction()
            throws SQLException;

    /**
     * Demo nhieu cau SQL co su dung JDBC Transaction.
     *
     * Tat autoCommit.
     * Commit neu thanh cong.
     * Rollback neu co loi.
     */
    void insertUpdateUseTransaction()
            throws SQLException;
}