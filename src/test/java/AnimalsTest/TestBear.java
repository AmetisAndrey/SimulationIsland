package AnimalsTest;

import com.animals.Bear;
import com.animals.Animal;

public class TestBear extends TestAnimalBase {

    @Override
    protected Animal createAnimal() { return new Bear(); }
}
