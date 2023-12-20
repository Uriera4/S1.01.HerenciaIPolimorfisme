package n3exercici1;

public class Motociclisme extends Noticia{

    public Motociclisme (String titular, String equip){
        super (titular);
        this.club = equip;
        this.preu = 100;
        this.puntuacio = 3;
    }

    public int calcularPreuNoticia(){
        if (clubEs("Honda") || clubEs("Yamaha")){
            preu += 50;
        }
        return preu;
    }
    public int calcularPuntuacioNoticia(){
        if (clubEs("Honda") || clubEs("Yamaha")){
            puntuacio += 3;
        }
        return puntuacio;
    }
}
