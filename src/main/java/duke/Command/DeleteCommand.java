package duke.Command;

import duke.Duke;
import duke.DukeException;

import java.io.IOException;

/**
 * Represents the delete command used in the user input.
 */
public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    private static final int ARGUMENTS_NUM = 2;

    public DeleteCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the deadline command by deleting specific task in the program.
     *
     * @param arguments parsed arguments for delete command.
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Duke.getTaskList().deleteTask(arguments[1]);
        } catch (DukeException | IOException e) {
            ;
        }
    }

    @Override
    public int getNumberOfArguments() {
        return ARGUMENTS_NUM;
    }
}
