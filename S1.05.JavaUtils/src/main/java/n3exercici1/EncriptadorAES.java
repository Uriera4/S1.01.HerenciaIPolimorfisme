package n3exercici1;

import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class EncriptadorAES {

    private Key clau;
    private Cipher aes;

    public EncriptadorAES() {
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            clau = keyGenerator.generateKey();
            aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e){
            System.out.println("Error al generar la clau d'encriptació: " + e.getMessage());
        }
    }

    public void encriptaFitxer (String ruta, String entrada, String sortida) {
        try{
            aes.init(Cipher.ENCRYPT_MODE, clau);
            try (FileInputStream fitxer = new FileInputStream(ruta + entrada);
                 CipherOutputStream escriuEncriptat = new CipherOutputStream(new FileOutputStream(ruta + sortida), aes)) {
                byte [] encriptat = aes.doFinal(fitxer.readAllBytes());
                for (byte b : encriptat){
                    escriuEncriptat.write(b);
                }
            }
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException e){
            System.out.println("Error al encriptar els fitxer: " + e.getMessage());
        }
    }
    public void desencriptaFitxer (String ruta, String entrada, String sortida){
        try {
            aes.init(Cipher.DECRYPT_MODE, clau);
            try (CipherInputStream recuperaEncriptat = new CipherInputStream(new FileInputStream(ruta + entrada), aes);
                 CipherOutputStream escriuDesencriptat = new CipherOutputStream(new FileOutputStream(ruta + sortida), aes)){
                byte[] desencriptat = recuperaEncriptat.readAllBytes();
                for (byte b : desencriptat){
                    escriuDesencriptat.write(b);
                }
            }
        } catch (InvalidKeyException | IOException e){
            System.out.println("Error al desencriptar el fitxer: " + e.getMessage());
        }
    }
}
