/**
 * 
 */
package Exceptions;

/**
 * @author Xin
 *
 */
public class InvalidTowerTypeException extends Exception {

    /** default serial ID */
    private static final long serialVersionUID = 1L;

    public InvalidTowerTypeException() {
        super();
    }

    public InvalidTowerTypeException(String message) {
        super(message);
    }

    public InvalidTowerTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
