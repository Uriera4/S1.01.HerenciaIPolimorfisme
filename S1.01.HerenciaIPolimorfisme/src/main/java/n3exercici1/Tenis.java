package n3exercici1;

public class Tenis extends Noticia {

    public Tenis (String titular, String competicio, String tenista){
        super (titular);
        this.competicio = competicio;
        this.jugador = tenista;
        this.preu = 150;
        this.puntuacio = 4;
    }

    public int calcularPreuNoticia(){
        if (jugadorEs("Federer") || jugadorEs("Nadal") || jugadorEs("Djokovic")){
            preu += 100;
        }
        return preu;
    }
    public int calcularPuntuacioNoticia(){
        if (jugadorEs("Federer") || jugadorEs("Nadal") || jugadorEs("Djokovic")){
            puntuacio += 3;
        }
        return puntuacio;
    }
}