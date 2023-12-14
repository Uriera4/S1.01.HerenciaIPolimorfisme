package n2exercici1;

public class Restaurant {

    final private String nom;
    final private int puntuacio;

    public Restaurant (String nom, int puntuacio){
        this.nom = nom;
        this.puntuacio = puntuacio;
    }

    public boolean comparaNoms (Restaurant nouRestaurant){
        return this.nom.equalsIgnoreCase(nouRestaurant.getNom());
    }
    public boolean comparaPuntuacions (Restaurant nouRestaurant){
        return this.puntuacio==nouRestaurant.getPuntuacio();
    }
    public String getNom (){
        return nom;
    }
    public int getPuntuacio (){
        return puntuacio;
    }
}
