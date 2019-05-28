<%-- 
    Document   : ViewOrders
    Created on : 21-May-2019, 15:30:06
    Author     : Simon
--%>
<%@page import="Data.OrderMapper"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Part list</title>
        <% OrderMapper om = new OrderMapper(); %>
        <% if (null == session.getAttribute("user")) {
         request.getRequestDispatcher("index.jsp").forward(request, response);
     }%>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Type a customer ID.</h1>
        <form action="FrontController" method="post">
            ID<br>
            <input type="text" name="id"><br><br>

            <input type="hidden" name="command" value="ViewOrders"/>
            <input type="submit" value="View Partlist"/>  
        </form>
        <div id="wrapper">
            <main clas="container-fluid">
                <div class="col-md-12">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>
                                    Order ID
                                </th>
                                <th>
                                    Status
                                </th>
                                <th>
                                    Width
                                </th>
                                <th>
                                    Length
                                </th>
                                <th>
                                    Shed Width
                                </th>
                                <th>
                                    Shed Length
                                </th>
                                <th>
                                    Roof Incline
                                </th>
                                <th>
                                    Customer ID
                                </th>
                                <th>
                                    Employee ID
                                </th>
                                <th>
                                    Total price
                                </th>

                            </tr>
                        </thead>

                        <% for (int i = 0; i < om.getOrders().size(); i++) {%>
                        <tr>
                            <td> <%=om.getOrders().get(i).getId_order()%></td>
                            <td> <%=om.getOrders().get(i).getStatus()%></td>
                            <td> <%=om.getOrders().get(i).getOrder_width()%></td>
                            <td> <%=om.getOrders().get(i).getOrder_length()%></td>
                            <td> <%=om.getOrders().get(i).getOrder_width_shed()%></td>
                            <td> <%=om.getOrders().get(i).getOrder_length_shed()%> </td>
                            <td> <%=om.getOrders().get(i).getIncline()%></td>
                            <td> <%=om.getOrders().get(i).getId_customer()%></td>
                            <td> <%=om.getOrders().get(i).getId_employee()%></td>
                            <td> <%=om.getOrders().get(i).getPrice()%></td>

                        </tr>
                        <% }%>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>


                    </table>

                </div>
            </main>
        </div>
    </body>
    <form>
        <button type="button" name="back" onclick="history.back()">back</button>
    </form>

</html>
