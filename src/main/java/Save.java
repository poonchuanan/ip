import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Handles data storage of task list
 */
public class Save {
    public static String projectRoot = System.getProperty("user.dir");
    public static String itemsPath = projectRoot + "/data/duke.txt";

    /**
     * Creates new file "data.txt" in data folder
     * @throws IOException On input error.
     */
    public static void createFile() throws IOException {
        File folder = new File("data");
        // create a folder in your current work space
        folder.mkdir();
        // put the file inside the folder
        File file = new File(folder, "duke.txt");
        file.createNewFile(); // create the file
    }

    /**
     * Loads task list from duke.txt everytime program is run
     * @throws FileNotFoundException If file does not exist in the first place.
     */
    public static void loadData() throws FileNotFoundException {
        // create a File for the given file path
        File f = new File(itemsPath);
        // create a Scanner using the File as the source
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String line = s.nextLine();
            String eventType = line.substring(1, 2);
            String symbol = line.substring(4, 5);
            String description = line.substring(7);
            switch (eventType) {
            case "T":
                Todo t = new Todo(description);
                Duke.items.add(t);
                break;
            case "E":
                int indexDividerEvent = description.indexOf("(at:");
                String eventTime = description.substring(indexDividerEvent+4).replace(")","");
                description = description.substring(0,indexDividerEvent);
                Event e = new Event(description, eventTime);
                Duke.items.add(e);
                break;
            case "D":
                int indexDividerDeadline = description.indexOf("(by:");
                String deadline = description.substring(indexDividerDeadline+4).replace(")","");
                description = description.substring(0,indexDividerDeadline);
                Deadline d = new Deadline(description, deadline);
                Duke.items.add(d);
                break;
            }
            if (symbol.equals("\u2713")) {
                Duke.items.get(Duke.items.size()-1).markAsDone();
            }
            Duke.itemsCount++;
        }
    }

    /**
     * Saves task list to duke.txt everytime it is modified
     * @throws IOException
     */
    public static void saveData() throws IOException {
        String textToAdd = "";
        for(Task t : Duke.items){
            if(t == null){
                break;
            }
            textToAdd += t + System.lineSeparator();
        }
        writeToFile(itemsPath, textToAdd);
    }

    /**
     * Writes task list contents to duke.txt
     * @param filePath Absolute path of the file to be written
     * @param textToAdd Contents to be written
     * @throws IOException On input error.
     */
    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

}
