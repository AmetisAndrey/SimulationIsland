package com.ui;

import com.island.Island;
import com.island.Simulation;
import com.island.Cell;
import com.island.TerrainType;


import com.animals.Animal;
import com.animals.Herbivores;
import com.animals.Predators;
import com.animals.Omnivorous;

import com.plant.Plant;
import com.plant.PlantType;

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

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        startBtn = new JButton("▶ Start");
        pauseBtn = new JButton("⏸ Pause");
        resumeBtn = new JButton("🔁 Resume");
        exitBtn = new JButton("❌ Exit");

        Font btnFont = new Font("Segoe UI", Font.BOLD, 14);
        startBtn.setFont(btnFont);
        pauseBtn.setFont(btnFont);
        resumeBtn.setFont(btnFont);
        exitBtn.setFont(btnFont);

        controlPanel.add(startBtn);
        controlPanel.add(pauseBtn);
        controlPanel.add(resumeBtn);
        controlPanel.add(exitBtn);

        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statsLabel = new JLabel("🌿 Plants: 0 | 🐇 Herbivores: 0 | 🍖 Omnivores: 0 | 🐺 Predators: 0");
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

    private void refreshMap() {
        if (paused || simulation.getIsland() == null) return;

        SwingUtilities.invokeLater(() -> {
            Cell[][] grid = simulation.getIsland().getGrid();

            int plantCount = 0;
            int herbCount = 0;
            int omniCount = 0;
            int predCount = 0;

            for (int i = 0; i < Island.HEIGHT; i++) {
                for (int j = 0; j < Island.WIDTH; j++) {
                    Cell cell = grid[i][j];
                    JLabel lbl = gridLabels[i][j];

                    TerrainType terrain = cell.getTerrain();
                    Plant plant = cell.getPlant();
                    Animal top = cell.getAnimals().stream()
                            .filter(Animal::isAlive)
                            .findFirst()
                            .orElse(null);

                    Color bg;
                    String symbol = "";

                    if (terrain == TerrainType.WATER) {
                        bg = new Color(150, 200, 255);
                    } else {
                        bg = new Color(235, 225, 200);
                    }

                    boolean hasPlant = plant != null && plant.getWeight() > 0;

                    if (top == null && hasPlant && terrain == TerrainType.LAND) {
                        PlantType pType = plant.getType();
                        switch (pType) {
                            case GRASS -> {
                                symbol = "🌿";
                                bg = new Color(200, 255, 200);
                            }
                            case BUSH -> {
                                symbol = "🌳";
                                bg = new Color(180, 235, 180);
                            }
                            case TREE -> {
                                symbol = "🌲";
                                bg = new Color(160, 215, 160);
                            }
                        }
                        plantCount++;
                    }

                    if (top != null) {
                        String type = top.getClass().getSimpleName();

                        switch (type) {
                            case "Bear"        -> symbol = "🐻";
                            case "Wolf"        -> symbol = "🐺";
                            case "Fox"         -> symbol = "🦊";
                            case "Snake"       -> symbol = "🐍";
                            case "Eagle"       -> symbol = "🦅";
                            case "Boar"        -> symbol = "🐗";
                            case "Mouse"       -> symbol = "🐁";
                            case "Duck"        -> symbol = "🦆";
                            case "Hedgehog"    -> symbol = "🦔";
                            case "Horse"       -> symbol = "🐎";
                            case "Deer"        -> symbol = "🦌";
                            case "Rabbit"      -> symbol = "🐇";
                            case "Goat"        -> symbol = "🐐";
                            case "Sheep"       -> symbol = "🐑";
                            case "Buffalo"     -> symbol = "🐃";
                            case "Caterpillar" -> symbol = "🐛";
                            case "Swan"        -> symbol = "🦢";
                        }

                        // Цвет по типу животного (на суше)
                        if (top instanceof Predators) {
                            if (terrain == TerrainType.LAND)
                                bg = new Color(220, 20, 60); // красный оттенок
                            predCount++;
                        } else if (top instanceof Omnivorous) {
                            if (terrain == TerrainType.LAND)
                                bg = new Color(255, 99, 71); // оранжевый оттенок
                            omniCount++;
                        } else if (top instanceof Herbivores) {
                            if (terrain == TerrainType.LAND)
                                bg = new Color(240, 230, 140); // зелёно-жёлтый
                            herbCount++;
                        }

                        if (terrain == TerrainType.WATER) {
                            bg = new Color(150, 200, 255);
                        }
                    }

                    if (terrain == TerrainType.WATER && top == null && !hasPlant) {
                        symbol = "🌊";
                    }

                    lbl.setBackground(bg);
                    lbl.setText(symbol);
                }
            }

            statsLabel.setText(String.format(
                    "🌿 Plants: %d | 🐇 Herbivores: %d | 🍖 Omnivores: %d | 🐺 Predators: %d",
                    plantCount, herbCount, omniCount, predCount
            ));
        });
    }
}
