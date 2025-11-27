package com.plant;

public class Plant {
    private double weight;
    private final double maxWeight;
    private final double growthPerTick;
    private final PlantType type;

    public Plant(PlantType type) {
        this.type = type;
        switch(type) {
            case GRASS -> {
                this.weight = 3.0;
                this.maxWeight = 15.0;
                this.growthPerTick = 1.0;
            }
            case BUSH -> {
                this.weight = 5.0;
                this.maxWeight = 25.0;
                this.growthPerTick = 0.7;
            }
            case TREE -> {
                this.weight = 8.0;
                this.maxWeight = 40.0;
                this.growthPerTick = 0.4;
            }
            default -> throw new IllegalArgumentException("Неизвестный тип растения");
        }
    }

    public  PlantType getType(){
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public void grow() {
        if(weight < maxWeight){
            weight = Math.min(maxWeight, weight + growthPerTick);
        }
    }

    public void reduce(double amount) {
        weight = Math.max(0.0, weight - amount);
    }
}

