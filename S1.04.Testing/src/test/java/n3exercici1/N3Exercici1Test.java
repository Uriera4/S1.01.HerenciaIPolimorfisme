package n3exercici1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class N3Exercici1Test {

    @Test
    public void valorsIguals (){
        Integer objecte1 = 5;
        Integer objecte2 = 5;
        assertThat(objecte1).isEqualTo(objecte2);
    }
    @Test
    public void valorsDiferents (){
        Integer objecte1 = 5;
        Integer objecte2 = 10;
        assertThat(objecte1).isNotEqualTo(objecte2);
    }

}