package com.island;


import com.animals.Animal;
import com.utils.RandomGenerator;

import java.util.function.Supplier;

public class Island {

    public static final int WIDTH = Config.ISLAND_WIDTH;
    public static final int HEIGHT = Config.ISLAND_HEIGHT;

    private final Cell[][] grid = new Cell[HEIGHT][WIDTH];

    public Island() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = new Cell();
                if(j == WIDTH / 2){
                    grid[i][j].setTerrain(TerrainType.WATER);
                } else{
                    grid[i][j].setTerrain(TerrainType.LAND);
                }
                grid[i][j].growPlant();
            }
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public Cell getRandomCell() {
        int x = RandomGenerator.nextInt(0, HEIGHT - 1);
        int y = RandomGenerator.nextInt(0, WIDTH - 1);
        return grid[x][y];
    }


    public void randomPopulate(Supplier<Animal> supplier, int countPerCall) {
        for (int i = 0; i < countPerCall; i++) {
            int x = RandomGenerator.nextInt(0, HEIGHT - 1);
            int y = RandomGenerator.nextInt(0, WIDTH - 1);
            Cell cell = grid[x][y];
            Animal a = supplier.get();
            if (a != null && cell.canAddAnimal(a.getName())) {
                cell.addAnimal(a);
            }
        }
    }
    public synchronized void moveAnimal(Animal animal, int fromX, int fromY, int toX, int toY) {
        if (toX < 0 || toY < 0 || toX >= HEIGHT || toY >= WIDTH) return;

        Cell from = grid[fromX][fromY];
        Cell to = grid[toX][toY];
        // Проверяю может ли Entity плавать
        if (to.getTerrain() == TerrainType.WATER) {

            String name = animal.getName();
            boolean canSwim = name != null && Config.CAN_SWIM.getOrDefault(name, false);

            if (!canSwim) {
                return;
            }
        }


        from.removeAnimal(animal);

        if (to.canAddAnimal(animal.getName())) {
            to.addAnimal(animal);
        } else {
            from.addAnimal(animal);
        }
    }
}

