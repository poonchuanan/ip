package duke.Parser;

import duke.Duke;
import duke.Command.ByeCommand;
import duke.Command.DeadlineCommand;
import duke.Command.DeleteCommand;
import duke.Command.DoneCommand;
import duke.Command.EventCommand;
import duke.Command.FindCommand;
import duke.Command.ListCommand;
import duke.Command.TodoCommand;

/**
 * Parses the user input.
 */
public class Parser {

    /**
     * Decides which command to execute based on user's input.
     *
     * @param userInput user input
     */
    public static void parseInput(String userInput) {
        String[] arguments = parseArgument(userInput, " ", 2);
        switch (arguments[0].toLowerCase()) {
        case TodoCommand.COMMAND_WORD:
            new TodoCommand(arguments);
            break;
        case DeadlineCommand.COMMAND_WORD:
            new DeadlineCommand(arguments);
            break;
        case EventCommand.COMMAND_WORD:
            new EventCommand(arguments);
            break;
        case DoneCommand.COMMAND_WORD:
            new DoneCommand(arguments);
            break;
        case ListCommand.COMMAND_WORD:
            new ListCommand(arguments);
            break;
        case FindCommand.COMMAND_WORD:
            new FindCommand(arguments);
            break;
        case DeleteCommand.COMMAND_WORD:
            new DeleteCommand(arguments);
            break;
        case ByeCommand.COMMAND_WORD:
            new ByeCommand(arguments);
            break;
        default:
            Duke.getUi().printBorder("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
            break;
        }
    }

    /**
     * Splits the arguments in based on the divider and limit.
     *
     * @param argument argument to be parsed
     * @param divider string used to parse the arguments
     * @param limit number of times to parse the arguments
     *
     * @return list of parsed arguments
     */
    public static String[] parseArgument (String argument, String divider, int limit) {
        String[] arguments = argument.split(divider, limit);
        return arguments;
    }
}