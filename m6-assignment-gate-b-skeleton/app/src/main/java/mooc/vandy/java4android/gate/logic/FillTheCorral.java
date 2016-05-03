package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This executable Android app will use your Gate.java class.  We have
 * supplied you with the code necessary to execute as an app.  You
 * must fill in the logic.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out){
        mOut = out;
    }

    // TODO -- Fill your code in here

    /**
     * Create	PrintStream	for	output;
     * create	Random	object	to	generage	ints
     * and	Bollean	values;
     * contains	some	logic;	makes	method	calls
     *
     * @param args
     */
    public static void main(String[] args) {
        //
    }

    /**
     * Given an array of gates, set each on to open in, open out or closed
     *
     * @param corral array of gates
     * @param rnd random number generator
     */
    public void setCorralGates(Gate[] corral, Random rnd) {
        for (int i = 0; i < corral.length; i++) {
            // randomly set to in or out
            setGate(corral[i], rnd);

            // print result
            mOut.println("Gate "+ i + ':' + String.valueOf(corral[i]));
        }

    }

    /**
     * Randomly assign each gate to open in, open out or closed
     *
     * @param gateToSet the gate to set
     * @param rnd random number generator
     */
    private static void setGate(Gate gateToSet, Random rnd) {
        if (rnd.nextBoolean()) {
            gateToSet.open(Gate.IN);
        } else {
            gateToSet.open(Gate.OUT);
        }
    }

    /**
     * Check if at least one gate in the corral is set to open in
     *
     * @param corral array of gates
     * @return true if at least one gate opens in
     */
    public static boolean anyCorralAvailable(Gate[] corral) {
        for (Gate gate : corral) {
            if (gate.isLocked()) { continue; }
            if (gate.getSwingDirection() == Gate.IN) {
                return true;
            }
        }
        return false;
    }


    /*
        5 snails are trying to move through locked coral 2.
        There are currently 5 snails still in the pasture.
        2 snails are trying to move through locked coral 2.
        There are currently 5 snails still in the pasture.
        4 snails are trying to move through entry coral 0.
        There are currently 1 snails still in the pasture.
        1 snails are trying to move through entry coral 0.
        There are currently 0 snails still in the pasture.
        It took 4 attempts to coral all of the snails.
    */

    /*
        The	program	begins with 5 snails out to pasture and an infinite
        number of snails in each corral.

        A random number of snails, not to exceed the number	already	out	to pasture,
        attempt	to pass through a randomly	chosen corral gate.

        If the gate allows for entry, the snails enter the corral and the
        number of snails out to pasture is reduced.

        If the gate	is locked, they do not enter. If the
        gate is	set	to	exit the corral	however, the same number of snails that attempted to enter
        that corral actually exits the corral thus increasing the number of snails out to pasture.

        This continues until finally there are no snails out to pasture
     */

    /**
     *
     * @param corral
     * @param rand
     */
    public void corralSnails(Gate[] corral, Random rand) {
        int snailsInPasture = 5;
        int iterations = 0;

        while (snailsInPasture > 0) {
            // random number of snails not to exceed total in pasture
            int numberOfSnails = rand.nextInt(snailsInPasture + 1);

            // random gate
            int gateNumber = rand.nextInt(corral.length);
            Gate randomGate = corral[gateNumber];

            mOut.println(numberOfSnails + " snails are trying to move through entry coral "
                    + gateNumber  +".");

            int netChange = randomGate.thru(numberOfSnails);

            // net change is change to pen; negative of this number is change to pasture
            snailsInPasture = snailsInPasture - netChange;

            iterations++;
        }

        mOut.println("It took " + iterations + " attempts to coral all of the snails.");
    }
}
