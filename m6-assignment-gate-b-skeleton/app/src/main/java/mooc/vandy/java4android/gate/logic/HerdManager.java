package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This executable Android App will use your Gate class.  We have
 * supplied you will the code necessary to execute as an app.  You
 * must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * Size of the herd
     */
    public static final int HERD = 24;

    /**
     * Constructor initializes the field.
     */
    public HerdManager(OutputInterface out){
        mOut = out;
    }

    /**
     * Set one gate to swing in, the other to swing out
     *
     * @param inGate the gate to swing in
     * @param outGate the gate to swing out
     */
    public static void setGates(Gate inGate, Gate outGate) {
        inGate.open(Gate.IN);
        outGate.open(Gate.OUT);
    }

    /**
     * Choose randomly from between two gates
     *
     * @param firstGate first gate to choose from
     * @param secondGate second gate to choose from
     * @param rnd Random number generator
     * @return gate choosen at random
     */
    private static Gate selectRandomGate(Gate firstGate, Gate secondGate, Random rnd) {
        if (rnd.nextBoolean()) {
            return firstGate;
        } else {
            return secondGate;
        }
    }

    /**
     * Select a random integer between 1 and maxExclusive
     *
     * @param rnd
     * @param maxExclusive
     * @return random number
     */
    private static int getRandomNumber(Random rnd, int maxExclusive) {
        if (maxExclusive == 1) return 1;
        return rnd.nextInt(maxExclusive) + 1;
    }

    /**
     * Run a simulation to let animals in and out of the pens.
     *
     * @param inGate gate that lets animals in
     * @param outGate gate that lets animals out
     * @param rnd Random number generator
     */
    public void simulateHerd(Gate inGate, Gate outGate, Random rnd) {
        int iterations = 10;
        int penCount = HERD;
        int pastureCount = 0;
        int netChange = 0;
        int throughCount = 0;

        for (int i = 0; i < iterations; i++) {
            if (pastureCount == 0) {
                throughCount = getRandomNumber(rnd, penCount);
                netChange = outGate.thru(throughCount);
            } else if (penCount == 0) {
                throughCount = getRandomNumber(rnd, pastureCount);
                netChange = inGate.thru(throughCount);
            } else {
                Gate randomGate = selectRandomGate(inGate, outGate, rnd);

                if (randomGate.getSwingDirection() == Gate.IN) {
                    // Gate swings in so choose a random number from pasture
                    throughCount = getRandomNumber(rnd, pastureCount);
                    netChange = randomGate.thru(throughCount);
                } else if (randomGate.getSwingDirection() == Gate.OUT) {
                    // Gate swings out so choose a random number from pen
                    throughCount = getRandomNumber(rnd, penCount);
                    netChange = randomGate.thru(throughCount);
                }
            }

            pastureCount = pastureCount - netChange;
            penCount = penCount + netChange;

            mOut.println("There are currently " + penCount +  " snails in the pen and " +
                    pastureCount + " snails in the pasture");
        }

    }
}
