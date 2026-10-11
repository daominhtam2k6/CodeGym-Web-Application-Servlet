package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Controller dieu huong cac chuc nang quan ly Product.
 */
@WebServlet(
        name = "ProductServlet",
        urlPatterns = {"/products"}
)
public class ProductServlet extends HttpServlet {

    private final ProductService productService =
            new ProductServiceImpl();


    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action =
                request.getParameter("action");


        if (action == null) {

            action = "";
        }


        switch (action) {

            case "create":

                showCreateForm(
                        request,
                        response
                );

                break;


            case "edit":

                showEditForm(
                        request,
                        response
                );

                break;


            case "delete":

                showDeleteForm(
                        request,
                        response
                );

                break;


            case "view":

                viewProduct(
                        request,
                        response
                );

                break;


            case "search":

                searchProducts(
                        request,
                        response
                );

                break;


            default:

                listProducts(
                        request,
                        response
                );

                break;
        }
    }


    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


        String action =
                request.getParameter("action");


        if (action == null) {

            action = "";
        }


        switch (action) {

            case "create":

                createProduct(
                        request,
                        response
                );

                break;


            case "edit":

                updateProduct(
                        request,
                        response
                );

                break;


            case "delete":

                deleteProduct(
                        request,
                        response
                );

                break;


            default:

                response.sendRedirect(
                        request.getContextPath()
                        + "/products"
                );

                break;
        }
    }


    private void listProducts(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        List<Product> products =
                productService.findAll();


        request.setAttribute(
                "products",
                products
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/product/list.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    private void searchProducts(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String keyword =
                request.getParameter("keyword");


        List<Product> products;


        if (
                keyword == null
                || keyword.trim().isEmpty()
        ) {

            products =
                    productService.findAll();
        }
        else {

            products =
                    productService.searchByName(
                            keyword
                    );
        }


        request.setAttribute(
                "products",
                products
        );


        request.setAttribute(
                "keyword",
                keyword
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/product/list.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    private void showCreateForm(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/product/create.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    private void createProduct(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String name =
                request.getParameter("name");


        String description =
                request.getParameter(
                        "description"
                );


        String manufacturer =
                request.getParameter(
                        "manufacturer"
                );


        double price;


        try {

            price =
                    Double.parseDouble(
                            request.getParameter(
                                    "price"
                            )
                    );

        } catch (NumberFormatException exception) {

            request.setAttribute(
                    "error",
                    "Gia san pham khong hop le."
            );


            showCreateForm(
                    request,
                    response
            );

            return;
        }


        Product product =
                new Product(
                        generateId(),
                        name,
                        price,
                        description,
                        manufacturer
                );


        productService.save(product);


        request.setAttribute(
                "message",
                "Product was created successfully."
        );


        showCreateForm(
                request,
                response
        );
    }


    private void showEditForm(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        Product product =
                findProductFromRequest(
                        request
                );


        if (product == null) {

            show404(
                    request,
                    response
            );

            return;
        }


        request.setAttribute(
                "product",
                product
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/product/edit.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    private void updateProduct(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        int id;


        try {

            id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"
                            )
                    );

        } catch (NumberFormatException exception) {

            show404(
                    request,
                    response
            );

            return;
        }


        Product product =
                productService.findById(id);


        if (product == null) {

            show404(
                    request,
                    response
            );

            return;
        }


        double price;


        try {

            price =
                    Double.parseDouble(
                            request.getParameter(
                                    "price"
                            )
                    );

        } catch (NumberFormatException exception) {

            request.setAttribute(
                    "product",
                    product
            );


            request.setAttribute(
                    "error",
                    "Gia san pham khong hop le."
            );


            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(
                            "/product/edit.jsp"
                    );


            dispatcher.forward(
                    request,
                    response
            );

            return;
        }


        product.setName(
                request.getParameter("name")
        );


        product.setPrice(price);


        product.setDescription(
                request.getParameter(
                        "description"
                )
        );


        product.setManufacturer(
                request.getParameter(
                        "manufacturer"
                )
        );


        productService.update(
                id,
                product
        );


        request.setAttribute(
                "product",
                product
        );


        request.setAttribute(
                "message",
                "Product was updated successfully."
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/product/edit.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    private void showDeleteForm(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        Product product =
                findProductFromRequest(
                        request
                );


        if (product == null) {

            show404(
                    request,
                    response
            );

            return;
        }


        request.setAttribute(
                "product",
                product
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/product/delete.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    private void deleteProduct(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        int id;


        try {

            id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"
                            )
                    );

        } catch (NumberFormatException exception) {

            show404(
                    request,
                    response
            );

            return;
        }


        Product product =
                productService.findById(id);


        if (product == null) {

            show404(
                    request,
                    response
            );

            return;
        }


        productService.remove(id);


        response.sendRedirect(
                request.getContextPath()
                + "/products"
        );
    }


    private void viewProduct(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        Product product =
                findProductFromRequest(
                        request
                );


        if (product == null) {

            show404(
                    request,
                    response
            );

            return;
        }


        request.setAttribute(
                "product",
                product
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/product/view.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }


    private Product findProductFromRequest(
            HttpServletRequest request
    ) {

        try {

            int id =
                    Integer.parseInt(
                            request.getParameter(
                                    "id"
                            )
                    );


            return productService.findById(id);

        } catch (NumberFormatException exception) {

            return null;
        }
    }


    private int generateId() {

        int maxId = 0;


        for (
                Product product
                : productService.findAll()
        ) {

            if (product.getId() > maxId) {

                maxId =
                        product.getId();
            }
        }


        return maxId + 1;
    }


    private void show404(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        response.setStatus(
                HttpServletResponse.SC_NOT_FOUND
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/error-404.jsp"
                );


        dispatcher.forward(
                request,
                response
        );
    }
}