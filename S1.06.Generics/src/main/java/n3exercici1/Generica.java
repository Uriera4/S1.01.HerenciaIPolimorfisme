package n3exercici1;

public class Generica {

    //Aquest mètode no pot utilitzar el mètode ferFotos de la classe Smartphone ja que només pot accedir als mètodes de la Interfície Telefon.
    public static <T extends Telefon> void metode1 (T t){
        t.trucar();
    }

    public static <T extends Smartphone> void metode2 (T t){
        t.trucar();
        t.ferFotos();
    }

}
