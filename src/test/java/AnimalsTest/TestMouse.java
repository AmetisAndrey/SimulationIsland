package AnimalsTest;

import com.animals.Mouse;
import com.animals.Animal;

public class TestMouse extends TestAnimalBase {

    @Override
    protected Animal createAnimal() { return new Mouse(); }
}
