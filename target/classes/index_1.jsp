<%-- 
    Document   : index
    Created on : 30/09/2020, 09:25:15 AM
    Author     : Julian Garcia Ortiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <script type="text/javascript" src="resources/funciones.js"></script>    

        <title>URLtokenCryptJSP</title>
    </head>
    <body>
        <h1>Generador URL con Token</h1>
        <form name="formCifrado" action="${pageContext.request.contextPath}/cryptServlet" method="POST"
              onsubmit="return validaDatos(this)" onreset="limpia(this)">
            <input type="hidden" name="datoNoVisible" value="ValorNoVisible"/>

            <table width="300px" id="enfasis-col">
            <!--<caption>
                    <h2>Generador URL con Token</h2>
                </caption>-->

                <tr>
                    <td class="col">
                        Tamaño de clave en bits(*):
                    </td >
                    <td>
                        128 bits <input type="radio" name="longClave" id="longClave" value="128" checked=""/>
                        256 bits <input type="radio" name="longClave" value="256"/>
                    </td>        
                </tr>
                <tr>
                    <td class="col">
                        Modo de cifrado(*):
                    </td >
                    <td>
                        <select name="modoCifrado" id="modoCifrado" class="default">
                            <option value="AES">AES/ECB</option>
                            <option value="AES">AES/CBC</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="col">
                        Texto a cifrar(*):
                    </td >
                    <td>
                        <textarea class="default" name="txtForCrypt" cols="36" rows="2" 
                                  placeholder="serial=SERIAL&activityId=CODIGOACTIVIDAD&user=USUARIO"
                                  onfocus="this.select()">${objetoEncDec.txtForCrypt}
                        </textarea>
                    </td>        
                </tr>
                <tr>
                    <td class="col">Serial: </td>
                    <td >
                        <input class="default" type="text" name="serial" id="serial"
                               value="" onfocus="this.select()"/>
                    </td>
                </tr>
                <tr>
                    <td class="col">ActivityId: </td>
                    <td>
                        <input class="default" type="text" name="activityId" id="activityId"
                               value="" onfocus="this.select()"/>
                    </td>
                </tr>
                <tr><td><label id="separador"> ............. </label></td></tr>
                <tr>
                    <td class="col">Usuario(*): </td>
                    <td>
                        <input class="default" type="text" name="user" id="user"
                               value="Digite el usuario." onfocus="this.select()"/>
                    </td>
                </tr>
                <tr>
                    <td class="col">Contraseña(*): </td>
                    <td>
                        <input class="default" type="password" name="key" id="key"
                               value="123" onfocus="this.select()"/>

                        <button class="btn btn-primary" type="button" id="btnKey"
                                onmouseover="verKey(formCifrado)" onclick="verKey(formCifrado)">Ver Clave</button>
                    </td>
                </tr>
                <tr><td><label id="separador"> ............. </label></td></tr>
                <tr style="text-align: center">
                    <td>
                        <input type="submit" value="Cifrar" class="default"/>
                    </td>        
                    <td>
                        <input type="reset" value="Limpiar" class="default"/>
                    </td>
                </tr>
                <tr><td><label id="separador"> ............. </label></td></tr>
                <tr>
                    <td class="col">
                        Texto Cifrado:
                    </td>
                    <td>
                        <label id="txtCrypt" onfocus="this.select()">
                            ${objetoEncDec.txtCrypt}
                        </label> 
                    </td>        
                </tr>
                <tr>
                    <td class="col">
                        URL:
                    </td >
                    <td class="col2">
                        <label id="url" onfocus="this.select()">
                            <a id="link" href="http://100.126.0.150:11030/PVE-Commands-web/pages/servletInit.xhtml?token=${objetoEncDec.url}" target="_blank">${objetoEncDec.url}</a>
                        </label> 
                    </td>        
                </tr>
            </table>
        </form>


        <!--<script>
            function limpiaCampos() {
                document.getElementById("url").hidden = true;
                document.getElementById("txtCrypt").hidden = true;
                alert("Aplicada funcion limpiaCampos!");
            }
        </script>-->
        <!--<script>
                    function verKey() {
                        var tipo = document.getElementById("key");
                        if (tipo.type == "password") {
                            tipo.type = "text";
                        } else {
                            tipo.type = "password";
                        }
                    }
        </script>-->
        
    </body>
</html>
