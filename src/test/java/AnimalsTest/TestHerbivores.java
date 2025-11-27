package AnimalsTest;

import com.animals.Herbivores;
import com.island.Cell;
import com.island.Island;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestHerbivores {

    static class HerbivoreMock extends Herbivores {
        public HerbivoreMock() {
            super("HerbivoreMock");
        }
    }

    @DisplayName("Herbivores — базовое поведение без Mockito")
    @Test
    void testHerbivoreBasic() {
        HerbivoreMock h = new HerbivoreMock();

        assertEquals("HerbivoreMock", h.getName());
        assertTrue(h.isAlive());

        Island island = new Island();
        Cell cell = new Cell();

        assertDoesNotThrow(() -> h.move(island, 0, 0));
        assertDoesNotThrow(() -> h.eat(cell));
        assertDoesNotThrow(() -> h.reproduce(cell));
    }
}
