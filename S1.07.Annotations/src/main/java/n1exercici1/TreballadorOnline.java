package n1exercici1;

public class TreballadorOnline extends Treballador{

    private final int TARIFAINTERNET = 40;

    public TreballadorOnline(String nom, String cognom, int preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public void calcularSou(int horesTreballadesMes) {
        System.out.println("El sou es de " + ((horesTreballadesMes*this.preuHora)+TARIFAINTERNET) + "€.");
    }

    @Deprecated
    public void retornaNom (){
        System.out.println(this.nom);
    }
}
