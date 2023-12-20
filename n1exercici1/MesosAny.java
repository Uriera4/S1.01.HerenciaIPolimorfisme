package n1exercici1;

import java.util.TreeMap;

public class MesosAny {

    private final TreeMap<Integer, String> llista;

    public MesosAny() {
        llista = new TreeMap<>();
        ompleLlista();
    }

    private String retornaNom(int i) {
        String[] mesos = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"};
        return mesos[i];
    }
    public void ompleLlista() {
        for (int i = 0; i < 12; i++) {
            llista.put(i + 1, retornaNom(i));
        }
    }
    public TreeMap<Integer, String> getLlista() {
        return llista;
    }

}
