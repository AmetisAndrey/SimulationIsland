package com.island;

import com.animals.Animal;
import com.plant.Plant;
import com.plant.PlantType;
import com.utils.RandomGenerator;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cell {

    private final List<Animal> animals = new CopyOnWriteArrayList<>();
    private Plant plant;
    private TerrainType terrain = TerrainType.LAND;

    public TerrainType getTerrain(){
        return terrain;
    }

    public void setTerrain(TerrainType terrain) {
        this.terrain = terrain;
    }

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
            int r = RandomGenerator.nextInt(1,3);
            PlantType type = (r == 1) ? PlantType.GRASS : (r == 2) ? PlantType.BUSH : PlantType.TREE;
            plant = new Plant(type);
        } else {
            plant.grow();
        }
    }


    public synchronized boolean canAddAnimal(String type) {
        long count = animals.stream()
                .filter(a -> a.isAlive() && a.getName().equals(type))
                .count();
        int limit = Config.MAX_IN_CELL.getOrDefault(type, 100);
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
