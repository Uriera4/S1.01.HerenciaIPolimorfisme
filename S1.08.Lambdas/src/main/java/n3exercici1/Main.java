package n3exercici1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args){

        List<Alumne> llistaAlumnes = ompleLlista();

        // ALUMNES QUE COMENCEN PER "A"
        List<Alumne> llistaAlumnesA = llistaAlumnes.stream().filter(alumne -> alumne.getNom().startsWith("A")).toList();
        llistaAlumnesA.forEach(System.out::println);
        System.out.println();

        // ALUMNES AMB NOTA IGUAL O SUPERIOR A 5
        llistaAlumnes.stream().filter(alumne -> alumne.getNota()>=5).forEach(System.out::println);
        System.out.println();

        // ALUMNES AMB NOTA IGUAL O SUPERIOR A 5 I NO ESTUDIEN PHP
        llistaAlumnes.stream().filter(alumne -> alumne.getNota()>=5 && !alumne.getCurs().equals("PHP")).forEach(System.out::println);
        System.out.println();

        // ALUMNES MAJORS D'EDAT QUE FAN JAVA
        llistaAlumnes.stream().filter(alumne -> alumne.getEdat()>=18 && alumne.getCurs().equals("JAVA")).forEach(System.out::println);
    }

    public static List<Alumne> ompleLlista (){
        List<Alumne> llista = new ArrayList<>();
        llista.add(new Alumne("Oriol",30,"JAVA",10));
        llista.add(new Alumne("Arnau",36,"PYTHON",8.5));
        llista.add(new Alumne("Tamara",20,"PHP",5.3));
        llista.add(new Alumne("Andreu",15,"JAVA",7.1));
        llista.add(new Alumne("Brenda",10,"PYTHON",4.2));
        llista.add(new Alumne("Joan",25,"JAVA",1));
        llista.add(new Alumne("Claudia",18,"PHP",9.4));
        llista.add(new Alumne("Martina",60,"PYTHON",6));
        llista.add(new Alumne("Carla",90,"PHP",2.9));
        llista.add(new Alumne("Albeni",5,"JAVA",3.3));
        return llista;
    }

}
