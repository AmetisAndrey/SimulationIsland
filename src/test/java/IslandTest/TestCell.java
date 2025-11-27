package IslandTest;

import com.island.Cell;
import com.animals.Animal;
import com.animals.Wolf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCell {

    private Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell();
    }

    @Test
    void testAddAnimal() {
        Animal a = new Wolf();

        cell.addAnimal(a);

        assertEquals(1, cell.getAnimals().size());
        assertTrue(cell.getAnimals().contains(a));
    }

    @Test
    void testRemoveAnimal() {
        Animal a = new Wolf();

        cell.addAnimal(a);
        assertEquals(1, cell.getAnimals().size());

        cell.removeAnimal(a);
        assertEquals(0, cell.getAnimals().size());
    }
}
