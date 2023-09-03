import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceObjectTest {

    @Test
    @DisplayName("Distance between objects calculation test")
    void distanceSquaredTo() {
        SpaceObject Earth = new SpaceObject("Earth", 3, 0, Math.PI/2);
        SpaceObject Mars = new SpaceObject("Mars", 4, 0, 0);
        assertEquals(25.0, Earth.distanceSquaredTo(Mars));
    }
}