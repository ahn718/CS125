import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sahil Modi
 *
 */

public class Main {

    /**
     * Main method.
     *
     * @param args is nothing
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        String[] url = {"http://erdani.com/tdpl/hamlet.txt",
                "https://www.bls.gov/tus/charts/chart9.txt",
                "http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt"};
        String contents = urlToString(url[0]);
        ArrayList<String> words = getWordList(contents, false); //set to true for unique words
        Scanner input = new Scanner(System.in);

        // contents = "This is a test test";
        System.out.println("Word Count: " + getWordCount(words));

        System.out.println("Please enter a word to search for:");
        String inputWord = input.nextLine();
        System.out.println(
                inputWord + " appears " + getCountOfWord(words, inputWord, false) + " times.");

        input.close();
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     *
     * @param baseString asdf
     * @param isUnique adsf
     * @return asdf
     */
    public static ArrayList<String> getWordList(final String baseString, final boolean isUnique) {
        ArrayList<String> wordsList = new ArrayList<>();
        String[] words = baseString.split("\\s");

        for (int i = 0; i < words.length; i++) {
            if (isUnique) {
                if (!words[i].isEmpty() && !isInList(wordsList, words[i])) {
                    wordsList.add(words[i]);
                }
            } else {
                if (!words[i].isEmpty()) {
                    wordsList.add(words[i]);
                }
            }
        }

        return wordsList;
    }

    /**
     *
     * @param baseString asdf
     * @param isUnique asdfs
     * @return asdf
     */
    public static int getWordCount(final String baseString, final boolean isUnique) {
        return getWordList(baseString, isUnique).size();
    }
    /**
     *
     * @param list asdf
     * @return asdf
     */
    public static int getWordCount(final ArrayList<String> list) {
        return list.size();
    }

    /**
     *
     * @param list asdf
     * @param word asdf
     * @return asdf
     */
    public static boolean isInList(final ArrayList<String> list, final String word) {
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            if (word.toLowerCase().equals(list.get(i).toLowerCase())) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     *
     * @param list asd
     * @param word asd
     * @param matchCase asd
     * @return count
     */
    public static int getCountOfWord(final ArrayList<String> list,
            final String word, final boolean matchCase) {
        int count = 0;
        if (matchCase) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(word)) {
                    count++;
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                String wordLowerCase = word.toLowerCase();
                String sLowerCase = list.get(i).toLowerCase();
                if (sLowerCase.length() >= wordLowerCase.length()) {
                    sLowerCase = sLowerCase.substring(0, word.length());
                } else {
                    sLowerCase = "";
                }
                if (sLowerCase.equals(wordLowerCase)) {
                    count++;
                }
            }
        }
        return count;
    }
}
