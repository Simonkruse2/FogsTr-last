<%-- 
    Document   : createCustomer
    Created on : 09-May-2019, 14:59:59
    Author     : simon
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <h1>Create employee</h1>
        <form action="FrontController" method="post">
            Name<br>
            <input type="text" name="name"><br><br>
            Email<br>
            <input type="text" name="email" ><br><br>
            Phone number<br>
            <input type="text" name="phone" ><br><br>
            Password:<br>
            <input type="password" name="password" ><br><br>
            <input type="hidden" name="command" value="CreateCustomer"/>
            <input type="submit" value="submit"/>  
        </form>
    </body>
</html>