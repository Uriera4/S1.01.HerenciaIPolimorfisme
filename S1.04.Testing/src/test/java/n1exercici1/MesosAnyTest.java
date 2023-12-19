package n1exercici1;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;

public class MesosAnyTest {
    static TreeMap<Integer, String> llistaMesos = (new MesosAny()).getLlista();

    @Test
    @Order(1)
    public void testTamanyLlista(){
        assertEquals(12, llistaMesos.size()); //MIRA SI TÉ 12 POSICIONS
    }

    @Test
    @Order(2)
    public void testNoEsNula (){
        assertNotNull(llistaMesos); //MIRA QUE NO SIGUI NULA
    }

    @Test
    @Order(3)
    public void testEsAgost (){
        assertEquals("Agost", llistaMesos.get(8)); //MIRA SI LA POSICIÓ 8 ÉS AGOST
    }

}