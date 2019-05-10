<%-- 
    Document   : Partlists
    Created on : 09-May-2019, 16:22:06
    Author     : Renz
--%>
<%@page import="Logic.CarportCalc"%>
<%@page import="Logic.Carport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Part list</title>
        <%Carport carport = (Carport) request.getAttribute("carport");%>
        <%CarportCalc carportCalc = (CarportCalc) request.getAttribute("CarportCalc");%>
        <% int length = carport.getLengthOuter();
           int width = carport.getWidthOuter();
        %>
        
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
                                    Category name
                                </th>
                                <th>
                                    Amount
                                </th>
                                <th>
                                    Price
                                </th>
                                <th>
                                    Length
                                </th>
                                <th>
                                    Width
                                </th>
                                <th>
                                    Unit
                                </th>

                            </tr>
                        </thead>
                        <tr>
                            <td>
                                <%=carportCalc.poles(length, width).getPname() %>
                            </td>
                            <td>
                                <%=carportCalc.poles(length, width).getAmount() %>
                            </td>
                            <td>
                                <%=carportCalc.poles(length, width).getPrice() %> kr
                            </td>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%=carportCalc.beamsLength(length).getPname() %>
                            </td>
                            <td>
                                <%=carportCalc.beamsLength(length).getAmount() %>
                            </td>
                            <td>
                                <%=carportCalc.beamsLength(length).getPrice() %> kr
                            </td>
                            <td>
                                <%= carportCalc.beamsLength(length).getLength() %>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%=carportCalc.rafts(length, width).getPname() %>
                            </td>
                            <td>
                                <%=carportCalc.rafts(length, width).getAmount() %>
                            </td>
                            <td>
                                <%=carportCalc.rafts(length, width).getPrice() %> kr
                            </td>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%=carportCalc.portFittings(length, width).getPname() %>
                            </td>
                            <td>
                                <%=carportCalc.portFittings(length, width).getAmount() %>
                            </td>
                            <td>
                                <%=carportCalc.portFittings(length, width).getPrice() %> kr
                            </td>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%=carportCalc.screwFittings(length, width).getPname() %>
                            </td>
                            <td>
                                <%=carportCalc.screwFittings(length, width).getAmount() %>
                            </td>
                            <td>
                                <%=carportCalc.screwFittings(length, width).getPrice() %> kr
                            </td>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%=carportCalc.frameLength(length, width).getPname() %>
                            </td>
                            <td>
                                <%=carportCalc.frameLength(length, width).getAmount() %>
                            </td>
                            <td>
                                <%=carportCalc.frameLength(length, width).getPrice() %> kr
                            </td>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%=carportCalc.frameWidth(length, width).getPname() %>
                            </td>
                            <td>
                                <%=carportCalc.frameWidth(length, width).getAmount() %>
                            </td>
                            <td>
                                <%=carportCalc.frameWidth(length, width).getPrice() %> kr
                            </td>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%=carportCalc.screwFrame(length, width).getPname() %>
                            </td>
                            <td>
                                <%=carportCalc.screwFrame(length, width).getAmount() %>
                            </td>
                            <td>
                                <%=carportCalc.screwFrame(length, width).getPrice() %> kr
                            </td>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%=carportCalc.plastmoShort(length, width).getPname() %>
                            </td>
                            <td>
                                <%=carportCalc.plastmoShort(length, width).getAmount() %>
                            </td>
                            <td>
                                <%=carportCalc.plastmoShort(length, width).getPrice() %> kr
                            </td>
                            <td>

                            </td>
                        </tr>
                         <tr>
                            <td>
                                <%=carportCalc.plastmoLong(length, width).getPname() %>
                            </td>
                            <td>
                                <%=carportCalc.plastmoLong(length, width).getAmount() %>
                            </td>
                            <td>
                                <%=carportCalc.plastmoLong(length, width).getPrice() %> kr
                            </td>
                            <td>

                            </td>
                        </tr>
                    </table>

                </div>
            </main>
        </div>

    </body>
</html>
