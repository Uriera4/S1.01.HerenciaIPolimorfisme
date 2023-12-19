package n3exercici1;

import java.util.ArrayList;

public class GestioButaques {

    private final ArrayList<Butaca> butaques;

    public GestioButaques (){
        butaques = new ArrayList<>();
    }

    public ArrayList<Butaca> getButaques (){
        return butaques;
    }
    public void afegirButaca (Butaca novaButaca) throws ExcepcioButacaOcupada {
        if (cercarButaca(novaButaca.getNombreDeFila(), novaButaca.getNombreDeSeient())==-1) {
            butaques.add(novaButaca);
        } else {
            throw new ExcepcioButacaOcupada("Aquesta butaca, actualment, ja està reservada");
        }
    }
    public void eliminarButaca (int nombreDeFila, int nombreDeSeient) throws ExcepcioButacaBuida {
        int posicio = cercarButaca(nombreDeFila, nombreDeSeient);
        if (posicio==-1) {
            throw new ExcepcioButacaBuida("Aquesta butaca, actualment, no està reservada");
        } else {
            butaques.remove(posicio);
        }
    }
    private int cercarButaca (int nombreDeFila, int nombreDeSeient){
        int posicio = 0;
        boolean trobada = false;
        while (posicio<butaques.size() && !trobada){
            if (butaques.get(posicio).equals(nombreDeFila, nombreDeSeient)){
                trobada = true;
            } else {
                posicio++;
            }
        }
        return posicioButaca(posicio, trobada);
    }
    private int posicioButaca (int posicio, boolean trobada){
        if (!trobada){
            posicio = -1;
        }
        return posicio;
    }
}
