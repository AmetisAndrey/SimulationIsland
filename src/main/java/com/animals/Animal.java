package com.animals;

import com.island.Island;
import com.island.Cell;
import com.island.Config;

public abstract class Animal {
    protected String name;
    protected double weight;
    protected int speed;
    protected double foodNeeded;
    protected double satiety;
    protected boolean alive = true;

    public Animal(String name) {
        this.name = name;
        this.weight = Config.WEIGHT.getOrDefault(name, Config.DEFAULT_WEIGHT);
        this.foodNeeded = Config.FOOD_NEEDED.getOrDefault(name, Config.DEFAULT_FOOD);
        this.speed = Config.SPEED.getOrDefault(name, Config.DEFAULT_SPEED);
        this.satiety = this.foodNeeded;
    }

    public boolean isAlive() { return alive; }

    public void die() { alive = false; }

    public void loseEnergy() {
        satiety -= foodNeeded * 0.1;
        if (satiety <= 0) die();
    }

    public void increaseSatiety(double foodWeight) {
        satiety = Math.min(satiety + foodWeight, foodNeeded);
    }

    public String getName() { return name; }

    public boolean isHungry() { return satiety < foodNeeded * 0.5; }

    public abstract void move(Island island, int x, int y);
    public abstract void eat(Cell cell);
    public abstract void reproduce(Cell cell);

    @Override
    public String toString() {
        return name + (alive ? " 🟢" : " ⚫");
    }
    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

    public void setFoodNeeded(double foodNeeded) {
        this.foodNeeded = foodNeeded;
    }
}
