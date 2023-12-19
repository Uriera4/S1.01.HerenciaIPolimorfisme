package n3exercici1;

public abstract class Noticia {

    protected String titular;
    protected String text;
    protected int puntuacio;
    protected int preu;
    protected String competicio;
    protected String club;
    protected String jugador;

    public Noticia (String titular){
        this.titular = titular;
    }

    public String getTitular(){
        return titular;
    }
    public boolean comparaTitulars (String titular){
        return this.titular.equalsIgnoreCase(titular);
    }

    public abstract int calcularPreuNoticia();
    public abstract int calcularPuntuacioNoticia();
    public void imprimeixPreuNoticia(){
        System.out.println("El preu de la notícia " + getTitular() + " és de " + calcularPreuNoticia());
    }
    public void imprimeixPuntuacioNoticia(){
        System.out.println("La puntuació de la notícia " + getTitular() + " és de " + calcularPuntuacioNoticia());
    }
    public boolean competicioEs(String missatge){
        return competicio.equalsIgnoreCase(missatge);
    }
    public boolean clubEs(String missatge){
        return club.equalsIgnoreCase(missatge);
    }
    public boolean jugadorEs(String missatge){
        return jugador.equalsIgnoreCase(missatge);
    }
}