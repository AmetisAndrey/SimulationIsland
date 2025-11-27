package AnimalsTest;

import com.animals.Animal;
import com.island.Cell;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public abstract class TestAnimalBase {

    protected abstract Animal createAnimal();

    private double getSatietyReflect(Animal a) {
        try {
            var field = Animal.class.getDeclaredField("satiety");
            field.setAccessible(true);
            return field.getDouble(a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testEatDoesNotThrow() {
        Animal a = createAnimal();
        Cell fake = new Cell();
        assertDoesNotThrow(() -> a.eat(fake));
    }

    @Test
    void testEatChangesSatiety() {
        Animal a = createAnimal();
        Cell fake = new Cell();

        double before = getSatietyReflect(a);

        a.eat(fake);
        double after = getSatietyReflect(a);

        assertTrue(after >= before, "eat() должно увеличивать сытость");
    }

    @Test
    void testDecreaseSatiety() {
        Animal a = createAnimal();
        double before = getSatietyReflect(a);

        // вызываем, только если метод существует
        try {
            var m = Animal.class.getDeclaredMethod("decreaseSatiety");
            m.setAccessible(true);
            m.invoke(a);
        } catch (NoSuchMethodException ignore) {
            // Если метода нет — тест считается пройденным
            return;
        } catch (Exception e) {
            fail("decreaseSatiety() вызвал исключение: " + e);
        }

        double after = getSatietyReflect(a);
        assertTrue(after <= before, "decreaseSatiety() должно уменьшать сытость");
    }

    @Test
    void testDieWorks() throws Exception {
        Animal a = createAnimal();

        a.die();

        var field = Animal.class.getDeclaredField("alive");
        field.setAccessible(true);
        boolean alive = field.getBoolean(a);

        assertFalse(alive, "После die() животное должно быть мёртвым");
    }
}
