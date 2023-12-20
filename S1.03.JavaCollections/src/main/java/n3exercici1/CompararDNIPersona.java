package n3exercici1;

import java.util.Comparator;

public class CompararDNIPersona implements Comparator<Persona>{
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getDNI().compareTo(p2.getDNI());
    }
}
