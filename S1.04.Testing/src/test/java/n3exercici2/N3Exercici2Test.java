package n3exercici2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class N3Exercici2Test {

    @Test
    public void mateixaReferencia(){
        Genere joan = new Masculi("Joan");
        Genere miquel = new Masculi("Miquel");
        assertThat(joan).hasSameClassAs(miquel);
    }
    @Test
    public void diferentReferencia(){
        Genere joan = new Masculi("Joan");
        Genere clara = new Femeni("Clara");
        assertThat(joan).doesNotHaveSameClassAs(clara);
    }
}
