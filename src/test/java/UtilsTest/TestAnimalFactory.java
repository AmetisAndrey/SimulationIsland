package UtilsTest;

import com.utils.AnimalFactory;
import com.animals.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestAnimalFactory {

    @DisplayName("")
    @Test
    void testCreatePredators() {
        assertTrue(AnimalFactory.create("Wolf") instanceof Wolf);
        assertTrue(AnimalFactory.create("Snake") instanceof Snake);
        assertTrue(AnimalFactory.create("Fox") instanceof Fox);
        assertTrue(AnimalFactory.create("Bear") instanceof Bear);
        assertTrue(AnimalFactory.create("Eagle") instanceof Eagle);
    }

    @DisplayName("")
    @Test
    void testCreateHerbivores() {
        assertTrue(AnimalFactory.create("Horse") instanceof Horse);
        assertTrue(AnimalFactory.create("Deer") instanceof Deer);
        assertTrue(AnimalFactory.create("Rabbit") instanceof Rabbit);
        assertTrue(AnimalFactory.create("Mouse") instanceof Mouse);
        assertTrue(AnimalFactory.create("Goat") instanceof Goat);
        assertTrue(AnimalFactory.create("Sheep") instanceof Sheep);
        assertTrue(AnimalFactory.create("Boar") instanceof Boar);
        assertTrue(AnimalFactory.create("Buffalo") instanceof Buffalo);
        assertTrue(AnimalFactory.create("Duck") instanceof Duck);
        assertTrue(AnimalFactory.create("Caterpillar") instanceof Caterpillar);
    }

    @DisplayName("")
    @Test
    void testCreateUnknownReturnsNull() {
        assertNull(AnimalFactory.create("UnknownType"));
    }

    @DisplayName("")
    @Test
    void testRandomAnimalAlwaysReturnsValidAnimal() {
        Set<Class<?>> validClasses = new HashSet<>();
        validClasses.add(Wolf.class);
        validClasses.add(Snake.class);
        validClasses.add(Fox.class);
        validClasses.add(Bear.class);
        validClasses.add(Eagle.class);
        validClasses.add(Horse.class);
        validClasses.add(Deer.class);
        validClasses.add(Rabbit.class);
        validClasses.add(Mouse.class);
        validClasses.add(Goat.class);
        validClasses.add(Sheep.class);
        validClasses.add(Boar.class);
        validClasses.add(Buffalo.class);
        validClasses.add(Duck.class);
        validClasses.add(Caterpillar.class);

        for (int i = 0; i < 100; i++) {
            assertNotNull(AnimalFactory.randomAnimal());
            assertTrue(validClasses.contains(AnimalFactory.randomAnimal().getClass()));
        }
    }
}
