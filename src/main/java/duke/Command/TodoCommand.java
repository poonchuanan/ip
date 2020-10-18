package duke.Command;

import duke.DukeException;
import duke.Task.Todo;

import java.io.IOException;

/**
 * Represents the todo command used in the user input
 */
public class TodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    private static final int ARGUMENTS_NUM = 2;

    public TodoCommand(String[] arguments) {
        super(arguments);
    }

    /**
     * Executes the todo command by adding the todo task to the program.
     *
     * @param arguments parsed arguments for todo command
     */
    @Override
    public void execute(String[] arguments) {
        try {
            super.execute(arguments);
            Todo.addTodo(arguments[1]);
        } catch (DukeException | IOException e) {
            ;
        }
    }

    @Override
    public int getNumberOfArguments() {
        return ARGUMENTS_NUM;
    }

}
