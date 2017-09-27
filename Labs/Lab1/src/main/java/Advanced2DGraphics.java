import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import edu.illinois.cs.cs125.lib.zen.Zen;

/**
 * Example program written using Zen Graphics.
 *
 * @see <a href="https://github.com/cs125-illinois/Zen">Zen on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/Zen/">Zen Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/1/#zen">Lab 1 Writeup</a>
 */
public class Advanced2DGraphics {

    /**
     * This example gives us a sense of what Zen has been doing for us.
     *
     * Rather than using the library, we request a 2D graphics buffer and manipulate it directly.
     * This provides access to features not provided by Zen, at the cost of additional complexity.
     *
     * @param unused unused input parameters
     */
    public static void main(final String[] unused) {

        /*
         * Get a handle to our sprite image.
         */
        ClassLoader classLoader = Advanced2DGraphics.class.getClassLoader();
        File spriteFile = new File(classLoader.getResource("sprite1.gif").getFile());
        Image image = Zen.getCachedImage(spriteFile.getAbsolutePath());

        double angleInRadians = 0.1;

        while (Zen.isRunning()) {
            /*
             * Get a new graphics buffer. Note that this has to be called again every time we flip
             * buffers.
             */
            Graphics2D graphicsBuffer = Zen.getBufferGraphics();
            angleInRadians = angleInRadians + 0.01;
            if (angleInRadians > 2 * Math.PI) {
                angleInRadians = angleInRadians - 2 * Math.PI;
            }

            /*
             * Get the mouse coordinates.
             */
            double x = Zen.getMouseX();
            double y = Zen.getMouseY();

            /*
             * Translate the graphics buffer so that it is centered on the current mouse location.
             * The rotate it around its new position.
             */
            graphicsBuffer.translate(x, y);
            graphicsBuffer.rotate(angleInRadians, 0, 0);

            /*
             * Scale the buffer twice to make it larger.
             */
            graphicsBuffer.scale(2 + Math.cos(angleInRadians), 2 + Math.sin(angleInRadians));
            graphicsBuffer.scale(2, 2);

            /*
             * Draw our sprite at the current buffer origin.
             */
            graphicsBuffer.drawImage(image, 0, 0, null);

            /*
             * Show the new buffer and pause.
             */
            Zen.flipBuffer();
            Zen.sleep(10);
        }
    }
}
