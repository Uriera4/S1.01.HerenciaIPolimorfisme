package n3exercici1;

import java.util.Comparator;

public class CompararNomsPersona implements Comparator<Persona>{
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getNom().compareTo(p2.getNom());
    }
}
