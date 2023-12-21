package n3exercici4;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class N3Exercici4Test {

    static ArrayList<Object> llistaObjectes = new ArrayList<>();
    static Objecte1 objecte1 = new Objecte1();
    static Objecte2 objecte2 = new Objecte2();
    static Objecte3 objecte3 = new Objecte3();
    static Objecte4 objecte4 = new Objecte4();

    @Test
    public void objectesEnOrdre(){
        llistaObjectes.add(objecte1);
        llistaObjectes.add(objecte2);
        llistaObjectes.add(objecte3);
        llistaObjectes.add(objecte4);
        assertThat(llistaObjectes).containsExactly(objecte1, objecte2, objecte3, objecte4);
    }
    @Test
    public void objectesEnQualsevolOrdre(){
        llistaObjectes.add(objecte1);
        llistaObjectes.add(objecte2);
        llistaObjectes.add(objecte3);
        llistaObjectes.add(objecte4);
        assertThat(llistaObjectes).containsExactlyInAnyOrder(objecte3, objecte1, objecte4, objecte2);
    }
    @Test
    public void objecteAfegitUnaVegada(){
        llistaObjectes.add(objecte2);
        llistaObjectes.add(objecte3);
        llistaObjectes.add(objecte4);
        llistaObjectes.add(objecte3);
        llistaObjectes.add(objecte4);
        assertThat(llistaObjectes).containsOnlyOnce(objecte2);
        assertThat(llistaObjectes).doesNotContain(objecte1);
    }
    @AfterEach
    public void buidaLluista(){
        llistaObjectes.clear();
    }


}
