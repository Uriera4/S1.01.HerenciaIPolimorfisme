package n3exercici1;

public class Basquet extends Noticia{

    public Basquet (String titular, String competicio, String club){
        super (titular);
        this.competicio = competicio;
        this.club = club;
        this.preu = 250;
        this.puntuacio = 4;
    }

    public int calcularPreuNoticia(){
        if (competicioEs("Eurolliga") ){
            preu += 75;
        }
        if (clubEs("Barça") || clubEs("Madrid")){
            preu += 75;
        }
        return preu;
    }
    public int calcularPuntuacioNoticia(){
        if (competicioEs("Eurolliga") ){
            puntuacio += 3;
        } else if (competicioEs("ACB")){
            puntuacio += 2;
        }
        if (clubEs("Barça") || clubEs("Madrid")){
            puntuacio += 1;
        }
        return puntuacio;
    }
}
