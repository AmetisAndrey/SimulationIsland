package utils;

import animals.*;
import animals.Predators;
import animals.Herbivores;
import java.util.Random;


public class AnimalFactory {
    private static final String[] PREDATORS = {"Wolf", "Snake", "Fox", "Bear", "Eagle"};
    private static final String[] HERBIVORES = {
            "Horse", "Deer", "Rabbit", "Mouse", "Goat",
            "Sheep", "Boar", "Buffalo", "Duck", "Caterpillar"
    };

    public static Animal create(String type){
        return switch (type) {
            case "Wolf" -> new Wolf();
            case "Snake" -> new Snake();
            case "Fox" -> new Fox();
            case "Bear" -> new Bear();
            case "Eagle" -> new Eagle();
            case "Horse" -> new Horse();
            case "Deer" -> new Deer();
            case "Rabbit" -> new Rabbit();
            case "Mouse" -> new Mouse();
            case "Goat" -> new Goat();
            case "Sheep" -> new Sheep();
            case "Boar" -> new Boar();
            case "Buffalo" -> new Buffalo();
            case "Duck" -> new Duck();
            case "Caterpillar" -> new Caterpillar();
            default -> throw new IllegalArgumentException("Неизвестный тип: " + type);
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
