package duke;

import java.util.Scanner;

/**
 * Deals with interaction with the user
 */
public class Ui {
    private Scanner in;

    /**
     * Creates a new instance of scanner
     *
     * returns userInput
     */
    public Ui() {
        this.in = new Scanner(System.in);
    }
    /**
     * Reads the user input
     *
     * @return user input
     */
    public String readCommand(){
        return in.nextLine();
    }

    /**
     * Prints border around the text.
     *
     * @param displayText text to be displayed to the user
     */
    public void printBorder(String displayText) {
        String line = "____________________________________________________________\n";
        System.out.print(line + displayText + line);
    }

    /**
     * prints greeting message.
     */
    public void printGreeting() {
        String welcomeMessage = "Hello! I'm Duke\nWhat can I do for you?\n";
        printBorder(welcomeMessage);
    }

    /**
     * prints exit message.
     */
    public void printExit() {
        String exitMessage = "Bye. Hope to see you again soon!\n";
        printBorder(exitMessage);
    }

    /**
     * Tells the user that a number is to be expected.
     *
     * @param Argument the argument that causes the error
     */
    public void printNumberFormatError(String Argument) {
        String invalidNumber = Argument + " is not a valid number!\n";
        printBorder(invalidNumber);
    }

    /**
     * Tells the user that a valid number in range is to be expected.
     */
    public void printIndexError() {
        String invalidNumber = "Please enter a number in range!\n";
        printBorder(invalidNumber);
    }

    /**
     * Tells the user that the Object is empty
     */
    public void printNullError() {
        String nullErrorMessage = "Object is empty!\n";
        printBorder(nullErrorMessage);
    }

}
