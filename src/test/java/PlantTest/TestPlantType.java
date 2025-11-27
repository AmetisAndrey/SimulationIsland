package PlantTest;


import com.plant.PlantType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


public class TestPlantType {
    @DisplayName("")
    @Test
    void testPlantTypeValues(){
        assertEquals(3, PlantType.values().length);
        assertNotNull(PlantType.GRASS);
        assertNotNull(PlantType.BUSH);
        assertNotNull(PlantType.TREE);
    }
}
