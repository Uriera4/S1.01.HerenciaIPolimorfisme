package n3exercici3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class N3Exercici3Test {

    @Test
    public void arraysIdentics(){
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        assertThat(array1).containsExactly(array2);
    }

}
