package model;

/**
 * Custom exception for calculations.
 * Thrown when an invalid input,
 * for example when the square root is taken from negative number.
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class NegativeSqrtException extends Exception {
    /**
     * Instantiates a new Negative sqrt exception.
     *
     * @param message the message
     */
    public NegativeSqrtException(String message) {
        super(message);
    }
}
