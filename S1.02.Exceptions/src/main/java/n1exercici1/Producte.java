package n1exercici1;

public class Producte {

    private final String nom;
    private float preu;

    public Producte (String nom, float preu){
        this.nom = nom;
        this.preu = preu;
    }

    public float getPreu (){
        return preu;
    }

}
