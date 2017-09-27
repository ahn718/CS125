import edu.illinois.cs.cs125.lib.zen.Zen;

/**
 * Example program written using Zen Graphics.
 *
 * @see <a href="https://github.com/cs125-illinois/Zen">Zen on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/Zen/">Zen Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/1/#zen">Lab 1 Writeup</a>
 */
public class Paint {
    /**
     * This example draws rectangles at random locations near mouse clicks when the mouse button is
     * held down.
     *
     * @param unused unused input parameters
     */
    public static void main(final String[] unused) {

        /*
         * Zen allows us to specific a window size during creation, as well as certain options. The
         * stretch option ensures that the entire canvas is covered.
         *
         * Note that the default starting color for our Zen window is white.
         */
        Zen.create(320, 200, "stretch");

        while (Zen.isRunning()) {

            /*
             * Grab the current mouse location.
             */
            int x = Zen.getMouseX();
            int y = Zen.getMouseY();

            /*
             * If the mouse buttons or any other key is held down...
             */
            if (Zen.getMouseButtonsAndModifierKeys() != 0) {

                /*
                 * Grab random numbers between -25 and 25 and use them to generate a white square at
                 * a position nearby the mouse click.
                 */
                double x2 = x - 25 + 50 * Math.random();
                double y2 = y - 25 + 50 * Math.random();

                Zen.fillRect((int) x2, (int) y2, 1, 1);
            }
        }
    }
}
