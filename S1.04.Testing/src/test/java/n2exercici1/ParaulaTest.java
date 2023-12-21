package n2exercici1;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class ParaulaTest {

    @Test
    public void longitudEsIgual(){
        assertThat(new Paraula("Mordor").getParaula(), new LongitudEsIgualA(not(equalTo((8))), ("La longitud esperada"), "longitud"));
    }

}