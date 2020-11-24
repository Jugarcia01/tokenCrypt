<%-- 
    Document   : desplegarVariables
    Created on : 30/09/2020, 10:11:45 AM
    Author     : julian.ortiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="resources/funciones.js"></script>    

        <title>Despliegue de Variables</title>
    </head>
    <body>
        <h1>Despliegue de Variables del Formulario</h1>
        Variable en alcance request: ${mensaje}
        <br/><br/>
        Variables en alcance de sesion:
        <br/><br/>
        serial:     ${objetoEncDec.serial} <br/>
        activityId: ${objetoEncDec.activityId} <br/>
        user:    ${objetoEncDec.user} <br/>
        key:      ${objetoEncDec.key} <br/>
        longClave = ${objetoEncDec.longClave} <br/>
        modoCifrado = ${objetoEncDec.modoCifrado} <br/>
        UnionCampos: ${objetoEncDec.txtForCryptJoin} <br/>
        CadenaTexto = ${objetoEncDec.txtForCrypt} <br/>
        txtCrypt = ${objetoEncDec.txtCrypt} <br/>
        url = ${objetoEncDec.url} <br/>

        <br/><br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Volver a inicio...</a>
    </body>
</html>
