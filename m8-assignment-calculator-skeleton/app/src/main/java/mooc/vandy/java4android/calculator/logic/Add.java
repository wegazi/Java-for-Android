package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 *
 */
public class Add implements MathematicalOperation {

    /**
     * The result of adding two numbers
     *
     * @param argumentOne first number to be added
     * @param argumentTwo second number to be added
     * @return result
     */
    public String process(int argumentOne, int argumentTwo) {
        return String.valueOf(argumentOne + argumentTwo);
    }
}
