package n3exercici1;

public class F1 extends Noticia{

    public F1 (String titular, String escuderia){
        super (titular);
        this.club = escuderia;
        this.preu = 100;
        this.puntuacio = 4;
    }

    public int calcularPreuNoticia(){
        if (clubEs("Ferrari") || jugadorEs("Mercedes")){
            preu += 50;
        }
        return preu;
    }
    public int calcularPuntuacioNoticia(){
        if (clubEs("Ferrari") || jugadorEs("Mercedes")){
            puntuacio += 2;
        }
        return puntuacio;
    }
}