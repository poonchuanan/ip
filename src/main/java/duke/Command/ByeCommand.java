package duke.Command;

import duke.Duke;
import duke.DukeException;

/**
 * Bye command used in user input.
 */
public class ByeCommand extends Command {
    public static final String COMMAND_WORD= "bye";
    private static final int ARGUMENTS_NUM = 1;

    public ByeCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the bye command by exiting the program with error 0.
     *
     * @param arguments parsed arguments for bye command.
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Duke.getUi().printBye();
            System.exit(0);
        } catch (DukeException e) {
            ;
        }
    }

    @Override
    public int getNumberOfArguments() {
        return ARGUMENTS_NUM;
    }
}