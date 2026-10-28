package game;

import entity.Creature;
import entity.Entity;

import java.util.HashMap;

public class MapRenderer {
    private final HashMap<Coordinates, Creature> entities;
    private final HashMap<Coordinates, Entity> staticEntities;
    private final int height;
    private final int width;
    public static final String EMPTY_CELL = "\uD83D\uDFEB";
    public static final String ROCK = "\uD83E\uDEA8";
    public static final String GRASS = "\uD83C\uDF40";
    public static final String TREE  = "\uD83C\uDF34";
    public static final String HERBIVORE = "\uD83E\uDD8C";
    public static final String PREDATOR = "\uD83D\uDC3A";


    public MapRenderer(SimulationMap simulationMap) {
        this.entities = simulationMap.getEntities();
        this.staticEntities = simulationMap.getStaticEntities();
        this.height = simulationMap.getHeight();
        this.width = simulationMap.getWidth();
    }

    public void render() {
        System.out.println("=========================");
        for (int r = 0; r <= height; r++) {
            for (int c = 0; c <= width; c++) {
                Coordinates coordinate = new Coordinates(r, c);
                if (entities.containsKey(coordinate)) {
                    switch (entities.get(coordinate).getEntitySign()) {
                        case "Herbivore" -> System.out.print(HERBIVORE + " ");
                        case "Predator" -> System.out.print(PREDATOR + " ");
                    }
                } else if (staticEntities.containsKey(coordinate)) {
                    switch (staticEntities.get(coordinate).getEntitySign()) {
                        case "Grass" -> System.out.print(GRASS + " ");
                        case "Tree" -> System.out.print(TREE + " ");
                        case "Rock" -> System.out.print(ROCK + " ");
                    }
                } else {
                    System.out.print(EMPTY_CELL + " ");
                }
            }
            System.out.println();
        }
    }
}