package model;

/**
 * Custom exception for calculations.
 * Thrown when an operation is used for calculation that is not described in the model.
 *
 * @author Pilipenko Mihail
 * @version 1.0
 */
public class UnexpectedException extends Exception{
    /**
     * Instantiates a new Unexpected exception.
     *
     * @param message the message
     */
    public UnexpectedException(String message) {
        super(message);
    }
}
