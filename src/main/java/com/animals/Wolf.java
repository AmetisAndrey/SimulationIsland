package com.animals;
import com.utils.RandomGenerator;
import com.island.Island;
import com.island.Cell;

import java.util.concurrent.CopyOnWriteArrayList;

public class Wolf extends Predators {
    public Wolf() {
        super("Wolf");
    }

    @Override
    public void move(Island island, int x, int y) {
        boolean packNearby = false;
        for (int dx = -2; dx <= 2 && !packNearby; dx++) {
            for (int dy = -2; dy <= 2 && !packNearby; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                int nx = x + dx;
                int ny = y + dy;
                if (nx < 0 || ny < 0 || nx >= Island.HEIGHT || ny >= Island.WIDTH) continue;
                Cell neighbor = island.getCell(nx, ny);
                if (neighbor.getAnimals().stream().anyMatch(a -> a instanceof Wolf && a.isAlive())) {
                    packNearby = true;
                }
            }
        }

        if (packNearby) {
            int bestDx = 0, bestDy = 0;
            double bestDist = Double.MAX_VALUE;
            for (int dx = -4; dx <= 4; dx++) {
                for (int dy = -4; dy <= 4; dy++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    if (nx < 0 || ny < 0 || nx >= Island.HEIGHT || ny >= Island.WIDTH) continue;
                    Cell c = island.getCell(nx, ny);
                    boolean hasHerb = c.getAnimals().stream()
                            .anyMatch(a -> a instanceof Herbivores && a.isAlive());
                    if (hasHerb) {
                        double dist = dx * dx + dy * dy;
                        if (dist < bestDist) {
                            bestDist = dist;
                            bestDx = dx;
                            bestDy = dy;
                        }
                    }
                }
            }
            if (bestDist < Double.MAX_VALUE){
                int targetX = x + Integer.signum(bestDx);
                int targetY = y + Integer.signum(bestDy);
                island.moveAnimal(this, x, y, targetX, targetY);
                return;
            }
        }
        super.move(island, x, y);
    }
    @Override
    public void eat(Cell cell) {
        int packSize = (int) cell.getAnimals().stream()
                .filter(a -> a instanceof Wolf && a.isAlive())
                .count();

        int baseChance = 90;
        int bonus = Math.min(Math.max(packSize - 1, 0), 3) * 5; // +5% за каждого волка рядом (до +15%)
        int chance = Math.min(100, baseChance + bonus);

        for (Animal prey : new CopyOnWriteArrayList<>(cell.getAnimals())) {
            if (!prey.isAlive() || prey instanceof Predators) continue;
            if (RandomGenerator.chance(chance)) {
                prey.die();
                this.increaseSatiety(prey.weight);
                break;
            }
        }
    }
}