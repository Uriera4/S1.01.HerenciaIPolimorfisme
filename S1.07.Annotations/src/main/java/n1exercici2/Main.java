package n1exercici2;

import n1exercici1.TreballadorOnline;
import n1exercici1.TreballadorPresencial;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        TreballadorPresencial treballadorP = new TreballadorPresencial("Oriol","Riera",15);
        TreballadorOnline treballadorO = new TreballadorOnline("Joan","Moreno",10);

        treballadorP.retornaNom();
        treballadorO.retornaNom();
    }
}
