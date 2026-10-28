package entity;

import actions.CoordinatesShift;
import game.Coordinates;
import game.SimulationMap;
import utils.CellsChecker;
import utils.CellsGetter;

import java.util.*;

public class Herbivore extends Creature {
    private final Random random = new Random();
    private final CellsGetter cellsGetter;

    public Herbivore(Coordinates coordinates, Integer HP, Integer speed) {
        super(coordinates,"Herbivore", HP, speed);
        CellsChecker cellsChecker = new CellsChecker();
        cellsGetter = new CellsGetter(cellsChecker);

    }

    public void makeMove(SimulationMap simulationMap) {
        List<Coordinates> moves = cellsGetter.getAvailableMoveCells(simulationMap, getEntityMoves(), coordinates);

        if (!moves.isEmpty()) {
            int randomMoveNumber = random.nextInt(moves.size());
            Coordinates nextCoordinate = moves.get(randomMoveNumber);

            Entity staticEntity = simulationMap.getStaticEntities().get(nextCoordinate);
            if (staticEntity instanceof Grass) {
                simulationMap.getStaticEntities().remove(nextCoordinate);
                eatGrass(nextCoordinate);
            }

            changeCoordinates(coordinates, nextCoordinate, simulationMap);
        }
    }

    public void eatGrass(Coordinates coordinates) {
        setHP(getHP() + 4);
        System.out.printf("The herbivore at %d %d ate the grass\n", coordinates.row() + 1, coordinates.column() + 1);
    }

    public int decreaseHP(int attackPower) {
        int currentHP = getHP() - attackPower;
        setHP(Math.max(currentHP, 0));
        return HP;
    }

    @Override
    protected Set<CoordinatesShift> getEntityMoves() {
        return new HashSet<>(Arrays.asList(
                new CoordinatesShift(speed, 0),
                new CoordinatesShift(0, speed),
                new CoordinatesShift(0, speed),
                new CoordinatesShift(speed, 0),
                new CoordinatesShift(speed, speed),
                new CoordinatesShift(-speed, -speed),
                new CoordinatesShift(speed, -speed),
                new CoordinatesShift(-speed, speed)
        ));
    }
}