package ui;

import island.Island;
import island.Simulation;
import animals.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.concurrent.*;

public class IslandFrame extends JFrame {

    private final Simulation simulation;
    private final JLabel[][] gridLabels;
    private final JLabel statsLabel;
    private final JButton startBtn, pauseBtn, resumeBtn, exitBtn;
    private ScheduledExecutorService uiUpdater;
    private boolean paused = false;

    public IslandFrame(Simulation simulation) {
        this.simulation = simulation;
        setTitle("🌍 Island Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 700);
        setLocationRelativeTo(null);


        JPanel mapPanel = new JPanel(new GridLayout(Island.HEIGHT, Island.WIDTH));
        mapPanel.setBackground(Color.BLACK);
        gridLabels = new JLabel[Island.HEIGHT][Island.WIDTH];

        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {
                JLabel lbl = new JLabel("", SwingConstants.CENTER);
                lbl.setOpaque(true);
                lbl.setBorder(new LineBorder(Color.DARK_GRAY, 1));
                lbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 22));
                lbl.setBackground(new Color(220, 220, 220));
                gridLabels[i][j] = lbl;
                mapPanel.add(lbl);
            }
        }


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        startBtn = new JButton("▶ Start");
        pauseBtn = new JButton("⏸ Pause");
        resumeBtn = new JButton("🔁 Resume");
        exitBtn = new JButton("❌ Exit");

        startBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pauseBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        resumeBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        exitBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        controlPanel.add(startBtn);
        controlPanel.add(pauseBtn);
        controlPanel.add(resumeBtn);
        controlPanel.add(exitBtn);


        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statsLabel = new JLabel("🌿 Plants: 0 | 🐇 Herbivores: 0 | 🐺 Predators: 0");
        statsLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        statsPanel.add(statsLabel);

        add(statsPanel, BorderLayout.NORTH);
        add(mapPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);


        startBtn.addActionListener(e -> startSimulation());
        pauseBtn.addActionListener(e -> pauseSimulation());
        resumeBtn.addActionListener(e -> resumeSimulation());
        exitBtn.addActionListener(e -> System.exit(0));
    }

    private void refreshMap() {
        var grid = simulation.getIsland().getGrid();
        int plantCount = 0, herbCount = 0, predCount = 0;

        for (int i = 0; i < Island.HEIGHT; i++) {
            for (int j = 0; j < Island.WIDTH; j++) {
                JLabel lbl = gridLabels[i][j];
                var cell = grid[i][j];


                lbl.setBackground(new Color(220, 220, 220));
                lbl.setText(" ");

                boolean hasPlant = cell.getPlant() != null && cell.getPlant().getWeight() > 0;
                Animal topAnimal = cell.getAnimals().stream()
                        .filter(Animal::isAlive)
                        .findFirst()
                        .orElse(null);


                String symbol = "";
                Color bg = new Color(210, 210, 210);

                if (topAnimal != null) {
                    String type = topAnimal.getClass().getSimpleName();

                    switch (type) {

                        case "Wolf" -> { symbol = "🐺"; bg = new Color(255, 120, 120); predCount++; }
                        case "Snake" -> { symbol = "🐍"; bg = new Color(255, 140, 100); predCount++; }
                        case "Fox" -> { symbol = "🦊"; bg = new Color(255, 100, 100); predCount++; }
                        case "Bear" -> { symbol = "🐻"; bg = new Color(255, 90, 90); predCount++; }
                        case "Eagle" -> { symbol = "🦅"; bg = new Color(255, 130, 130); predCount++; }


                        case "Horse" -> { symbol = "🐎"; bg = new Color(255, 240, 150); herbCount++; }
                        case "Deer" -> { symbol = "🦌"; bg = new Color(255, 240, 150); herbCount++; }
                        case "Rabbit" -> { symbol = "🐇"; bg = new Color(255, 240, 150); herbCount++; }
                        case "Mouse" -> { symbol = "🐁"; bg = new Color(255, 240, 150); herbCount++; }
                        case "Goat" -> { symbol = "🐐"; bg = new Color(255, 240, 150); herbCount++; }
                        case "Sheep" -> { symbol = "🐑"; bg = new Color(255, 240, 150); herbCount++; }
                        case "Boar" -> { symbol = "🐗"; bg = new Color(255, 240, 150); herbCount++; }
                        case "Buffalo" -> { symbol = "🐃"; bg = new Color(255, 240, 150); herbCount++; }
                        case "Duck" -> { symbol = "🦆"; bg = new Color(255, 240, 150); herbCount++; }
                        case "Caterpillar" -> { symbol = "🐛"; bg = new Color(255, 240, 150); herbCount++; }
                    }
                } else if (hasPlant) {
                    symbol = "🌿";
                    bg = new Color(170, 240, 170);
                    plantCount++;
                }

                lbl.setBackground(bg);
                lbl.setText(symbol);
            }
        }

        statsLabel.setText(String.format(
                "🌿 Plants: %d | 🐇 Herbivores: %d | 🐺 Predators: %d",
                plantCount, herbCount, predCount));
    }

    private void startSimulation() {
        if (uiUpdater != null && !uiUpdater.isShutdown()) return;
        simulation.start();
        uiUpdater = Executors.newSingleThreadScheduledExecutor();
        uiUpdater.scheduleAtFixedRate(this::refreshMap, 0, 1, TimeUnit.SECONDS);
    }

    private void pauseSimulation() {
        paused = true;
        simulation.setPaused(true);
    }

    private void resumeSimulation() {
        paused = false;
        simulation.setPaused(false);
    }
}
