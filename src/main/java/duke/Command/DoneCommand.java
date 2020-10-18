package duke.Command;

import duke.Duke;
import duke.DukeException;

import java.io.IOException;

/**
 * Done command in the user input
 */
public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";
    private static final int ARGUMENTS_NUM = 2;

    public DoneCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Marks the specified task as completed.
     *
     * @param arguments parsed arguments for done command.
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Duke.getTaskList().markTaskAsDone(arguments[1]);
        } catch (DukeException e) {
            ;
        } catch (NumberFormatException e) {
            Duke.getUi().printNumberFormatError(arguments[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getNumberOfArguments() {
        return ARGUMENTS_NUM;
    }
}
