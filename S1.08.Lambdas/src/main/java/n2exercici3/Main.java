package n2exercici3;

public class Main {
    public static void main (String[] args){

        Functional funcional = (a, b) -> a + b;
        System.out.println("La suma es: " + funcional.operacio(2,3));

        funcional = (a ,b) -> a - b;
        System.out.println("La suma es: " + funcional.operacio(2,3));

        funcional = (a, b) -> a*b;
        System.out.println("La suma es: " + funcional.operacio(2,3));

        funcional = (a, b) -> a/b;
        System.out.println("La suma es: " + funcional.operacio(2,3));

    }



}
