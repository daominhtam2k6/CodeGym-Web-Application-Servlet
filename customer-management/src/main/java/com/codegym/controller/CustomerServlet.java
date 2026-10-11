package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Front Controller xu ly cac thao tac quan ly Customer.
 */
@WebServlet(
        name = "CustomerServlet",
        urlPatterns = {"/customers"}
)
public class CustomerServlet extends HttpServlet {

    private final CustomerService customerService =
            new CustomerServiceImpl();

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
                showCreateForm(request, response);
                break;

            case "edit":
                showEditForm(request, response);
                break;

            case "delete":
                showDeleteForm(request, response);
                break;

            case "view":
                viewCustomer(request, response);
                break;

            default:
                listCustomers(request, response);
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
                createCustomer(request, response);
                break;

            case "edit":
                updateCustomer(request, response);
                break;

            case "delete":
                deleteCustomer(request, response);
                break;

            default:
                response.sendRedirect(
                        request.getContextPath()
                        + "/customers"
                );
                break;
        }
    }

    private void listCustomers(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        List<Customer> customers =
                customerService.findAll();

        request.setAttribute(
                "customers",
                customers
        );

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/customer/list.jsp"
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
                        "/customer/create.jsp"
                );

        dispatcher.forward(
                request,
                response
        );
    }

    private void createCustomer(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String address =
                request.getParameter("address");


        int id =
                generateId();


        Customer customer =
                new Customer(
                        id,
                        name,
                        email,
                        address
                );


        customerService.save(customer);


        request.setAttribute(
                "message",
                "New customer was created"
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/customer/create.jsp"
                );

        dispatcher.forward(
                request,
                response
        );
    }

    private void showEditForm(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        Customer customer =
                findCustomerFromRequest(request);

        if (customer == null) {

            show404(
                    request,
                    response
            );

            return;
        }

        request.setAttribute(
                "customer",
                customer
        );

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/customer/edit.jsp"
                );

        dispatcher.forward(
                request,
                response
        );
    }

    private void updateCustomer(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        int id;

        try {

            id =
                    Integer.parseInt(
                            request.getParameter("id")
                    );

        } catch (NumberFormatException exception) {

            show404(
                    request,
                    response
            );

            return;
        }


        Customer customer =
                customerService.findById(id);


        if (customer == null) {

            show404(
                    request,
                    response
            );

            return;
        }


        customer.setName(
                request.getParameter("name")
        );

        customer.setEmail(
                request.getParameter("email")
        );

        customer.setAddress(
                request.getParameter("address")
        );


        customerService.update(
                id,
                customer
        );


        request.setAttribute(
                "customer",
                customer
        );

        request.setAttribute(
                "message",
                "Customer information was updated"
        );


        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/customer/edit.jsp"
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

        Customer customer =
                findCustomerFromRequest(request);

        if (customer == null) {

            show404(
                    request,
                    response
            );

            return;
        }

        request.setAttribute(
                "customer",
                customer
        );

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/customer/delete.jsp"
                );

        dispatcher.forward(
                request,
                response
        );
    }

    private void deleteCustomer(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        int id;

        try {

            id =
                    Integer.parseInt(
                            request.getParameter("id")
                    );

        } catch (NumberFormatException exception) {

            show404(
                    request,
                    response
            );

            return;
        }


        Customer customer =
                customerService.findById(id);


        if (customer == null) {

            show404(
                    request,
                    response
            );

            return;
        }


        customerService.remove(id);


        response.sendRedirect(
                request.getContextPath()
                + "/customers"
        );
    }

    private void viewCustomer(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        Customer customer =
                findCustomerFromRequest(request);

        if (customer == null) {

            show404(
                    request,
                    response
            );

            return;
        }

        request.setAttribute(
                "customer",
                customer
        );

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/customer/view.jsp"
                );

        dispatcher.forward(
                request,
                response
        );
    }

    private Customer findCustomerFromRequest(
            HttpServletRequest request
    ) {

        try {

            int id =
                    Integer.parseInt(
                            request.getParameter("id")
                    );

            return customerService.findById(id);

        } catch (NumberFormatException exception) {

            return null;
        }
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

    private int generateId() {

        int maxId = 0;

        for (Customer customer : customerService.findAll()) {

            if (customer.getId() > maxId) {
                maxId = customer.getId();
            }
        }

        return maxId + 1;
    }
}