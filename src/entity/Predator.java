package entity;

import actions.CoordinatesShift;
import game.Coordinates;
import game.SimulationMap;
import utils.CellsChecker;
import utils.CellsGetter;

import java.util.*;

public class Predator extends Creature {
    private final Integer attackPower;
    private final Random random = new Random();
    private final CellsGetter cellsGetter;

    public Predator(Coordinates coordinates, Integer HP, Integer speed, Integer attackPower) {
        super(coordinates, "Predator", HP, speed);
        this.attackPower = attackPower;
        CellsChecker cellsChecker = new CellsChecker();
        cellsGetter = new CellsGetter(cellsChecker);
    }

    public void makeMove(SimulationMap simulationMap) {
        List<Coordinates> moves = cellsGetter.getAvailableMoveCells(simulationMap, getEntityMoves(), coordinates);

        if (!moves.isEmpty()) {
            int randomMoveNumber = random.nextInt(moves.size());
            Coordinates nextCoordinate = moves.get(randomMoveNumber);

            Entity targetEntity = simulationMap.getEntities().get(nextCoordinate);
            if (targetEntity instanceof Herbivore) {
                int herbivoreHealth = attackHerbivore((Herbivore) targetEntity, nextCoordinate, simulationMap);
                if (herbivoreHealth <= 0) simulationMap.getEntities().remove(nextCoordinate);
            }

            changeCoordinates(coordinates, nextCoordinate, simulationMap);
        }
    }

    public int attackHerbivore(Herbivore herbivore, Coordinates coordinates, SimulationMap simulationMap) {
        if (herbivore.getHP() <= 0) simulationMap.getEntities().remove(coordinates);
        System.out.printf("The predator at %d %d attacked the herbivore\n", coordinates.row() + 1, coordinates.column() + 1);
        setHP(getHP() + 3);
        return herbivore.decreaseHP(attackPower);
    }

    protected Set<CoordinatesShift> getEntityMoves() {
        return new HashSet<>(Arrays.asList(
                new CoordinatesShift(0, speed),
                new CoordinatesShift(speed, 0),
                new CoordinatesShift(0, -speed),
                new CoordinatesShift(-speed, 0),
                new CoordinatesShift(speed, speed),
                new CoordinatesShift(-speed, -speed),
                new CoordinatesShift(speed, -speed),
                new CoordinatesShift(-speed, speed)
        ));
    }
}