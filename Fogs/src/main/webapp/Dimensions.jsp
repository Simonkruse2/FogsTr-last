<%-- 
    Document   : index
    Created on : 28-Apr-2019, 18:30:38
    Author     : simon
--%>
<%@page import="Data.User"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="style_fog.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <% User u = (User) session.getAttribute("user"); %>
        <% if (null == session.getAttribute("user")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }%>
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
                        <a href="ViewOrders.jsp" >click here to view previous orders</a>
                    </li>
                </ul>
            </nav>
            <main class="container-fluid">
                <section class="row-no-gutters dimensions">
                    <form class="col-md-6" action="FrontController" method="post">
                        <h1>View carport drawings</h1>
                        <h2>Carport without shed</h2>
                        Length:<br>
                        <input class="col-md-8" type="number" value="240" name="length" min="240" max="780"> <i class="i">*240-780 cm</i><br><br>
                        Width:<br>
                        <input class="col-md-8" type="number" value="240" name="width" min="240" max="750"> <i class="i">*240-750 cm</i><br><br>

                        <input type="hidden" name="command" value="CarportSimpleDrawing"/>
                        <input type="submit" value="View drawing"/>
                    </form>
                    <div class="col-md-6">
                        <form class="" action="FrontController" method="post">
                            <h1>View carport partslist </h1>
                            Length:<br>
                            <input class="col-md-8" type="number" value="240" name="length" min="240" max="780"> <i class="i">*240-780 cm</i><br><br>
                            Width:<br>
                            <input class="col-md-8" type="number" value="240" name="width" min="240" max="750"> <i class="i">*240-750 cm</i><br><br>

                            <div class="">
                                <input type="radio" name="shed" value="false" checked/> 
                                Without Shed<br> 
                                <input type="radio" name="shed" value="true" />
                                With shed <br> <br>
                            </div>
                            <p>Length on shed:</p>
                            <table class="col-md-12">
                                <tr>
                                    <td>
                                        <select class="col-md-8" id="length" name="shedlength">
                                            <% for (int i = 0; i < 18; i++) {%> 
                                            <option value="<%=(210 + i * 30)%>"><%=(210 + i * 30)%></option>

                                            <% } %>


                                        </select><i class="i">*210-720 cm</i>
                                    </td>
                                </tr>
                            </table>
                            <p>Width on shed:</p>
                            <table class="col-md-12">
                                <tr>
                                    <td>
                                        <select class="col-md-8" id="width" name="shedwidth">
                                            <% for (int i = 0; i < 18; i++) {%> 
                                            <option value="<%=(210 + i * 30)%>"><%=(210 + i * 30)%></option>

                                            <% }%>
                                        </select><i class="i">*210-720 cm</i>
                                    </td>
                                </tr>
                            </table>
                            <% if (!((request.getSession().getAttribute("error")) == null)) {%>
                            * <%= request.getSession().getAttribute("error")%> 
                            <br>
                            <% request.removeAttribute("error"); %> 
                            <% }%> 
                            <input type="hidden" name="command" value="Partlists"/>
                            <input type="submit" value="View Partlist">
                        </form>
                    </div>
                </section>
            </main>
        </div>

    </body>
</html>


