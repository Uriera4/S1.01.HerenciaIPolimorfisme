package n1exercici2;

public class Main {

    public static void main (String [] args){

        GenericsMethods.metodeGeneric(new Persona("Oriol","Riera",30),"Hola",9);
        GenericsMethods.metodeGeneric(9,new Persona("Oriol","Riera",30), true);
        GenericsMethods.metodeGeneric("15","Hola", new Persona("Oriol","Riera",30));

    }

}
