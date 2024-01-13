package n1exercici3;

import n3exercici1.EncriptadorAES;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GuardaResultat {

    private static final EncriptadorAES encriptador = new EncriptadorAES();

    public static void guardarContingut(String nomFitxerTXT, ArrayList<String> llistaElements) {
        File arxiu = new File (nomFitxerTXT);
        try (BufferedWriter escriu = new BufferedWriter(new FileWriter(arxiu+".txt"))){
            escriuLlistaOrdenada(escriu, llistaElements);
            encriptador.encriptaFitxer(nomFitxerTXT, ".txt", "Encriptat.txt");
            encriptador.desencriptaFitxer(nomFitxerTXT, "Encriptat.txt", "Desencriptat.txt");
        } catch (IOException e){
            System.out.println("Error al intentar guardar les dades.");
        }
    }
    private static void escriuLlistaOrdenada (BufferedWriter escriu, ArrayList<String> llistaElements) throws IOException {
        for (String element: llistaElements){
            escriu.write(element + "\n");
        }
    }

}
