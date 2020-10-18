package duke.Command;

import duke.DukeException;

/**
 * Command class used in user input.
 */
public abstract class Command {

    public Command(String[] arguments) {
        try {
            execute(arguments);
        } catch (DukeException e) {
            ;
        }
    }

    /**
     * Runs different functionalities of Duke based on the user's command.
     *
     * @param arguments parsed arguments for commands.
     */
    public void execute(String[] arguments) throws DukeException {
        checkSize(arguments);
    };

    /**
     * Checks the number of arguments for the different commands.
     *
     * @param arguments parsed arguments.
     * @throws DukeException if number of arguments is not the same as predetermined number.
     */
    public void checkSize(String[] arguments) throws DukeException {
        if (arguments.length < getNumberOfArguments()) {
            throw new DukeException(DukeException.LESS_THAN_SIZE);
        } else if (arguments.length > getNumberOfArguments()) {
            throw new DukeException(DukeException.MORE_THAN_SIZE);
        }
    }

    /**
     * Gets the number of arguments for a specific command.
     */
    public abstract int getNumberOfArguments();
}
