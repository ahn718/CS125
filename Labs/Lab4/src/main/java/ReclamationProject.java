/*
 * The following code needs a lot of TLC. So give it some! 1. Fix all checkstyle errors 2. Determine
 * what it does (it's going to be tough before you finish #1) 3. Improve the name of the methods and
 * variables 4. Add comments and Javadoc comments where needed 5. Remove unnecessary comments as
 * appropriate
 */

/**
 * Main class.
 */
public class ReclamationProject {

    /**
     * @param a2 string 1
     * @param b2 string 2
     * @return string 3
     */
    static String doit(final String a2, final String b2) {
        String a, b;
        if (a2.length() > b2.length()) {
            String c = a2; // TODO set c to a
            a = b2;
            b = c;
        } else {
            a = a2;
            b = b2;
        }

        String r = "";

        // String r = (a.equals(b)) ? "" : ""; //I love the ternary operator!
        /*
         * For loop with i
         */
        for (int i = 0; i < a.length(); i++) {
            for (int j = a.length() - i; j > 0; j--) {
                for (int k = 0; k < b.length() - j; k++) {
                    if (a.regionMatches(i, b, k, j) && j > r.length()) {
                        r = a.substring(i, i + j);
                    }
                    // r = (a.regionMatches(i, b, k, j) && j > r.length()) ? a.substring(i, i + j) :
                    // r;/
                    // Do it!

                }
            } // Ah yeah
        }
        return r;
    }
}
