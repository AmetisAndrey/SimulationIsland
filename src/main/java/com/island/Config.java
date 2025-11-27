package com.island;

import java.util.Map;

public class Config {

    public static final int ISLAND_WIDTH = 30;
    public static final int ISLAND_HEIGHT = 20;

    public static final int TICK_PLANTS_SEC = 1;
    public static final int TICK_ANIMALS_SEC = 2;
    public static final int TICK_STATS_SEC = 3;
    public static final int TICK_RESPAWN_SEC = 10;

    public static final double DEFAULT_WEIGHT = 1.0;
    public static final double DEFAULT_FOOD = 0.1;
    public static final int DEFAULT_SPEED = 1;


    public static final boolean STOP_WHEN_NO_ANIMALS = true;

    // ============================
    //      WEIGHT
    // ============================
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
            Map.entry("Caterpillar", 0.01),
            Map.entry("Duck", 4.0),
            Map.entry("Hedgehog", 1.0),
            Map.entry("Swan", 6.0)
    );

    // ============================
    //      MAX IN CELL
    // ============================
    public static final Map<String, Integer> MAX_IN_CELL = Map.ofEntries(
            Map.entry("Wolf", 30),
            Map.entry("Snake", 50),
            Map.entry("Fox", 30),
            Map.entry("Bear", 5),
            Map.entry("Eagle", 20),

            Map.entry("Horse", 20),
            Map.entry("Deer", 20),
            Map.entry("Rabbit", 150),
            Map.entry("Mouse", 500),
            Map.entry("Goat", 140),
            Map.entry("Sheep", 140),
            Map.entry("Boar", 50),
            Map.entry("Buffalo", 10),
            Map.entry("Caterpillar", 1000),
            Map.entry("Duck", 200),
            Map.entry("Hedgehog", 200),
            Map.entry("Swan", 200)
    );

    // ============================
    //      SPEED
    // ============================
    public static final Map<String, Integer> SPEED = Map.ofEntries(
            Map.entry("Wolf", 3),
            Map.entry("Fox", 2),
            Map.entry("Bear", 2),
            Map.entry("Eagle", 3),
            Map.entry("Snake", 1),

            Map.entry("Horse", 4),
            Map.entry("Deer", 4),
            Map.entry("Rabbit", 2),
            Map.entry("Mouse", 1),
            Map.entry("Goat", 3),
            Map.entry("Sheep", 3),
            Map.entry("Boar", 2),
            Map.entry("Buffalo", 3),
            Map.entry("Caterpillar", 1),
            Map.entry("Duck", 4),
            Map.entry("Hedgehog", 1),
            Map.entry("Swan", 4)
    );

    // ============================
    //      FOOD NEEDED
    // ============================
    public static final Map<String, Double> FOOD_NEEDED = Map.ofEntries(
            Map.entry("Wolf", 8.0),
            Map.entry("Snake", 3.0),
            Map.entry("Fox", 2.0),
            Map.entry("Bear", 40.0),
            Map.entry("Eagle", 1.0),

            Map.entry("Horse", 60.0),
            Map.entry("Deer", 50.0),
            Map.entry("Rabbit", 0.45),
            Map.entry("Mouse", 0.01),
            Map.entry("Goat", 10.0),
            Map.entry("Sheep", 15.0),
            Map.entry("Boar", 20.0),
            Map.entry("Buffalo", 100.0),
            Map.entry("Caterpillar", 0.002),
            Map.entry("Duck", 0.15),
            Map.entry("Hedgehog", 0.2),
            Map.entry("Swan", 0.2)
    );

    // ============================
    //      CAN SWIM
    // ============================
    public static final Map<String, Boolean> CAN_SWIM = Map.ofEntries(
            Map.entry("Duck", true),
            Map.entry("Swan", true),
            Map.entry("Bear", true),
            Map.entry("Boar", true),

            Map.entry("Wolf", false),
            Map.entry("Fox", false),
            Map.entry("Eagle", false),
            Map.entry("Snake", false),
            Map.entry("Rabbit", false),
            Map.entry("Mouse", false),
            Map.entry("Goat", false),
            Map.entry("Sheep", false),
            Map.entry("Horse", false),
            Map.entry("Deer", false),
            Map.entry("Buffalo", false),
            Map.entry("Caterpillar", false),
            Map.entry("Hedgehog", false)
    );
    public static final Map<String, Integer> OFFSPRING_COUNT = Map.ofEntries(
            Map.entry("Wolf", 2),
            Map.entry("Fox", 2),
            Map.entry("Bear", 1),
            Map.entry("Eagle", 1),
            Map.entry("Snake", 4),

            Map.entry("Boar", 5),
            Map.entry("Goat", 2),
            Map.entry("Sheep", 2),
            Map.entry("Deer", 2),
            Map.entry("Rabbit", 6),
            Map.entry("Mouse", 8),

            Map.entry("Duck", 3),
            Map.entry("Swan", 2),

            Map.entry("Caterpillar", 20),
            Map.entry("Hedgehog", 3),
            Map.entry("Buffalo", 1),
            Map.entry("Horse", 1)
    );
}
