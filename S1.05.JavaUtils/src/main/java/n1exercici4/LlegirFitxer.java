package n1exercici4;

import n1exercici3.GuardaResultat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LlegirFitxer {

    public static void llegeixArxiuTXT(File ruta){
        try (BufferedReader llegeix = new BufferedReader(new FileReader(ruta.getAbsoluteFile()))){
            String linea;
            while ((linea = llegeix.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e){
            System.out.println("Error al intentar llegir les dades." + Arrays.toString(e.getStackTrace()));
        }
    }

}
