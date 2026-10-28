package actions;

import config.SimulationConfig;
import entity.*;
import game.Coordinates;
import game.MapRenderer;
import game.SimulationMap;

import java.util.Map;
import java.util.Random;

public class InitActions {
    private final Random random = new Random();
    private final SimulationMap simulationMap;

    public InitActions(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    public void setDefaultHerbivoresPositions() {
        int i = 0;
        while (i < SimulationConfig.HERBIVORE_START_COUNT) {
            int randomRow = random.nextInt(simulationMap.getHeight());
            int randomColumn = random.nextInt(simulationMap.getWidth());
            Coordinates coordinates = new Coordinates(randomRow, randomColumn);

            if (!simulationMap.getEntities().containsKey(coordinates) && !simulationMap.getStaticEntities().containsKey(coordinates)) {
                simulationMap.setEntity(coordinates, new Herbivore(coordinates, SimulationConfig.HERBIVORE_HEALTH, SimulationConfig.HERBIVORE_SPEED));
                i++;
            }
        }
    }

    public void setDefaultPredatorsPositions() {
        int i = 0;
        while (i < SimulationConfig.PREDATOR_START_COUNT) {
            int randomRow = random.nextInt(simulationMap.getHeight());
            int randomColumn = random.nextInt(simulationMap.getWidth());
            Coordinates coordinates = new Coordinates(randomRow, randomColumn);

            if (!simulationMap.getEntities().containsKey(coordinates) && !simulationMap.getStaticEntities().containsKey(coordinates)) {
                simulationMap.setEntity(coordinates, new Predator(coordinates, SimulationConfig.PREDATOR_HEALTH, SimulationConfig.PREDATOR_SPEED, SimulationConfig.PREDATOR_ATTACK));
                i++;
            }
        }
    }

    public void setDefaultGrassPositions() {
        int i = 0;
        while (i < SimulationConfig.GRASS_START_COUNT) {
            int randomRow = random.nextInt(simulationMap.getHeight());
            int randomColumn = random.nextInt(simulationMap.getWidth());
            Coordinates coordinates = new Coordinates(randomRow, randomColumn);

            if (!simulationMap.getEntities().containsKey(coordinates) && !simulationMap.getStaticEntities().containsKey(coordinates)) {
                simulationMap.setStaticEntities(coordinates, new Grass(coordinates));
                i++;
            }
        }
    }

    public void setDefaultRockPositions() {
        int i = 0;
        while (i < SimulationConfig.ROCK_START_COUNT) {
            int randomRow = random.nextInt(simulationMap.getHeight());
            int randomColumn = random.nextInt(simulationMap.getWidth());
            Coordinates coordinates = new Coordinates(randomRow, randomColumn);

            if (!simulationMap.getEntities().containsKey(coordinates) && !simulationMap.getStaticEntities().containsKey(coordinates)) {
                simulationMap.setStaticEntities(coordinates, new Rock(coordinates));
                i++;
            }
        }
    }

    public void setDefaultTreePositions() {
        int i = 0;
        while (i < SimulationConfig.TREE_START_COUNT) {
            int randomRow = random.nextInt(simulationMap.getHeight());
            int randomColumn = random.nextInt(simulationMap.getWidth());
            Coordinates coordinates = new Coordinates(randomRow, randomColumn);

            if (!simulationMap.getEntities().containsKey(coordinates) && !simulationMap.getStaticEntities().containsKey(coordinates)) {
                simulationMap.setStaticEntities(coordinates, new Tree(coordinates));
                i++;
            }
        }
    }

    public void setDefaultPositionsForObjects() {
        setDefaultHerbivoresPositions();
        setDefaultPredatorsPositions();
        setDefaultGrassPositions();
        setDefaultTreePositions();
        setDefaultRockPositions();
    }

    public void startingMessage(MapRenderer mapRenderer) throws InterruptedException {
        mapRenderer.render();
        int i = 5;
        while (i > 1) {
            System.out.printf("Game starting in %d seconds...\n", i);
            Thread.sleep(1000);
            i--;
        }
        System.out.println("Game starting in 1 second...\n");
    }
}