package AnimalsTest;

import com.animals.Horse;
import com.animals.Animal;
public class TestHorse extends TestAnimalBase {
    @Override
    protected Animal createAnimal() { return new Horse(); }
}
