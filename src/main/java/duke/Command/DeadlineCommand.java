package duke.Command;

import duke.DukeException;
import duke.Task.Deadline;

import java.io.IOException;

/**
 * Represents the deadline command used in the user input.
 */
public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";
    private static final int ARGUMENTS_NUM = 2;

    public DeadlineCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the deadline command by adding Deadlines to the program.
     *
     * @param arguments parsed arguments for deadline command.
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Deadline.addDeadline(arguments[1]);
        } catch (DukeException | IOException e) {
            ;
        }
    }

    @Override
    public int getNumberOfArguments() {
        return ARGUMENTS_NUM;
    }
}