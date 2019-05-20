<%-- 
    Document   : Partlists
    Created on : 09-May-2019, 16:22:06
    Author     : Renz
--%>
<%@page import="Logic.CarportCalcShed"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.Material"%>
<%@page import="Logic.CarportCalc"%>
<%@page import="Logic.Carport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Part list</title>
        <%Carport carport = (Carport) request.getAttribute("carport");%>
        <%CarportCalcShed carportCalcShed = (CarportCalcShed) request.getAttribute("CarportCalcShed");%>
        <% int length = carport.getLengthOuter();
           int width = carport.getWidthOuter();
        %>
        <% carportCalcShed.runCalc(length, width); %>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div id="wrapper">
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
                        <% int price = 0; %>
                       
                            <% for(int i = 0; i < carportCalcShed.partLists().size(); i++){ %>
                             <tr>
                             <td> <%=carportCalcShed.partLists().get(i).getPname() %></td>
                             <td> <%=carportCalcShed.partLists().get(i).getUnit() %></td>
                             <td> <%=carportCalcShed.partLists().get(i).getLength() %> cm</td>
                             <td> <%=carportCalcShed.partLists().get(i).getAmount() %></td>
                             <td> <%=carportCalcShed.partLists().get(i).getPrice() %> kr.</td>
                             <td> <%=carportCalcShed.partLists().get(i).getTotalPrice() %> kr.</td>
                             <% price += carportCalcShed.partLists().get(i).getTotalPrice(); %>
                             </tr>
                           <% } %>
                           <tr>
                               <td></td>
                               <td></td>
                               <td></td>
                               <td></td>
                               <td><b><i>Total price</i></b></td>
                               <td><b><i> <%=price %></i>,-</b></td>
                           </tr>
                       
                       
                    </table>

                </div>
            </main>
        </div>

    </body>
</html>