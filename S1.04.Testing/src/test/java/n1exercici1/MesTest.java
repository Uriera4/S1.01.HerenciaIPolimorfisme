package n1exercici1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;

class MesTest {

    static TreeMap<Integer, Mes> llistaMesos = new TreeMap<>();
    @Test
    @Order(1)
    public void testTamanyLlista(){
        for (int i=0; i<12; i++){
            llistaMesos.put(i+1, (new Mes(i)));
        }
        assertEquals(12, llistaMesos.size()); //MIRA SI TÉ 12 POSICIONS
    }

    @Test
    @Order(2)
    public void testNoEsNula (){
        assertNotEquals(null, llistaMesos.firstKey()); //MIRA SI ESTÀ PLENA
    }

    @Test
    @Order(3)
    public void testEsAgost (){
        assertEquals("Agost", llistaMesos.get(8).getNom()); //MIRA SI LA POSICIÓ 8 ÉS AGOST
    }

}