package n1exercici1;

import n1exercici2.ElementDirectori;
import n1exercici3.GuardaResultat;
import n1exercici4.LlegirFitxer;
import n1exercici4.Ruta;
import n1exercici5.Serialitzador;
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
    public void guardarContingut(String nomFitxerTXT) {
        GuardaResultat.guardarContingut(nomFitxerTXT, llistaElements);
    }
    public void llegeixArxiuTXT(File ruta){
        LlegirFitxer.llegeixArxiuTXT(ruta);
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
        Serialitzador.serialitzaContingut(contingut, rutaSerial, fitxer);
    }
    public void deserialitzaContingut (File ruta, String rutaSerial){
        llistaElements = Serialitzador.deserialitzaContingut(ruta, rutaSerial);
    }

}
