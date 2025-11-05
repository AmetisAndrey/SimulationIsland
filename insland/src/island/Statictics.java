package island;

import animals.Animal;

    public class Statictics {
        public static void print(Island island) {
        int alive = 0;
        int plants = 0;
        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {
                for (Animal a : island.getCell(i, j).getAnimals())
                    if (a.isAlive()) alive++;
                if (island.getCell(i, j).getPlant() != null)
                    plants++;
            }
        }
        System.out.printf("🌿 Растений: %d | 🐾 Животных: %d%n", plants, alive);
    }
}