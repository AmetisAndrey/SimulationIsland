package AnimalsTest;

import com.animals.Boar;
import com.animals.Animal;

public class TestBoar extends TestAnimalBase {

    @Override
    protected Animal createAnimal() { return new Boar(); }
}
