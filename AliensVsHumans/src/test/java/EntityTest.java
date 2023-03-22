import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    Entity entity;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        entity = new Entity(100);
        entity.setDamage(50);
        entity.setWeapon("Mace");
    }

    @org.junit.jupiter.api.Test
    void getHitPoints() {
        assertEquals(100, entity.getHitPoints());
    }

    @org.junit.jupiter.api.Test
    void setHitPoints() {
        entity.setHitPoints(200);
        assertEquals(200, entity.getHitPoints());
    }

    @org.junit.jupiter.api.Test
    void getDamage() {
        assertEquals(50, entity.getDamage());
    }


    @org.junit.jupiter.api.Test
    void setDamage() {
        entity.setDamage(10);
        assertEquals(10, entity.getDamage());
    }

    @org.junit.jupiter.api.Test
    void getWeapon() {
        assertEquals("Mace", entity.getWeapon());
    }

    @org.junit.jupiter.api.Test
    void setWeapon() {
        entity.setWeapon("Hand");
        assertEquals("Hand", entity.getWeapon());
    }
}