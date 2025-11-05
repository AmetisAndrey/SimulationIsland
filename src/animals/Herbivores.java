package animals;

import island.Cell;
import island.Island;
import utils.RandomGenerator;

public abstract class Herbivores extends Animal {

    public Herbivores(String name) {
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
        if (cell.getPlant() != null && cell.getPlant().getWeight() > 0) {
            double food = Math.min(cell.getPlant().getWeight(), this.foodNeeded);
            cell.getPlant().reduce(food);
            this.increaseSatiety(food);
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
