package mooc.vandy.java4android.gate.logic;

/**
 * Controls for a cattle gate
 */
public class Gate {
    public static final int IN = 1;
    public static final int OUT = -1;

    private int swingDirection = 0; // closed by default
    private boolean locked = true;


    /**
     * Set the swing direction of the gate
     *
     * @param swingDirection in or out
     * @return true if gate direction was set successfully
     */
    public boolean setSwing(int swingDirection) {
        if (!(swingDirection == IN || swingDirection == OUT)) {
            return false;
        }
        this.swingDirection = swingDirection;
        return true;
    }

    /**
     * Open the gate in a given direction
     *
     * @param swingDirection in or out
     * @return result (will be false if improper swing direction specified
     */
    public boolean open(int swingDirection) {
        if (!(swingDirection == IN || swingDirection == OUT)) {
            return false;
        }
        this.swingDirection = swingDirection;
        locked = false;
        return true;
    }

    /**
     * Return true when gate is open (swingDirection not equal 0)
     *
     */
    public boolean isOpen() {
        return ! (swingDirection == 0);
    }

    /**
     * Is the gate locked?
     *
     * @return lock status of gate
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Set whether gate swings to let animals in or out
     *
     * @return swing direction
     */
    public int getSwingDirection() {
        return swingDirection;
    }

    /**
     * Lock the gate
     */
    public void close() {
        locked = true;
    }

    /**
     * Send animals through the gate then return the net change to the pen
     *
     * @param count number of animals going through the gate
     * @return net change in number of anmials in the pen
     */
    public int thru(int count) {
        switch (swingDirection) {
            case IN:
                return count;
            case OUT:
                return -count;
            default:
                return 0;
        }
    }

    /**
     * Summarize the status of the gate
     * @return status message
     */
    public String toString() {
        String message;

        if (locked) {
            message = "This gate is locked";
        } else {
            if (swingDirection == IN) {
                message = "This gate is not locked and swings to enter the pen only";
            } else if (swingDirection == OUT) {
                message = "This gate is not locked and swings to exit the pen only";
            } else {
                message = "This gate is not locked and swings but the swing is not set properly";
            }
        }
        return message;
    }
}
