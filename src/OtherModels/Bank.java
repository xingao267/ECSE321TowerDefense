package OtherModels;

import Exceptions.NoEnoughMoneyException;
import Utility.Constants;

/**
 * 
 * Singleton Bank class
 * 
 * @author Jose, Xin
 *
 */
public class Bank {

    private static Bank uniqueInstance = null;

    private int balance;

    private Bank() {
        this.balance = Constants.INITIAL_BANK_BALANCE;
    }

    public static synchronized Bank getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Bank();
        }
        return uniqueInstance;
    }

    public static void resetUniqueInstance() {
        uniqueInstance = new Bank();
    }

    /**
     * Return the balance to the bank
     * 
     * @param refundValue
     */
    public synchronized void returnToBank(double refundValue) {
        this.balance += refundValue;
    }

    /**
     * Remove the balance from the bank
     * 
     * @param cost
     * @throws NoEnoughMoneyException
     */
    public synchronized void removeFromBank(int cost) throws NoEnoughMoneyException {
        if (this.balance < cost) {
            throw new NoEnoughMoneyException();
        }
        this.balance -= cost;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int b) {
        balance = b;
    }

}
