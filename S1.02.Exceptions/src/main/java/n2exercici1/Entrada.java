package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Entrada {
    static Scanner input = new Scanner (System.in);
    public static byte llegirByte (String missatge) throws InputMismatchException{
        byte numero = 0;
        boolean correcte = false;
        do{
            System.out.print(missatge);
            try {
                numero = input.nextByte();
                correcte = true;
            } catch (InputMismatchException error){
                System.out.println("Error de format. Introdueixi un número sencer entre -128 i 127");
            }
            input.nextLine();
        } while (!correcte);
        return numero;
    }
    public static int llegirInt (String missatge) throws InputMismatchException{
        int numero = 0;
        boolean correcte = false;
        do{
            System.out.print(missatge);
            try {
                numero = input.nextInt();
                correcte = true;
            } catch (InputMismatchException error){
                System.out.println("Error de format. Introdueixi un número sencer");
            }
            input.nextLine();
        } while (!correcte);
        return numero;
    }
    public static float llegirFloat (String missatge) throws InputMismatchException{
        float numero = 0F;
        boolean correcte = false;
        do{
            System.out.print(missatge);
            try {
                numero = input.nextFloat();
                correcte = true;
            } catch (InputMismatchException error){
                System.out.println("Error de format. Introdueixi un número i asseguri que escriu els decimals amb ',' enlloc de '.'");
            }
            input.nextLine();
        } while (!correcte);
        return numero;
    }
    public static double llegirDouble (String missatge) throws InputMismatchException{
        double numero = 0;
        boolean correcte = false;
        do{
            System.out.print(missatge);
            try {
                numero = input.nextDouble();
                correcte = true;
            } catch (InputMismatchException error){
                System.out.println("Error de format. Introdueixi un número i asseguri que escriu els decimals amb ',' enlloc de '.'");
            }
            input.nextLine();
        } while (!correcte);
        return numero;
    }

    public static char llegirChar (String missatge) {
        char caracter = 'a';
        boolean correcte = false;
        do {
            System.out.print(missatge);
            try {
                caracter = comprovaSiUnCaracter(input.nextLine());
                correcte = true;
            } catch (MesDunCaracterException error){
                System.out.println(error.getMessage());
            }
        } while (!correcte);
        return caracter;
    }
    static char comprovaSiUnCaracter (String text) throws MesDunCaracterException{
        char caracter;
        if (text.length()==1){
            caracter = (char)text.codePointAt(0);
        } else {
            throw new MesDunCaracterException ("Error de format. Ha d'introduir un sol carácter");
        }
        return caracter;
    }

    public static String llegirString (String missatge) {
        String cadenaText = "";
        boolean correcte = false;
        do {
            System.out.print(missatge);
            try {
                cadenaText = comprovaSiNomesUnCaracter(input.nextLine());
                correcte = true;
            } catch (NomesUnCaracterException error){
                System.out.println(error.getMessage());
            }
        } while (!correcte);
        return cadenaText;
    }
    static String comprovaSiNomesUnCaracter (String text) throws NomesUnCaracterException{
        String cadenaText;
        if (text.length()==1){
            throw new NomesUnCaracterException ("Error de format. Ha d'introduir més d'un carácter");
        } else {
            cadenaText = text;
        }
        return cadenaText;
    }

    public static boolean llegirSiNo (String missatge) {
        boolean siOno = true;
        boolean correcte = false;
        do {
            System.out.print(missatge);
            try {
                siOno = comprovaSioNo(input.nextLine());
                correcte = true;
            } catch (NomesSioNoException error){
                System.out.println(error.getMessage());
            }
        } while (!correcte);
        return siOno;
    }
    static boolean comprovaSioNo (String opcio) throws NomesSioNoException{
        boolean siOno;
        if (opcio.equalsIgnoreCase("SI")){
            siOno = true;
        } else if (opcio.equalsIgnoreCase("NO")){
            siOno = false;
        } else {
            throw new NomesSioNoException ("Error de format. Ha d'introduir SI o NO");
        }
        return siOno;
    }
}
