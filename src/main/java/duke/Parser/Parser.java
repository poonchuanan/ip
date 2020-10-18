package duke.parse;

import duke.Duke;
import duke.command.ByeCommand;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.command.TodoCommand;

/**
 * Parses the user input.
 */
public class Parser {

    /**
     * Filters the user input bu sorting out the appropriate  command keyword.
     *
     * @param userInput user input
     */
    public static void filterInput(String userInput) {
        String[] arguments = parseArgument(userInput, " ", 2);

        switch (arguments[0].toLowerCase()) {
        case ListCommand.COMMAND_WORD:
            new ListCommand(arguments);
            break;
        case DoneCommand.COMMAND_WORD:
            new DoneCommand(arguments);
            break;
        case TodoCommand.COMMAND_WORD:
            new TodoCommand(arguments);
            break;
        case DeadlineCommand.COMMAND_WORD:
            new DeadlineCommand(arguments);
            break;
        case EventCommand.COMMAND_WORD:
            new EventCommand(arguments);
            break;
        case DeleteCommand.COMMAND_WORD:
            new DeleteCommand(arguments);
            break;
        case ByeCommand.COMMAND_WORD:
            new ByeCommand(arguments);
            break;
        case FindCommand.COMMAND_WORD:
            new FindCommand(arguments);
            break;
        default:
            Duke.getUi().printBorder("Invalid command. Please try again.\n");
            break;
        }
    }

    /**
     * Splits the arguments in acoordance with the divider and limit used.
     *
     * @param argument argument that is to be parsed
     * @param divider string used to parse the arguments
     * @param limit number of times to parse the arguments
     *
     * @return a list of parsed arguments
     */
    public static String[] parseArgument (String argument, String divider, int limit) {
        String[] arguments = argument.split(divider, limit);
        return arguments;
    }

}