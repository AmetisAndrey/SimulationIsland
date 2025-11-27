package AnimalsTest;

import com.animals.Omnivorous;
import com.island.Cell;
import com.island.Island;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOmnivorous {

    static class OmnivoreMock extends Omnivorous {
        public OmnivoreMock() {
            super("OmnivoreMock");
        }
    }

    @DisplayName("Omnivorous — базовое поведение без Mockito")
    @Test
    void testOmnivorousBasic() {
        OmnivoreMock o = new OmnivoreMock();

        assertEquals("OmnivoreMock", o.getName());
        assertTrue(o.isAlive());

        Island island = new Island();
        Cell cell = new Cell();

        assertDoesNotThrow(() -> o.move(island, 0, 0));
        assertDoesNotThrow(() -> o.eat(cell));
        assertDoesNotThrow(() -> o.reproduce(cell));
    }
}
