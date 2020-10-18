package duke.Command;

import duke.DukeException;
import duke.Task.Event;

import java.io.IOException;

/**
 * Represents the event command used in the user input
 */
public class EventCommand extends Command {
    public static final String COMMAND_WORD = "event";
    private static final int ARGUMENTS_NUM = 2;

    public EventCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the event command by adding the event task to the program.
     *
     * @param arguments parsed arguments for event command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Event.addEvent(arguments[1]);
        } catch (DukeException | IOException e) {
            ;
        }
    }

    @Override
    public int getNumberOfArguments() {
        return ARGUMENTS_NUM;
    }
}
