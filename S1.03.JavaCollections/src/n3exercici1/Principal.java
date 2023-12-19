package n3exercici1;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    static ArrayList<Persona> llistaPersones = new ArrayList<>();
    static String ruta = retornaDirectori();
    public static void main (String[] args) {
        try{
            llegeixArxiuLlistaPersones();
            titolPrograma();
            accionaPrograma();
        } catch (IOException e){
            System.out.println("Error. No es troben els arxius del programa");
        }
    }

    //COMENÇA EL PROGRAMA
    static void accionaPrograma (){
        int opcioMenu;
        do {
            opcioMenu = demanaOpcioMenu();
            switch (opcioMenu) {
                case 1:
                    opcioIntroduirPersona();
                    break;
                case 2:
                    if (llistaPersones.isEmpty()) {
                        imprimeixLluistaBuida();
                    } else {
                        opcioOrdenarLlistaNomAZ();
                    }
                    break;
                case 3:
                    if (llistaPersones.isEmpty()) {
                        imprimeixLluistaBuida();
                    } else {
                        opcioOrdenarLlistaNomZA();
                    }
                    break;
                case 4:
                    if (llistaPersones.isEmpty()) {
                        imprimeixLluistaBuida();
                    } else {
                        opcioOrdenarLlistaCognomAZ();
                    }
                    break;
                case 5:
                    if (llistaPersones.isEmpty()) {
                        imprimeixLluistaBuida();
                    } else {
                        opcioOrdenarLlistaCognomZA();
                    }
                    break;
                case 6:
                    if (llistaPersones.isEmpty()) {
                        imprimeixLluistaBuida();
                    } else {
                        opcioOrdenarLlistaDNI19();
                    }
                    break;
                case 7:
                    if (llistaPersones.isEmpty()) {
                        imprimeixLluistaBuida();
                    } else {
                        opcioOrdenarLlistaDNI91();
                    }
                    break;
                case 0:
                    opcioSortir();
                    break;
            }
        } while (opcioMenu!=0);
    }

    //OPCIÓ (1) INTRODUIR PERSONA
    static void opcioIntroduirPersona () {
        try{
            String dni = demanaDNI();
            if (llistaPersones.isEmpty() || !dniRegistrat(dni)){
                String nom = demanaDada("nom");
                String cognom = demanaDada("cognom o cognoms");
                llistaPersones.add(new Persona(nom, cognom, dni));
                guardaArxiuLlistaPersones(nom, cognom, dni);
                avisPersonaInclosa();
            } else {
                System.out.println("Aquest DNI ja està registrat");
            }
        } catch (ExcepcioNoIntroduit e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error. No es troben els arxius del programa");
        }
    }
    static String demanaDNI () throws ExcepcioNoIntroduit {
        String dni;
        boolean continuar;
        do{
            dni = demanaString("\nIndiqui el DNI del redactor a incorporar: ");
            try {
                validaDNI(dni);
                continuar = false;
            } catch (ExcepcioDNIincorrecte e){
                System.out.println(e.getMessage());
                dni = null;
                continuar = introduirAltreDNI();
            }
        } while (continuar);
        if (dni==null){
            throw new ExcepcioNoIntroduit("No s'ha pogut portar a terme l'introducció d'una persona al sistema");
        }
        return dni;
    }
    static void validaDNI (String dni) throws ExcepcioDNIincorrecte {
        if (dni.length()!=9 || !Character.isLetter(dni.charAt(8))) {
            throw new ExcepcioDNIincorrecte("El DNI introduït no és correcte");
        } else {
            try {
                int numeros = Integer.parseInt(dni.substring(0,8));
                if (!(lletraDNI(numeros).equalsIgnoreCase(dni.substring(8)))){
                    throw new ExcepcioDNIincorrecte("El DNI introduït no és correcte");
                }
            } catch (NumberFormatException e) {
                throw new ExcepcioDNIincorrecte("El DNI introduït no és correcte");
            }
        }
    }
    static String lletraDNI(int numerosDNI){
        String[] lletresDNI = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        int residu = numerosDNI % 23;
        return lletresDNI[residu];
    }
    static boolean dniRegistrat(String dni){
        boolean coincideix = false;
        int index = 0;
        do {
            if (llistaPersones.get(index).comparaDNI(dni)){
                coincideix = true;
            }
            index++;
        } while (!coincideix && index<llistaPersones.size());
        return coincideix;
    }
    static String demanaDada (String instruccio){
        String dada = "";
        boolean correcte = false;
        do {
            try {
                dada = validaDada(instruccio);
                correcte = true;
            } catch (ExcepcioConteNumeros e){
                System.out.println(e.getMessage());
            }
        } while (!correcte);
        return dada;
    }
    static String validaDada (String instruccio) throws ExcepcioConteNumeros {
        String dada = demanaString("Introdueixi el seu " + instruccio + ": ");
        if (dada.matches(".*[0-9].*")){
            throw new ExcepcioConteNumeros("Introdueixi un " + instruccio + " real, sense números.");
        }
        return dada;
    }

    //OPCIONS (2-5) MOSTRAR PERSONES ORDENADES PER NOM [A-Z] I [Z-A]
    static void opcioOrdenarLlistaNomAZ (){
        llistaPersones.sort(new CompararNomsPersona());
        imprimeixLlistaOrdenada();
    }
    static void opcioOrdenarLlistaCognomZA (){
        llistaPersones.sort(new CompararNomsPersona().reversed());
        imprimeixLlistaOrdenada();
    }
    static void opcioOrdenarLlistaCognomAZ (){
        llistaPersones.sort(new CompararCognomsPersona());
        imprimeixLlistaOrdenada();
    }
    static void opcioOrdenarLlistaNomZA (){
        llistaPersones.sort(new CompararCognomsPersona().reversed());
        imprimeixLlistaOrdenada();
    }
    static void opcioOrdenarLlistaDNI19 (){
        llistaPersones.sort(new CompararDNIPersona());
        imprimeixLlistaOrdenada();
    }
    static void opcioOrdenarLlistaDNI91 (){
        llistaPersones.sort(new CompararDNIPersona().reversed());
        imprimeixLlistaOrdenada();
    }
    static void imprimeixLlistaOrdenada (){
        System.out.println("___NOM___  ___COGNOM___  ___NIF___");
        for (Persona persona : llistaPersones) {
            System.out.println(persona.getNom() + "     " + persona.getCognom() + "     " + persona.getDNI());
        }
    }

    //OPCIÓ (0) SORTIR DE L'APLICACIÓ
    static void opcioSortir() {
        System.out.println("\n Aplicació finalitzada. Adéu.");
    }

    //DEMANEM A L'USUARI OPCIÓ DEL MENÚ I VALIDACIÓ DE L'OPCIÓ
    static int demanaOpcioMenu()  {
        System.out.println(menu());
        int opcioMenu = demanaInt("Introdueix una opció del menú: ");
        try{
            validaOpcio(opcioMenu);
        } catch (ExcepcioOpcioNoValida e){
            System.out.println(e.getMessage());
        }
        return opcioMenu;
    }
    static void validaOpcio (int opcioMenu) throws ExcepcioOpcioNoValida {
        if (opcioMenu<0 || opcioMenu>7){
            throw new ExcepcioOpcioNoValida("Aquesta opció no existeix");
        }
    }

    //CONDICIÓ PER CONTINUAR EL PROGRAMA
    static boolean introduirAltreDNI() {
        boolean siOno = true;
        boolean correcte = false;
        do {
            try {
                siOno = comprovaSioNo(demanaString("\nVol introduir un altre DNI? (SI/NO) "));
                correcte = true;
            } catch (NomesSioNoException e) {
                System.out.println(e.getMessage());
            }
        } while (!correcte);
        return siOno;
    }
    static boolean comprovaSioNo (String opcio) throws NomesSioNoException {
        return switch (opcio.toUpperCase()) {
            case "SI" -> true;
            case "NO" -> false;
            default -> throw new NomesSioNoException("Error de format. Ha d'introduir SI o NO");
        };
    }

    //MÉTODES PER LLEGIR I ESCRIURE TXT
    static String retornaDirectori (){
        return demanaString("Introdueix la ruta on està l'arxiu llistaPerones.csv: ");
    }
    static void llegeixArxiuLlistaPersones() throws IOException {
        try (FileReader fr = new FileReader((ruta+"/llistaPersones.csv"));
             BufferedReader br = new BufferedReader(fr)){
            ompleLlistaPersones(br);
        }
    }
    static void ompleLlistaPersones (BufferedReader arxiuLlistaPersones) throws IOException {
        String fila;
        boolean titolArxiu = true;
        String[] nom0cognom1dni2;
        while ((fila = arxiuLlistaPersones.readLine()) != null) {
            if (titolArxiu){
                titolArxiu = false;
            } else {
                nom0cognom1dni2 = fila.split(";");
                llistaPersones.add(new Persona(nom0cognom1dni2[0], nom0cognom1dni2[1], nom0cognom1dni2[2]));
            }
        }
    }
    static void guardaArxiuLlistaPersones (String nom, String cognom, String dni) throws IOException{
        try (FileWriter fw = new FileWriter(new File((ruta+"/llistaPersones.csv")).getAbsoluteFile(), true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter escriure = new PrintWriter (bw)) {
            escriure.println(nom + ";" + cognom + ";" + dni);
            escriure.flush();
        }
    }

    //MISSATGES DE L'APLICACIÓ
    static void titolPrograma(){
        System.out.println("CONTROL D'ACCÈS AL SISTEMA\n" +
                "Aquesta aplicació serveix per mantenir un control de qui accedeix al sistema.");
    }
    static String menu() {
        return """

                 MENÚ DE L'APLICACIÓ:
                (1). Introduir persona
                (2). Mostrar les persones ordenades per nom (A-Z)
                (3). Mostrar les persones ordenades per nom (Z-A)
                (4). Mostrar les persones ordenades per cognom (A-Z)
                (5). Mostrar les persones ordenades per cognom (Z-A)
                (6). Mostrar les persones ordenades per DNI (1-9)
                (7). Mostrar les persones ordenades per DNI (9-1)
                (0). Sortir""";
    }
    static void avisPersonaInclosa(){
        System.out.println("Persona introduïda");
    }
    static void imprimeixLluistaBuida (){
        System.out.println("Actualment la llista està buida");
    }

    //MÉTODES INTRODUCCIÓ DADES USUARI
    static String demanaString (String missatge) {
        Scanner input = new Scanner (System.in);
        System.out.print(missatge);
        return input.nextLine();
    }
    static int demanaInt(String mensaje) {
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
