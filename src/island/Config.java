package island;

import java.util.Map;

public class Config {

    public static final int ISLAND_WIDTH = 30;
    public static final int ISLAND_HEIGHT = 20;

    public static final int TICK_PLANTS_SEC = 1;
    public static final int TICK_ANIMALS_SEC = 2;
    public static final int TICK_STATS_SEC = 3;
    public static final int TICK_RESPAWN_SEC = 10;


    public static final boolean STOP_WHEN_NO_ANIMALS = true;


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
            Map.entry("Caterpillar", 0.01),

            Map.entry("Hedgehog", 0.8),
            Map.entry("Swan", 8.0)
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
            Map.entry("Caterpillar", 1),

            Map.entry("Hedgehog", 1),
            Map.entry("Swan", 2)
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
            Map.entry("Caterpillar", 0.01),

            Map.entry("Hedgehog", 0.1),
            Map.entry("Swan", 0.6)
    );

    public static final Map<String, Integer> MAX_IN_CELL = Map.ofEntries(
            Map.entry("Wolf", 10),
            Map.entry("Snake", 10),
            Map.entry("Fox", 10),
            Map.entry("Bear", 3),
            Map.entry("Eagle", 8),

            Map.entry("Horse", 20),
            Map.entry("Deer", 20),
            Map.entry("Rabbit", 150),
            Map.entry("Mouse", 200),
            Map.entry("Goat", 60),
            Map.entry("Sheep", 60),
            Map.entry("Boar", 30),
            Map.entry("Buffalo", 10),
            Map.entry("Duck", 80),
            Map.entry("Caterpillar", 300),

            Map.entry("Hedgehog", 80),
            Map.entry("Swan", 25)
    );
    public static final Map<String, Integer> OFFSPRING_COUNT = Map.ofEntries(
            Map.entry("Wolf", 1),
            Map.entry("Bear", 1),
            Map.entry("Fox", 2),
            Map.entry("Eagle", 1),
            Map.entry("Snake", 2),

            Map.entry("Rabbit", 3),
            Map.entry("Mouse", 4),
            Map.entry("Duck", 3),
            Map.entry("Goat", 1),
            Map.entry("Sheep", 1),
            Map.entry("Boar", 2),
            Map.entry("Horse", 1),
            Map.entry("Deer", 1),
            Map.entry("Buffalo", 1),
            Map.entry("Caterpillar", 5),
            Map.entry("Hedgehog", 2),
            Map.entry("Swan", 2)
    );

    public static final Map<String, Integer> INITIAL_ANIMALS = Map.ofEntries(
            Map.entry("Wolf", 8),
            Map.entry("Bear", 3),
            Map.entry("Fox", 6),
            Map.entry("Snake", 6),
            Map.entry("Eagle", 4),

            Map.entry("Rabbit", 40),
            Map.entry("Mouse", 40),
            Map.entry("Deer", 15),
            Map.entry("Horse", 10),
            Map.entry("Sheep", 20),
            Map.entry("Goat", 20),
            Map.entry("Boar", 10),
            Map.entry("Buffalo", 5),
            Map.entry("Duck", 25),
            Map.entry("Caterpillar", 60),
            Map.entry("Hedgehog", 15),
            Map.entry("Swan", 8)
    );

    public static final Map<String, Boolean> CAN_SWIM = Map.ofEntries(
            Map.entry("Duck", true),
            Map.entry("Swan", true),
            Map.entry("Eagle", true),
            Map.entry("Bear", true),
            Map.entry("Boar", true),
            Map.entry("Buffalo", true)
    );
}
