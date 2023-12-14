package n1exercici3;

import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
public class Main {
    static HashMap<String, String> llistaPaisosCapitals = new HashMap<>();
    public static void main (String[] args) {
        try {
            llegeixArxiuPaisosCapitals();
            imprimeixTitolPrograma();
            String nom = demanaNomUsuari();
            byte respostes = 0;
            byte puntuacio = 0;
            do {
                puntuacio += preguntaCapital();
                respostes++;
            } while (respostes!=10);
            crearModificarArxiu(nom, puntuacio);
        } catch (IOException e) {
            System.out.println("No es pot iniciar l'aplicació. No es poden trobar els arxius del programa");
        }
    }

    //MÉTODES JOC
    static void imprimeixTitolPrograma(){
        System.out.println("""
                ENCERTA LES CAPITALS DELS PAÏSOS
                Es farà un total de 10 preguntes sobre la capital de 10 països.
                Al final es farà un recompte dels encerts i s'afegirà el seu nom a la classificació.
                A JUGAR!""");
    }
    static byte preguntaCapital (){
        Object pais = retornaUnPaisAleatori();
        String capital = demanaCapital(pais.toString());
        return retornaSiEsCorrecte(pais, capital);
    }
    static Object retornaUnPaisAleatori (){
        int numAleatori = (new Random()).nextInt(llistaPaisosCapitals.size()-1);
        Object[] paisos = llistaPaisosCapitals.keySet().toArray();
        return paisos[numAleatori];
    }
    static byte retornaSiEsCorrecte(Object pais, String capital){
        byte puntuacio = 0;
        capital = capital.replaceAll(" ","_");
        if (llistaPaisosCapitals.get(pais).equalsIgnoreCase(capital)){
            puntuacio = 1;
        }
        llistaPaisosCapitals.remove(pais);
        return puntuacio;
    }

    //MÉTODES PER LLEGIR I ESCRIURE TXT
    static void llegeixArxiuPaisosCapitals() throws IOException {
        try (FileReader fr = new FileReader("C:/Users/urier/Desktop/IT ACADEMY/CURSO ESPECIALIZACION JAVA & SPRING FRAMEWORKS/S1.03.JavaCollections/src/n1exercici3/countries.txt");
             BufferedReader br = new BufferedReader(fr)){
            ompleLlistaPaisosCapitals(br);
        }
    }
    static void ompleLlistaPaisosCapitals (BufferedReader arxiuPaisosCapitals) throws IOException {
        String cadena;
        String[] pais0capital1;
        while ((cadena = arxiuPaisosCapitals.readLine()) != null) {
            pais0capital1 = cadena.split(" ");
            llistaPaisosCapitals.put(pais0capital1[0], pais0capital1[1]);
        }
    }
    static void crearModificarArxiu (String nom, byte puntuacio) throws IOException {
        try (FileWriter fw = new FileWriter(new File(("C:/Users/urier/Desktop/IT ACADEMY/CURSO ESPECIALIZACION JAVA & SPRING FRAMEWORKS/S1.03.JavaCollections/src/n1exercici3/classificacio.txt")).getAbsoluteFile(), true);
             BufferedReader llegir = new BufferedReader(new FileReader(("C:/Users/urier/Desktop/IT ACADEMY/CURSO ESPECIALIZACION JAVA & SPRING FRAMEWORKS/S1.03.JavaCollections/src/n1exercici3/classificacio.txt")));
             BufferedWriter escriure = new BufferedWriter(fw)) {
            if ((llegir.readLine()) == null) {
                escriure.write("JUGADOR / PUNTUACIO\n");
            }
            nom = nom.replaceAll(" ", "_");
            escriure.write(nom + " / " + puntuacio + "\n");
        } catch (Exception e){
            System.out.println("Ho lamentem. No s'ha pogut registrar la partida. Error en l'assignació de la ruta de l'arxiu de guardat");
        }
    }

    //MÉTODES QUE DEMANEN DADES AL USUARI
    static String demanaNomUsuari(){
        return demanaString("Introdueixi el seu nom o nickname: ");
    }
    static String demanaCapital (String pais){
        pais = pais.replaceAll("_", " ");
        return demanaString("Quina és la capital de " + pais + "? ");
    }
    static String demanaString (String missatge) {
        Scanner input = new Scanner (System.in);
        System.out.print(missatge);
        return input.nextLine();
    }
}