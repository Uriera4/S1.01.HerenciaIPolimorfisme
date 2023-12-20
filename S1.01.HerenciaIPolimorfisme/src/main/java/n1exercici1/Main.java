package n1exercici1;

public class Main {
    public static void main(String[] args) {

        Instrument nouVent = new Vent("Flauta", 20.53);
        nouVent.tocar();
        tocaInstrument(nouVent);

        Instrument nouCorda = new Corda("Guitarra", 38.7);
        nouCorda.tocar();
        tocaInstrument(nouCorda);

        Instrument nouPercussio = new Percussio("Batería", 139.99);
        nouPercussio.tocar();
        tocaInstrument(nouPercussio);
    }

    static void tocaInstrument (Instrument nouInstrument){
        nouInstrument.tocar();
    }
}