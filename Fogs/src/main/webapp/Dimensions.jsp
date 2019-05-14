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
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FrontController" method="post">
            Length:<br>
            <input type="text" name="length"><br><br>
            Width:<br>
            <input type="text" name="width"><br><br>
            <input type="hidden" name="command" value="CarportSimpleDrawing"/>
            <input type="submit" value="calculate"/>  
           </form>
    </body>
</html>
