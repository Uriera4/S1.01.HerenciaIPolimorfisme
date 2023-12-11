package n3exercici1;
public class Futbol extends Noticia{

    public Futbol (String titular, String competicio, String club, String jugador){
        super (titular);
        this.competicio = competicio;
        this.club = club;
        this.jugador = jugador;
        this.preu = 300;
        this.puntuacio = 5;
    }

    public int calcularPreuNoticia(){
        if (competicioEs("Lliga") || competicioEs("Lliga de Campions") ){
            preu += 100;
        }
        if (clubEs("Barça") || clubEs("Madrid")){
            preu += 100;
        }
        if (jugadorEs("Ferran Torres") || jugadorEs("Benzema")){
            preu += 50;
        }
        return preu;
    }
    public int calcularPuntuacioNoticia(){
        if (competicioEs("Lliga de Campions") ){
            puntuacio += 3;
        } else if (competicioEs("Lliga")){
            puntuacio += 2;
        }
        if (clubEs("Barça") || clubEs("Madrid")){
            puntuacio += 1;
        }
        if (jugadorEs("Ferran Torres") || jugadorEs("Benzema")){
            puntuacio += 1;
        }
        return puntuacio;
    }

}
