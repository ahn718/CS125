import edu.illinois.cs.cs125.lib.zen.Zen;

/**
 * Example program written using Zen Graphics.
 *
 * @see <a href="https://github.com/cs125-illinois/Zen">Zen on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/Zen/">Zen Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/1/#zen">Lab 1 Writeup</a>
 */
public class HelloWorld {
    /**
     * This is a basic example that simply prints a welcome message to the display.
     *
     * @param unused unused input parameters.
     */
    public static void main(final String[] unused) {
        Zen.drawText("Hello, world. This is Sahil", 100, 200);
    }
}
