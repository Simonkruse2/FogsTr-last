
<%@page import="Data.OrderMapper"%>
<%@page import="Data.User"%>
<%@page import="Logic.CarportCalcShed"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.Material"%>
<%@page import="Logic.CarportCalc"%>
<%@page import="Data.Carport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Partslist</title>

        <% if (null == session.getAttribute("user")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }%>
        <% User u = (User) session.getAttribute("user"); %>
        <%Carport carport = (Carport) request.getAttribute("carport");%>
        <%CarportCalcShed carportCalcShed = (CarportCalcShed) request.getAttribute("CarportCalcShed");%>
        <% int length = carport.getLengthOuter();
            int width = carport.getWidthOuter();
            int shedlength = carport.getShedlength();
            int shedwidth = carport.getShedwidth();

            OrderMapper om = new OrderMapper();
            carportCalcShed.runCalc(length, width, shedlength, shedwidth); %>
        <link href="style_fog.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div id="wrapper">
            <nav class="">
                <ul>
                    <li>
                        <form class="float-right" action="FrontController" method="post">
                            <input type="hidden" name="command" value="logout">
                            <input type="submit" value="Log out"/>  
                        </form>
                    </li>
                    <li>
                        <b><% out.print(u.getUsername().toUpperCase());%></b>
                    </li>
                    <li>
                        <form class="float-left" action="" method="">
                            <button type="button" name="back" onclick="history.back()">Back</button>
                        </form>
                    </li>
                    <li>
                        <a href="ViewOrders.jsp" >click here to view previous orders</a>
                    </li>
                </ul>
            </nav>
            Width:  <% out.print(carport.getWidthOuter()); %> CM
            <br>
            Length:  <% out.print(carport.getLengthOuter()); %> CM
            <br>
            Shed width:  <% out.print(carport.getShedwidth()); %> CM
            <br>
            Shed length:  <% out.print(carport.getShedlength()); %> CM
            <br>
            <main clas="container-fluid">
                <div class="col-md-12">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>
                                    Description
                                </th>
                                <th>
                                    Unit
                                </th>
                                <th>
                                    Length
                                </th>
                                <th>
                                    Amount
                                </th>
                                <th>
                                    Price per unit
                                </th>
                                <th>
                                    Total price
                                </th>

                            </tr>
                        </thead>
                        <tr>
                            <td> <b> Carport </b></td>
                            <td>  </td>
                            <td>  </td>
                            <td>  </td>
                            <td>  </td>
                            <td>  </td>
                        </tr>
                        <tr>
                            <% for (int i = 0; i < carportCalcShed.partLists().size(); i++) {%>
                            <td> <%=carportCalcShed.partLists().get(i).getPname()%></td>
                            <td> <%=carportCalcShed.partLists().get(i).getUnit()%></td>
                            <td>
                                <% if (carportCalcShed.partLists().get(i).getLength() == 0) { %>
                                -
                                <% } else {%>
                                <%=carportCalcShed.partLists().get(i).getLength()%> cm
                                <% }%>
                            </td>
                            <td> <%=carportCalcShed.partLists().get(i).getAmount()%></td>
                            <td> <%=carportCalcShed.partLists().get(i).getPrice()%> kr.</td>
                            <td> <%=carportCalcShed.partLists().get(i).getTotalPrice()%> kr.</td>
                            <% if (carportCalcShed.partLists().get(i).getPname().equals("Plastmo Exolite blåtonet - Kort")) { %>
                        <tr>
                            <td> <b> Shed </b> </td>
                            <td>  </td>
                            <td>  </td>
                            <td>  </td>
                            <td>  </td>
                            <td>  </td>
                        </tr>
                        <% } %>
                        </tr>
                        <% }%>
                        <% if (request.getAttribute("id") == null) {%>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><b><i>Total price</i></b></td>
                            <td><b><i> <%= carportCalcShed.getPrice()%></i>,-</b></td>
                        </tr>
                        <% } else {
                            int id = Integer.parseInt(request.getParameter("id"));
                        %>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><b><i>Total price</i></b></td>
                            <td><b><i> <%= om.getOrder(id).getPrice()%></i>,-</b></td>
                        </tr>
                        <% } %>

                    </table>

                </div>
            </main>
        </div>
        <hr>
        <div class="col-md-12">
            <div class="col-md-6 forms">
                <% if (request.getAttribute("id") == null) { %>
                <h1>Place order</h1>
                <h2>Fill out customer information</h2>
                <form class="col-md-6 one" action="FrontController" method="post">
                    Name<br>
                    <input type="text" name="name"><br><br>
                    Email<br>
                    <input type="email" name="email" ><br><br>
                    Phone number<br>
                    <input type="tel" name="phone" pattern="[0-9]{8}" required>
                    <input type="hidden" name="command" value="CreateOrderShed"/>
                    <input type="submit" value="Submit"/>  
                </form>
                <%  } else {
                    int id = Integer.parseInt(request.getParameter("id"));%>
                <div class="col-md-12">
                    <form class="col-md-6 one" action="FrontController" method="post">
                        <p>Update total price</p>
                        <input class="col-md-8" type="number" min="0" value="<%= om.getOrder(id).getPrice()%>" name="price"><br><br>
                        <input type="hidden" name="command" value="UpdatePrice"/>
                        <input class="col-md-8" type="submit" value="Update price"/>  
                    </form>

                    <form class="col-md-6 one" action="FrontController" method="post">
                        <p>Update status</p>

                        <select class="col-md-8" name="newStatus">
                            <option hidden> <%= om.getOrder(id).getStatus().toString()%> </option>
                            <option value="In progress">In progress</option>
                            <option value="Shipped">Shipped</option>
                            <option value="Pending payment">Pending payment</option>
                        </select>
                        <input type="hidden" name="command" value="UpdateStatus"/>
                        <input class="col-md-8" type="submit" value="Update status"/>  
                    </form>
                </div>
                <%}%>
            </div>
        </div>
    </body>
</html>
