/**
 * Represents the properties of a task.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Stores details of task in the instance.
     *
     * @param description description of a particular task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns status of task (completed or not).
     *
     * @return tick or cross symbols
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Marks the status of task to done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns details of task.
     * @return description
     */
    public String toString() {
        return description;
    }
}