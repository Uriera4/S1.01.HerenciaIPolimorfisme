package n1exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Venda novaVenda = new Venda();

    public static void main(String[] args) {

        titolPrograma();
        int opcioMenu;
        do {
            System.out.println(menuPrograma());
            opcioMenu = demanaOpcioMenu();
            accionaPrograma(opcioMenu);
        } while (opcioMenu != 0);
    }

    //COMENÇA EL PROGRAMA
    static void accionaPrograma(int opcioMenu) {
        switch (opcioMenu) {
            case 1:
                opcioAfegirNouProducte();
                break;
            case 2:
                opcioMostraPreuTotalProductes();
                break;
            case 0:
                opcioSortir();
                break;
        }
    }

    //OPCIO (1). AFEGIR NOU PRODUCTE
    static void opcioAfegirNouProducte() {
        novaVenda.afegeixProducte(new Producte(demanaNomProducte(), demanaPreuProducte()));
    }

    static String demanaNomProducte() {
        return demanaString("Indiqui el nom del producte: ");
    }

    static float demanaPreuProducte() {
        return demanaFloat("Indiqui el preu del producte: ");
    }

    //OPCIO (2). MOSTRA PREU TOTAL PRODUCTES
    static void opcioMostraPreuTotalProductes() {
        try {
            System.out.println("\nLa suma total del preu dels productes es de " + novaVenda.calcularTotal() + "€.");
        } catch (VendaBuidaException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException error) {
            System.out.println("\nLa suma total del preu dels productes es de " + novaVenda.getPreuTotalVenda() + "€.");
        }
    }

    //OPCIÓ (0) SORTIR DE L'APLICACIÓ
    static void opcioSortir() {
        System.out.println("\n Aplicació finalitzada. Adéu.");
    }

    //DEMANEM A L'USUARI OPCIÓ DEL MENÚ I VALIDACIÓ DE L'OPCIÓ
    static int demanaOpcioMenu() {
        return corregeixOpcioMenu(demanaInt("\n Indiqui què vol fer: "));
    }

    static int corregeixOpcioMenu(int opcioMenu) {
        while (!(opcioEsValida(opcioMenu))) {
            opcioMenu = demanaInt("\n No existeix aquesta opció.\n" + menuPrograma()
                    + "\n\n Indiqui què vol fer dins les opcions del menú: ");
        }
        return opcioMenu;
    }

    static boolean opcioEsValida(int opcioMenu) {
        return (majorIgualQue0(opcioMenu) && menorIgualQue2(opcioMenu));
    }

    static boolean majorIgualQue0(int x) {
        return x >= 0;
    }

    static boolean menorIgualQue2(int x) {
        return x <= 2;
    }

    //MISSATGES DE L'APLICACIÓ
    static void titolPrograma() {
        System.out.println("MOSTRA PREU TOTAL DE VENDA");
    }

    static String menuPrograma() {
        return """

                (1). Introduir un producte a la col·lecció
                (2). Mostra els productes de la col·lecció
                (0). Sortir de l'aplicació.""";
    }

    //MÉTODES INTRODUCCIÓ DADES USUARI
    static int demanaInt(String missatge) {
        Scanner input = new Scanner(System.in);
        int numero = 0;
        boolean correcte = false;
        do {
            System.out.print(missatge);
            try {
                numero = input.nextInt();
                correcte = true;
            } catch (InputMismatchException ex) {
                System.out.println("Error de format. Introdueixi un número sencer.");
            }
            input.nextLine();
        } while (!correcte);
        return numero;
    }

    static String demanaString(String missatge) {
        Scanner input = new Scanner(System.in);
        System.out.print(missatge);
        return input.nextLine();
    }

    static float demanaFloat(String missatge) {
        Scanner input = new Scanner(System.in);
        float numero = 0;
        boolean correcte = false;
        do {
            System.out.print(missatge);
            try {
                numero = input.nextFloat();
                correcte = true;
            } catch (InputMismatchException ex) {
                System.out.println("Error de format. Introdueixi un número.");
            }
            input.nextLine();
        } while (!correcte);
        return numero;
    }
}