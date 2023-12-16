package n3exercici1;

public class Persona {

    private final String nom;
    private final String cognom;
    private final String dni;

    public Persona (String nom, String cognom, String dni){
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
    }

    public boolean comparaDNI (String dni){
        return this.dni.equalsIgnoreCase(dni);
    }
    public String getNom (){
        return nom;
    }
    public String getCognom (){
        return cognom;
    }
    public String getDNI (){
        return dni;
    }
}
