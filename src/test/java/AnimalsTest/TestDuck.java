package AnimalsTest;

import com.animals.Duck;
import com.animals.Animal;

public class TestDuck extends TestAnimalBase {

    @Override
    protected Animal createAnimal() { return new Duck(); }
}
