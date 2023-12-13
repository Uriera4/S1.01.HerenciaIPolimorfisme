package n1exercici2;
public class Cotxe {
    final private static String MARCA = "Opel";
    private static String model;
    final private double potencia;

    public Cotxe (String model, double potencia){
        inicialitzaModel(model);
        this.potencia = potencia;
    }

    private static void inicialitzaModel (String model){
        Cotxe.model = model;
    }
    public static void frenar(){
        System.out.println("El vehícle està frenant");
    }
    public void accelerar(){
        System.out.println("El vehícle està accelerant");
    }

    public void setModel (String model){
        Cotxe.model = model;
    }

    public String toString(){
        return "El cotxe de marca " + MARCA + " és un model " + model + " amb potència de " + potencia + " cavalls.";
    }

}
