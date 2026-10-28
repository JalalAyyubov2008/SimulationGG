package game;

import java.util.Scanner;

public class MoveCounter {
    private int count = 0;
    private final Scanner scanner = new Scanner(System.in);

    public void increaseCount() {
        count++;
        printCount();

    }

    private void printCount() {
        System.out.println("Moves: " + count);
        System.out.println("=========================\n");
    }

    public boolean askToContinue() {
        if (count == 0 || count % 15 != 0) return true;

        System.out.printf("You have done %d moves\nDo you want to continue?\n1 - yes | 2 - no\n", count);
        while (true) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input == 1) {
                    System.out.println("Continuing...");
                    return true;
                } else if (input == 2) {
                    System.out.println("Exiting...");
                    return false;
                }
            } else {
                scanner.next();
            }
            System.out.println("Please enter strictly 1 or 2.");
        }
    }
}
