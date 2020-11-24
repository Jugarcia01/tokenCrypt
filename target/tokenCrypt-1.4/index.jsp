<%-- 
    Document   : index
    Created on : 13/10/2020, 07:25:15 AM
    Author     : Julian Garcia Ortiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="text/html, width=device-width, initial-scale=1" charset="utf-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <link rel="stylesheet" type="text/css" href="resources/animatedText.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="resources/funciones.js"></script>
        <link rel="shortcut icon" type="image/png" href="resources/favicon.png"/>
        <title>URLtokenCryptJSP</title>
    </head>
    <!--
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="resources/funciones.js"></script>    
        <title>URLtokenCryptJSP</title>
    </head>
    -->

    <body>

        <div class="container" id="advanced-search-form">
            <!--
            <div class="globe-container">
                <div class="globe"></div>
            </div>
            -->
            <div class="wrapper">
                <img src="resources/claro-logo.png">
                <div class="letters"><span class="letter">G</span><span class="letter">e</span><span class="letter">n</span><span class="letter">e</span><span class="letter">r</span><span class="letter">a</span><span class="letter">d</span><span class="letter">o</span><span class="letter">r</span><span class="letter"> </span><span class="letter">U</span><span class="letter">R</span><span class="letter">L</span><span class="letter"> </span><span class="letter">T</span><span class="letter">o</span><span class="letter">k</span><span class="letter">e</span><span class="letter">n</span></div>

            </div>

            <form name="formCifrado" action="${pageContext.request.contextPath}/cryptServlet" method="POST"
                  onsubmit="return validaDatos(this)" onreset="limpia(this)" >
                <input type="hidden" name="datoNoVisible" value="ValorNoVisible"/>

                <table>
                    <tr>
                        <td class="form-caption">Usuario(*): </td>
                        <td>
                            <input class="form-control" type="text" name="user" id="user"
                                   placeholder="Digite el usuario." value="" onfocus="this.select()"/>
                        </td>
                    </tr>

                    <tr class="form-fila">
                        <td class="form-caption">Contraseña(*): </td>
                        <td>
                            <input class="form-control" type="text" name="key" id="key"
                                   value="" onfocus="this.select()"/>
                    </tr>
                    <tr class="form-fila align-items-center">
                        <td class="form-caption"></td>
                        <td>
                            <button class="boton btn-danger btn-xs" type="button" id="btnKey"
                                    onmouseover="verKey(formCifrado)" onclick="verKey(formCifrado)">Ver Clave</button>

                            <button class="boton btn-info btn-xs" type="button" id="restartKey"
                                    onclick="keyFecha()">Restablecer</button>
                        </td>
                    </tr>

                    <tr class="form-fila">
                        <td class="form-caption">
                            Modo de Token(*): 
                        </td >

                        <td class="radio-control" >
                            <div class="col-sm-4">
                                Comandos <input class="radio-inline" type="radio" name="modoApp" id="modoApp" value="Comandos" onchange="opcionModoApp(formCifrado)" />
                            </div>
                            <div class="col-sm-4">
                                Agenda <input class="radio-inline" type="radio" name="modoApp" value="Agenda" onchange="opcionModoApp(formCifrado)"/>
                            </div>
                            <div class="col-sm-4">
                                Solo Token <input class="radio-inline" type="radio" name="modoApp" value="SoloToken" onchange="opcionModoApp(formCifrado)"/>
                            </div>
                        </td>
                    </tr>
                </table>

                <table width="300px" class="form-group">
                    <tr class="cat1" id="filaC1a" style="display:none">
                        <td class="form-caption">Cod.Serial(*): </td>
                        <td>
                            <input class="form-control" type="text" name="serial" id="serial"
                                   placeholder="1A:2B:3C:D4:E5:F0" value="" onfocus="this.select()"/>
                        </td>
                    </tr>
                    <tr class="cat1" id="filaC1b" style="display:none">
                        <td class="form-caption">ActivityId(*): </td>
                        <td>
                            <input class="form-control" type="text" name="activityId" id="activityId"
                                   placeholder="17175617" value="" onfocus="this.select()"/>
                        </td>
                    </tr>
                    <tr class="cat2" id="filaA1a" style="display:none">
                        <td  class="form-caption">appointment(*): </td>
                        <td>
                            <input class="form-control" type="text" name="appointment" id="appointment"
                                   placeholder="20000042" value="" onfocus="this.select()"/>
                        </td>
                    </tr>
                    <tr class="cat2" id="filaA1b" style="display:none">
                        <td class="form-caption">documentUser(*): </td>
                        <td>
                            <input class="form-control" type="text" name="documentUser" id="documentUser"
                                   placeholder="1095922926" value="" onfocus="this.select()"/>
                        </td>
                    </tr>
                    <tr class="cat2" id="filaT1a" style="display:none">
                        <td class="form-caption" >
                            Texto a cifrar(*):
                        </td >
                        <td>
                            <textarea class="form-control" name="txtForCrypt" cols="36" rows="2"
                                      placeholder="appointment=###&idUser=%%%&documentUser=###" value=""
                                      onfocus="this.select()">${objetoEncDec.txtForCrypt}
                            </textarea>
                        </td>
                    </tr>
                </table>
                <table width="300px">
                    <tr style="text-align: center">
                        <td>
                            <button type="submit" class="btn btn-danger btn-lg btn-responsive" value="Cifrar"><span class="glyphicon glyphicon-search"></span> Cifrar </button>
                        </td>
                        <td>
                            <button type="reset" class="btn btn-info btn-lg btn-responsive" value="Limpiar"><span class="glyphicon glyphicon-trash"></span> Limpiar </button>
                        </td>
                    </tr>
                </table>
                </table>
                <table>
                    <tr class="form-group">
                        <td class="form-caption">
                            URL_UAT<br>Token:
                        </td>
                        <td>
                            <label class="form-caption" id="url" onfocus="this.select()">
                                <a class="form-url" id="link" href="${objetoEncDec.url}" target="_blank">${objetoEncDec.url}</a>
                            </label> 
                        </td>        
                    </tr>
                    <tr class="form-group" id="url2-Fila">
                        <td class="form-caption">
                            URL_DLLO<br>Token:
                        </td>
                        <td>
                            <label class="form-caption" id="url2" onfocus="this.select()">
                                <a class="form-url" id="link2" href="${objetoEncDec.url2}" target="_blank">${objetoEncDec.url2}</a>
                            </label> 
                        </td>        
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
