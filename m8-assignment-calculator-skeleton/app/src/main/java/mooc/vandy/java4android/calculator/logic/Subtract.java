package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract implements MathematicalOperation {

    /**
     * The result of subtracting one number from another
     *
     * @param argumentOne minuend
     * @param argumentTwo subtrahend
     * @return difference
     */
    public String process(int argumentOne, int argumentTwo) {
        return String.valueOf(argumentOne - argumentTwo);
    }
}
