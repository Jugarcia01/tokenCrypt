package co.com.claro.tokencrypt.web.models;

//import co.com.claro.tokencrypt.web.controlServlets.AES;
import co.com.claro.tokencrypt.web.controlServlets.cifradoAES;

/**
 * @author Julian Garcia Ortiz
 */
public class EncryptDecrypt {

    // Variables del modelo
    private String txtForCrypt;
    private String serial;
    private String activityId;
    private String user;
    private String key;
    private String txtCrypt;
    private String modoApp;
    private String longClave;
    private String modoCifrado;
    private String url;
    private String url2;
    private String optCifrado;
    private String appointment;
    private String documentUser;
    private String urlReturn;

    // Constructores
    public EncryptDecrypt() {
    }

    public EncryptDecrypt(String txtForCrypt, String serial, String activityId, String user, String key, String txtCrypt, String modoApp, String longClave, String modoCifrado, String url, String url2, String optCifrado, String appointment, String documentUser, String urlReturn) {
        this.txtForCrypt = txtForCrypt;
        this.serial = serial;
        this.activityId = activityId;
        this.user = user;
        this.key = key;
        this.txtCrypt = txtCrypt;
        this.modoApp = modoApp;
        this.longClave = longClave;
        this.modoCifrado = modoCifrado;
        this.url = url;
        this.url2 = url2;
        this.optCifrado = optCifrado;
        this.appointment = appointment;
        this.documentUser = documentUser;
        this.urlReturn = urlReturn;
    }

    public EncryptDecrypt(String txtForCrypt, String user, String key, String longClave, String modoCifrado) {
        this.txtForCrypt = txtForCrypt;
        this.user = user;
        this.key = key;
        this.longClave = longClave;
        this.modoCifrado = modoCifrado;
    }

    // Getters & Setters de Variables
    public String getTxtForCrypt() {
        return txtForCrypt;
    }

    public void setTxtForCrypt(String txtForCrypt) {
        this.txtForCrypt = txtForCrypt;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getModoApp() {
        return modoApp;
    }

    public void setModoApp() {
        this.modoApp = modoApp;
    }

    public String getTxtCrypt() {
        return txtCrypt;
    }

    public void setTxtCrypt(String txtCrypt) {
        this.txtCrypt = txtCrypt;
    }

    public String getLongClave() {
        return longClave;
    }

    public void setLongClave(String longClave) {
        this.longClave = longClave;
    }

    public String getModoCifrado() {
        return modoCifrado;
    }

    public void setModoCifrado(String modoCifrado) {
        this.modoCifrado = modoCifrado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getOptCifrado() {
        return optCifrado;
    }

    public void setOptCifrado(String optCifrado) {
        this.optCifrado = optCifrado;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getDocumentUser() {
        return documentUser;
    }

    public void setDocumentUser(String documentUser) {
        this.documentUser = documentUser;
    }

    public String getUrlReturn() {
        return urlReturn;
    }

    public void setUrlReturn(String urlReturn) {
        this.urlReturn = urlReturn;
    }

    // Métodos de la Clase
    public String getTxtForCryptJoinComandos() {
        String dataJoin = "serial=" + serial + "&activityId=" + activityId + "&idUser=" + user;
        //String dataJoin = "&activityId=" + activityId;
        return dataJoin;
    }

    public String getTxtForCryptJoinAgenda() {
        String dataJoin = "appointment=" + appointment + "&idUser=" + user + "&documentUser=" + documentUser + "&urlReturn=" + urlReturn;
        return dataJoin;
    }

    public void setDataJoin(String activityId) {
        this.activityId = activityId;
        this.txtForCrypt = "activityId=" + this.activityId;
    }

    public void setDataJoin(String serial, String activityId, String user) {
        this.serial = serial;
        this.activityId = activityId;
        this.user = user;

        this.txtForCrypt = "serial=" + this.serial + "&activityId=" + this.activityId + "&idUser=" + this.user;
    }

    public String cifraCampos() {
        String camposACifrar;

        if ("Agenda".equals(modoApp)) {
            camposACifrar = getTxtForCryptJoinAgenda();
            System.out.println("Seleccionado modo Agenda");

        } else {
            camposACifrar = getTxtForCryptJoinComandos();
            System.out.println("Seleccionado modo Comandos");
        }
        
        System.out.println("camposACifrar= " + camposACifrar);

        //String txtCamposCifrados = AES.encrypt(camposACifrar, key);
        String txtCamposCifrados = cifradoAES.getEncrypted(camposACifrar, key, modoCifrado);
        txtCamposCifrados = "token=" + txtCamposCifrados;

        return txtCamposCifrados;
    }

    public String cifraTexto() {
        String txtACifrar = txtForCrypt;
        System.out.println("textoACifrar= " + txtACifrar);

        //String txtCifrado = AES.encrypt(txtACifrar, key);
        String txtCifrado = cifradoAES.getEncrypted(txtACifrar, key, modoCifrado);
        //txtCifrado = "serial=" + serial + "&idUser=" + user + "&token=" + txtCifrado;
        txtCifrado = "token=" + txtCifrado;

        return txtCifrado;
    }
    
    public String urlToken (String url, String token) {
        String urlCrypt = url + token;

        return urlCrypt;
    }

    @Override
    public String toString() {
        return "EncryptDecrypt{" + "txtForCrypt=" + txtForCrypt + ", serial=" + serial + ", activityId=" + activityId + ", user=" + user + ", key=" + key + ", txtCrypt=" + txtCrypt + ", modoApp=" + modoApp + ", longClave=" + longClave + ", modoCifrado=" + modoCifrado + ", url=" + url + ", optCifrado=" + optCifrado + '}';
    }

    //    // Main de Prueba
    //    public static void main(String[] args) {
    //        String textoAcifrar = "serial=10:C2:5A:28:70:C2&activityId=17175617&idUser=ECM3403C";
    //        String clave = "MICLAROA20200928";
    //        String algoritmo = "AES";
    //        
    //        String encryptedString = cifradoAES.getEncrypted(textoAcifrar, clave, algoritmo);
    //        encryptedString = encryptedString.replace("\n", "");
    //
    //        encryptedString = "xNRtwO6w0bytWqhvpUT73ej6qqTp/KuTKbXdCDmAEJmnfJq4GD8yPk0tePqymOuP";
    //        String decryptedString = cifradoAES.getDecrypted(encryptedString, clave, algoritmo);
    //        
    //        System.out.println("Este es el mensaje cifrado:");
    //        System.out.println(encryptedString);
    //
    //        System.out.println("Aqui esta el mensaje descifrado:");
    //        System.out.println(decryptedString);
    //    }
}
