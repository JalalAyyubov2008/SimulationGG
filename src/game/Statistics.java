package game;

import entity.Creature;
import entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final SimulationMap simulationMap;

    public Statistics(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    public void printStatistics() {
        printEntityStatistics();
        printStaticEntityStatistics();
    }

    public void printEntityStatistics() {
        System.out.println("=========================");
        Map<String, Integer> statistics = new HashMap<>();
        for (Creature creature: simulationMap.getEntities().values()) {
            statistics.put(creature.getEntitySign(), statistics.getOrDefault(creature.getEntitySign(), 0) + 1);
        }
        statistics.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));
        System.out.println("=========================");
    }

    public void printStaticEntityStatistics() {
        Map<String, Integer> statistics = new HashMap<>();
        for (Entity entity: simulationMap.getStaticEntities().values()) {
            statistics.put(entity.getEntitySign(), statistics.getOrDefault(entity.getEntitySign(), 0) + 1);
        }
        statistics.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));
        System.out.println("=========================");
    }
}
