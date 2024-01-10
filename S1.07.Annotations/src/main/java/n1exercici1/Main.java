package n1exercici1;

public class Main {
    public static void main(String[] args) {

        Treballador treballador = new Treballador ("Gerard","Noguera",15);
        Treballador treballadorP = new TreballadorPresencial("Oriol","Riera",15);
        Treballador treballadorO = new TreballadorOnline("Joan","Moreno",10);

        treballador.calcularSou(160);
        treballadorP.calcularSou(160);
        treballadorO.calcularSou(140);

    }
}