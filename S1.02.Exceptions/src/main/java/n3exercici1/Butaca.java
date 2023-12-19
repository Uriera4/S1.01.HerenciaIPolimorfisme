package n3exercici1;

public class Butaca {

    private final int nombreDeFila;
    private final int nombreDeSeient;
    private final String nomPersona;

    public Butaca (int nombreDeFila, int nombreDeSeient, String nomPersona){
        this.nombreDeFila = nombreDeFila;
        this.nombreDeSeient = nombreDeSeient;
        this.nomPersona = nomPersona;
    }

    public int getNombreDeFila (){
        return nombreDeFila;
    }
    public int getNombreDeSeient (){
        return nombreDeSeient;
    }
    public String getNomPersona (){
        return nomPersona;
    }

    public boolean equals (int nombreDeFila, int nombreDeSeient){
        return this.nombreDeFila==nombreDeFila && this.nombreDeSeient==nombreDeSeient;
    }

    public String toString (){
        return "Fila: " + nombreDeFila + ", Seient: " + nombreDeSeient + ", Persona: " + nomPersona + ".";
    }

}
