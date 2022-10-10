import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class UI {

    LocalTime time = LocalTime.now();
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

    Scanner myScanner = new Scanner(System.in);


    /** This command line program is designed to help parents keep track of their child's bathroom, eating, and sleeping throughout the day.**/

    /** MENUS **/
    public int printMenu() {
        System.out.println("\n**************************");
        System.out.println("****** BABY TRACKER ******");
        System.out.println("**************************\n");

        System.out.println("(1) Bathroom");
        System.out.println("(2) Eating/Drinking");
        System.out.println("(3) Sleep");
        System.out.println("(4) Display Entries");
        System.out.println("(5) Exit");

        try {
            System.out.print("\nSelect an option above: ");
            String answer = myScanner.nextLine();

            if (answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5")) {
                return Integer.parseInt(answer);
            } else {
                System.out.println("Invalid entry");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry");
        }
        return 0;
    }

    public int printBathroomSubMenu() {
        System.out.println("(1) Urine");
        System.out.println("(2) Bowel Movement");
        System.out.println("(3) Bathroom Attempt");
        System.out.println(("(4) Back"));

    try {
        System.out.print("\nSelect an option above: ");
        String answer = myScanner.nextLine();

        if(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4")) {
            return Integer.parseInt(answer);
        }else {
            System.out.println("Invalid entry");
        }
    } catch (NumberFormatException e) {
        System.out.println("Invalid entry");
    }
        return 0;
    }

    public int printFoodSubMenu() {
        System.out.println("(1) Bottle Feeding");
        System.out.println("(2) Eating");
        System.out.println("(3) Drinking");
        System.out.println(("(4) Back"));

        try {
            System.out.print("\nSelect an option above: ");
            String answer = myScanner.nextLine();

            if(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4")) {
                return Integer.parseInt(answer);
            }else {
                System.out.println("Invalid entry");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry");
        }
        return 0;
    }

    public int printSleepSubMenu() {
        System.out.println("(1) Sleep Start");
        System.out.println("(2) Sleep End");
        System.out.println("(3) Back");

        try {
            System.out.print("\nSelect an option above: ");
            String answer = myScanner.nextLine();

            if(answer.equals("1") || answer.equals("2") || answer.equals("3")) {
                return Integer.parseInt(answer);
            }else {
                System.out.println("Invalid entry");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry");
        }
        return 0;
    }


    /** DATE_TIME FORMATTING **/
    public String makeTimestamp() {
        String timeStamp = date.format(formatter) + " " + time.format(timeFormatter);
        return timeStamp;
    }


    /** BATHROOM ENTRIES **/

    public String urineEntry() {
        String urineEntry = makeTimestamp() + " -- Urinated";
        return urineEntry;
    }

    public String bowelMovementEntry() {
        String bowelMovement = makeTimestamp() + " -- Bowel Movement";
        return bowelMovement;
    }

    public String bathroomAttemptEntry() {
        String bathroomAttempt = makeTimestamp() + " -- Bathroom Attempt";
        return bathroomAttempt;
    }


    /** FOOD ENTRIES **/
    public String bottleFeedingEntry() {
        int numberOfOunces = 0;
        System.out.print("How many ounces were consumed? ");
        try {
            numberOfOunces = myScanner.nextInt();
            myScanner.nextLine();
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid entry");
            }
        String bottleFeed = makeTimestamp() + " -- Bottle Feeding (" + numberOfOunces + "oz)";
        return bottleFeed;
    }

    public String liquidEntry() {
        System.out.println("Brief Description of what was drank: ");
        String liquidDescription = myScanner.nextLine();

        int numberOfOunces = 0;
        System.out.print("How many ounces were drank? (approx): ");
        try {
            numberOfOunces = myScanner.nextInt();
            myScanner.nextLine();
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid entry");
        }
        String bottleFeed = makeTimestamp() + " -- " + liquidDescription + " (" + numberOfOunces + "oz)";
        return bottleFeed;
    }

    public String foodEntry() {
        String foodGiven = "";
        System.out.print("Enter brief description of what was consumed? ");
        try {
            foodGiven = myScanner.nextLine();
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid entry");
        }
        String foodEaten = makeTimestamp() + " -- Food: " + foodGiven;
        return foodEaten;
    }


    /** SLEEP ENTRY **/
    public String fellAsleepEntry() {
        LocalTime timeFellAsleep = LocalTime.now();

        String sleepEntry = makeTimestamp() + " -- Fell Asleep";
        return sleepEntry;
    }

    /** SLEEP ENTRY **/
    public String awakeFromSleepEntry() {
        LocalTime timeWokeFromSleep = LocalTime.now();

        String sleepEntry = makeTimestamp() + " -- Woke up";
        return sleepEntry;
    }


    public void printEntries(List<String> entries) {
        for(String entry: entries) {
            System.out.println(entry);
        }
    }

}

