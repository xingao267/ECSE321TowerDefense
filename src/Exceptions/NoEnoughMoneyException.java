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
public class NoEnoughMoneyException extends Exception {

    /** default serial ID */
    private static final long serialVersionUID = 1L;

    public NoEnoughMoneyException() {
        super();
    }

    public NoEnoughMoneyException(String message) {
        super(message);
    }

    public NoEnoughMoneyException(String message, Throwable cause) {
        super(message, cause);
    }
}
