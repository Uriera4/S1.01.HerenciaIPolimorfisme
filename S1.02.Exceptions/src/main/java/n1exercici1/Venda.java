package n1exercici1;

import java.util.ArrayList;

public class Venda {

    private final ArrayList<Producte> colleccioProductes;
    private float preuTotalVenda;

    public Venda (){
        colleccioProductes = new ArrayList<>();
        preuTotalVenda = 0;
    }

    public float calcularTotal () throws VendaBuidaException, IndexOutOfBoundsException{
        if (colleccioProductes.isEmpty()){
            throw new VendaBuidaException("\nPer fer una venda primer has d'afegir productes");
        } else {
            for (int i=0; i<=colleccioProductes.size(); i++){
                preuTotalVenda += colleccioProductes.get(i).getPreu();
            }
        }
        return preuTotalVenda;
    }
    public float getPreuTotalVenda(){
        return preuTotalVenda;
    }
    public void afegeixProducte (Producte nouProducte) {
        colleccioProductes.add(nouProducte);
    }
}
