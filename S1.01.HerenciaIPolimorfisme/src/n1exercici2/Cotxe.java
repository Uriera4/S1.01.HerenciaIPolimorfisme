package n1exercici2;
public class Cotxe {
    final static String MARCA = "Opel";
    static String model;
    final public double potencia;

    public Cotxe (String model, double potencia){
        Cotxe.model = model;
        this.potencia = potencia;
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
