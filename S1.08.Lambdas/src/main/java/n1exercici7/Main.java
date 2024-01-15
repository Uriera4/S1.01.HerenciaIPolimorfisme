package n1exercici7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Object> llista = Arrays.asList(0, "hola", 15, "tu", 3597613, "esternoclidomastoideo", 4010203, "mar", 355, "ordinador", 1999999444);
        llista.sort(Comparator.comparing(objecte -> objecte.toString().length()).reversed());
        llista.forEach(System.out::println);

    }
}