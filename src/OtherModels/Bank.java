package OtherModels;

import Utility.Constants;

/**
 * 
 * Singleton Bank class
 * 
 * @author Jose
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

    /**
     * Return the balance to the bank
     * 
     * @param refundValue
     */
    public void returnToBank(int refundValue) {
        this.balance += refundValue;
    }

    /**
     * Remove the balance from the bank
     * 
     * @param refundValue
     */
    public void removeFromBank(int cost) {
        this.balance -= cost;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int b) {
        balance = b;
    }

}
