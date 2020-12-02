package co.com.claro.tokencrypt.web.controlServlets;

import co.com.claro.tokencrypt.web.models.EncryptDecrypt;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter;

/**
 * @author Julian Garcia Ortiz
 */
@WebServlet("/cryptServlet")
public class cryptServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Se indica al browser que no guarde en cache.
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-store");
        resp.setDateHeader("Expires", 1);

        // Se obtienen y procesan los parametros del formulario
        String txtForCrypt = req.getParameter("txtForCrypt");
        String serial = req.getParameter("serial");
        String activityId = req.getParameter("activityId");
        String user = req.getParameter("user");
        String key = req.getParameter("key");
        String txtCrypt = req.getParameter("txtCrypt");
        String modoApp = req.getParameter("modoApp");
        String longClave = req.getParameter("longClave");
        String modoCifrado = req.getParameter("modoCifrado");
        String url = req.getParameter("url");
        String url2 = req.getParameter("url2");
        String optCifrado = req.getParameter("optCifrado");
        String appointment = req.getParameter("appointment");
        String documentUser = req.getParameter("documentUser");
        String urlReturn = req.getParameter("urlReturn");
        String urlToken = "";

        System.out.println("txtForCrypt: " + txtForCrypt);
        System.out.println("user: " + user);
        System.out.println("key: " + key);

        // Se crean los JavaBeans necesarios
        EncryptDecrypt objEnc = new EncryptDecrypt(txtForCrypt, serial, activityId, user, key, txtCrypt, modoApp, longClave, modoCifrado, url, url2, optCifrado, appointment, documentUser, urlReturn);

        if (modoApp.isEmpty()) {
        } else {
            objEnc.setModoCifrado("AES");

            switch (modoApp) {
                case "Comandos":
                    objEnc.getTxtForCryptJoinComandos();
                    url = "http://100.126.0.150:11030/Commands-web/pages/servletInit.xhtml?";
                    txtCrypt = objEnc.cifraCampos();
                    urlToken = objEnc.urlToken(url, txtCrypt);
                    objEnc.setUrl(urlToken);
                    //objEnc.setTxtCrypt(urlToken);
                    System.out.println("urlToken: " + urlToken);
                    break;
                case "Agenda":
                    objEnc.getTxtForCryptJoinAgenda();
                    url = "http://100.126.0.150:11016/MgwAgenda-web/pages/servletInit.xhtml?";
                    url2 = "http://100.126.0.150:11203/MgwAgenda-web/pages/servletInit.xhtml?";
                    txtCrypt = objEnc.cifraCampos();
                    // Definiendo URL UAT con Token
                    urlToken = objEnc.urlToken(url, txtCrypt);
                    objEnc.setUrl(urlToken);
                    //objEnc.setTxtCrypt(urlToken);
                    System.out.println("urlToken1: " + urlToken);
                    // Definiendo URL DLLO con Token
                    urlToken = objEnc.urlToken(url2, txtCrypt);
                    objEnc.setUrl2(urlToken);
                    //objEnc.setTxtCrypt(urlToken);
                    System.out.println("urlToken2: " + urlToken);
                    break;
                case "SoloToken":
                    objEnc.getTxtForCrypt();
                    txtCrypt = objEnc.cifraCampos();
                    url = "";
                    url2 = "";
                    /*
                    urlReturn = "http://100.126.0.150:11052/PVE-web/";
                    objEnc.setUrlReturn(urlReturn);
                    */
                    txtCrypt = objEnc.cifraTexto();
                    urlToken = objEnc.urlToken(url, txtCrypt);
                    objEnc.setUrl(urlToken);
                    objEnc.setTxtCrypt(urlToken);
                    
                    System.out.println("Token= " + urlToken);
                    break;
                    
                default:
                    url = "Debe seleccionar la Opción de cifado";
                    url2 = "Debe seleccionar la Opción de cifado";
                    objEnc.setUrl(urlToken);
            }
        }

        req.setAttribute("mensaje", "Procesando informacion del servlet...");

        HttpSession sesion = req.getSession();
        sesion.setAttribute("objetoEncDec", objEnc);

        // Se redirecciona información a la vista seleccionada
        //RequestDispatcher rd = req.getRequestDispatcher("views/desplegarVariables.jsp");
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");

        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.setContentType("text/html; charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.println("Servlet funcionando correctamente!.");

                // Se indica al browser que no guarde en cache.
                resp.setHeader("Pragma", "no-cache");
                resp.setHeader("Cache-Control", "no-store");
                resp.setDateHeader("Expires", 1);
        //
        //        // Se obtienen y procesan los parametros del formulario
        //        String txtForCrypt = req.getParameter("txtForCrypt");
        //        String serial = req.getParameter("serial");
        //        String activityId = req.getParameter("activityId");
        //        String user = req.getParameter("user");
        //        String key = req.getParameter("key");
        //        String txtCrypt = req.getParameter("txtCrypt");
        //        String longClave = req.getParameter("longClave");
        //        String modoCifrado = req.getParameter("modoCifrado");
        //        String url = req.getParameter("url");
        //        System.out.println("txtForCrypt: " + txtForCrypt);
        //        System.out.println("user: " + user);
        //        System.out.println("key: " + key);
        //
        //        // Se crean los JavaBeans necesarios
        //        EncryptDecrypt objEnc = new EncryptDecrypt(txtForCrypt, user, key, longClave, modoCifrado);
        //        objEnc.getTxtForCryptJoin();
        //        
        //        // Se agregan los JavaBeans a los alcances requeridos
                req.setAttribute("mensaje", "Procesando informacion del servlet...");
        //        
        //        HttpSession sesion = req.getSession();
        //        sesion.setAttribute("objetoEncDec", objEnc);
        //        
        //        // Se redirecciona información a la vista seleccionada
                RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                rd.forward(req, resp);        
    }

}
