package n3exercici7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OptionalTest {

    @Test
    public void comprovaSiBuit (){
        Optional optional = new Optional();
        assertThat(optional).hasAllNullFieldsOrProperties();
    }

}