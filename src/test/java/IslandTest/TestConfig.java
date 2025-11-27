package IslandTest;

import com.island.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import java.lang.invoke.ConstantBootstraps;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestConfig {

    @DisplayName("")
    @Test
    void testConstants() {
        assertEquals(30, Config.ISLAND_WIDTH);
        assertEquals(20, Config.ISLAND_HEIGHT);
        assertTrue(Config.STOP_WHEN_NO_ANIMALS);

        assertTrue(Config.WEIGHT.containsKey("Wolf"));
        assertTrue(Config.WEIGHT.containsKey("Rabbit"));
        assertEquals(50.0, Config.WEIGHT.get("Wolf"));
        assertEquals(2.0, Config.WEIGHT.get("Rabbit"));
    }
}
