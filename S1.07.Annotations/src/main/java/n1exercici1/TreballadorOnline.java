package n1exercici1;

public class TreballadorOnline extends Treballador{

    final private int tarifaInternet = 40;

    public TreballadorOnline(String nom, String cognom, int preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public void calcularSou(int horesTreballadesMes) {
        System.out.println("El sou es de " + ((horesTreballadesMes*preuHora)+tarifaInternet) + "€.");
    }

    @Deprecated
    public void retornaNom (){
        System.out.println(nom);
    }
}
