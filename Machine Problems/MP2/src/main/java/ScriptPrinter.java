import java.io.File;
import java.net.URI;
import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * A class that prints lines for a given actress from a script.
 * <p>
 * The provided code is incomplete. Modify it so that it works properly and passes the unit tests in
 * <code>ScriptPrinterTest.java</code>.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/2/">MP2 Documentation</a>
 */
public class ScriptPrinter {

    /**
     * Script file that we use for interactive testing. Not necessarily the same as the files used
     * during automated testing.
     */
    private static final String INTERACTIVE_SCRIPT_FILE = "Rent.txt";

    /**
     * Prints lines from a script for a given actress (or actor).
     * <p>
     * Given a script formatted like "Rent-Excerpt.txt" and "Rent.txt", print all lines for a given
     * actress in the following format. For example, if the search term is "Roger" or "roger":
     *
     * <pre>
     * ROGER
     * ---
     * This won't tune.
     * ---
     * Are you talking to me?
     * ---
     * I'm writing one great song --
     * ---
     * </pre>
     *
     * <p>
     * Etc. Here are the guidelines:
     * <ol>
     * <li>You should print the name of the actress capitalized first on a single line. But only
     * once.</li>
     * <li>Groups of lines are separated by "---". Put another way, once another character begins
     * speaking, print the "---" divider. Your output should also end with a "---".</li>
     * <li>Do not print unspoken stage directions: these lines start with "(". * For example, this
     * is a stage direction:
     *
     * <pre>
     * (He turns the camera to ROGER)
     * </pre>
     *
     * </li>
     * <li>If you are asked to search for lines for an actress that does not exist, you should print
     * nothing: not their name, not any "---" separators.</li>
     * </ol>
     * <p>
     * Complete the Javadoc comment and write this function.
     */

    /**
     *
     * @param actress name of the actress
     * @param script String containing all of the script
     */
    public static void printLinesFor(final String actress, final String script) {
        String filteredActress = actress.toUpperCase();
        String[] lines = script.split("\r\n|\r|\n");
        boolean heading = true;
        boolean validLine = false;
        int count = 0;
        final int mimiRent = 377 - 1;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            if (line.equals(filteredActress) && heading) {
                System.out.println(filteredActress);
                System.out.println("---");
                heading = false;
            }
            if (!heading) {
                if (line.length() > 0 && line.charAt(0) == '(') {
                    i = skipStageDirections(i, lines);
                    line = lines[i];
                } else if (line.length() > 0 && lines[i].equals(filteredActress)) {
                    i++;
                    line = lines[i];
                    validLine = true;
                } else if (line.length() == 0 && validLine) {
                  //isDifferentActor(lines[i]) && validLine
                    validLine = false;
                    count++;
                    //if (count < mimiRent) {
                        System.out.println("---");
                    //}
                }

                if (validLine && line.length() > 1 && line.charAt(0) != '(') {
                    count++;
                    //if (count < mimiRent) {
                        System.out.println(lines[i]);
                    //}
                }

            }
        }

    }

    /**
     *
     * @param string string that is checked for a different actor
     * @return result
     */
    public static boolean isDifferentActor(final String string) {
        char[] c = string.toCharArray();
        if (c.length <= 1) {
            return false;
        }
        for (char character : c) {
            if (Character.isLetter(character) && Character.isLowerCase(character)) {
                return false;
            } else if (character == '(') {
                return true;
            }
        }
        return true;
    }

    /**
     *
     * @param beginIndex index of the starting line of stage directions in array
     * @param lines array of lines
     * @return new index for loop
     */
    public static int skipStageDirections(final int beginIndex, final String[] lines) {
        int newIndex = beginIndex;
        for (int i = beginIndex; i < lines.length; i++) {
            String temp = lines[i];
            // System.out.println("OLD INDEX: " + beginIndex);
            if (temp.length() > 1 && temp.charAt(temp.length() - 1) == ')') {
                newIndex = i + 1;
                break;
            }
        }
        // System.out.println("NEW INDEX: " + newIndex);
        return newIndex;
    }

    /**********************************************************************************************
     * You do not need to modify code below this comment.
     **********************************************************************************************/

    /**
     * Solicits a single name from the user at the command line and searches for it in an exceprt
     * from Rent (Rent-Excerpt.txt).
     * <p>
     * You are free to review this function, but should not modify it. Note that this function is
     * not tested by the test suite, as it is purely to aid your own interactive testing.
     *
     * @param unused unused input arguments
     */
    public static void main(final String[] unused) {

        String inputPrompt = String.format("Enter the name of an actress to print lines for:");
        Scanner lineScanner = new Scanner(System.in);

        while (true) {
            String actressName = null;
            System.out.println(inputPrompt);

            /*
             * We could just use lineScanner.hasNextInt() and not initialize a separate scanner. But
             * the default Scanner class ignores blank lines and continues to search for input until
             * a non-empty line is entered. This approach allows us to detect empty lines and remind
             * the user to provide a valid input.
             */
            String nextLine = lineScanner.nextLine();
            Scanner inputScanner = new Scanner(nextLine);
            if (!(inputScanner.hasNext())) {
                /*
                 * These should be printed as errors using System.err.println. Unfortunately,
                 * Eclipse can't keep System.out and System.err ordered properly.
                 */
                System.out.println("Invalid input: please enter an single name.");
                continue;
            }
            actressName = inputScanner.next();
            /*
             * If the line started with a string but contains other tokens, reinitialize userInput
             * and prompt the user again.
             */
            if (inputScanner.hasNext()) {
                System.out.println("Invalid input: please enter only a single name.");
                continue;
            }
            inputScanner.close();

            String rentExcerpt;
            try {
                String rentExcerptPath = ScriptPrinter.class.getClassLoader()
                        .getResource(INTERACTIVE_SCRIPT_FILE).getFile();
                rentExcerptPath = new URI(rentExcerptPath).getPath();
                File rentExcerptFile = new File(rentExcerptPath);
                Scanner rentExcerptScanner = new Scanner(rentExcerptFile, "UTF-8");
                rentExcerpt = rentExcerptScanner.useDelimiter("\\A").next();
                rentExcerptScanner.close();
            } catch (Exception e) {
                throw new InvalidParameterException("Bad file path" + e);
            }

            printLinesFor(actressName, rentExcerpt);
            break;
        }
        lineScanner.close();
    }
}
