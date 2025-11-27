package UtilsTest;

import com.utils.RandomGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestRandomGenerator {

    @Test
    void testNextIntRange() {
        for (int i = 0; i < 100; i++) {
            int value = RandomGenerator.nextInt(1, 5);
            assertTrue(value >= 1 && value <= 5);
        }
    }

    @Test
    void testNextDoubleRange() {
        for (int i = 0; i < 100; i++) {
            double value = RandomGenerator.nextDouble(0.5, 2.5);
            assertTrue(value >= 0.5 && value <= 2.5);
        }
    }

    @Test
    void testChance() {
        assertTrue(RandomGenerator.chance(100));

        assertFalse(RandomGenerator.chance(0));
    }
}