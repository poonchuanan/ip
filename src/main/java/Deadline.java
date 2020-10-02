public class Deadline extends Task {
    protected String by;

    /**
     * Represents the properties of Deadline task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Stores details of deadline
     *
     * @return full details of task -  deadline type, completion status and description
     */
    @Override
    public String toString() {
        return "[D][" + getStatusIcon() + "] " + super.toString() + "(by:" + by + ")";
    }
}