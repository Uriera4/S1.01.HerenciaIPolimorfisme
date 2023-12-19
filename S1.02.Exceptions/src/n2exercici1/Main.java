package n2exercici1;

public class Main {
    public static void main (String[] args) {
            byte numero1 = Entrada.llegirByte("Introdueix un número sencer petit: ");
            int numero2 = Entrada.llegirInt("Introdueix un número sencer: ");
            float numero3 = Entrada.llegirFloat("Introdueix un número decimal: ");
            double numero4 = Entrada.llegirDouble("Introdueix un número decimal: ");

            char caracter = Entrada.llegirChar("Introdueix un sol carácter: ");
            String text = Entrada.llegirString("Introdueix un text: ");
            boolean siOno = (Entrada.llegirSiNo("Introdueix SI o NO: "));
            System.out.println(numero1 + ", " + numero2 + ", " + numero3 + ", " + numero4 + ", " + caracter + ", " + text + ", " + siOno);
    }
}
