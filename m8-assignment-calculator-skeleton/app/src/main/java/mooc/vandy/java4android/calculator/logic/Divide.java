package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide implements MathematicalOperation {

    /**
     * Given two integers, return both the quotient and remainder
     *
     * @param argumentOne numerator
     * @param argumentTwo denominator
     * @return string representation of division operation
     */
    public String process(int argumentOne, int argumentTwo) {
        if (argumentTwo == 0) {
            return "Warning: division by 0 is not allowed.";
        }

        return String.valueOf(getQuotient(argumentOne, argumentTwo)) +
                " R: " + String.valueOf(getRemainder(argumentOne, argumentTwo));
    }

    /**
     * Calculate quotient when dividing two numbers
     *
     * @param argumentOne numerator
     * @param argumentTwo denominator
     * @return quotient
     */
    private int getQuotient(int argumentOne, int argumentTwo) {
        return argumentOne / argumentTwo;
    }

    /**
     * Calculate remainder when two numbers are divided
     *
     * @param argumentOne numerator
     * @param argumentTwo denominator
     * @return remainder
     */
    private int getRemainder(int argumentOne, int argumentTwo) {
        return argumentOne % argumentTwo;
    }
}
