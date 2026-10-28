import config.SimulationConfig;
import game.Simulation;
import game.SimulationMap;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int width;
        int height;

        System.out.printf("Enter the height for the map, min height: %d\n", SimulationConfig.MAP_MIN_HEIGHT);
        while (true) {
            height= scanner.nextInt();
            if (height >= 10) break;
            else System.out.println("Enter a correct number");
        }

        System.out.printf("Enter the width for the map, min width: %d\n", SimulationConfig.MAP_MIN_WIDTH);
        while (true) {
            width = scanner.nextInt();
            if (width >= 10) break;
            else System.out.println("Enter a correct number");
        }

        SimulationMap simulationMap = new SimulationMap(height, width);
        Simulation simulation = new Simulation(simulationMap);

        simulation.startSimulation();
    }
}
