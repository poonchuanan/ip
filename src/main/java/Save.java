import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Save {
    public static String projectRoot = System.getProperty("user.dir");
    public static String itemsPath = projectRoot + "/data/duke.txt";

    public static void createFile() throws IOException {
        File folder = new File("data");
        folder.mkdir(); // create a folder in your current work space
        File file = new File(folder, "duke.txt"); // put the file inside the folder
        file.createNewFile(); // create the file
    }

    public static void loadData() throws FileNotFoundException {
        File f = new File(itemsPath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String line = s.nextLine();
            String eventType = line.substring(1, 2);
            String symbol = line.substring(4, 5);
            String description = line.substring(7);
            switch (eventType) {
            case "T":
                Todo t = new Todo(description);
                Duke.items[Duke.itemsCount] = t;
                break;
            case "E":
                int indexDividerEvent = description.indexOf("(at:");
                String eventTime = description.substring(indexDividerEvent+4).replace(")","");
                description = description.substring(0,indexDividerEvent);
                Event e = new Event(description, eventTime);
                Duke.items[Duke.itemsCount] = e;
                break;
            case "D":
                int indexDividerDeadline = description.indexOf("(by:");
                String deadline = description.substring(indexDividerDeadline+4).replace(")","");
                description = description.substring(0,indexDividerDeadline);
                Deadline d = new Deadline(description, deadline);
                Duke.items[Duke.itemsCount] = d;
            }
            if (symbol.equals("\u2713")) {
                Duke.items[Duke.itemsCount].markAsDone();
            }
            Duke.itemsCount++;
        }
    }

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


    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    private static void loadToArraylist(){

    }
}
