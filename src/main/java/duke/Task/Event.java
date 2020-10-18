package duke.Task;

import duke.Duke;
import duke.DukeException;
import duke.Parser.Parser;

import java.io.IOException;


/**
 * Represents the properties of event task.
 */
public class Event extends Task {
    private static final String TASK_TYPE = "E";
    protected String at;

    /**
     * Stores details of event in the instance.
     *
     * @param description description of deadline task
     * @param at date and time
     * @throws IndexOutOfBoundsException if blank arguments is given
     */
    public Event(String description, String at) throws DukeException {
        super(description);
        this.at = at;
    }

    /**
     * Prints the full details of event task
     *
     * @return full details of task -  event type, completion status and description
     */
    @Override
    public String toString() {
        return "["+ getTaskType() + "]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String getTaskType() {
        return TASK_TYPE;
    }


    /**
     * Add event task to the Tasklist by parsing the arguments.
     *
     * @param argument description of event
     */
    public static void addEvent(String argument) throws IOException {
        try {
            String[] arguments = Parser.parseArgument(argument, " /at ", 0);
            Task e = new Event(arguments[0], arguments[1]);
            Duke.getTaskList().addTask(e,true);
        } catch (DukeException e) {
            ;
        } catch (IndexOutOfBoundsException e) {
            Duke.getUi().printBorder("The \"/at\" argument is missing.\n");
        }
    }
}
