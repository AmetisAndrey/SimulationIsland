package animals;

import island.Cell;
import island.Island;
import utils.RandomGenerator;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Predators extends Animal {

    public Predators(String name) {
        super(name);
    }

    @Override
    public void move(Island island, int x, int y) {
        int dx = RandomGenerator.nextInt(-speed, speed);
        int dy = RandomGenerator.nextInt(-speed, speed);

        int nx = x + dx;
        int ny = y + dy;

        if (nx < 0 || ny < 0 || nx >= Island.HEIGHT || ny >= Island.WIDTH) return;

        island.moveAnimal(this, x, y, nx, ny);
    }

    @Override
    public void eat(Cell cell) {
        for (Animal prey : new CopyOnWriteArrayList<>(cell.getAnimals())) {
            if (!prey.isAlive() || prey instanceof Predators) continue;

            int chance = switch (this.name) {
                case "Wolf" -> 90;
                case "Bear" -> 95;
                case "Fox" -> 80;
                case "Snake" -> 60;
                case "Eagle" -> 75;
                default -> 50;
            };

            if (RandomGenerator.chance(chance)) {
                prey.die();
                this.increaseSatiety(prey.weight);
                break;
            }
        }
    }

    @Override
    public void reproduce(Cell cell) {
        long sameSpecies = cell.getAnimals().stream()
                .filter(a -> a.isAlive() && a.getClass().equals(this.getClass()))
                .count();
        if (sameSpecies > 0 && RandomGenerator.chance(5)) {
            if (cell.canAddAnimal(this.name)) {
                try {
                    cell.addAnimal(this.getClass().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {}
            }
        }
    }

}
