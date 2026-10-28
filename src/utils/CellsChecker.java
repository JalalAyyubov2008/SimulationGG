package utils;

import entity.Creature;
import entity.Entity;
import entity.Herbivore;
import game.Coordinates;

import java.util.HashMap;

public class CellsChecker {
    public boolean isCellAvailableForHerbivoreMove(Coordinates coordinates, HashMap<Coordinates, Creature> creatureMap, HashMap<Coordinates, Entity> entityMap) {
        return (entityMap.containsKey(coordinates) && entityMap.get(coordinates).getEntitySign().equals("Grass")) || (!entityMap.containsKey(coordinates) && !creatureMap.containsKey(coordinates));
    }

    public boolean isCellAvailableForPredatorMove(Coordinates coordinates, HashMap<Coordinates, Creature> creatureMap, HashMap<Coordinates, Entity> entityMap) {
        return (creatureMap.containsKey(coordinates) && creatureMap.get(coordinates).getEntitySign().equals("Herbivore")) || (!creatureMap.containsKey(coordinates) && !entityMap.containsKey(coordinates));
    }
}
