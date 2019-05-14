<%--
    Document   : index
    Created on : 09-May-2019, 14:59:59
    Author     : simon
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="style_fog.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="wrapper">
            <main class="container-fluid">
                <section class="col-md-12">
                    <form class="" action="FrontController" method="post">
                        <h1>Carport with shed</h1>
                        Length:<br>
                        <input type="text" name="length"><br><br>
                        Width:<br>
                        <input type="text" name="width"><br><br>
                        <input type="hidden" name="command" value="CarportSimpleDrawing"/>
                        <input type="submit" value="View drawing"/>
                    </form>
                    <form action="FrontController" method="post">
                        Length:<br>
                        <input type="text" name="length"><br><br>
                        Width:<br>
                        <input type="text" name="width"><br><br>
                        <input type="hidden" name="command" value="Partlists"/>
                        <input type="submit" value="View Partlist">
                    </form>

                    <input type="radio" name="tab" value="igotnone" onclick="show1();" />

                    Without Shed
                    <input type="radio" name="tab" value="igottwo" onclick="show2();" />
                    With shed <br>
                    <div id="div1" class="hide">

                        <h1>With shed</h1>
                        Length on shed:<br>
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
