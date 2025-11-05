package island;

import animals.Animal;
import utils.RandomGenerator;
import java.util.function.Supplier;

public class Island {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    private final Cell[][] grid = new Cell[HEIGHT][WIDTH];

    public Island() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = new Cell();
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

        Cell fromCell = grid[fromX][fromY];
        Cell toCell = grid[toX][toY];

        fromCell.removeAnimal(animal);

        if (toCell.canAddAnimal(animal.getName())) {
            toCell.addAnimal(animal);
        } else {
            fromCell.addAnimal(animal);
        }
    }
}

