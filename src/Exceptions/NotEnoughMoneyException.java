/**
 * 
 */
package Exceptions;

/**
 * NoEnoughMoneyException thrown when purchasing a tower
 * 
 * @author Xin
 *
 */
public class NotEnoughMoneyException extends Exception {

    /** default serial ID */
    private static final long serialVersionUID = 1L;

    public NotEnoughMoneyException() {
        super();
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }

    public NotEnoughMoneyException(String message, Throwable cause) {
        super(message, cause);
    }
}
