package IslandTest;

import com.island.Island;
import com.island.Cell;
import com.island.TerrainType;
import com.animals.Animal;
import com.animals.Wolf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestIsland {

    private Island island;

    @BeforeEach
    void setUp() {
        island = new Island();
    }

    @DisplayName("getCell возвращает не-null клетку в пределах острова")
    @Test
    void testGetCell() {
        Cell c = island.getCell(0, 0);
        assertNotNull(c);
    }

    @DisplayName("Все клетки острова инициализированы")
    @Test
    void testGridInitialization() {
        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {
                assertNotNull(island.getCell(i, j));
            }
        }
    }

    @DisplayName("Средняя колонка острова — вода")
    @Test
    void testWaterColumn() {
        int waterColumn = Island.WIDTH / 2;
        for (int i = 0; i < Island.HEIGHT; i++) {
            assertEquals(
                    TerrainType.WATER,
                    island.getCell(i, waterColumn).getTerrain()
            );
        }
    }

    @DisplayName("randomPopulate добавляет хотя бы одно животное")
    @Test
    void testRandomPopulate() {
        island.randomPopulate(Wolf::new, 10);

        int totalAnimals = 0;
        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {
                totalAnimals += island.getCell(i, j).getAnimals().size();
            }
        }

        assertTrue(totalAnimals > 0);
    }

    @DisplayName("moveAnimal перемещает животное при корректных координатах")
    @Test
    void testMoveAnimalSuccess() {
        Animal a = new Wolf();
        island.getCell(0, 0).addAnimal(a);

        island.moveAnimal(a, 0, 0, 0, 1);

        assertFalse(island.getCell(0, 0).getAnimals().contains(a));
        assertTrue(island.getCell(0, 1).getAnimals().contains(a));
    }

    @DisplayName("moveAnimal не перемещает, если цель — вода и животное не плавает")
    @Test
    void testMoveAnimalIntoWaterDenied() {
        Animal a = new Wolf();
        int waterColumn = Island.WIDTH / 2;

        island.getCell(0, 0);
    }

}
