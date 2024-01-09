package n2exercici2;

public class GenericsMethods {
    @SafeVarargs
    public static <T> void metodeGeneric (T... args){
        for (T t : args){
            System.out.println(t);
        }
    }
}
