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
    </head>
    <body>
        <h1><% out.print(u.getUsername()); %></h1>
        <h1><% out.print(u.getName());%></h1>
        <h1><% out.print(u.getRole());%></h1>
        <div id="wrapper">
            <main class="container-fluid">
                <section class="row-no-gutters">
                    <form class="col-md-6" action="FrontController" method="post">
                        <h1>View carport drawings</h1>
                        <h2>Carport without shed</h2>
                        Length:<br>
                        <input type="text" name="length"><br><br>
                        Width:<br>
                        <input type="text" name="width"><br><br>
                        <input type="hidden" name="command" value="CarportSimpleDrawing"/>
                        <input type="submit" value="View drawing"/>
                    </form>
                    <div class="col-md-6">
                        <form class="" action="FrontController" method="post">
                            <h1>View carport partslist </h1>
                            Length:<br>
                            <input type="text" name="length"><br><br>
                            Width:<br>
                            <input type="text" name="width"><br><br>

                            <div class="">
                                <input type="radio" name="shed" value="false" checked/> 
                                Without Shed<br> 
                                <input type="radio" name="shed" value="true" />
                                With shed <br> <br>
                            </div>

                            <p>Length on shed</p>
                            <table>
                                <tr>
                                    <td>
                                        <select class="" id="length" name="shedlength">
                                            <% for(int i = 0; i < 18; i++) { %> 
                                            <option value="<%=(210 + i*30) %>"><%=(210 + i*30)  %></option>
                                           
                                            <% } %>
                                            
                                            
                                        </select>
                                    </td>
                                </tr>
                            </table>
                            Width on shed:
                            <table>
                                <tr>
                                    <td>
                                        <select class="" id="width" name="shedwidth">
                                            <% for(int i = 0; i < 18; i++) { %> 
                                            <option value="<%=(210 + i*30) %>"><%=(210 + i*30)  %></option>
                                           
                                            <% } %>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                            <input type="hidden" name="command" value="Partlists"/>
                            <input type="submit" value="View Partlist">
                        </form>




                </section>
            </main>
        </div>
    </body>
</html>


