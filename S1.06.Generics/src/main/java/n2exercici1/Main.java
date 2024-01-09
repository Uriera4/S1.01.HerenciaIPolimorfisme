package n2exercici1;

import n1exercici2.Persona;

public class Main {

    public static void main (String [] args){

        GenericsMethods.metodeGeneric("Hola", new Persona("Oriol","Riera",30), 9);
        GenericsMethods.metodeGeneric("String", false, new Persona("Oriol","Riera",30));

    }
}
