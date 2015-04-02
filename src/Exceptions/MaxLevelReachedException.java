package Exceptions;

/**
 * 
 * MaxLevelReachedException class
 * 
 * @author Xin
 *
 */
public class MaxLevelReachedException extends Exception {

    /** default serial ID */
    private static final long serialVersionUID = 1L;

    public MaxLevelReachedException() {
        super();
    }

    public MaxLevelReachedException(String message) {
        super(message);
    }

    public MaxLevelReachedException(String message, Throwable cause) {
        super(message, cause);
    }

}
