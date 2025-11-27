package AnimalsTest;

import com.animals.Rabbit;
import com.animals.Animal;

public class TestRabbit extends TestAnimalBase {
    @Override
    protected Animal createAnimal() { return new Rabbit(); }
}
