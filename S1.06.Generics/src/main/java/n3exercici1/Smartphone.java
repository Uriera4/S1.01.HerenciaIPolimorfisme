package n3exercici1;

public class Smartphone implements Telefon{
    @Override
    public void trucar() {
        System.out.println("S'ha fet una trucada");
    }

    public void ferFotos(){
        System.out.println("S'ha fet una foto");
    }
}
