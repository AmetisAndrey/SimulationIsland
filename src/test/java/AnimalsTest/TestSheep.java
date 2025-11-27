package AnimalsTest;

import com.animals.Sheep;
import com.animals.Animal;

public class TestSheep extends TestAnimalBase {

    @Override
    protected Animal createAnimal() { return new Sheep(); }
}
