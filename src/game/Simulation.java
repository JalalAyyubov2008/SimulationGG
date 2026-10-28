package game;

import actions.InitActions;
import actions.TurnActions;

public class Simulation {
    InitActions initActions;
    MapRenderer mapRenderer;
    TurnActions turnActions;
    Statistics statistics;
    MoveCounter moveCounter;
    private boolean isRunning = true;

    public Simulation(SimulationMap simulationMap) {
        this.initActions = new InitActions(simulationMap);
        this.mapRenderer = new MapRenderer(simulationMap);
        this.turnActions = new TurnActions(simulationMap);
        this.statistics = new Statistics(simulationMap);
        this.moveCounter = new MoveCounter();
        initActions.setDefaultPositionsForObjects();
    }

    private void nextTurn() throws InterruptedException {
        callMoveHerbivores();
        callMovePredators();
        turnActions.removeEntityIfHPZero();

        if (turnActions.stopGameIfZeroHerbivores()) {
            System.out.println("All herbivores died");
            isRunning = false;
        }
    }

    public void startSimulation() throws InterruptedException {
        initActions.startingMessage(mapRenderer);
        while (isRunning) {
            nextTurn();
        }
    }

    public void callMoveHerbivores() throws InterruptedException {
        Thread.sleep(1000);

        turnActions.moveHerbivores();
        mapRenderer.render();

        statistics.printStatistics();
        moveCounter.increaseCount();
        isRunning = moveCounter.askToContinue();
    }

    public void callMovePredators() throws InterruptedException {
        Thread.sleep(1000);

        turnActions.movePredators();
        mapRenderer.render();

        statistics.printStatistics();
        moveCounter.increaseCount();
        isRunning = moveCounter.askToContinue();
    }
}