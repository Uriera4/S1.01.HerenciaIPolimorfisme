package n2exercici4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Object> llista = Arrays.asList(0, "hola", 15, "tu", 3597613, "esternoclidomastoideo", "4010203", "mar", 355, "ordinador", 1999999444, "gelat","apartament","23");

        // ORDENADA ALFABETICAMENT PEL PRIMER CARÀCTER
        llista.sort(Comparator.comparing(objecte -> objecte.toString().charAt(0)));
        llista.forEach(System.out::println);
        System.out.println();

        // PRIMER ORDENADA ALFABETICAMENT PEL PRIMER CARÀCTER LES PARAULES QUE CONTENEN "E", DESPRÉS LA RESTA
        llista.stream().filter(objecte -> objecte.toString().contains("e")).sorted(Comparator.comparing(objecte -> objecte.toString().charAt(0))).forEach(System.out::println);
        llista.stream().filter(objecte -> !objecte.toString().contains("e")).sorted(Comparator.comparing(objecte -> objecte.toString().charAt(0))).forEach(System.out::println);
        System.out.println();

        // MODIFICA ES PARAULES QUE CONTENEN UNA "A" I CANVIALA PER UN "4"
        llista.stream().map(objecte -> (objecte.toString().replace("a","4"))).forEach(System.out::println);
        System.out.println();

        // MOSTRA NOMÉS STRINGS NUMÈRICS, ENCARA QUE ESTIGUIN GUARDATS COM STRING
        llista.stream().filter(objecte -> objecte.toString().matches("[0-9]*")).forEach(System.out::println);
    }
}