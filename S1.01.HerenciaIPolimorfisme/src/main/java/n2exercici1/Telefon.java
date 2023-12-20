package n2exercici1;

public abstract class Telefon {

    protected String marca;
    protected String model;

    public Telefon (String marca, String model){
        this.marca = marca;
        this.model = model;
    }

    public void trucar (String numero){
        System.out.println("S'està trucant al número " + numero + ".");
    }

}
