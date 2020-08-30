import java.util.Scanner;

public class Duke {
    public static class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        }
        public void markAsDone(){
            this.isDone = true;
        }
    }

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
            }
            else if (input.equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int i = 0; i<itemsCount; i++){
                    System.out.println(i+1 + ".["+ items[i].getStatusIcon() +"] "+ items[i].description);
                }
                input = in.nextLine();
            }
            else if (input.contains("done")){
                int taskNumber = Integer.parseInt(input.replaceAll("[^0-9]", ""));
                items[taskNumber-1].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + items[taskNumber-1].getStatusIcon()+ "] " + items[taskNumber-1].description);
                input = in.nextLine();
            }
            else {
                Task t = new Task(input);
                items[itemsCount] = t;
                itemsCount++;
                System.out.println("added: "+ input);
                input = in.nextLine();
            }
        }
    }
}