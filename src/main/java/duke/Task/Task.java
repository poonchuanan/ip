package duke.Task;

import duke.DukeException;

/**
 * Represents the properties of a task.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Stores details of task in the instance.
     *
     * @param description description of task
     */
    public Task(String description) throws DukeException {
        if (description.isBlank()) {
            throw new DukeException(DukeException.INVALID_DESCRIPTION);
        }
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets the status of task.
     *
     * @return tick or X symbols
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Changes the status of task to done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * gets description of task.
     *
     * @return description of task
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * returns details of task in a certain format.
     *
     * @return details of task
     */
    public String toString() {
        String output = "[" + getStatusIcon() + "] " + getDescription();
        return output;
    }

    /**
     * Gets the appropriate task type of each task.
     *
     * @return the string used to represent the task type
     */
    public abstract String getTaskType();

}
