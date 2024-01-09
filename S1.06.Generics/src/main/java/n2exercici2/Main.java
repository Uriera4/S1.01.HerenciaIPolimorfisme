package n2exercici2;

import n1exercici2.Persona;

public class Main {

    public static void main (String[] args){
        GenericsMethods.metodeGeneric("Hola", "String", 4, true, new Persona("Oriol","Riera",30));
        GenericsMethods.metodeGeneric(new Persona("Oriol","Riera",30), 4, true, false);
        GenericsMethods.metodeGeneric("Adeu");
    }

}
