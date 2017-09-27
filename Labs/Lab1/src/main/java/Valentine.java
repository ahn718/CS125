import java.io.File;

import edu.illinois.cs.cs125.lib.zen.Zen;

/**
 * Example program written using Zen Graphics.
 *
 * @see <a href="https://github.com/cs125-illinois/Zen">Zen on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/Zen/">Zen Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/1/#zen">Lab 1 Writeup</a>
 */
public class Valentine {
    /**
     * This example is feeling amorous.
     *
     * @param unused unused input parameters
     */
    public static void main(final String[] unused) {
        /*
         * Get the path to our image.
         */
        ClassLoader classLoader = SpriteMoveFlipBuffer.class.getClassLoader();
        File heartFile = new File(classLoader.getResource("LabeledHeart.png").getFile());

        /*
         * Slide our heart in from the right...
         */
        for (double heartXPosition = 640; heartXPosition > 1; heartXPosition *= 0.9) {
            Zen.drawImage(heartFile.getAbsolutePath(), (int) heartXPosition, 0);
            Zen.sleep(33);
        }
        /*
         * ...and then out to the left.
         */
        for (double heartXPosition = -1; heartXPosition > -1000; heartXPosition *= 1.1) {
            Zen.drawImage(heartFile.getAbsolutePath(), (int) heartXPosition, 0);
            Zen.sleep(33);
        }

        /*
         * Repeatedly broadcast our message of peace and harmony.
         */
        while (Zen.isRunning()) {
            /*
             * Fill the canvas with black.
             */
            Zen.setColor("black");
            Zen.fillRect(0, 0, 640, 480);

            /*
             * Write one message in its entirety.
             */
            Zen.setColor("red");
            Zen.drawText("You stole my heart!", 100, 200);

            /*
             * Write another message iteratively.
             */
            Zen.setColor(200, 120, 120);
            String myMessage = "Be my Valentine!";
            String myMessagePrefix = "";
            for (int i = 0; i < myMessage.length(); i++) {
                myMessagePrefix += myMessage.charAt(i);
                Zen.drawText(myMessagePrefix, 0, 100);
                Zen.sleep(100);
            }
        }
    }
}
