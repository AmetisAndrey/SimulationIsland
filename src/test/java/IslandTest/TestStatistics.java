package IslandTest;

import com.island.Island;
import com.island.Statistics;
import com.animals.Animal;
import com.animals.Wolf;
import com.plant.Plant;
import com.plant.PlantType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestStatistics {

    private Island island;

    @BeforeEach
    void setup() {
        island = new Island();
    }

    @DisplayName("Statistics.print() — пустой остров не вызывает ошибок")
    @Test
    void testStatisticsEmptyIsland() {
        assertDoesNotThrow(() -> Statistics.print(island));
    }

    @DisplayName("Statistics.print() — остров только с растениями не вызывает ошибок")
    @Test
    void testStatisticsWithPlants() {
        island.getCell(0, 0).setPlant(new Plant(PlantType.GRASS));
        island.getCell(1, 1).setPlant(new Plant(PlantType.BUSH));

        assertDoesNotThrow(() -> Statistics.print(island));
    }

    @DisplayName("Statistics.print() — остров только с живыми животными не вызывает ошибок")
    @Test
    void testStatisticsWithAliveAnimals() {
        Animal a1 = new Wolf();
        Animal a2 = new Wolf();

        island.getCell(0, 0).addAnimal(a1);
        island.getCell(1, 1).addAnimal(a2);

        assertDoesNotThrow(() -> Statistics.print(island));
    }

    @DisplayName("Statistics.print() — растения + живые и мёртвые животные не вызывают ошибок")
    @Test
    void testStatisticsMixed() {
        // Растения
        island.getCell(0, 0).setPlant(new Plant(PlantType.GRASS));
        island.getCell(1, 1).setPlant(new Plant(PlantType.BUSH));

        // Животные: 2 живых + 1 мёртвое
        Animal alive1 = new Wolf();
        Animal alive2 = new Wolf();
        Animal dead = new Wolf();
        dead.die();

        island.getCell(0, 0).addAnimal(alive1);
        island.getCell(1, 1).addAnimal(alive2);
        island.getCell(2, 2).addAnimal(dead);

        assertDoesNotThrow(() -> Statistics.print(island));
    }
}
