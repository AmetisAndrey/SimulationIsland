package com.utils;

import com.animals.*;

import com.animals.*;
import java.util.Random;


public class AnimalFactory {
    private static final String[] PREDATORS = {"Wolf", "Snake", "Fox", "Bear", "Eagle"};
    private static final String[] HERBIVORES = {
            "Horse", "Deer", "Rabbit", "Mouse", "Goat",
            "Sheep", "Boar", "Buffalo", "Duck", "Caterpillar"
    };

    public static Animal create(String type) {
        return switch (type) {
            case "Wolf" -> new Wolf();
            case "Snake" -> new Snake();
            case "Fox" -> new Fox();
            case "Eagle" -> new Eagle();
            case "Bear" -> new Bear();

            case "Boar" -> new Boar();
            case "Mouse" -> new Mouse();
            case "Duck" -> new Duck();
            case "Hedgehog" -> new Hedgehog();

            case "Horse" -> new Horse();
            case "Deer" -> new Deer();
            case "Rabbit" -> new Rabbit();
            case "Goat" -> new Goat();
            case "Sheep" -> new Sheep();
            case "Buffalo" -> new Buffalo();
            case "Caterpillar" -> new Caterpillar();
            case "Swan" -> new Swan();

            default -> null;
        };
    }


    public static Animal randomAnimal() {
        Random r = new Random();
        if (r.nextBoolean()) {
            return create(PREDATORS[r.nextInt(PREDATORS.length)]);
        } else {
            return create(HERBIVORES[r.nextInt(HERBIVORES.length)]);
        }
    }
}
