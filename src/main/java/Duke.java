import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Duke {
    public static final int MAX_TASKS = 100;
    public static Task[] items = new Task[MAX_TASKS];
    public static int itemsCount = 0;

    public static String getFirstWord(String word){
        String firstWord = word;
        if (firstWord.contains(" ")) {
            firstWord = firstWord.substring(0, firstWord.indexOf(" "));
        }
        return firstWord;
    }

    public static boolean checkOneWord(String word){
        String [] wordArray = word.trim().split(" ");
        if(wordArray.length == 1){
            return true;
        } else{
            return false;
        }
    }

    public static void main(String[] args) throws DukeException, IOException {
        Scanner in = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
        String input = in.nextLine();
//        String firstWord = getFirstWord(input);
        try {
            Save.loadData();
        } catch(FileNotFoundException e){
            Save.createFile();
        }
        while (true) {
//            String firstWord = getFirstWord(input);
//            System.out.println(firstWord);
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (input.equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int i = 0; i<itemsCount; i++){
//                    System.out.println(i+1 + ".["+ items[i].getStatusIcon() +"] "+ items[i].description);
                    System.out.println(String.valueOf(i+1) + ". " + items[i]);
                }
                input = in.nextLine();
            } else if (input.contains("done")){
                try {
                    int taskNumber = Integer.parseInt(input.replaceAll("[^0-9]", ""));
                    items[taskNumber - 1].markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + items[taskNumber - 1].getStatusIcon() + "] " + items[taskNumber - 1].description);
                    Save.saveData();
                    input = in.nextLine();
                } catch (NumberFormatException e){
                    System.out.println("Task number cannot be empty");
                    input = in.nextLine();
                } catch (NullPointerException e){
                    System.out.println("Please input a valid number");
                    input = in.nextLine();
                }
            } else {
//                String [] wordArray = input.trim().split(" ");
                if (input.contains("todo")){
                    if (checkOneWord(input)){
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        input = in.nextLine();
                        continue;
                    } else {
                        input = input.replace("todo ", "");
                        Todo t = new Todo(input);
                        items[itemsCount] = t;
                        System.out.println("Got it. I've added this task:\n" + t);
                    }
                } else if (input.contains("deadline")){
                    int indexDivider = input.indexOf("/by");
                    String dueDate = input.substring(indexDivider+3);
                    input = input.substring(0,indexDivider).replace("deadline ", "");
                    Deadline t = new Deadline(input, dueDate);
                    items[itemsCount] = t;
                    System.out.println("Got it. I've added this task:\n"+ t);
                } else if (input.contains("event")){
                    int indexDivider = input.indexOf("/at");
                    String eventTime = input.substring(indexDivider+3);
                    input = input.substring(0,indexDivider).replace("event ", "");
                    Event t = new Event(input, eventTime);
                    items[itemsCount] = t;
                    System.out.println("Got it. I've added this task:\n"+ t);
                } else{
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    input = in.nextLine();
                    continue;
                }
                itemsCount++;
                Save.saveData();
                System.out.println("Now you have " + itemsCount + " task(s) in the list.");
                input = in.nextLine();
            }
        }
    }
}