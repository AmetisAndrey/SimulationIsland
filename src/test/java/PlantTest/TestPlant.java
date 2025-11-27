package PlantTest;

import com.plant.Plant;
import com.plant.PlantType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPlant {

    @Test
    void testInitialGrassValues() {
        Plant p = new Plant(PlantType.GRASS);
        assertEquals(3.0, p.getWeight(), 0.001);
        assertEquals(PlantType.GRASS, p.getType());
    }

    @Test
    void testGrowth() {
        Plant p = new Plant(PlantType.GRASS);
        double initial = p.getWeight();
        p.grow();
        assertTrue(p.getWeight() > initial);
    }

    @Test
    void testReduce() {
        Plant p = new Plant(PlantType.GRASS);
        p.reduce(2.0);
        assertEquals(1.0, p.getWeight(), 0.001);

        // не должно уходить ниже 0
        p.reduce(100);
        assertEquals(0.0, p.getWeight(), 0.001);
    }
}
