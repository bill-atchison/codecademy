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
        assertEquals(250, alien.getMaxHitPoints());
        assertEquals(250, alien.getHitPoints());
    }

    @Test
    void regenerate() {
        alien.setHitPoints(50);
        alien.regenerate();
        assertTrue(alien.getHitPoints() > 50);
        alien.setHitPoints(200);
        alien.regenerate();
        assertEquals(alien.getHitPoints(), alien.getMaxHitPoints());
    }
}