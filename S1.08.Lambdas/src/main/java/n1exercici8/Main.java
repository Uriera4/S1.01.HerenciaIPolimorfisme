package n1exercici8;

public class Main {
    public static void main(String[] args) {

        Functional funcional = (cadena -> new StringBuilder(cadena).reverse().toString());
        System.out.println(funcional.reverse("hola"));

    }
}