package IslandTest;

import com.island.TerrainType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


public class TestTerrainType {
    @DisplayName("")
    @Test
    void testEnumValues(){
        assertNotNull(TerrainType.WATER);
        assertNotNull(TerrainType.LAND);
        assertEquals(2, TerrainType.values().length);
    }

}
