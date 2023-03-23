import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    Human human;

    @BeforeEach
    void setUp() {
        human = new Human("Sam", 100);
        human.setArmorPoints(50);
        human.setArmorType("Leather");
    }

    @Test
    void getArmorPoints() {
        assertEquals(50, human.getArmorPoints());
    }

    @Test
    void setArmorPoints() {
        human.setArmorPoints(25);
        assertEquals(25, human.getArmorPoints());
    }

    @Test
    void getArmorType() {
        assertEquals("Leather", human.getArmorType());
    }

    @Test
    void setArmorType() {
        human.setArmorType("Cloth");
        assertEquals("Cloth", human.getArmorType());
    }

    @Test
    void eatFood() {
    }
}