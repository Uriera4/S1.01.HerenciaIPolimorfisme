package n1exercici5;

import n1exercici4.Ruta;

import java.io.*;
import java.util.ArrayList;

public class Serialitzador {

    public static void serialitzaContingut(ArrayList<String> contingut, String rutaSerial, Ruta fitxer) {
        File arxiu = new File (fitxer.getRuta().getAbsolutePath() + rutaSerial);
        try (ObjectOutputStream escriureFitxer = new ObjectOutputStream(new FileOutputStream(arxiu))){
            escriureFitxer.writeObject(contingut);
            System.out.println("El contingut ha estat serialitzat i guardat en la ruta especificada");
        } catch (IOException e) {
            System.out.println("Error al serialitzar el contingut");
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<String> deserialitzaContingut(File ruta, String rutaSerial){
        ArrayList<String> llistaElements = new ArrayList<>();
        try (ObjectInputStream recuperaFitxer = new ObjectInputStream(new FileInputStream(ruta.getAbsolutePath() + rutaSerial))){
            llistaElements = (ArrayList<String>) recuperaFitxer.readObject();
            System.out.println("El contingut ha estat deserialitzat de la ruta especificada");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error al desearilitzar el contingut");
        }
        return llistaElements;
    }

}
