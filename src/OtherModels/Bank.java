package OtherModels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

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

    // TODO need to be brought to presentation layer
    private int iconXPos = 550;
    private int iconYPos = 35;
    private Rectangle moneyIcon;

    private Bank() {
        this.balance = Constants.INITIAL_BANK_BALANCE;

        // TODO need to be brought to presentation layer
        moneyIcon =
                new Rectangle(iconXPos, iconYPos
                        + (Constants.STORE_BUTTON_SIZE - Constants.DISPLAY_SIZE) / 2,
                        Constants.DISPLAY_SIZE, Constants.DISPLAY_SIZE);
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

    /**
     * 
     * @param g
     */
    // TODO need to be brought to presentation layer
    public void draw(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(moneyIcon.x, moneyIcon.y, moneyIcon.width, moneyIcon.height);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.setColor(new Color(255, 255, 255));
        g.drawString("" + balance, iconXPos + moneyIcon.width + Constants.SPACING, iconYPos
                + Constants.STORE_BUTTON_SIZE / 2 + Constants.DISPLAY_SIZE / 4 - 1);
    }

}
