package n2exercici1;

public class Restaurant{

    final private String nom;
    final private int puntuacio;

    public Restaurant (String nom, int puntuacio){
        this.nom = nom;
        this.puntuacio = puntuacio;
    }

    @Override
    public boolean equals(Object obj){
        boolean iguals = false;
        if (obj instanceof Restaurant){
            Restaurant restaurant = (Restaurant) obj;
            if (this.nom == restaurant.nom && this.puntuacio == restaurant.puntuacio){
                iguals = true;
            }
        }
        return iguals;
    }

    public String getNom (){
        return nom;
    }
    public int getPuntuacio (){
        return puntuacio;
    }
}
