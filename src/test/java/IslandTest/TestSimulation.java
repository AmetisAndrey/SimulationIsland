package IslandTest;

import com.island.Simulation;
import com.island.Island;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.jupiter.api.Assertions.*;

public class TestSimulation {

    private Simulation simulation;

    @BeforeEach
    void setup() {
        simulation = new Simulation();
    }

    @AfterEach
    void tearDown() throws Exception {
        // Аккуратно завершаем Scheduler и пул животных, чтобы тесты не зависали
        Field schedulerField = Simulation.class.getDeclaredField("scheduler");
        schedulerField.setAccessible(true);
        ScheduledExecutorService scheduler =
                (ScheduledExecutorService) schedulerField.get(simulation);
        scheduler.shutdownNow();

        Field poolField = Simulation.class.getDeclaredField("animalPool");
        poolField.setAccessible(true);
        ExecutorService pool = (ExecutorService) poolField.get(simulation);
        pool.shutdownNow();
    }

    @DisplayName("getIsland() возвращает не-null остров")
    @Test
    void testGetIsland() {
        Island island = simulation.getIsland();
        assertNotNull(island);
    }

    @DisplayName("Проверка установки и снятия паузы")
    @Test
    void testPauseToggle() throws Exception {
        Field pausedField = Simulation.class.getDeclaredField("paused");
        pausedField.setAccessible(true);

        simulation.setPaused(true);
        assertTrue((boolean) pausedField.get(simulation));

        simulation.setPaused(false);
        assertFalse((boolean) pausedField.get(simulation));
    }

    @DisplayName("start() запускается без исключений")
    @Test
    void testStart() {
        assertDoesNotThrow(() -> simulation.start());
    }

    @DisplayName("animalLifeCycle() выполняется без исключений")
    @Test
    void testAnimalLifeCycle() throws Exception {
        Method method = Simulation.class.getDeclaredMethod("animalLifeCycle");
        method.setAccessible(true);

        assertDoesNotThrow(() -> method.invoke(simulation));
    }

    @DisplayName("growPlants() выполняется без исключений")
    @Test
    void testGrowPlants() throws Exception {
        Method method = Simulation.class.getDeclaredMethod("growPlants");
        method.setAccessible(true);

        assertDoesNotThrow(() -> method.invoke(simulation));
    }

    @DisplayName("printStats() выполняется без исключений")
    @Test
    void testPrintStats() throws Exception {
        Method method = Simulation.class.getDeclaredMethod("printStats");
        method.setAccessible(true);

        assertDoesNotThrow(() -> method.invoke(simulation));
    }

    @DisplayName("respawnIfExtinct() выполняется без исключений")
    @Test
    void testRespawnIfExtinct() throws Exception {
        Method method = Simulation.class.getDeclaredMethod("respawnIfExtinct");
        method.setAccessible(true);

        assertDoesNotThrow(() -> method.invoke(simulation));
    }
}
