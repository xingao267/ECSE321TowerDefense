package Exceptions;

public class InvalidMapConfigException extends Exception{
	/** default serial ID */
    private static final long serialVersionUID = 1L;

    public InvalidMapConfigException() {
        super();
    }

    public InvalidMapConfigException(String message) {
        super(message);
    }

    public InvalidMapConfigException(String message, Throwable cause) {
        super(message, cause);
    }
}
