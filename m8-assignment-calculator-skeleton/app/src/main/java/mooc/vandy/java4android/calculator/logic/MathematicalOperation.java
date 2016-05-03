package mooc.vandy.java4android.calculator.logic;

/**
 * Created by bill on 4/29/16.
 *
 * All mathematical operations follow the same pattern so use an interface to enforce it
 *
 */
public interface MathematicalOperation {

    /**
     * Perform a class-specific mathematical operation
     *
     * @param argumentOne first argument
     * @param argumentTwo second argument
     * @return result
     */
    String process(int argumentOne, int argumentTwo);
}
