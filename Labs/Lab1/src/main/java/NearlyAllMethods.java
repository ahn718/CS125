import edu.illinois.cs.cs125.lib.zen.Zen;

/**
 * Example program written using Zen Graphics.
 *
 * @see <a href="https://github.com/cs125-illinois/Zen">Zen on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/Zen/">Zen Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/1/#zen">Lab 1 Writeup</a>
 */
public class NearlyAllMethods {

    /**
     * This example uses most of the public Zen methods.
     *
     * @param unused unused input parameters
     */
    public static void main(final String[] unused) {

        /*
         * Draw some white text and wait for a click.
         */
        Zen.setColor("white");
        Zen.setFont("Times-40");
        Zen.drawText("Click!", 20, 40);
        Zen.waitForClick();

        /*
         * Draw some text in a different font using a RGB color value.
         */
        Zen.setColor(0, 255, 255);
        Zen.setFont("Courier-12");
        Zen.drawText(Zen.getAboutMessage(), 0, 400);

        /*
         * Blank buffer and pause.
         */
        Zen.flipBuffer();
        Zen.sleep(2000);

        /*
         * Draw a line, arc, oval, and rectangle using the current color.
         */
        Zen.drawLine(300, 150, 150, 300);
        Zen.drawArc(400, 400, 50, 50, 30, 150);
        Zen.fillOval(100, 20, 40, 40);
        Zen.fillRect(5, 10, 5, 5);

        /*
         * Blank buffer and pause.
         */
        Zen.flipBuffer();
        Zen.sleep(1000);

        /*
         * Zen can get text from the user.
         */
        Zen.setEditText("Type and Click");
        while (Zen.isRunning()) {

            /*
             * Continue drawing text from the user.
             */
            String userInputText = Zen.getEditText();
            Zen.drawText(userInputText, 100, 100);

            /*
             * Draw a rectangle that fallows the mouse.
             */
            Zen.fillRect(Zen.getMouseX() - 16, Zen.getMouseY() - 16, 32, 32);

            /*
             * Display messages when the user clicks.
             */
            long clickTime = Zen.getMouseClickTime();
            String clickedMessage = "Clicked at " + clickTime;
            Zen.drawText(clickedMessage, Zen.getMouseClickX(), Zen.getMouseClickY());

            /*
             * Flip the buffer and continue.
             */
            Zen.flipBuffer();
        }
    }
}
