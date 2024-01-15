package n2exercici2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args){

        List<Integer> llistaNumeros = Arrays.asList(1,34,88,20,15,99,1563,15154,7);
        String cadena = llistaNumeros.stream().map(n -> (n%2==0 ? "e" : "o")+n).collect(Collectors.joining(", "));
        System.out.println(cadena);

    }



}
