package n1exercici1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> llistaInicial = Arrays.asList("pluja","nuvol","sol","temps","boira","vent","foc","bosc","muntanya","mar","riu","mon","terratremol","tramuntana","cascada","navegacio","aviacio","alpinisme");
        List<String> llistaFinal = llistaInicial.stream().filter(p -> p.contains("o")).toList();
        llistaFinal.forEach(System.out::println);

    }
}