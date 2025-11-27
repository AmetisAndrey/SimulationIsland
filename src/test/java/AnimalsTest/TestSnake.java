package AnimalsTest;

import com.animals.Snake;
import com.animals.Animal;

public class TestSnake extends TestAnimalBase {
    @Override
    protected Animal createAnimal() { return new Snake(); }
}
