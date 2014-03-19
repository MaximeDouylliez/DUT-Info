import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game. It is
 * used to recognise commands as they are typed in.
 * 
 * @author Michael Kolling and David J. Barnes and Julien Vion
 * @version 1.1 (March 2011)
 */

enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"),DIG("dig"),USE("use");

    private final static Map<String, CommandWord> COMMANDS;

    private final static String ALL_COMMANDS;

    static {
        final Map<String, CommandWord> commands = new LinkedHashMap<String, CommandWord>();
        final StringBuilder stb = new StringBuilder();
        for (CommandWord cw : CommandWord.values()) {
            commands.put(cw.stringDesc, cw);
            stb.append(cw.stringDesc).append(' ');
        }
        COMMANDS = Collections.unmodifiableMap(commands);
        ALL_COMMANDS = stb.toString();
    }

    private final String stringDesc;

    private CommandWord(final String stringDesc) {
        this.stringDesc = stringDesc;
    }

    /**
     * Returns the CommandWord member matching the given String value, or null
     * when the given String is either null or unknown.
     */
    public static CommandWord command(final String aString) {
        if (aString == null) {
            return null;
        }
        return COMMANDS.get(aString);
    }

    /**
     * Returns the list of all commands.
     */
    public static String allCommands() {
        return ALL_COMMANDS;
    }
}
