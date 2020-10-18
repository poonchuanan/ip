package duke.Command;

import duke.Duke;
import duke.DukeException;

/**
 * Represents the list command used in the user input
 */
public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";
    private static final int ARGUMENTS_NUM = 1;

    public ListCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the list command by showing the list of tasks in program.
     *
     * @param arguments parsed arguments for list command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Duke.getTaskList().displayList();
        } catch (DukeException e) {
            ;
        }
    }

    @Override
    public int getNumberOfArguments() {
        return ARGUMENTS_NUM;
    }

}
