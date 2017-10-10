/**
 * A class that runs implements several simple transformations on 2D image arrays.
 * <p>
 * This file contains stub code for your image transformation methods that are called by the main
 * class. You will do your work for this MP in this file.
 * <p>
 * Note that you can make several assumptions about the images passed to your functions, both by the
 * web front end and by our testing harness:
 * <ul>
 * <li>You will not be passed empty images.</li>
 * <li>All images will have even width and height.</li>
 * </ul>
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/4/">MP4 Documentation</a>
 */
public class Transform {

    /**
     * Default amount to shift an image's position. Not used by the testing suite, so feel free to
     * change this value.
     */
    public static final int DEFAULT_POSITION_SHIFT = 16;

    /**
     * Pixel value to use as filler when you don't have any valid data. All white with complete
     * transparency. DO NOT CHANGE THIS VALUE: the testing suite relies on it.
     */
    public static final int FILL_VALUE = 0x00FFFFFF;

    /**
     *
     * @param array array to clone
     * @return cloned array
     */
    public static int[][] clone2D(final int[][] array) {
        int[][] result = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].clone();
        }
        return result;
    }

    /**
     * Shift the image left by the specified amount.
     * <p>
     * Any pixels shifted in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to shift to the left
     * @param amount the amount to shift the image to the left
     * @return the shifted image
     */
    public static int[][] shiftLeft(final int[][] originalImage, final int amount) {
        return shift(originalImage, amount, 0); // shifts up because it's weird
    }

    /*
     * Shift right like above.
     */
    /**
     *
     * @param originalImage original image
     * @param amount shift amount
     * @return image array
     */
    public static int[][] shiftRight(final int[][] originalImage, final int amount) {
        return shift(originalImage, -amount, 0); // shifts down
    }

    /**
     * Shift up like above.
     */
    /**
     *
     * @param originalImage original image
     * @param amount shift amount
     * @return image array
     */
    public static int[][] shiftUp(final int[][] originalImage, final int amount) {
        return shift(originalImage, 0, -amount); // shifts left
    }

    /**
     * Shift down like above.
     */
    /**
     *
     * @param originalImage original image
     * @param amount shift amount
     * @return image array
     */
    public static int[][] shiftDown(final int[][] originalImage, final int amount) {
        return shift(originalImage, 0, amount); // shifts right
    }

    /**
     *
     * @param originalImage original image
     * @param amountUp amount image needs to be shifted up
     * @param amountRight amount image needs to be shifted right
     * @return resulting image array
     */
    public static int[][] shift(final int[][] originalImage, final int amountUp,
            final int amountRight) {
        int[][] resultImage = clone2D(originalImage);
        int columnLength = originalImage.length;

        for (int row = 0; row < columnLength - Math.abs(amountUp); row++) {
            int rowLength = originalImage[row].length;

            if (amountUp > 0) {
                resultImage[row] = originalImage[row + amountUp].clone();
            } else if (amountUp < 0) {
                resultImage[columnLength - 1
                        - row] = originalImage[columnLength - 1 + amountUp - row].clone();
            } else if (amountUp == 0 && amountRight != 0) {

                for (int column = 0; column < rowLength - Math.abs(amountRight); column++) {
                    if (amountRight < 0) {
                        // amount will be negative so it will add
                        resultImage[row][column] = originalImage[row][column - amountRight];
                    } else if (amountRight > 0) {
                        resultImage[row][rowLength - 1 - column] = originalImage[row][rowLength - 1
                                - amountRight - column];
                    }

                }
                for (int fillColumn = rowLength
                        - Math.abs(amountRight); fillColumn < rowLength; fillColumn++) {
                    if (fillColumn >= 0) {
                        if (amountRight < 0) {
                            resultImage[row][fillColumn] = FILL_VALUE;
                        } else if (amountRight > 0) {
                            resultImage[row][rowLength - fillColumn - 1] = FILL_VALUE;
                        }
                    }
                }
            } // end amountRight if
        }

        if (amountUp != 0 && amountRight == 0) {
            for (int fillRow = columnLength
                    - Math.abs(amountUp); fillRow < columnLength; fillRow++) {
                if (fillRow >= 0) {
                    for (int column = 0; column < originalImage[fillRow].length; column++) {
                        if (amountUp > 0) {
                            resultImage[fillRow][column] = FILL_VALUE;
                        } else if (amountUp < 0) {
                            resultImage[columnLength - fillRow - 1][column] = FILL_VALUE;
                        }
                    }
                }
            }
        }

        return resultImage;
    }

    /**
     * Rotate the image left by 90 degrees around its center.
     * <p>
     * Any pixels rotated in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to rotate left 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateLeft(final int[][] originalImage) {
        return rotate(originalImage, false);
    }

    /*
     * Rotate the image right like above.
     */
    /**
     *
     * @param originalImage original image
     * @return rotated image
     */
    public static int[][] rotateRight(final int[][] originalImage) {
        return rotate(originalImage, true);
    }

    /**
     *
     * @param originalImage original image
     * @param rotateRight true if rotating right
     * @return image array
     */
    private static int[][] rotate(final int[][] originalImage, final boolean rotateRight) {
        // creates the right sized array
        int[][] resultImage = new int[originalImage[0].length][originalImage.length];

        int columnLength = originalImage.length;
        for (int row = 0; row < columnLength; row++) {
            int rowLength = originalImage[row].length;

            for (int column = 0; column < rowLength; column++) {
                if (rotateRight) {
                    resultImage[column][row] = originalImage[columnLength - 1 - row][column];
                } else {
                    resultImage[column][row] = originalImage[row][rowLength - 1 - column];
                }
            }
        }

        return resultImage;
    }

    /*
     * Flip the image on the vertical axis across its center.
     */
    /**
     *
     * @param originalImage original image
     * @return flipped image
     */
    public static int[][] flipVertical(final int[][] originalImage) {
        return null;
    }

    /*
     * Flip the image on the horizontal axis across its center.
     */
    /**
     *
     * @param originalImage original image
     * @return flipped image
     */
    public static int[][] flipHorizontal(final int[][] originalImage) {
        return null;
    }

    /**
     * Default amount to shift colors by. Not used by the testing suite, so feel free to change this
     * value.
     */
    public static final int DEFAULT_COLOR_SHIFT = 32;

    /**
     * Add red to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to add red to
     * @param amount the amount of red to add
     * @return the recolored image
     */
    public static int[][] moreRed(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Remove red from the image.
     */
    /**
     *
     * @param originalImage original image
     * @param amount amount to remove red
     * @return image array
     */
    public static int[][] lessRed(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Add green to the image.
     */
    /**
     *
     * @param originalImage original image
     * @param amount amount to add green
     * @return image array
     */
    public static int[][] moreGreen(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Remove green from the image.
     */
    /**
     *
     * @param originalImage original image
     * @param amount amount to remove green
     * @return image array
     */
    public static int[][] lessGreen(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Add blue to the image.
     */
    /**
     *
     * @param originalImage original image
     * @param amount amount to add blue
     * @return image array
     */
    public static int[][] moreBlue(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Remove blue from the image.
     */
    /**
     *
     * @param originalImage original image
     * @param amount amount to remove blue
     * @return image array
     */
    public static int[][] lessBlue(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Increase the image alpha channel.
     */
    /**
     *
     * @param originalImage original image
     * @param amount increase transparency
     * @return image array
     */
    public static int[][] moreAlpha(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Decrease the image alpha channel.
     */
    /**
     *
     * @param originalImage original image
     * @param amount decrease transparency
     * @return image array
     */
    public static int[][] lessAlpha(final int[][] originalImage, final int amount) {
        return null;
    }

    /**
     * The default resize factor. Not used by the testing suite, so feel free to change this value.
     */
    public static final int DEFAULT_RESIZE_AMOUNT = 2;

    /**
     * Shrink in the vertical axis around the image center.
     * <p>
     * An amount of 2 will result in an image that is half its original height. An amount of 3 will
     * result in an image that's a third of its original height. Any pixels shrunk in from off
     * screen should be filled with FILL_VALUE. This function <i>does not modify the original
     * image</i>.
     *
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's height is reduced
     * @return the shrunken image
     */
    public static int[][] shrinkVertical(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Expand in the vertical axis around the image center.
     */
    /**
     *
     * @param originalImage original image
     * @param amount amount to expand
     * @return image array
     */
    public static int[][] expandVertical(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Shrink in the horizontal axis around the image center.
     */
    /**
     *
     * @param originalImage original image
     * @param amount amount to shrink
     * @return image array
     */
    public static int[][] shrinkHorizontal(final int[][] originalImage, final int amount) {
        return null;
    }

    /*
     * Expand in the horizontal axis around the image center.
     */
    /**
     *
     * @param originalImage original image
     * @param amount amount to expand
     * @return image array
     */
    public static int[][] expandHorizontal(final int[][] originalImage, final int amount) {
        return null;
    }

    /**
     * Remove a green screen mask from an image.
     * <p>
     * This function should remove primarily green pixels from an image and replace them with
     * transparent pixels (FILL_VALUE), allowing you to achieve a green screen effect. Obviously
     * this function will destroy pixels, but it <i>does not modify the original image</i>.
     * <p>
     * While this function is tested by the test suite, only extreme edge cases are used. Getting it
     * work work will with real green screen images is left as a challenge for you.
     *
     * @param originalImage the image to remove a green screen from
     * @return the image with the green screen removed
     */
    public static int[][] greenScreen(final int[][] originalImage) {
        return null;
    }

    /**
     * A wild and mysterious image transform.
     * <p>
     * You are free to implement this in any way you want. It is not tested rigorously by the test
     * suite, but it should do something (change the original image) and <i>not modify the original
     * image</i>.
     * <p>
     * Call this function mystery. It should take only the original image as a single argument and
     * return a modified image.
     *
     * @param originalImage the image to perform a strange and interesting transform on
     * @return the image transformed in wooly and frightening ways
     */
    public static int[][] mystery(final int[][] originalImage) {
        return null;
    }
}
