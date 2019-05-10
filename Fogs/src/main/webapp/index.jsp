<%--
    Document   : index
    Created on : 28-Apr-2019, 18:30:38
    Author     : simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="../../../../../../../week_5/FogsTr-last/Fogs/src/main/webapp/META-INF/style_fog.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-md-6">
            <h1>Without Shed</h1>
            <form action="FrontController" method="post">
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
            <button onclick="myFunction()">Add shed</button>
        </div>



        <div id="myDIV" class="col-md-6">
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

    </body>
</html>
<script>
    function myFunction() {
        var x = document.getElementById("myDIV");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
</script>
