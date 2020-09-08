import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
        Task[] items = new Task[100];
        int itemsCount = 0;
        String input = in.nextLine();
        while (true) {
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
                int taskNumber = Integer.parseInt(input.replaceAll("[^0-9]", ""));
                items[taskNumber-1].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + items[taskNumber-1].getStatusIcon()+ "] " + items[taskNumber-1].description);
                input = in.nextLine();
            } else {
                if (input.contains("todo")){
                    input = input.replace("todo ","");
                    Todo t = new Todo(input);
                    items[itemsCount] = t;
                    System.out.println("Got it. I've added this task:\n"+ t);
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
                    System.out.println("Invalid command");
                    input = in.nextLine();
                    continue;
                }
                itemsCount++;
                System.out.println("Now you have " + itemsCount + " task(s) in the list.");
                input = in.nextLine();
            }
        }
    }
}