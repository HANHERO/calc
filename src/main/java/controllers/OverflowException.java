package controllers;

/**
 * Custom exception for calculations.
 * Thrown when scale of result of calculation is bigger than maximum scale.
 * Maximum scale determined in {@link Controller}.
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class OverflowException extends Exception {
    /**
     * Instantiates a new Overflow exception.
     *
     * @param message the message
     */
    public OverflowException(String message) {
        super(message);
    }
}
