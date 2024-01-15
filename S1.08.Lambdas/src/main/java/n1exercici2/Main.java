package n1exercici2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> llistaInicial = Arrays.asList("pluja","nuvol","sol","temps","boira","vent","foc","bosc","muntanya","mar","riu","mon","terratremol","tramuntana","cascada","navegacio","aviacio","alpinisme");
        List<String> llistaFinal = llistaInicial.stream().filter(p -> p.contains("o")&&p.length()>5).toList();
        llistaFinal.forEach(System.out::println);

    }
}