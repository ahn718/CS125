import edu.illinois.cs.cs125.lib.zen.Zen;

/**
 * Example program written using Zen Graphics.
 *
 * @see <a href="https://github.com/cs125-illinois/Zen">Zen on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/Zen/">Zen Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/1/#zen">Lab 1 Writeup</a>
 */
public class ColorOvalsIf {
   /**
     * This example draws beautiful ovals in happy joyous colors.
     *
     * @param unused unused input parameters
     */
    public static void main(final String[] unused) {

        /*
         * If the user exits the loop, shut down.
         */
        while (Zen.isRunning()) {

            /*
             * Wait for a mouse click.
             */
            Zen.waitForClick();
            Zen.waitForClick();

            /*
             * Get the click location and use it to set the oval location and color.
             */
            int x = Zen.getMouseX();
            int y = Zen.getMouseY();

            Zen.fillOval(x - 64, y - 64, 32, 32);
            Zen.fillRect(x - 16, y - 16, 32, 32);
            Zen.setColor(x, y, x + y);
        }
    }
}
