package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply implements MathematicalOperation {

    /**
     * The result of multiplying two numbers
     *
     * @param argumentOne first number to be multiplied
     * @param argumentTwo second number to be multiplied
     * @return result
     */
    public String process(int argumentOne, int argumentTwo) {
        return String.valueOf(argumentOne * argumentTwo);
    }
}
