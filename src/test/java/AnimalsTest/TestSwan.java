package AnimalsTest;

import com.animals.Swan;
import com.animals.Animal;

public class TestSwan extends TestAnimalBase {
    @Override
    protected Animal createAnimal() { return new Swan(); }
}
