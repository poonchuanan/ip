package duke;

import java.util.Scanner;

/**
 * This class deals with the user's interface.
 */
public class Ui {
    private Scanner in;

    /**
     * Creates a new instance of scanner
     *
     */
    public Ui() {
        this.in = new Scanner(System.in);
    }

    /**
     * Reads the user input
     *
     */
    public String readCommand(){
        return in.nextLine();
    }

    /**
     * Prints top and bottom border around text.
     *
     * @param message text to be displayed to the user
     */
    public void printBorder(String message) {
        String line = "------------------------------------------------------------\n";
        System.out.print(line + message + line);
    }

    /**
     * Prints greeting message.
     */
    public void printWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String welcomeMessage = "Hello from\n" + logo + "Hello! I'm Duke\nWhat can I do for you?\n";
        printBorder(welcomeMessage);
    }

    /**
     * Prints exit message.
     */
    public void printBye() {
        String exitMessage = "Bye. Hope to see you again soon!\n";
        printBorder(exitMessage);
    }

    /**
     * Prints message for index out of bounds.
     */
    public void printIndexError() {
        String invalidNumber = "Please enter the correct range!\n";
        printBorder(invalidNumber);
    }

    /**
     * Prints message asking for valid index.
     *
     * @param Argument the argument that causes the error
     */
    public void printNumberFormatError(String Argument) {
        String invalidNumber = Argument + " is not a valid number!\n";
        printBorder(invalidNumber);
    }
}
