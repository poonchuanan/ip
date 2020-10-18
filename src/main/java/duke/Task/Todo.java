package duke.Task;

import duke.Duke;
import duke.DukeException;

import java.io.IOException;

/**
 * Represents the properties of Todo task.
 */
public class Todo extends duke.Task.Task {
    private static final String TASK_TYPE = "T";

    /**
     * Stores details of Todo in the instance
     *
     * @param description description of the todo task
     */
    public Todo(String description) throws DukeException {
        super(description);
    }

    /**
     * Prints the full details of todo
     *
     * @return full details of task -  todo type, completion status and description
     */
    @Override
    public String toString() {
        return "["+ getTaskType() + "]" + super.toString();
    }

    @Override
    public String getTaskType() {
        return TASK_TYPE;
    }

    /**
     * Add Todo task to the Tasklist.
     *
     * @param argument description of event
     * @throws DukeException if argument is wrong/blank
     */
    public static void addTodo(String argument) throws DukeException, IOException {
        duke.Task.Task t = new Todo(argument);
        Duke.getTaskList().addTask(t,true);
    }

}
