package duke.Task;

import duke.Duke;
import duke.DukeException;
import duke.Parser.Parser;

import java.io.IOException;

/**
 * Represents the properties of Deadline task.
 */
public class Deadline extends Task {
    private static final String TASK_TYPE = "D";
    protected String by;

    /**
     * Stores details of deadline in the instance
     *
     * @param description description of deadline task
     * @param by deadline due
     * @throws DukeException if wrong number of arguments
     */
    public Deadline(String description, String by) throws DukeException{
        super(description);
        this.by = by;
    }

    @Override
    public String getTaskType() {
        return TASK_TYPE;
    }

    /**
     * Prints the full details of deadline task
     *
     * @return full details of task -  deadline type, completion status and description
     */
    @Override
    public String toString() {
        return "["+ getTaskType() + "]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * Adds deadline task to the Tasklist by parsing the arguments.
     *
     * @param argument description of deadline
     */
    public static void addDeadline(String argument) throws IOException {
        try {
            String[] arguments = Parser.parseArgument(argument, " /by ", 0);
            Task d = new Deadline(arguments[0], arguments[1]);
            Duke.getTaskList().addTask(d,true);
        } catch (DukeException e) {
            ;
        } catch (IndexOutOfBoundsException e) {
            Duke.getUi().printBorder("The \"/by\" argument is missing.\n");
        }
    }
}
