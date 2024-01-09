package n1exercici1;

import n1exercici2.ElementDirectori;
import n1exercici4.Ruta;
import n3exercici1.EncriptadorAES;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ContingutDirectori {

    private Ruta fitxer;
    private ArrayList<String> llistaElements;
    private final EncriptadorAES encriptador = new EncriptadorAES();

    public ContingutDirectori (String ruta){
        fitxer = new Ruta (new File (ruta));
        llistaElements = new ArrayList<>();
    }
    public ContingutDirectori (Ruta fitxer){
        this.fitxer = fitxer;
        llistaElements = new ArrayList<>();
    }

    public void guardaLlistaOrdenada (File ruta, String tabulacio){
        File [] arxius = ruta.listFiles();
        String nouElement;
        if (arxius != null) {
            Arrays.sort(arxius);
            for (File arxiu: arxius){
                if (arxiu.isDirectory()){
                    nouElement = tabulacio + (new ElementDirectori(arxiu, "(D)"));
                    llistaElements.add(nouElement);
                    guardaLlistaOrdenada(new File (ruta+ "/"+ arxiu.getName()), tabulacio + "   ");
                } else {
                    nouElement = tabulacio + (new ElementDirectori(arxiu, "(F)"));
                    llistaElements.add(nouElement);
                }
            }
        }
    }
    public void imprimeixLlistaOrdenada (){
        for (String element: llistaElements){
            System.out.println(element);
        }
    }
    public void guardarContingut(String nomFitxerTXT){
        try {
            File arxiu = new File (nomFitxerTXT);
            BufferedWriter escriu = new BufferedWriter(new FileWriter(arxiu+".txt"));
            escriuLlistaOrdenada(escriu);
            escriu.close();
            encriptador.encriptaFitxer(nomFitxerTXT, ".txt", "Encriptat.txt");
            encriptador.desencriptaFitxer(nomFitxerTXT, "Encriptat.txt", "Desencriptat.txt");
        } catch (IOException e){
            System.out.println("Error al intentar guardar les dades.");
        }
    }
    private void escriuLlistaOrdenada (BufferedWriter escriu) throws IOException {
        for (String element: llistaElements){
            escriu.write(element + "\n");
        }
    }
    public void llegeixArxiuTXT(File ruta){
        try {
            BufferedReader llegeix = new BufferedReader(new FileReader(ruta.getAbsoluteFile()));
            String linea;
            while ((linea = llegeix.readLine()) != null){
                System.out.println(linea);
            }
            llegeix.close();
        } catch (IOException e){
            System.out.println("Error al intentar llegir les dades." + Arrays.toString(e.getStackTrace()));
        }
    }

    public Ruta getFitxer(){
        return fitxer;
    }
    public ArrayList<String> getLlistaElements (){
        return llistaElements;
    }
    public void seleccionaFitxer (String missatge){
        this.fitxer.afageixRutaArxiu(missatge);
    }

    public void serialitzaContingut (ArrayList<String> contingut, String rutaSerial) {
        try {
            File arxiu = new File (fitxer.getRuta().getAbsolutePath() + rutaSerial);
            ObjectOutputStream escriureFitxer = new ObjectOutputStream(new FileOutputStream(arxiu));
            escriureFitxer.writeObject(contingut);
            escriureFitxer.close();
            System.out.println("El contingut ha estat serialitzat i guardat en la ruta especificada");

        } catch (IOException e) {
            System.out.println("Error al serialitzar el contingut");
            System.out.println(e.getMessage());
        }
    }
    public void deserialitzaContingut (File ruta, String rutaSerial){
        try (ObjectInputStream recuperaFitxer = new ObjectInputStream(new FileInputStream(ruta.getAbsolutePath() + rutaSerial))){
            llistaElements = (ArrayList<String>) recuperaFitxer.readObject();
            System.out.println("El contingut ha estat deserialitzat de la ruta especificada");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error al desearilitzar el contingut");
        }
    }

}
