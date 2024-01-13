package n1exercici4;

import n1exercici1.ContingutDirectori;
import n2exercici1.Parametritzador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Menu {

    private static Parametritzador parametres = new Parametritzador();

    public static void accionaMenu(){
        guardaLlistaDirectori();
        int opcioMenu;
        do {
            opcioMenu = demanaOpcioMenu();
            switch (opcioMenu) {
                case 1:
                    opcio1(parametres.getContingut());
                    break;
                case 2:
                    opcio2(parametres.getContingut());
                    break;
                case 3:
                    opcio3(parametres.getContingut());
                    break;
            }
        }while (opcioMenu!=0);
        serialitzador(parametres.getContingut());
        System.out.println("Aplicació finalitzada");
    }
    private static void guardaLlistaDirectori(){
        parametres.getContingut().guardaLlistaOrdenada(parametres.getContingut().getFitxer().getRuta(), "");
    }
    private static void opcio1 (ContingutDirectori contingut){
        contingut.imprimeixLlistaOrdenada();
    }
    private static void opcio2 (ContingutDirectori contingut) {
        if (parametres.getParametritzacio()) {
            contingut.guardarContingut(parametres.getFile().getAbsolutePath() + parametres.getPropietats().getProperty("nomFitxerTXT"));
        } else {
            contingut.guardarContingut("src/main/java/n1exercici3/contingutDirectori");
        }
    }
    private static void opcio3 (ContingutDirectori contingut){
        contingut.seleccionaFitxer("Introdueixi l'arxiu TXT a llegir: ");
        if (contingut.getFitxer().getRutaArxiu()!=null){
            contingut.llegeixArxiuTXT(contingut.getFitxer().getRutaArxiu());
        }
    }
    private static void serialitzador (ContingutDirectori contingut){
        String rutaSerial = "/src/main/java/n1exercici5/contingut.ser";
        contingut.serialitzaContingut(contingut.getLlistaElements(), rutaSerial);
        contingut.deserialitzaContingut(contingut.getFitxer().getRuta(), rutaSerial);
    }

    private static int demanaOpcioMenu(){
        int opcioMenu;
        do{
            System.out.println(menu());
            opcioMenu = demanaInt("Seleccioni una opció del menú: ");
        } while(validaOpcio(opcioMenu));
        return opcioMenu;
    }
    private static boolean validaOpcio(int opcio){
        boolean correcte = false;
        if (opcio<0 || opcio>3){
            System.out.println("Aquesta opció no existeix en el menú");
            correcte = true;
        }
        return correcte;
    }
    private static String menu() {
        return """

                 MENÚ DE L'APLICACIÓ:
                (1). Mostra l'arbre de directoris
                (2). Guarda l'abre de directoris en un arxiu txt
                (3). Indica un arxiu TXT dins la ruta e imprimeix el resultat per pantalla
                (0). Sortir de l'aplicació""";
    }
    private static int demanaInt(String mensaje) {
        Scanner input = new Scanner (System.in);
        int numero = 0;
        boolean correcto = false;
        do {
            System.out.print(mensaje);
            try {
                numero = input.nextInt();
                correcto = true;
            } catch (InputMismatchException ex) {
                System.out.println("Error de format. Introdueixi un número sencer.");
            }
            input.nextLine();
        } while (!correcto);
        return numero;
    }

}
