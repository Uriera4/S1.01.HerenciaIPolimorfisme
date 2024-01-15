package n2exercici1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> llistaInicial = Arrays.asList("Angel","Adu","Abel","Bea","Didac","Don","Aba","Gerard","Uri","Ana","Miquel","Mar");
        List<String> llistaFinal = llistaInicial.stream().filter(nom -> nom.startsWith("A")&&nom.length()==3).toList();
        llistaFinal.forEach(System.out::println);

    }

}