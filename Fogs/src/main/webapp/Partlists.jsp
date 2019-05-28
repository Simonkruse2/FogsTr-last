<%-- 
    Document   : Partlists
    Created on : 09-May-2019, 16:22:06
    Author     : Renz
--%>
<%@page import="Data.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.Material"%>
<%@page import="Logic.CarportCalc"%>
<%@page import="Data.Carport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Part list</title>
        <% if (null == session.getAttribute("user")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }%>
        <% User u = (User) session.getAttribute("user"); %>
        <%Carport carport = (Carport) request.getAttribute("carport");%>
        <%CarportCalc carportCalc = (CarportCalc) request.getAttribute("CarportCalc");%>
        <% int length = carport.getLengthOuter();
            int width = carport.getWidthOuter();
        %>
        <% carportCalc.runCalc(length, width); %>
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
                        <i><% out.print(u.getUsername().toUpperCase()); %></i>
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
                                    Price pr. unit
                                </th>
                                <th>
                                    Total price
                                </th>

                            </tr>
                        </thead>

                        <% for (int i = 0; i < carportCalc.partLists().size(); i++) {%>
                        <tr>
                            <td> <%=carportCalc.partLists().get(i).getPname()%></td>
                            <td> <%=carportCalc.partLists().get(i).getUnit()%></td>
                            <td> 
                                <% if (carportCalc.partLists().get(i).getLength() == 0) { %>
                                -
                                <% } else {%>
                                <%=carportCalc.partLists().get(i).getLength()%> cm
                                <% }%> 
                            </td>
                            <td> <%=carportCalc.partLists().get(i).getAmount()%></td>
                            <td> <%=carportCalc.partLists().get(i).getPrice()%> kr.</td>
                            <td> <%=carportCalc.partLists().get(i).getTotalPrice()%> kr.</td>
                        </tr>
                        <% }%>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><b><i>Total price</i></b></td>
                            <td><b><i> <%= carportCalc.getPrice()%></i>,-</b></td>
                        </tr>


                    </table>

                </div>
            </main>
        </div>
        <div class="col-md-12 create">
            <div class="col-md-4 forms">
                <% if (request.getAttribute("id") == null) { %>
                <h1>Create Customer</h1>
                <form class="" action="FrontController" method="post">
                    Name<br>
                    <input class="col-md-6" type="text" name="name">
                    <br><br>
                    Email<br>
                    <input class="col-md-6" type="email" name="email" ><br><br>
                    Phone number<br>
                    <input class="col-md-6" type="number" name="phone" ><br><br>
                    <% if (!((request.getSession().getAttribute("error")) == null)) {%>
                    * <%= request.getSession().getAttribute("error")%>
                    <% request.removeAttribute("error"); %> 
                    <% } %> 
                    <br>
                    <input type="hidden" name="command" value="CreateOrder"/>
                    <input class="col-md-6" type="submit" value="submit"/>  
                </form>
                <%  } else { %>
                <form action="FrontController" method="post">
                    Update total price<br>
                    <input type="number" name="price"><br><br>
                    <input type="hidden" name="command" value="UpdatePrice"/>
                    <input type="submit" value="Update price"/>  
                </form>
                <br>
                <form action="FrontController" method="post">
                    Update status<br>
                    <select name="newStatus">
                        <option value="In progress">In progress</option>
                        <option value="Shipped">Shipped</option>
                        <option value="Pending payment">Pending payment</option>
                    </select>
                    <input type="hidden" name="command" value="UpdateStatus"/>
                    <input type="submit" value="Update status"/>  
                </form>
                <%   }%>
            </div>
        </div>
    </body>
</html>
