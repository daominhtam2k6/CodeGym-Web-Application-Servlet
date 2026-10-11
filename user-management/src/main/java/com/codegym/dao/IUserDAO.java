package com.codegym.dao;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Khai bao cac thao tac CRUD,
 * tim kiem va sap xep User.
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

    /**
     * Tim kiem User theo country.
     *
     * @param country tu khoa country
     * @return danh sach User phu hop
     */
    List<User> searchByCountry(
            String country
    ) throws SQLException;

    /**
     * Lay danh sach User duoc sap xep
     * theo name tang dan A-Z.
     *
     * @return danh sach da sap xep
     */
    List<User> sortByName()
            throws SQLException;
}