package island;

import animals.Animal;
import plant.Plant;
import utils.RandomGenerator;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cell {

    private final List<Animal> animals = new CopyOnWriteArrayList<>();
    private Plant plant;

    public synchronized List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public synchronized Plant getPlant() {
        return plant;
    }

    public synchronized void setPlant(Plant plant) {
        this.plant = plant;
    }


    public void growPlant() {
        if (plant == null) {
            plant = new Plant(RandomGenerator.nextDouble(5.0, 10.0));
        } else {
            double current = plant.getWeight();
            if (current < 20.0) {
                double growth = RandomGenerator.nextDouble(0.5, 1.0);

            }
            if (RandomGenerator.chance(90)) return;

        }
    }



    public synchronized boolean canAddAnimal(String type) {
        long count = animals.stream()
                .filter(a -> a.isAlive() && a.getName().equals(type))
                .count();
        int limit = island.Config.MAX_IN_CELL.getOrDefault(type, 100);
        return count < limit;
    }


    public synchronized void addAnimal(Animal animal) {
        if (canAddAnimal(animal.getName())) {
            animals.add(animal);
        }
    }

    public synchronized void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
}
