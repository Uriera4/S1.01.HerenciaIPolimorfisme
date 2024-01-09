package n1exercici1;

public class Main {
    public static void main(String[] args) {

        NoGenericMethod n1exercici1 = new NoGenericMethod("argument1", "argument2", "argument3");
        System.out.println(n1exercici1);
        n1exercici1 = new NoGenericMethod("argument2", "argument3", "argument1");
        System.out.println(n1exercici1);
        n1exercici1 = new NoGenericMethod("argument3","argument1","argument2");
        System.out.println(n1exercici1);


    }
}