package AnimalsTest;

import com.animals.Wolf;
import com.animals.Animal;

public class TestWolf extends TestAnimalBase {
    @Override
    protected Animal createAnimal() { return new Wolf(); }
}
