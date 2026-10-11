package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

/**
 * Dinh nghia cac thao tac quan ly Product.
 */
public interface ProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(
            int id,
            Product product
    );

    void remove(int id);

    List<Product> searchByName(
            String keyword
    );
}