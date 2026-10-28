package actions;

import entity.Creature;
import entity.Herbivore;
import entity.Predator;
import game.SimulationMap;

import java.util.ArrayList;
import java.util.List;

public class TurnActions {
    private final SimulationMap simulationMap;

    public TurnActions(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    public void moveHerbivores() {
        List<Creature> creatures = new ArrayList<>(simulationMap.getEntities().values());

        for (Creature creature : creatures) {
            if (creature instanceof Herbivore) {
                creature.makeMove(simulationMap);
            }
        }
        System.out.println("Herbivores made a move");
    }

    public void movePredators() {
        List<Creature> creatures = new ArrayList<>(simulationMap.getEntities().values());

        for (Creature creature : creatures) {
            if (creature instanceof Predator) {
                creature.makeMove(simulationMap);
            }
        }
        System.out.println("Predators made a move");
    }

    public void removeEntityIfHPZero() {
        List<Creature> creatures = new ArrayList<>(simulationMap.getEntities().values());

        for (Creature creature : creatures) {
            if (creature.getHP() <= 0) {
                simulationMap.getEntities().values().removeIf(entity -> entity == creature);
            }
        }
    }

    public boolean stopGameIfZeroHerbivores() {
        for (Creature creature: simulationMap.getEntities().values()) {
            if (creature instanceof Herbivore) return false;
        }
        return true;
    }
}