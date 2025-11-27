package AnimalsTest;

import com.animals.Fox;
import com.animals.Animal;

public class TestFox extends TestAnimalBase {
    @Override
    protected Animal createAnimal() { return new Fox(); }
}
