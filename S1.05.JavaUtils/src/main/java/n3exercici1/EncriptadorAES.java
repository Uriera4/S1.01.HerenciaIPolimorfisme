package n3exercici1;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;

public class EncriptadorAES {

    private Key clau;
    private Cipher aes;

    public EncriptadorAES() {
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            clau = keyGenerator.generateKey();
            aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (Exception e){
            System.out.println("Error al generar la clau d'encriptació.");
        }
    }

    public void encriptaFitxer (String ruta, String entrada, String sortida) {
        try{
            aes.init(Cipher.ENCRYPT_MODE, clau);
            FileInputStream fitxer = new FileInputStream(ruta + entrada);
            CipherOutputStream escriuEncriptat = new CipherOutputStream(new FileOutputStream(ruta + sortida), aes);
            byte [] encriptat = aes.doFinal(fitxer.readAllBytes());
            for (byte b : encriptat){
                escriuEncriptat.write(b);
            }
            fitxer.close();
            escriuEncriptat.close();
        } catch (Exception e){
            System.out.println("Error al encriptar els fitxer");
        }
    }
    public void desencriptaFitxer (String ruta, String entrada, String sortida){
        try {
            aes.init(Cipher.DECRYPT_MODE, clau);
            CipherInputStream recuperaEncriptat = new CipherInputStream(new FileInputStream(ruta + entrada), aes);
            CipherOutputStream escriuDesencriptat = new CipherOutputStream(new FileOutputStream(ruta + sortida), aes);
            byte[] desencriptat = recuperaEncriptat.readAllBytes();
            for (byte b : desencriptat){
                escriuDesencriptat.write(b);
            }
            recuperaEncriptat.close();
            escriuDesencriptat.close();
        } catch (Exception e){
            System.out.println("Error al desencriptar els fitxer");
        }
    }
}
