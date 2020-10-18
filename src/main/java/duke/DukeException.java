package duke;

/**
 * Handles error exception in Duke.
 */
public class DukeException extends Exception {
    public static final String EMPTY_LIST = "empty list";
    public static final String ILLEGAL_NUMBER = "illegal number";
    public static final String LESS_THAN_SIZE = "arguments less than expected";
    public static final String MORE_THAN_SIZE = "arguments more than expected";
    public static final String INVALID_DESCRIPTION = "invalid description";

    /**
     * Prints out corresponding error messages.
     *
     * @param errorMessage The error found
     */
    public DukeException(String errorMessage) {
        switch(errorMessage) {
        case ILLEGAL_NUMBER:
            Duke.getUi().printBorder("Please input a valid number\n");
            break;
        case EMPTY_LIST:
            Duke.getUi().printBorder("Oh no the list is empty!\n");
            break;
        case LESS_THAN_SIZE:
            Duke.getUi().printBorder("☹ OOPS!!! The description cannot be empty.\n");
            break;
        case MORE_THAN_SIZE:
            Duke.getUi().printBorder("Oh no the number of arguments is more than expected!\n");
            break;
        case INVALID_DESCRIPTION:
            Duke.getUi().printBorder("Oh no the description should not be blank!\n");
            break;
        default:
            Duke.getUi().printBorder("Unknown error detected!\n");
        }
    }
}
