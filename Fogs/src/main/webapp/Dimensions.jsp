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
        <h1><% out.print(u.getName()); %></h1>
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
                            <h1>View carport partlists </h1>
                            Length:<br>
                            <input type="text" name="length"><br><br>
                            Width:<br>
                            <input type="text" name="width"><br><br>
                            <input type="hidden" name="command" value="Partlists"/>
                            <input type="submit" value="View Partlist">
                        </form>

                        <div class="">
                            <input type="radio" name="tab" value="igotnone" onclick="show1();" checked/>
                            Without Shed
                            <input type="radio" name="tab" value="igottwo" onclick="show2();" />
                            With shed <br>
                        </div>

                        <div id="div1" class="hide">
                            <h1>With shed</h1>
                            <p>Length on shed</p>
                            <form action="FrontController" method="POST">
                                <table>
                                    <tr>
                                        <td>
                                            <select class="" id="length" name="length">
                                                <option value="210" value="length">210</option>
                                                <option value="230">230</option>
                                                <option value="260">260</option>
                                                <option value="290">290</option>
                                                <option value="320">320</option>
                                                <option value="350">350</option>
                                                <option value="380">380</option>
                                                <option value="410">410</option>
                                                <option value="440">440</option>
                                            </select>
                                        </td>
                                    </tr>
                                </table>
                                Width on shed:
                                <table>
                                    <tr>
                                        <td>
                                            <select class="" id="width" name="width">
                                                <option value="210">210</option>
                                                <option value="230">230</option>
                                                <option value="260">260</option>
                                                <option value="290">290</option>
                                                <option value="320">320</option>
                                                <option value="350">350</option>
                                                <option value="380">380</option>
                                                <option value="410">410</option>
                                                <option value="440">440</option>
                                            </select>
                                        </td>
                                    </tr>
                                </table>
                                <input type="hidden" class="" name="command" value="Partlists"/>
                                <button type="submit">View partslist</button>
                            </form>
                        </div>
                </section>
            </main>
        </div>
    </body>
</html>
<script>
    function show1() {
        document.getElementById('div1').style.display = 'none';
    }
    function show2() {
        document.getElementById('div1').style.display = 'block';
    }
</script>

