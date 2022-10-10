import java.sql.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BabyTrackerApp {
    public static void main(String[] args) {

        UI userInterface = new UI();
        List<String> entries = new ArrayList<>();

        boolean isRunning = true;
        while (isRunning) {
            int mainMenuChoice = userInterface.printMenu();

            /** SUB-MENU BATHROOM **/
            if (mainMenuChoice == 1) {
                while (true) {
                    int bathroomChoice = userInterface.printBathroomSubMenu();
                    if (bathroomChoice == 1) {
                        entries.add(userInterface.urineEntry());
                    }
                    if (bathroomChoice == 2) {
                        entries.add(userInterface.bowelMovementEntry());
                    }
                    if (bathroomChoice == 3) {
                        entries.add(userInterface.bathroomAttemptEntry());
                    }
                    if (bathroomChoice == 4) {
                        break;
                    }
                }
            }

            /** SUB-MENU FEEDING  **/
                if (mainMenuChoice == 2) {
                    while (true) {
                        int foodChoice = userInterface.printFoodSubMenu();
                        if (foodChoice == 1) {
                            entries.add(userInterface.bottleFeedingEntry());
                        }
                        if (foodChoice == 2) {
                            entries.add(userInterface.foodEntry());
                        }
                        if (foodChoice == 3) {
                            entries.add(userInterface.liquidEntry());
                        }
                        if (foodChoice == 4) {
                            break;
                        }
                    }
                }
            /** SUB-MENU - SLEEP  **/
            if (mainMenuChoice == 3) {
                while (true) {

                    int sleepChoice = userInterface.printSleepSubMenu();
                    LocalTime timeHolder = null;
                    if (sleepChoice == 1) {
                        entries.add(userInterface.fellAsleepEntry());
                    }
                    if (sleepChoice == 2) {
                        entries.add(userInterface.awakeFromSleepEntry());
                    }
                    if (sleepChoice == 3) {
                        break;
                    }
                }
                }
            /** DISPLAY ENTRIES  **/
            if (mainMenuChoice == 4) {
                userInterface.printEntries(entries);
            }
            /** EXIT PROGRAM  **/
            if (mainMenuChoice == 5) {
                isRunning = false;
            }
        }
    }
}
