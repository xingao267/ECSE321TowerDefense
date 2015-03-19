package Exceptions;

import CritterModels.Critter;

/**
 * CritterDeadException class
 * 
 * When this exception is caught, the critter should be removed from the global critter group list
 * 
 * @author Xin
 */

public class CritterDeadException extends Exception {
    /** default serial ID */
    private static final long serialVersionUID = 1L;

    private Critter critter;

    public CritterDeadException(Critter critter) {
        super();
        this.critter = critter;
    }

    public CritterDeadException(String message, Critter critter) {
        super(message);
        this.critter = critter;
    }

    public CritterDeadException(String message, Throwable cause, Critter critter) {
        super(message, cause);
        this.critter = critter;
    }

    public Critter getDeadCritter() {
        return this.critter;
    }
}
