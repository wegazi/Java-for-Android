package mooc.vandy.java4android.birthdayprob.logic;

import java.util.Random;

import mooc.vandy.java4android.birthdayprob.ui.OutputInterface;

import static java.lang.Math.round;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early Android interactions.
 * Designing the assignments this way allows you to first learn key 'Java' features without
 * having to beforehand learn the complexities of Android.
 *
 */
public class Logic implements LogicInterface {

    // This is a String to be used in Logging (if/when you decide you need it for debugging)
    public static final String TAG = Logic.class.getName();

    /*
    * This is the variable that stores our OutputInterface instance.
    * <p>
    * This is how we will interact with the User Interface [MainActivity.java].
    * <p>
    * it is called 'out' because it is where we 'out-put' our results. (It is also the 'in-put'
    * from where we get values from, but it only needs 1 name, and 'out' is good enough)
    */
    OutputInterface out;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface _out){
        out = _out;
    }

    /**
     * This is the method that will (eventually) get called when the on-screen button labelled
     * 'Process...' is pressed.
     */
    public void process() {

        int groupSize = out.getSize();
        int simulationCount = out.getCount();

        if (groupSize < 2 || groupSize > 365) {
            out.makeAlertToast("Group Size must be in the range 2-365.");
            return;
        }
        if (simulationCount <= 0) {
            out.makeAlertToast("Simulation Count must be positive.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        out.println("For a group of " + groupSize + " people, the percentage");
        out.println("of times that two people share the same birthday is");
        out.println(String.format("%.2f%% of the time.", percent));

    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit testing.
     *
     * Given a sample size and and a number of iterations, look for at least
     * two people with the same birthday. Return a percentage of the iterations
     * where matching birthdays were found.
     *
     * @param size the number of people to test
     * @param count the number of iterations
     * @return the percentage of iterartions that showed a match
     */
    public double calculate(int size, int count) {
        int numberFound = 0;
        boolean found = false;

        for (int i=0; i < count; i++) { // number of tests
            if (foundMatch(size, i+1)) {
                numberFound++;
            }
        }
        double percentage = ((double) numberFound / (double) count) * 100.00;
        return percentage;
    }

    /**
     * For a sample of size 'size' search for two identical birthdays
     *
     * @param size sample size
     * @return did we find a match
     */
    private static boolean foundMatch(int size, int seed) {
        // System.out.println("In found match with seed " + seed);
        Random random = new Random(seed);
        boolean[] birthdays = new boolean[365];

        for (int j = 0; j < size; j++) { // size of sample
            int n = random.nextInt(365);
            if (birthdays[n]) {
                return true;
            }
            birthdays[n] = true;
        }

        return false;
    }
     
}
