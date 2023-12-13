package n1exercici1;
public class Producte {

    private String nom;
    private final float preu;

    public Producte (String nom, float preu){
        this.nom = nom;
        this.preu = preu;
    }

    public float getPreu (){
        return preu;
    }

}
