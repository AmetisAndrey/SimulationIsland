package AnimalsTest;

import com.animals.Goat;
import com.animals.Animal;

public class TestGoat extends TestAnimalBase {

    @Override
    protected Animal createAnimal() { return new Goat(); }
}
