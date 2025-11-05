package island;

import java.util.Map;

public class Config {

    public static final Map<String, Double> WEIGHT = Map.ofEntries(
            Map.entry("Wolf", 50.0),
            Map.entry("Snake", 15.0),
            Map.entry("Fox", 8.0),
            Map.entry("Bear", 100.0),
            Map.entry("Eagle", 6.0),

            Map.entry("Horse", 400.0),
            Map.entry("Deer", 300.0),
            Map.entry("Rabbit", 2.0),
            Map.entry("Mouse", 0.5),
            Map.entry("Goat", 60.0),
            Map.entry("Sheep", 70.0),
            Map.entry("Boar", 120.0),
            Map.entry("Buffalo", 700.0),
            Map.entry("Duck", 1.0),
            Map.entry("Caterpillar", 0.01)
    );

    public static final Map<String, Integer> MAX_IN_CELL = Map.ofEntries(
            Map.entry("Wolf", 30),
            Map.entry("Snake", 30),
            Map.entry("Fox", 30),
            Map.entry("Bear", 5),
            Map.entry("Eagle", 20),

            Map.entry("Horse", 20),
            Map.entry("Deer", 20),
            Map.entry("Rabbit", 150),
            Map.entry("Mouse", 200),
            Map.entry("Goat", 60),
            Map.entry("Sheep", 60),
            Map.entry("Boar", 30),
            Map.entry("Buffalo", 10),
            Map.entry("Duck", 80),
            Map.entry("Caterpillar", 300)
    );
    public static final Map<String, Integer> SPEED = Map.ofEntries(
            Map.entry("Wolf", 3),
            Map.entry("Snake", 1),
            Map.entry("Fox", 2),
            Map.entry("Bear", 2),
            Map.entry("Eagle", 3),

            Map.entry("Horse", 3),
            Map.entry("Deer", 3),
            Map.entry("Rabbit", 2),
            Map.entry("Mouse", 1),
            Map.entry("Goat", 2),
            Map.entry("Sheep", 2),
            Map.entry("Boar", 2),
            Map.entry("Buffalo", 2),
            Map.entry("Duck", 1),
            Map.entry("Caterpillar", 1)
    );
    public static final Map<String, Double> FOOD_NEEDED = Map.ofEntries(
            Map.entry("Wolf", 8.0),
            Map.entry("Snake", 1.0),
            Map.entry("Fox", 2.0),
            Map.entry("Bear", 20.0),
            Map.entry("Eagle", 1.0),

            Map.entry("Horse", 60.0),
            Map.entry("Deer", 50.0),
            Map.entry("Rabbit", 0.45),
            Map.entry("Mouse", 0.05),
            Map.entry("Goat", 10.0),
            Map.entry("Sheep", 15.0),
            Map.entry("Boar", 20.0),
            Map.entry("Buffalo", 100.0),
            Map.entry("Duck", 0.15),
            Map.entry("Caterpillar", 0.01)
    );
}
