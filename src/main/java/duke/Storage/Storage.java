import duke.Duke;
import duke.DukeException;
import duke.Task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Handles the file in hard drive that is needed for storage
 */
public class Storage {
    private String filePath;
    private File storageText;

    /**
     * Creates a reference to the file in the filepath
     *
     * @param filePath path of storage file in hard drive
     */
    public Storage(String filePath) {
        this.filePath = filePath;
        this.storageText = new File(filePath);
    }

    /**
     * Attempts to find file in the hard drive
     *
     * @return reference to the file
     */
    public File findFile() {
        if (!storageText.exists()) {
            storageText = createFile();
        }
        return storageText;

    }

    /**
     * creates a new file and a directory if file does not
     * exist in the directory or the directory does not exist
     *
     * @return reference to the file
     */
    public File createFile() {
        try {
            if (!storageText.getParentFile().exists()) {
                storageText.getParentFile().mkdirs();
            }
            storageText.createNewFile();
        } catch (IOException e) {
            Duke.getUi().printBorder("Unable to create file...\n");
        }
        return storageText;
    }

    /**
     * Attempts to load data from the storage file
     * into the program
     */
    public void loadFile() {
        File storage = findFile();
        Scanner storageData;

        try {
            storageData = new Scanner(storage);
            while (storageData.hasNext()) {
                String data = storageData.nextLine();
                new ExtractableData(data).ExtractData();
            }
        } catch (FileNotFoundException e) {
            Duke.getUi().printBorder("Error has occurred! File not found!\n");
            return;
        } catch (DukeException e) {
            //DukeException has its own error message
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid number of Arguments");
        }
    }

    /**
     * Saves any task that has been added into the hard drive
     *
     * @param item task item that had been added into the list
     */
    public void saveData(Task item) {
        try {
            FileWriter appendWrite = new FileWriter(filePath, true);
            String data =  new CompilableData(item).CompileData();
            appendWrite.write(data);
            appendWrite.close();
        } catch (IOException e) {
            Duke.getUi().printBorder("Unable to Save!");
        } catch (DukeException e) {
            //DukeException has its own error message
        }
    }

    /**
     * Overwrites the data in storage file with the data currently in the program
     */
    public void writeFile() {
        try {
            FileWriter overWrite = new FileWriter(filePath, false);
            String data = "";
            for (int i = 0; i < Duke.getTaskList().getSize(); i++) {
                Task item = Duke.getTaskList().getTask(i);
                data += new CompilableData(item).CompileData();
            }
            overWrite.write(data);
            overWrite.close();
        } catch (IOException e) {
            Duke.getUi().printBorder("Unable to Save!");
        } catch (DukeException e) {
            //DukeException has its own error message
        }
    }

}
