package n3exercici1;

public class Alumne {

    private final String nom;
    private final int edat;
    private final String curs;
    private final double nota;

    public Alumne (String nom, int edat, String curs, double nota){
        this.nom = nom;
        this.edat = edat;
        this.curs = curs;
        this.nota = nota;
    }

    public String getNom(){
        return nom;
    }
    public int getEdat(){
        return edat;
    }
    public String getCurs(){
        return curs;
    }
    public double getNota(){
        return nota;
    }

    public String toString(){
        return "Alumne: " + nom + ", Edat: " + edat + ", Cursant: " + curs + ", Nota: " + nota + ".";
    }
}
