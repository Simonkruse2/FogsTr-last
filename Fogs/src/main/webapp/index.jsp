<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Fog</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="style_fog.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <img width="100%" src="image/FOG_forside.png" alt=""/>
        <div class="row-no-gutters">
            <div class="main">
                <i><p class="centre">Login using salesperson/admin as username. salesperson/admin as password</p></i>
                <div class="col-md-4 ">
                    <h1>Login as employee</h1>
                    <form  action="FrontController" method="post">
                        Username<br>
                        <input class="col-md-12" type="text" name="username" ><br><br>
                        Password:<br>
                        <input class="col-md-12" type="password" name="password" ><br><br>
                        <% if (!((request.getSession().getAttribute("loginerror")) == null)) {%>
                        * <%= request.getSession().getAttribute("loginerror")%> <br>
                        <% } %>
                        <% request.getSession().invalidate();%>
                        <input type="hidden" name="command" value="Login"/>
                        <input class="col-md-12 one" type="submit" value="Login"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
