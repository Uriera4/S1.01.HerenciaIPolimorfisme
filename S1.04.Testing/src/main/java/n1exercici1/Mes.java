package n1exercici1;

public class Mes {
    private final String nom;

    public Mes (int posicio){
        this.nom = introdueixNom(posicio);
    }

    public String introdueixNom(int i){
        String[] mesos = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"};
        return mesos[i];
    }
    public String getNom() {
        return nom;
    }
}
