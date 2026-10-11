package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ProductService gia lap database bang Map.
 */
public class ProductServiceImpl
        implements ProductService {

    private static final Map<Integer, Product> products =
            new LinkedHashMap<>();


    static {

        products.put(
                1,
                new Product(
                        1,
                        "Laptop Dell Inspiron",
                        850.0,
                        "Laptop hoc tap va van phong",
                        "Dell"
                )
        );


        products.put(
                2,
                new Product(
                        2,
                        "iPhone 15",
                        999.0,
                        "Dien thoai thong minh",
                        "Apple"
                )
        );


        products.put(
                3,
                new Product(
                        3,
                        "Galaxy S24",
                        899.0,
                        "Dien thoai Android cao cap",
                        "Samsung"
                )
        );


        products.put(
                4,
                new Product(
                        4,
                        "ThinkPad E14",
                        920.0,
                        "Laptop doanh nghiep",
                        "Lenovo"
                )
        );


        products.put(
                5,
                new Product(
                        5,
                        "AirPods Pro",
                        249.0,
                        "Tai nghe khong day",
                        "Apple"
                )
        );
    }


    @Override
    public List<Product> findAll() {

        return new ArrayList<>(
                products.values()
        );
    }


    @Override
    public void save(Product product) {

        products.put(
                product.getId(),
                product
        );
    }


    @Override
    public Product findById(int id) {

        return products.get(id);
    }


    @Override
    public void update(
            int id,
            Product product
    ) {

        products.put(
                id,
                product
        );
    }


    @Override
    public void remove(int id) {

        products.remove(id);
    }


    @Override
    public List<Product> searchByName(
            String keyword
    ) {

        List<Product> result =
                new ArrayList<>();


        if (keyword == null) {

            return result;
        }


        String normalizedKeyword =
                keyword
                        .trim()
                        .toLowerCase();


        for (Product product : products.values()) {

            if (
                    product
                            .getName()
                            .toLowerCase()
                            .contains(normalizedKeyword)
            ) {

                result.add(product);
            }
        }


        return result;
    }
}