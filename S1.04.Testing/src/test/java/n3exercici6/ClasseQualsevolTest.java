package n3exercici6;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ClasseQualsevolTest {

    @Test()
    public void throwExcepcioQuanToca(){
        int numero = 5;
        assertThat(new ClasseQualsevol(numero).getPosicio(numero)).isEqualTo("Index " + numero + " out of bounds for length " + numero);
    }
}