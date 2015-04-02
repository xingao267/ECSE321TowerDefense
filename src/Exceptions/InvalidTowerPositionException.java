/**
 * 
 */
package Exceptions;

/**
 * @author Xin
 *
 */
public class InvalidTowerPositionException extends Exception {

    /** default serial ID */
    private static final long serialVersionUID = 1L;

    public InvalidTowerPositionException() {
        super();
    }

    public InvalidTowerPositionException(String message) {
        super(message);
    }

    public InvalidTowerPositionException(String message, Throwable cause) {
        super(message, cause);
    }
}
