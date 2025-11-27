package AnimalsTest;

import com.animals.Deer;
import com.animals.Animal;

public class TestDeer extends TestAnimalBase {
    @Override
    protected Animal createAnimal() { return new Deer(); }
}
