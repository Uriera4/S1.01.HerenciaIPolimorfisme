package n3exercici6;

public class ClasseQualsevol {

    static int[] llista;

    public ClasseQualsevol(int valors){
        llista = new int[valors];
        for(int i=0;i<valors;i++){
            llista[i] = (i+1);
        }
    }

    public Object getPosicio (int posicio) {
        try {
            return llista[posicio];
        } catch (ArrayIndexOutOfBoundsException e){
            return e.getMessage();
        }
    }
}
