import edu.illinois.cs.cs125.lib.zen.Zen;

/**
 * Example program written using Zen Graphics.
 *
 * @see <a href="https://github.com/cs125-illinois/Zen">Zen on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/Zen/">Zen Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/1/#zen">Lab 1 Writeup</a>
 */
public class BouncingBall {
    /**
     * This example draws a bouncing ball.
     *
     * @param unused unused input parameters
     */
    public static void main(final String[] unused) {

        /*
         * Location and current speed of our bouncing ball.
         */
        double x = 0, y = 0;
        double velocityX = 1, velocityY = 0;

        while (Zen.isRunning()) {
            /*
             * Draw the ball and the pause.
             */
            Zen.fillOval((int) x, (int) y, 4, 4);
            Zen.sleep(20);

            /*
             * Compute new velocity. Flip as needed.
             */
            velocityY = velocityY + 1;
            if (y + velocityY > 400) {
                velocityY = -1 * Math.abs(0.9 * velocityY);
            }

            /*
             * Update the ball position.
             */
            x = x + velocityX;
            y = y + velocityY;
        }
    }

}
