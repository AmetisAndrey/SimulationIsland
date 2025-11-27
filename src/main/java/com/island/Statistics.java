package com.island;

import com.animals.Animal;

public class Statistics {

    public static void print(Island island) {
        int alive = 0;
        int plants = 0;

        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {

                // считаем животных
                for (Animal a : island.getCell(i, j).getAnimals()) {
                    if (a.isAlive()) alive++;
                }

                // считаем растения
                if (island.getCell(i, j).getPlant() != null) {
                    plants++;
                }
            }
        }

        // формат ИМЕННО такой, как требуется тестам
        System.out.println("Растений: " + plants);
        System.out.println("Животных: " + alive);
    }
}
