import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest {
    Alien alien;

    @BeforeEach
    void setUp() {
        alien = new Alien("ET", 200);
    }

    @Test
    void isMutated() {
        assertFalse(alien.isMutated());
    }

    @Test
    void setMutated() {
        alien.setMutated(true);
        assertTrue(alien.isMutated());
    }

    @Test
    void regenerate() {
    }
}