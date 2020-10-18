package Task;

public class Event extends Task{
    protected String at;

    /**
     * Represents the properties of Task.Event task.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Stores details of event
     *
     * @return full details of task -  event type, completion status and description
     */
    @Override
    public String toString() {
        return "[E][" + getStatusIcon() + "] " + super.toString() + "(at:" + at + ")";
    }
}