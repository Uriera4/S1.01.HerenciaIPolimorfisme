package n1exercici3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NomTest {
    @Test
    public void testNom () throws ArrayIndexOutOfBoundsException {
        assertThrows(ArrayIndexOutOfBoundsException.class, (new Nom("Oriol")::llegeixNom));
    }
}