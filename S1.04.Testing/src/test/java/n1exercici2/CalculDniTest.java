package n1exercici2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class CalculDniTest {

    @ParameterizedTest
    @ValueSource(strings = {"43571063R","12345678Z","45678901G","56789012B","89012345E"})
    public void testCalculLletraDni(String dni) {
        assertEquals(dni,(new CalculDni(dni)).getDni());
    }

    @ParameterizedTest
    @ValueSource(strings = {"67890123A","78901234A","90123456X","23456789A","34567890A"})
    public void testCalculLletraDni2(String dni){
        assertNotEquals(dni,(new CalculDni(dni)).getDni());
    }
}