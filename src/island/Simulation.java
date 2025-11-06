package island;

import animals.Animal;
import java.util.concurrent.*;

public class Simulation {
    private final Island island = new Island();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
    private final ExecutorService animalPool = Executors.newFixedThreadPool(20);
    private volatile boolean paused = false;

    public Island getIsland() {
        return island;
    }

    public void setPaused(boolean value) {
        this.paused = value;
    }

    public void start() {

        for (int i = 0; i < 100; i++) {
            island.randomPopulate(() -> utils.AnimalFactory.randomAnimal(), 1);
        }

        scheduler.scheduleAtFixedRate(this::growPlants, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::animalLifeCycle, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::printStats, 0, 3, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::respawnIfExtinct, 0, 10, TimeUnit.SECONDS);
    }

    private void growPlants() {
        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {
                island.getCell(i, j).growPlant();
            }
        }
    }
    private boolean isOverpopulated() {
        long total = 0;
        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {
                total += island.getCell(i, j).getAnimals().size();
            }
        }
        return total > 1000;
    }


    private void animalLifeCycle() {
        if (paused) return;
        if (isOverpopulated()) {
            System.out.println("⚠️ Перенаселение — остановка размножения!");
            return;
        }

        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {
                Cell cell = island.getCell(i, j);
                for (Animal a : cell.getAnimals()) {
                    if (!a.isAlive()) continue;
                    final int x = i;
                    final int y = j;
                    final Cell localCell = cell;
                    final Animal animal = a;

                    animalPool.submit(() -> {
                        animal.eat(localCell);
                        animal.reproduce(localCell);
                        animal.move(island, x, y);
                        animal.loseEnergy();
                    });
                }
            }
        }
    }

    private void respawnIfExtinct() {
        for (String type : Config.WEIGHT.keySet()) {
            long count = countAnimals(type);
            if (count == 0) {
                System.out.println("♻️ Респаун " + type);
                for (int i = 0; i < 3; i++) {
                    Cell cell = island.getRandomCell();
                    if (cell.canAddAnimal(type)) {
                        cell.addAnimal(utils.AnimalFactory.create(type));
                    }
                }
            }
        }
    }

    private long countAnimals(String type) {
        long count = 0;
        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {
                count += island.getCell(i, j).getAnimals().stream()
                        .filter(a -> a.isAlive() && a.getClass().getSimpleName().equals(type))
                        .count();
            }
        }
        return count;
    }

    private void printStats() {
        long predators = 0, herbivores = 0, omnivores = 0, plants = 0;

        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {
                Cell c = island.getCell(i, j);

                if (c.getPlant() != null && c.getPlant().getWeight() > 0) {
                    plants++;
                }

                predators += c.getAnimals().stream()
                        .filter(a -> a.isAlive() && a instanceof animals.Predators)
                        .count();

                herbivores += c.getAnimals().stream()
                        .filter(a -> a.isAlive() && a instanceof animals.Herbivores)
                        .count();

                omnivores += c.getAnimals().stream()
                        .filter(a -> a.isAlive() && a instanceof animals.Omnivorous)
                        .count();
            }
        }

        System.out.printf("🌿 Plants: %d | 🐇 Herbivores: %d | 🍖 Omnivores: %d | 🐺 Predators: %d%n",
                plants, herbivores, omnivores, predators);
    }

}
