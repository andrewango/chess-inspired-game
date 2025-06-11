import java.util.Scanner;
import java.util.*;

public class TextView {

    private int fromRow;
    private int fromCol;
    private int toRow;
    private int toCol;
    char actionType;

    public static int getValidInt(int minimum, int maximum, Scanner scr) {
        // Create Scanner object to read data at keyboard
        scr = new Scanner(System.in);
        // Set up a boolean flag (boolean variable)
        boolean validValue = false;
        // Declare a variable to hold the value user enters
        int intValue = 0;
        // Loop until the user enters an integer between min and max arguments
        while (!validValue) {
            System.out.println("Enter a number between " + minimum + " and " + maximum + ": ");
            // Check if user input is an integer
            if (scr.hasNextInt()) {
                // Read in the integer
                intValue = scr.nextInt();
                // Check if int a positive value
                if (intValue >= minimum && intValue <= maximum) {
                    // Is within bounds so does not need to loop, set boolean flag to true
                    validValue = true;
                    System.out.println("Your value is: " + intValue);
                }
                else {
                    System.out.println("Your integer is out of bounds.");
                }
            }
            else {
                // Read the user input value
                scr.next();
                System.out.println("Your value is not an integer.");
            }
        }
        // Return the integer value after while loop ends
        return intValue;
    }

    Scanner scr = new Scanner(System.in);
    private void getPlayersNextAction() {
        fromRow = getValidInt(0, Game.getGameBoard().getNumRows(), scr);
    }
}
