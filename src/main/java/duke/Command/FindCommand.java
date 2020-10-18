package duke.Command;

import duke.Duke;
import duke.DukeException;

import java.io.IOException;

/**
 * Represents the find command used in the user input
 */
public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    private static final int ARGUMENTS_NUM = 2;

    public FindCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the find command by showing the list of matching tasks in program.
     *
     * @param arguments parsed arguments for find command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Duke.getTaskList().findTask(arguments[1]);
        } catch (DukeException | IOException e) {
            ;
        }
    }

    @Override
    public int getNumberOfArguments() {
        return ARGUMENTS_NUM;
    }
}
