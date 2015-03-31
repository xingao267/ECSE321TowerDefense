package Exceptions;

public class InvalidMapParameterException extends Exception{
	/** default serial ID */
    private static final long serialVersionUID = 1L;

    public InvalidMapParameterException() {
        super();
    }

    public InvalidMapParameterException(String message) {
        super(message);
    }

    public InvalidMapParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
