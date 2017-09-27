import edu.illinois.cs.cs125.lib.mazemaker.Maze;

/**
 * Solve a randomly-generated maze.
 *
 * @see <a href="https://github.com/cs125-illinois/mazemaker">Mazemaker on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/mazemaker/">Mazemaker Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/2/#maze">Lab 2 Writeup</a>
 */
@SuppressWarnings("checkstyle:emptyblock")
public class SolveMaze {

    /**
     * Implement your maze solving algorithm here.
     *
     * @param unused unused input arguments
     */

    public static void main(final String[] unused) {
        /*
         * Create a new 10 x 10 maze. Feel free to change these values.
         */
        Maze maze;

        /*
         * Pick (0, 0), the bottom left corner, as the starting point. Put the end in the top right
         * corner.
         */

        /*
         * You should be able to solve a 10 x 10 maze in (far fewer than) 1000 steps. Feel free to
         * adjust this number if you experiment with other mazes.
         */
        int totRunThroughs = 2000;
        int[] nRunThroughs = new int[totRunThroughs];
        int nStep = 0;
        int lowestStep = 250;
        for (int runThrough = 0; runThrough < totRunThroughs; runThrough++) {
            // Implement your maze solving algorithm here
            maze = new Maze(6, 5);
            maze.startAtZero();
            maze.endAtTopRight();
            while (!maze.isFinished()) {
                maze.turnRight();
                while (!maze.canMove()) {
                    maze.turnLeft();
                }
                maze.move();
                nStep++;
            }
            if (nStep < lowestStep) {
                lowestStep = nStep;
            }
            nRunThroughs[runThrough] = nStep;
            nStep = 0;
        }

        int sum = 0;
        for (int i = 0; i < nRunThroughs.length; i++) {
            sum += nRunThroughs[i];
        }
        //System.out.println(Arrays.toString(nRunThroughs));
        System.out.println("Lowest # of steps: " + lowestStep);
        System.out.println("Average Steps: " + sum / nRunThroughs.length);

        /* Found out lowest number of steps of an M by N maze is (N-1) + (M-1)*/

//        if (maze.isFinished()) {
//            System.out.println("You solved the maze!");
//        } else {
//            System.out.println("Try again!");
//        }
    }
}
