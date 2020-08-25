import java.util.Scanner;
import java.util.Arrays;

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
        String[] items = new String[100];
        int itemsCount = 0;
        String input = in.nextLine();
        while (true) {
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            if (input.equals("list")){
                for(int i = 0; i<itemsCount; i++){
                    System.out.println(i + ". "+ items[i]);
                }
                input = in.nextLine();
            }
            else {
                items[itemsCount] = input;
                itemsCount++;
                System.out.println("added: "+ input);
                input = in.nextLine();
            }
        }
    }
}
