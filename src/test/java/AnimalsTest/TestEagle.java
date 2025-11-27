package AnimalsTest;

import com.animals.Eagle;
import com.animals.Animal;

public class TestEagle extends TestAnimalBase {

    @Override
    protected Animal createAnimal() { return new Eagle(); }
}
