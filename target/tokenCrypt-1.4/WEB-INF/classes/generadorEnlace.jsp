<%-- 
    Document   : generadorEnlace
    Created on : 28/09/2020, 06:01:59 PM
    Author     : julian.ortiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>URLtoken Generator</title>
    </head>
    <body>
        <h1>Generador URL con Token:</h1>
        
        <a href="MyServlet?var1=2&var2=6">Creamos una peticion de tipo GET</a>
        <form action="myServlet" method="post">
            <label>Nombre:</label>
            <input type="text" name="nombre">
            <button type="submit">Enviar Nombre</button>
            
        </form>
        
    </body>
</html>
