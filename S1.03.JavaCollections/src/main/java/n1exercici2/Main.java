package n1exercici2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> llista1 = new ArrayList<>();
    static List<Integer> llista2 = new ArrayList<>();

    public static void main (String[] args){

        ompleLlista1();
        System.out.print(llista1);

        ompleLlista2();             //OMPLIM LLISTA2 A PARTIR DE LLISTA1 A L'INVERSA
        System.out.print("\n" + llista2);

        afegeixElementsAmbListIterator();
        System.out.print("\n" + llista2); //OMPLIM LLISTA2 AMB LISTITERATOR DE LA LLISTA1

    }
    static void ompleLlista1 (){
        for (int i=1; i<=10; i++){
            llista1.add(i);
        }
    }
    static void ompleLlista2 (){
        for (int i=0; i<llista1.size(); i++){
            llista2.add(llista1.get((llista1.size()-1)-i));
        }
    }
    static void afegeixElementsAmbListIterator (){
        int index = 0;
        while (llista1.listIterator(index).hasNext()){
            llista2.add(llista1.listIterator(index).next());
            index++;
        }
    }
}
