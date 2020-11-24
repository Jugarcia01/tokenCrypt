package co.com.claro.tokencrypt.web.controlServlets;

//import android.util.Base64;
import com.loopj.android.http.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class cifradoAES {
    private static final String ALGORITHM = "AES";
    private static String password = "INGRESE_CLAVE";
    private static final byte[] KEY_SPEC = password.getBytes();

    
    public static String getEncrypted(String plainText, String password, String ALGORITHM) {
        if (plainText == null) {
            return null;
        }

        Key claveSpec = getKeySpec(password, ALGORITHM);
        //Key claveSpec = getKeySpec();
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, claveSpec);
            byte[] encodedValue = cipher.doFinal(plainText.getBytes());
            return Base64.encodeToString(encodedValue, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Failed to encrypt data");
    }

    public static String getDecrypted(String encodedText, String password, String ALGORITHM) {
        if (encodedText == null) {
            return null;
        }

        Key claveSpec = getKeySpec(password, ALGORITHM);
        //Key claveSpec = getKeySpec();
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, claveSpec);
            byte[] decodedValue = Base64.decode(encodedText, Base64.DEFAULT);
            byte[] decValue = cipher.doFinal(decodedValue);
            return new String(decValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Key getKeySpec() {
        return new SecretKeySpec(KEY_SPEC, ALGORITHM);
    }

    public static Key getKeySpec(String password, String ALGORITHM) {
        final byte[] KEY_SPEC = password.getBytes();
        return new SecretKeySpec(KEY_SPEC, ALGORITHM);

    }

}
