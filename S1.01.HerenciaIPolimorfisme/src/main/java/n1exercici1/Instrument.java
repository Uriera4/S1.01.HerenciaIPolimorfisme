package n1exercici1;

public abstract class Instrument {
    protected final String nom;
    protected final double preu;

    public Instrument (String nom, double preu){
        this.nom = nom;
        this.preu = preu;
    }

    public String getNom (){
        return nom;
    }
    public double getPreu (){
        return preu;
    }

    public abstract void tocar();
}
