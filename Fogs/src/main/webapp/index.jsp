<%--
    Document   : index
    Created on : 09-May-2019, 14:59:59
    Author     : simon
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="style_fog.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <div class="row-no-gutter">
          <img class="col-md-12" src="image/FOG_forside.png" alt=""/>
              <div class="col-md-4 indexf">
                    <h1>Login as employee</h1>
                    <form class="test" action="FrontController" method="post">
                        Username<br>
                        <input class="col-md-12" type="text" name="username" ><br><br>
                        Password:<br>
                        <input class="col-md-12" type="password" name="password" ><br><br>
                        <% if( !((request.getSession().getAttribute("error")) == null) )  { %>
                        * <%= request.getSession().getAttribute("error") %> <br>
                        <% } %>
                        <% request.getSession().invalidate(); %>
                        <input type="hidden" name="command" value="Login"/>
                        <input class="col-md-12" type="submit" value="submit"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
