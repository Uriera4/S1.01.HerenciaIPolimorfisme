package n1exercici1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

    static ArrayList<Month> llistaMesosArrayList = new ArrayList<>();
    static HashSet<Month> llistaMesosHashSet = new HashSet<>();

    public static void main (String[] args){

        Month agost = new Month("Agost");

        ompleLlistaMesosArrayList();
        System.out.println(llistaMesosArrayList);           //LLISTA AMB ELS 11 ELEMENTS
        llistaMesosArrayList.add(6, agost);
        System.out.println(llistaMesosArrayList);           //LLISTA AMB ELS 12 ELEMENTS ORDENATS PER VALOR

        llistaMesosHashSet.addAll(llistaMesosArrayList);
        System.out.println(llistaMesosHashSet);             //LLISTA AMB ELS 12 ELEMENTS AFEGITS DEL ARRAYLIST
        llistaMesosHashSet.addAll(llistaMesosArrayList);
        System.out.println(llistaMesosHashSet);             //DEMOSTRACIÓ LLISTA HASHSET ON NO HA INTRODUIT ELS REPLICATS.
        llistaMesosHashSet.add(agost);
        System.out.println(llistaMesosHashSet);             //DEMOSTRACIÓ LLISTA HASHSET ON NO HA INTRODUIT L'OBJECTE REPLICAT.

        recorreLlistaAmbFor();
        System.out.println();
        recorreLlistaAmbIterator();

    }

    static void ompleLlistaMesosArrayList (){
        llistaMesosArrayList.add(new Month("Gener"));
        llistaMesosArrayList.add(new Month("Febrer"));
        llistaMesosArrayList.add(new Month("Març"));
        llistaMesosArrayList.add(new Month("Abril"));
        llistaMesosArrayList.add(new Month("Juny"));
        llistaMesosArrayList.add(new Month("Juliol"));
        llistaMesosArrayList.add(new Month("Setembre"));
        llistaMesosArrayList.add(new Month("Octubre"));
        llistaMesosArrayList.add(new Month("Novembre"));
        llistaMesosArrayList.add(new Month("Desembre"));
    }
    static void recorreLlistaAmbFor(){
        for(Month mes: llistaMesosHashSet){
            System.out.print(mes + " ");
        }
    }
    static void recorreLlistaAmbIterator(){
        Iterator<Month> iteracio = llistaMesosHashSet.iterator();
        while (iteracio.hasNext()){
            System.out.print(iteracio.next() + " ");
        }
    }
}
