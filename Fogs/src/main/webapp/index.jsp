<%-- 
    Document   : index
    Created on : 09-May-2019, 14:59:59
    Author     : simon
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <h1>Create Customer</h1>
        <form action="FrontController" method="post">
            Email<br>
            <input type="text" name="email" ><br><br>
            Password:<br>
            <input type="password" name="password" ><br><br>
            <input type="hidden" name="command" value="Login"/>
            <input type="submit" value="submit"/>  
        </form>
    </body>
</html>