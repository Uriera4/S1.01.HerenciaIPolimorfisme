package n3exercici6;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ClasseQualsevolTest {

    @Test
    public void throwExcepcioQuanToca(){
        try{
            assertThat(new ClasseQualsevol(5).getPosicio(5)).isInstanceOf(ArrayIndexOutOfBoundsException.class);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}