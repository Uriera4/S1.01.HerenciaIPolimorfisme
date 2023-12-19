package n3exercici1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    static ArrayList<Redactor> llistaRedactors = new ArrayList<>();
    public static void main (String[] args) {

        titolPrograma();
        int opcioMenu;
        do {
            System.out.println(menuPrograma());
            opcioMenu = demanaOpcioMenu();
            accionaPrograma(opcioMenu);
        } while (opcioMenu!=0);
    }

    //COMENÇA EL PROGRAMA
    static void accionaPrograma (int opcioMenu){
        switch (opcioMenu) {
            case 1:
                opcioIntroduirRedactor();
                break;
            case 2:
                if (llistaRedactorsBuida()) {
                    imprimeixSiNoRedactors();
                } else {
                    opcioEliminarRedactor();
                }
                break;
            case 3:
                if (llistaRedactorsBuida()) {
                    imprimeixSiNoRedactors();
                } else {
                    opcioIntroduirNoticia();
                }
                break;
            case 4:
                if (llistaRedactorsBuida()) {
                    imprimeixSiNoRedactors();
                } else {
                    opcioEliminarNoticia();
                }
                break;
            case 5:
                if (llistaRedactorsBuida()) {
                    imprimeixSiNoRedactors();
                } else {
                    opcioMostrarNoticia();
                }
                break;
            case 6:
                if (llistaRedactorsBuida()) {
                    imprimeixSiNoRedactors();
                } else {
                    opcioCalcularPuntuacio();
                }
                break;
            case 7:
                if (llistaRedactorsBuida()) {
                    imprimeixSiNoRedactors();
                } else {
                    opcioCalcularPreu();
                }
                break;
            case 0:
                opcioSortir();
                break;
        }
    }

    //OPCIÓ (1) INTRODUIR REDACTOR
    static void opcioIntroduirRedactor () {
        String DNI;
        int index;
        boolean continuar;
        do {
            DNI = validaDNI(demanaString("\nIndiqui el DNI del redactor a incorporar: "));
            index = retornaIndexDNI(DNI);
            if (index<Main.llistaRedactors.size()) {
                imprimeixRedactorJaInclos();
                continuar = introduirAltreDNI();
            } else {
                Main.llistaRedactors.add(retornaRedactorInclos(DNI));
                avisRedactorInclos(seleccionaRedactor(index));
                continuar = false;
            }
        } while (continuar);
    }
    static String validaDNI(String DNI) {
        while (DNI.length()!=9 || !Character.isLetter(DNI.charAt(8))) {
            DNI = demanaString("El DNI no és vàlid. Ha de constar de 8 números i una lletra al final: ");
        }
        return DNI;
    }
    static int retornaIndexDNI (String DNI) {
        int index = 0;
        try {
            while (!DNIcoincideixen(index, DNI)) {
                index++;
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
        return index;
    }
    static boolean DNIcoincideixen(int index, String DNI) {
        return seleccionaRedactor(index).compararDNI(DNI);
    }
    static Redactor seleccionaRedactor (int index) {
        return Main.llistaRedactors.get(index);
    }
    static Redactor retornaRedactorInclos (String DNI) {
        return new Redactor(demanarNom(), DNI);
    }
    static String demanarNom() {
        return demanaString("\nIntrodueix el nom del redactor: ");
    }

    //OPCIÓ (2) ELIMINAR REDACTOR
    static void opcioEliminarRedactor () {
        String DNI;
        int index;
        boolean continuar;
        do {
            DNI = validaDNI(demanaString("\nIndiqui el DNI del redactor a eliminar: "));
            index = retornaIndexDNI(DNI);
            if (index<Main.llistaRedactors.size()) {
                avisEliminacio(seleccionaRedactor(index));
                Main.llistaRedactors.remove(index);
                continuar = false;
            } else {
                avisRedactorNoTrobat();
                continuar = introduirAltreDNI();
            }
        } while (continuar);
    }

    //OPCIÓ (3) INTRODUIR NOTÍCIA A UN REDACTOR
    static void opcioIntroduirNoticia () {
        String DNI;
        int index;
        boolean continuar;
        do {
            DNI = validaDNI(demanaString("\nIndiqui el DNI del redactor responsable de la notícia: "));
            index = retornaIndexDNI(DNI);
            if (index<Main.llistaRedactors.size()) {
                afegeixNoticia(Main.llistaRedactors.get(index));
                avisNoticiaCreada();
                continuar = false;
            } else {
                avisRedactorNoTrobat();
                continuar = introduirAltreDNI();
            }
        } while (continuar);
    }
    static void afegeixNoticia(Redactor redactorNoticia) {
        String tipusNoticia = validaTipusNoticia(demanaString("\nIndiqui quin tipus de notícia vol crear: " + menuTipusNoticies()));
        switch (tipusNoticia.toUpperCase()) {
            case "FUTBOL":
                redactorNoticia.afegeixNoticia(crearNoticiaFutbol());
                break;
            case "BASQUET":
                redactorNoticia.afegeixNoticia(crearNoticiaBasquet());
            case "TENIS":
                redactorNoticia.afegeixNoticia(crearNoticiaTenis());
            case "F1":
                redactorNoticia.afegeixNoticia(crearNoticiaF1());
            case "MOTOCICLISME":
                redactorNoticia.afegeixNoticia(crearNoticiaMotociclisme());
                break;
        }
    }
    static String validaTipusNoticia(String tipusNoticia) {
        while (noEstaAlaLlista(tipusNoticia)) {
            tipusNoticia = demanaString("Tipus no vàlid. Esculli un tipus de la llista: " + menuTipusNoticies());
        }
        return tipusNoticia;
    }
    static boolean noEstaAlaLlista(String tipusNoticia) {
        boolean noEsta = true;
        String x = tipusNoticia.toUpperCase();
        if (x.equals("FUTBOL") || x.equals("BASQUET") || x.equals("TENIS") || x.equals("F2") || x.equals("MOTOCICLISME")) {
            noEsta = false;
        }
        return noEsta;
    }
    static Futbol crearNoticiaFutbol() {
        return new Futbol (demanarTitular(), demanarCompeticio(), demanarClub(), demanarJugador());
    }
    static Basquet crearNoticiaBasquet() {
        return new Basquet (demanarTitular(), demanarCompeticio(), demanarClub());
    }
    static Tenis crearNoticiaTenis() {
        return new Tenis (demanarTitular(), demanarCompeticio(), demanarJugador());
    }
    static F1 crearNoticiaF1() {
        return new F1 (demanarTitular(), demanarClub());
    }
    static Motociclisme crearNoticiaMotociclisme() {
        return new Motociclisme (demanarTitular(), demanarClub());
    }
    static String demanarTitular() {
        return demanaString("\nIntrodueix el titular de la notícia: ");
    }
    static String demanarCompeticio() {
        return demanaString("\nIntrodueix el nom de la competició: ");
    }
    static String demanarClub() {
        return demanaString("\nIntrodueix el nom del club: ");
    }
    static String demanarJugador() {
        return demanaString("\nIntrodueix el nom del jugador: ");
    }

    //OPCIÓ (4) ELIMINAR NOTÍCIA
    static void opcioEliminarNoticia () {
        String DNI, titular;
        int index, indexNoticia;
        boolean continuar;
        do {
            DNI = validaDNI(demanaString("\nIndiqui el DNI del redactor responsable de la notícia: "));
            index = retornaIndexDNI(DNI);
            if (index<Main.llistaRedactors.size()) {
                if (llistaNoticiesBuida(index)) {
                    imprimeixSiNoNoticies();
                    continuar = false;
                } else {
                    titular = demanaString("\nIndiqui el titular de la notícia: ");
                    indexNoticia = seleccionaRedactor(index).retornaIndexNoticia(titular);
                    if (indexNoticia<seleccionaRedactor(index).llistaNoticies.size()) {
                        seleccionaRedactor(index).eliminaNoticia(indexNoticia);
                        avisNoticiaEliminada();
                        continuar = false;
                    } else {
                        avisNoticiaNoTrobada();
                        continuar = introduirAltreDNI();
                    }
                }
            } else {
                avisRedactorNoTrobat();
                continuar = introduirAltreDNI();
            }
        } while (continuar);
    }

    //OPCIÓ (5) MOSTRAR NOTÍCIES PER REDACTOR
    static void opcioMostrarNoticia () {
        String DNI;
        int index;
        boolean continuar;
        do {
            DNI = validaDNI(demanaString("\nIndiqui el DNI del redactor de qui vol veure les notícies assignades: "));
            index = retornaIndexDNI(DNI);
            if (index<Main.llistaRedactors.size()) {
                if (llistaNoticiesBuida(index)) {
                    imprimeixSiNoNoticies();
                    continuar = false;
                } else {
                    imprimeixNoticies(index);
                    continuar = false;
                }
            } else {
                avisRedactorNoTrobat();
                continuar = introduirAltreDNI();
            }
        } while (continuar);
    }
    static void imprimeixNoticies(int index) {
        for (int i=0; i<seleccionaRedactor(index).tamanyLlistaNoticies(); i++) {
            System.out.println("Noticia " + (i+1) + ": " + seleccionaRedactor(index).seleccionaTitularNoticia(i));
        }
    }

    //OPCIÓ (6) CALCULAR PUNTUACIÓ DE LA NOTÍCIA
    static void opcioCalcularPuntuacio(){
        String DNI, titular;
        int index, indexNoticia;
        boolean continuar;
        do {
            DNI = validaDNI(demanaString("\nIndiqui el DNI del redactor responsable de la notícia: "));
            index = retornaIndexDNI(DNI);
            if (index<Main.llistaRedactors.size()) {
                if (llistaNoticiesBuida(index)) {
                    imprimeixSiNoNoticies();
                    continuar = false;
                } else {
                    titular = demanaString("\nIndiqui el titular de la notícia: ");
                    indexNoticia = seleccionaRedactor(index).retornaIndexNoticia(titular);
                    if (indexNoticia<seleccionaRedactor(index).llistaNoticies.size()) {
                        seleccionaRedactor(index).seleccionaNoticia(indexNoticia).imprimeixPuntuacioNoticia();
                        continuar = false;
                    } else {
                        avisNoticiaNoTrobada();
                        continuar = introduirAltreDNI();
                    }
                }
            } else {
                avisRedactorNoTrobat();
                continuar = introduirAltreDNI();
            }
        } while (continuar);
    }

    //OPCIÓ (7) CALCULAR PREU DE LA NOTÍCIA
    static void opcioCalcularPreu(){
        String DNI, titular;
        int index, indexNoticia;
        boolean continuar;
        do {
            DNI = validaDNI(demanaString("\nIndiqui el DNI del redactor responsable de la notícia: "));
            index = retornaIndexDNI(DNI);
            if (index<Main.llistaRedactors.size()) {
                if (llistaNoticiesBuida(index)) {
                    imprimeixSiNoNoticies();
                    continuar = false;
                } else {
                    titular = demanaString("\nIndiqui el titular de la notícia: ");
                    indexNoticia = seleccionaRedactor(index).retornaIndexNoticia(titular);
                    if (indexNoticia<seleccionaRedactor(index).llistaNoticies.size()) {
                        seleccionaRedactor(index).seleccionaNoticia(indexNoticia).imprimeixPreuNoticia();
                        continuar = false;
                    } else {
                        avisNoticiaNoTrobada();
                        continuar = introduirAltreDNI();
                    }
                }
            } else {
                avisRedactorNoTrobat();
                continuar = introduirAltreDNI();
            }
        } while (continuar);
    }

    //OPCIÓ (0) SORTIR DE L'APLICACIÓ
    static void opcioSortir() {
        System.out.println("\n Aplicació finalitzada. Adéu.");
    }

    //DEMANEM A L'USUARI OPCIÓ DEL MENÚ I VALIDACIÓ DE L'OPCIÓ
    static int demanaOpcioMenu() {
        return corregeixOpcioMenu(demanaInt("\n Indiqui què vol fer: "));
    }
    static int corregeixOpcioMenu (int opcioMenu) {
        while (!(opcioEsValida(opcioMenu))) {
            opcioMenu=demanaInt("\n No existeix aquesta opció.\n" + menuPrograma()
                    + "\n\n Indiqui què vol fer dins les opcions del menú: ");
        }
        return opcioMenu;
    }
    static boolean opcioEsValida (int opcioMenu) {
        return (majorIgualQue0(opcioMenu) && menorIgualQue7(opcioMenu));
    }
    static boolean majorIgualQue0 (int x) {
        return x>=0;
    }
    static boolean menorIgualQue7 (int x) {
        return x<=7;
    }

    //CONDICIÓ PER CONTINUAR EL PROGRAMA
    static boolean introduirAltreDNI() {
        return aseguraSiNo(demanaString("\nVol introduir un altre DNI? (SI/NO) ")).equalsIgnoreCase("SI");
    }
    static String aseguraSiNo (String paraula) {
        while (!(paraula.equalsIgnoreCase("SI")) && !(paraula.equalsIgnoreCase("NO"))) {
            paraula = demanaString("La resposta no és vàlida. Indiqui SI o NO: ");
        }
        return paraula;
    }
    static boolean llistaRedactorsBuida() {
        return llistaRedactors.isEmpty();
    }
    static boolean llistaNoticiesBuida(int index) {
        return seleccionaRedactor(index).llistaNoticies.isEmpty();
    }

    //MISSATGES DE L'APLICACIÓ
    static void titolPrograma(){
        System.out.println("Aplicació de control de noticies i redactors");
    }
    static String menuPrograma() {
        return """

                 MENÚ DE L'APLICACIÓ:
                (0). Sortir de l'aplicació
                (1). Introduir redactor
                (2). Eliminar redactor
                (3). Introduir noticia a un redactor
                (4). Eliminar noticia
                (5). Mostrar totes les notícies per redactor
                (6). Calcular puntuació de la notícia
                (7). Calcular preu de la notícia""";
    }
    static void imprimeixRedactorJaInclos() {
        System.out.println("Aquest redactor ja està inclòs.");
    }
    static void avisRedactorInclos(Redactor nouRedactor) {
        System.out.println("El redactor " + nouRedactor.getNom() + " ha estat inclòs.");
    }
    static void imprimeixSiNoRedactors() {
        System.out.println("\nAcció no realitzable. No hi ha cap redactor donat d'alta.");
    }
    static void avisEliminacio(Redactor redactorEscollit) {
        System.out.println("El redactor " + redactorEscollit.getNom() + " ha estat eliminat.");
    }
    static void avisRedactorNoTrobat() {
        System.out.println("\nAquest redactor no està donat d'alta.");
    }
    static void avisNoticiaCreada() {
        System.out.println("\nLa notícia ha estat creada.");
    }
    static String menuTipusNoticies() {
        return """

                FUTBOL
                BASQUET
                TENIS
                F1
                MOTOCICLISME
                """;
    }
    static void imprimeixSiNoNoticies() {
        System.out.println("\nAcció no realitzable. Aquest redactor no té cap notícia assignada.");
    }
    static void avisNoticiaNoTrobada() {
        System.out.println("\nLa notícia no existeix o no pertany a aquest redactor.");
    }
    static void avisNoticiaEliminada() {
        System.out.println("\nLa notícia ha estat eliminada.");
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
