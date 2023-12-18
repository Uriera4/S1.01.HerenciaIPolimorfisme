package n1exercici2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculoDniTest {
    @Test
    void testCalculLletraDni() {
        assertEquals("43571063R",(new CalculoDni("43571063R")).getDni());
        assertEquals("12345678Z",(new CalculoDni("12345678Z")).getDni());
        assertEquals("45678901G",(new CalculoDni("45678901G")).getDni());
        assertEquals("56789012B",(new CalculoDni("56789012B")).getDni());
        assertEquals("89012345E",(new CalculoDni("89012345E")).getDni());
        assertNotEquals("67890123A",(new CalculoDni("67890123A")).getDni());
        assertNotEquals("78901234A",(new CalculoDni("78901234A")).getDni());
        assertNotEquals("23456789A",(new CalculoDni("23456789A")).getDni());
        assertNotEquals("34567890A",(new CalculoDni("34567890A")).getDni());
        assertNotEquals("90123456X",(new CalculoDni("90123456X")).getDni());
    }
}