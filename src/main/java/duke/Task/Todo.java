package Task;

/**
 * Represents the properties of Task.Todo task.
 */
public class Todo extends Task {
    /**
     * Stores details of Task.Todo
     * @param description description of task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Stores details of Task.Todo
     *
     * @return full details of task -  todo type, completion status and description
     */
    @Override
    public String toString() {
        return "[T][" + getStatusIcon() + "] " + super.toString();
    }
}