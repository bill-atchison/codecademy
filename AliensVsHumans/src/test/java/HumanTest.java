import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    Human human;

    @BeforeEach
    void setUp() {
        human = new Human("Sam", 100);
        human.setArmorPoints(10);
        human.setArmorType("Leather");
    }

    @Test
    void getArmorPoints() {
        assertEquals(10, human.getArmorPoints());
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
        human.setHitPoints(50);
        human.eatFood();
        assertTrue(human.getHitPoints() > 50);
        human.setHitPoints(100);
        human.eatFood();
        assertEquals(human.getHitPoints(), human.getMaxHitPoints());
    }

    @Test
    void equipWeapon() {
        human.equipWeapon("Mace");
        assertEquals(5, human.getDamage());
        assertEquals("Mace", human.getWeapon());
        human.equipWeapon("");
        assertEquals(2, human.getDamage());
        assertEquals("", human.getWeapon());
    }

    @Test
    void equipArmor() {
        human.equipArmor("Leather");
        assertEquals(10, human.getArmorPoints());
        assertEquals("Leather", human.getArmorType());
        human.equipArmor("");
        assertEquals(0, human.getArmorPoints());
        assertEquals("", human.getArmorType());
    }

    @Test
    void takeDamage() {
        human.setDamage(5);
        human.takeDamage();
        assertTrue(human.getHitPoints() <= 100);
        assertTrue(human.getArmorPoints() <= 10);

        human.setHitPoints(1);
        human.setArmorPoints(0);
        human.setDamage(5);
        human.takeDamage();
        assertEquals(0, human.getHitPoints());

        human.setHitPoints(100);
        human.setArmorPoints(1);
        human.setDamage(5);
        human.takeDamage();
        assertEquals(0, human.getArmorPoints());
    }
}