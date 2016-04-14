package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // Set size of diamond based on user input
        int rows = size * 2 + 1;
        int cols = size * 2 + 2;

        /**
         * i is used to represent rows.
         * j is used to reprsent columns.
         * Iterate over each row and column, implementing appropriate logic
         *   to create a diamond shape.
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows-1) { // outer rows
                    if (j == 0 || j == cols-1) {
                        mOut.print('+');
                    } else {
                        mOut.print('-');
                    }

                } else {  // inner rows
                    if (j == 0 || j == cols-1) {
                        mOut.print('|'); // outer cols
                    } else { // inner cols
                        if (i == rows / 2) { // middle of diamond
                            if (j == 1) {
                                mOut.print('<');
                            } else if (j == cols-2) {
                                mOut.print('>');
                            } else {
                                mOut.print(getFiller(i));
                            }
                        } else if (i < rows / 2) { // upper half of diamond
                            int upperLeftEdge = (cols/2) - i;
                            int upperRightEdge = (cols/2) + (i-1);

                            if (j == upperLeftEdge) {
                                mOut.print('/');
                            } else if (j == upperRightEdge) {
                                mOut.print('\\');
                            } else if (j > upperLeftEdge && j < upperRightEdge) {
                                mOut.print(getFiller(i));
                            } else {
                                mOut.print(" ");
                            }
                        } else if (i > rows / 2) { // lower half of diamond
                            int lowerLeftEdge = (cols/2) + (i - (cols - 2));
                            int lowerRightEdge = (cols/2) - (i - (cols - 3));

                            if (j == lowerLeftEdge) {
                                mOut.print('\\');
                            } else if (j == lowerRightEdge) {
                                mOut.print('/');
                            } else if (j > lowerLeftEdge && j < lowerRightEdge) {
                                mOut.print(getFiller(i));
                            } else {
                                mOut.print(" ");
                            }
                        }
                    }
                }
            }
            mOut.println(""); // end of each row
        }
    }

    // Use modulus to tell if integer is odd or even
    private static boolean isEven(int value) {
        return (value % 2 == 0);
    }

    // return different char for odd vs even integer values
    public static char getFiller(int line) {
        if (isEven(line)) {
            return '-';
        }
        return '=';
    }

}
