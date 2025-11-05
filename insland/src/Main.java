import island.Simulation;
import ui.IslandFrame;

public class Main {
    public static void main (String[] args){
        Simulation simulation = new Simulation();
        IslandFrame frame = new IslandFrame(simulation);
        frame.setVisible(true);
        simulation.start();
    }
}