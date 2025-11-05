package plant;

public class Plant {
    private double weight;

    public Plant(double weight) { this.weight = weight; }

    public double getWeight() { return weight; }

    public void grow() { weight += 1.0; }

    public void reduce(double amount) { weight = Math.max(0, weight - amount); }
}
