package AnimalsTest;

import com.animals.Hedgehog;
import com.animals.Animal;

public class TestHedgehog extends TestAnimalBase {

    @Override
    protected Animal createAnimal() { return new Hedgehog(); }
}
