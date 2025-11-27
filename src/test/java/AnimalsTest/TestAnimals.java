package AnimalsTest;

import com.animals.Animal;
import com.island.Cell;
import com.island.Island;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAnimals {

    // Анонимный тестовый класс
    static class TestAnimal extends Animal {
        public TestAnimal() { super("TestAnimal"); }

        @Override
        public void move(Island island, int x, int y) {}

        @Override
        public void eat(Cell cell) {}

        @Override
        public void reproduce(Cell cell) {}
    }

    @DisplayName("Проверка базовых свойств Animal")
    @Test
    void testBasicFields() {
        Animal a = new TestAnimal();

        assertEquals("TestAnimal", a.getName());
        assertTrue(a.isAlive());
        assertNotNull(a.toString());
    }

    @DisplayName("Animal.isHungry() корректно определяет голод")
    @Test
    void testIsHungry() {
        Animal a = new TestAnimal();

        a.setSatiety(0);
        a.setFoodNeeded(10);

        assertTrue(a.isHungry());

        a.setSatiety(6); // > 50%
        assertFalse(a.isHungry());
    }

    @DisplayName("Animal.die() переключает alive = false")
    @Test
    void testDie() {
        Animal a = new TestAnimal();
        assertTrue(a.isAlive());

        a.die();

        assertFalse(a.isAlive());
    }

}
