<%@ page
    contentType="text/html"
    pageEncoding="UTF-8"
%>

<%@ page
    import="java.util.ArrayList"
%>

<%@ page
    import="java.util.HashMap"
%>

<%@ page
    import="java.util.List"
%>

<%@ page
    import="java.util.Map"
%>

<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core"
%>

<%
    List<Map<String, String>> customers =
            new ArrayList<>();


    Map<String, String> customer1 =
            new HashMap<>();

    customer1.put(
            "name",
            "Nguyễn Văn Nam"
    );

    customer1.put(
            "birthDate",
            "15/03/1995"
    );

    customer1.put(
            "address",
            "Hà Nội"
    );

    customer1.put(
            "image",
            "images/customer-1.svg"
    );

    customers.add(customer1);


    Map<String, String> customer2 =
            new HashMap<>();

    customer2.put(
            "name",
            "Trần Thu Trang"
    );

    customer2.put(
            "birthDate",
            "22/08/1998"
    );

    customer2.put(
            "address",
            "Đà Nẵng"
    );

    customer2.put(
            "image",
            "images/customer-2.svg"
    );

    customers.add(customer2);


    Map<String, String> customer3 =
            new HashMap<>();

    customer3.put(
            "name",
            "Lê Minh Hoàng"
    );

    customer3.put(
            "birthDate",
            "05/11/1992"
    );

    customer3.put(
            "address",
            "TP. Hồ Chí Minh"
    );

    customer3.put(
            "image",
            "images/customer-3.svg"
    );

    customers.add(customer3);


    Map<String, String> customer4 =
            new HashMap<>();

    customer4.put(
            "name",
            "Phạm Mai Anh"
    );

    customer4.put(
            "birthDate",
            "18/06/2000"
    );

    customer4.put(
            "address",
            "Thái Nguyên"
    );

    customer4.put(
            "image",
            "images/customer-4.svg"
    );

    customers.add(customer4);


    Map<String, String> customer5 =
            new HashMap<>();

    customer5.put(
            "name",
            "Đỗ Lan Hương"
    );

    customer5.put(
            "birthDate",
            "09/01/1997"
    );

    customer5.put(
            "address",
            "Hải Phòng"
    );

    customer5.put(
            "image",
            "images/customer-5.svg"
    );

    customers.add(customer5);


    request.setAttribute(
            "customers",
            customers
    );
%>

<!DOCTYPE html>

<html lang="vi">

<head>

    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0"
    >

    <title>
        Danh sách khách hàng
    </title>


    <style>

        * {
            box-sizing: border-box;
        }


        body {
            margin: 0;

            padding:
                40px
                20px;

            background-color: #f8fafc;

            color: #1e293b;

            font-family:
                Arial,
                sans-serif;
        }


        .container {
            width: 100%;

            max-width: 1000px;

            margin: 0 auto;
        }


        h1 {
            margin:
                0
                0
                8px;

            color: #1b2a7a;

            text-align: center;
        }


        .description {
            margin:
                0
                0
                30px;

            color: #64748b;

            text-align: center;
        }


        .table-wrapper {
            overflow-x: auto;

            border-radius: 12px;

            background-color: white;

            box-shadow:
                0 10px 35px
                rgba(15, 23, 42, 0.08);
        }


        table {
            width: 100%;

            border-collapse: collapse;
        }


        thead {
            background-color: #1b2a7a;

            color: white;
        }


        th,
        td {
            padding:
                14px
                18px;

            border-bottom:
                1px solid
                #e2e8f0;

            text-align: left;

            vertical-align: middle;
        }


        th:first-child,
        td:first-child {
            text-align: center;
        }


        tbody tr:hover {
            background-color: #f8fafc;
        }


        .customer-image {
            width: 72px;

            height: 72px;

            display: block;

            margin: 0 auto;

            border-radius: 12px;

            object-fit: cover;
        }


        .customer-name {
            color: #1b2a7a;

            font-weight: bold;
        }


        .count {
            margin-top: 18px;

            color: #64748b;

            text-align: right;

            font-size: 14px;
        }


        @media (max-width: 600px) {

            body {
                padding:
                    20px
                    10px;
            }

            th,
            td {
                padding:
                    10px
                    12px;

                font-size: 14px;
            }

            .customer-image {
                width: 55px;

                height: 55px;
            }

        }

    </style>

</head>


<body>

    <main class="container">

        <h1>
            Danh sách khách hàng
        </h1>


        <p class="description">
            Thông tin khách hàng được hiển thị
            bằng JSP Standard Tag Library - JSTL.
        </p>


        <div class="table-wrapper">

            <table>

                <thead>

                    <tr>

                        <th>
                            Ảnh
                        </th>

                        <th>
                            Họ và tên
                        </th>

                        <th>
                            Ngày sinh
                        </th>

                        <th>
                            Địa chỉ
                        </th>

                    </tr>

                </thead>


                <tbody>

                    <%--
                        JSTL c:forEach:
                        Lap qua danh sach customers.

                        Khong viet 5 dong HTML bang tay.
                    --%>

                    <c:forEach
                        var="customer"
                        items="${customers}"
                    >

                        <tr>

                            <td>

                                <img
                                    class="customer-image"
                                    src="<c:out value='${customer.image}' />"
                                    alt="<c:out value='${customer.name}' />"
                                >

                            </td>


                            <td class="customer-name">

                                <c:out
                                    value="${customer.name}"
                                />

                            </td>


                            <td>

                                <c:out
                                    value="${customer.birthDate}"
                                />

                            </td>


                            <td>

                                <c:out
                                    value="${customer.address}"
                                />

                            </td>

                        </tr>

                    </c:forEach>

                </tbody>

            </table>

        </div>


        <p class="count">

            Tổng số khách hàng:

            <strong>
                <c:out
                    value="${customers.size()}"
                />
            </strong>

        </p>

    </main>

</body>

</html>
