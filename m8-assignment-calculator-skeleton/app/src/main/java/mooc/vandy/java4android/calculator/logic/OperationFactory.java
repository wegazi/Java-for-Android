package mooc.vandy.java4android.calculator.logic;

/**
 * Created by bill on 5/3/16.
 *
 * Factory class to return the appropriate Math Object.
 */
public class OperationFactory {
    /**
     * Constants to map the operation name to an integer
     *
     */
    public static final int ADDITION = 1; // 1 = addition
    public static final int SUBSTRACTION = 2; // 2 = subtraction
    public static final int MULTIPLICATION = 3; // 3 = multiplication
    public static final int DIVISION = 4; // 4 = division

    public static MathematicalOperation getOperation(int operationType) throws Exception {
        MathematicalOperation mathObject;

        switch (operationType) {
            case ADDITION:
                mathObject = new Add();
                break;
            case SUBSTRACTION:
                mathObject = new Subtract();
                break;
            case MULTIPLICATION:
                mathObject = new Multiply();
                break;
            case DIVISION:
                mathObject = new Divide();
                break;
            default:
                throw new Exception("Invalid operation type: " + operationType);
        }

        return mathObject;

    }
}
