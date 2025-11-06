package animals;

import island.Cell;
import island.Config;
import island.Island;
import utils.RandomGenerator;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Omnivorous  extends Animal{

    public Omnivorous(String name) {
        super(name);
    }

    @Override
    public void eat(Cell cell) {
        for (Animal prey : new CopyOnWriteArrayList<>(cell.getAnimals())){
            if(!prey.isAlive() || prey == this) continue;

            boolean suitablePrey =
                    prey instanceof Herbivores || prey instanceof Omnivorous;
            if (!suitablePrey)  continue;
            int chance = 50;

            if (RandomGenerator.chance(chance)){
                prey.die();
                this.increaseSatiety(prey.weight);
                return;
            }
        }

        if (cell.getPlant() != null && cell.getPlant().getWeight() > 0) {
            double food = Math.min(cell.getPlant().getWeight(), this.foodNeeded);
            cell.getPlant().reduce(food);
            this.increaseSatiety(food);
        }
    }

    @Override
    public void move(Island island, int x, int y) {
        int nx = Math.max(0, Math.min(Island.HEIGHT - 1,
                x + RandomGenerator.nextInt(-speed, speed)));
        int ny = Math.max(0, Math.min(Island.WIDTH - 1,
                y + RandomGenerator.nextInt(-speed, speed)));

        if (nx != x || ny != y) {
            island.moveAnimal(this, x, y, nx, ny);
        }
    }

    @Override
    public void reproduce(Cell cell) {
        long same = cell.getAnimals().stream()
                .filter(a -> a.isAlive() && a.getClass().equals(getClass()))
                .count();

        if (same > 0 && RandomGenerator.chance(5)) {
            int babies = Config.OFFSPRING_COUNT.getOrDefault(this.name, 1);
            for (int i = 0; i < babies; i++) {
                if (cell.canAddAnimal(this.name)) {
                    try {
                        cell.addAnimal(getClass().getDeclaredConstructor().newInstance());
                    } catch (Exception ignored) {}
                }
            }
        }
    }
}
