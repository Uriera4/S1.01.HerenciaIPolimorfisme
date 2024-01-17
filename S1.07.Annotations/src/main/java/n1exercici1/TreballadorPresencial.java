package n1exercici1;

public class TreballadorPresencial extends Treballador{

    private static int benzina = 200;

    public TreballadorPresencial(String nom, String cognom, int preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public void calcularSou(int horesTreballadesMes) {
        System.out.println("El sou es de " + ((horesTreballadesMes*this.preuHora)+benzina) + "€.");
    }
    @Deprecated
    public void retornaNom (){
        System.out.println(this.nom);
    }
}
