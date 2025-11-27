package AnimalsTest;

import com.animals.Caterpillar;
import com.animals.Animal;

public class TestCaterpillar extends TestAnimalBase {

    @Override
    protected Animal createAnimal() { return new Caterpillar(); }
}
