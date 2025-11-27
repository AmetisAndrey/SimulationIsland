package AnimalsTest;

import com.animals.Predators;
import com.island.Cell;
import com.island.Island;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPredator {

    static class PredatorMock extends Predators {
        public PredatorMock() {
            super("PredatorMock");
        }

        @Override
        public void move(Island island, int x, int y) {
            // пустая реализация для теста
        }
    }

    @DisplayName("Predator basic behavior")
    @Test
    void testPredator() {
        PredatorMock p = new PredatorMock();

        assertEquals("PredatorMock", p.getName());
        assertTrue(p.isAlive());
    }
}
