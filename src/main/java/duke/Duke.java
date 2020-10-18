package duke;

import duke.Storage.Storage;
import duke.Parser.Parser;
import duke.Task.TaskList;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Represents the main program of Duke
 */
public class Duke {
    private static Storage storage;
    private static Ui ui;
    private static TaskList tasks;

    /**
     * Creates instances of classes needed for the program to run.
     *
     */
    public Duke() throws IOException, DukeException {
        storage = new Storage();
        ui = new Ui();
        tasks = new TaskList();
    }

    /**
     * Runs an instance of Duke.
     */
    public static void main(String[] args) throws IOException, DukeException {
        new Duke().run();
    }

    /**
     * Prints welcome message and runs the program.
     */
    public void run() throws IOException {
        ui.printWelcome();
        try {
            storage.loadData();
        } catch (FileNotFoundException | DukeException e){
            storage.createFile();
        }
        while (true) {
            String userInput = Duke.getUi().readCommand();
            Parser.parseInput(userInput);
        }
    }

    public static Storage getStorage() {
        return storage;
    }

    public static Ui getUi() {
        return ui;
    }

    public static TaskList getTaskList() {
        return tasks;
    }
}
