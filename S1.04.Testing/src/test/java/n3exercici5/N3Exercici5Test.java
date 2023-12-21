package n3exercici5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;

public class N3Exercici5Test {

    static HashMap<Integer, String> llista = new HashMap<>();

    @Test
    public void conteKeyConcreta(){
        llista.put(1, "u");
        llista.put(2, "dos");
        llista.put(3, "tres");
        llista.put(4, "quatre");
        llista.put(5, "cinc");
        assertThat(llista).containsKey(3);
    }
}
