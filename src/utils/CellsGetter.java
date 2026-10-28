package utils;

import actions.CoordinatesShift;
import entity.Creature;
import entity.Entity;
import entity.Herbivore;
import entity.Predator;
import game.Coordinates;
import game.SimulationMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CellsGetter {
    private final CellsChecker cellsChecker;

    public CellsGetter(CellsChecker cellsChecker) {
        this.cellsChecker = cellsChecker;
    }

    public List<Coordinates> getAvailableMoveCells(SimulationMap simulationMap, Set<CoordinatesShift> entityMoves, Coordinates coordinates) {
        List<Coordinates> result = new ArrayList<>();
        for (CoordinatesShift shift: entityMoves) {
            if (coordinates.canShift(shift, simulationMap.getHeight(), simulationMap.getWidth())) {
                addCellInResult(result, simulationMap, coordinates, shift);
            }
        }
        return result;
    }

    public void addCellInResult(List<Coordinates> result, SimulationMap simulationMap, Coordinates coordinates, CoordinatesShift shift) {
        Coordinates newCoordinates = coordinates.shift(shift);

        HashMap<Coordinates, Creature> creatureMap = simulationMap.getEntities();
        HashMap<Coordinates, Entity> entityMap = simulationMap.getStaticEntities();

        if (simulationMap.getEntities().get(coordinates) instanceof Herbivore) {
            if (cellsChecker.isCellAvailableForHerbivoreMove(newCoordinates, creatureMap, entityMap)) result.add(newCoordinates);
        }
        if (simulationMap.getEntities().get(coordinates) instanceof Predator) {
            if (cellsChecker.isCellAvailableForPredatorMove(newCoordinates, creatureMap, entityMap)) result.add(newCoordinates);
        }
    }
}
