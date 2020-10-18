package duke.Task;

import duke.Duke;
import duke.DukeException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents the list of tasks stored in the program.
 */
public class TaskList {
    private ArrayList<Task> Tasks;

    /**
     * Creates new instance of array list.
     */
    public TaskList() {
        Tasks = new ArrayList<>();
    }

    /**
     * mark the specific task in list as completed.
     *
     * @param argument index number of task
     * @throws DukeException if number is invalid
     */
    public void markTaskAsDone(String argument) throws DukeException, IOException {
        int taskNumber = Integer.parseInt(argument);
        if ((taskNumber <= 0) | (taskNumber > this.getSize())) {
            throw new DukeException("illegal number");
        }
        Task t = this.getTask(taskNumber - 1);
        t.markAsDone();
        Duke.getStorage().saveData();
        Duke.getUi().printBorder("Nice! I've marked this task as done:\n" + t.toString() + "\n");
    }

    /**
     * Shows the list of tasks in program.
     *
     * @throws DukeException if the list is empty
     */
    public void displayList() throws DukeException {
        if (Tasks.size() == 0) {
            throw new DukeException("empty list");
        }
        String itemList = "";
        for (int i = 0 ; i < this.getSize() ; i++) {
            itemList += (i + 1) + ". "  +  Tasks.get(i).toString() + "\n";
        }
        Duke.getUi().printBorder("Here are the tasks in your list:\n" + itemList);
    }

    /**
     * Adds task to the list.
     *
     * @param item task item to be added
     * @param isToBeSaved boolean to check whether to save to txt
     */
    public void addTask(Task item, boolean isToBeSaved) throws IOException {
        Tasks.add(item);
        if(isToBeSaved) {
            Duke.getUi().printBorder("Got it. I've added this task:\n" + item.toString() + "\n");
            Duke.getStorage().saveData();
        }
    }

    /**
     * Deletes task according to index.
     *
     * @param argument the index of task to be deleted
     */
    public void deleteTask(String argument) throws IOException {
        try {
            int taskNumber = Integer.parseInt(argument);
            Task deletedTask = this.getTask(taskNumber - 1);
            Tasks.remove(taskNumber - 1);
            Duke.getStorage().saveData();
            String remainingTask = "Now you have " + this.getSize() + " tasks in the list\n";
            Duke.getUi().printBorder("Noted. I've removed this task:\n" + deletedTask.toString() + "\n" + remainingTask);
        } catch (NumberFormatException e) {
            Duke.getUi().printNumberFormatError(argument);
        } catch (IndexOutOfBoundsException e) {
            Duke.getUi().printIndexError();
        }
    }

    /**
     * Get task by its index
     *
     * @param index index of task
     * @return task in that index
     */
    public Task getTask(int index){
        return Tasks.get(index);
    }

    /**
     * Gets number of items in Tasklist
     *
     * @return size number
     */
    public int getSize(){
        return Tasks.size();
    }

    public void findTask(String keyword) throws IOException {
        TaskList foundItems = new TaskList();

        for (Task item : this.Tasks) {
            String description = item.getDescription();
            if (description.contains(keyword)) {
                foundItems.addTask(item, false);
            }
        }
        try {
            foundItems.displayList();
        } catch (DukeException e) {
            ;
        }
    }
}