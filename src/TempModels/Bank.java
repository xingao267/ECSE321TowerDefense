package TempModels;

import java.awt.*;

import Utility.Constants;

/**
 * 
 * @author Jose
 *
 */
public class Bank {

	private static int balance; 
	
	private int iconXPos = 550;
	private int iconYPos = 35;
	
	private Rectangle moneyIcon;
	
	public Bank(){
		this.balance = Constants.INITIAL_BANK_BALANCE;
		moneyIcon = new Rectangle(iconXPos, iconYPos + (Constants.STORE_BUTTON_SIZE - Constants.DISPLAY_SIZE)/2, 
				Constants.DISPLAY_SIZE, Constants.DISPLAY_SIZE);
	}
	
	/**
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(moneyIcon.x, moneyIcon.y, moneyIcon.width, moneyIcon.height);
		g.setFont(new Font("Courier New", Font.BOLD, 20));
		g.setColor(new Color(255, 255, 255));
		g.drawString("" + balance, iconXPos + moneyIcon.width + Constants.SPACING, 
				iconYPos + Constants.STORE_BUTTON_SIZE/2 + Constants.DISPLAY_SIZE/4 - 1);
	}
	
	/**
	 * 
	 * @param refundValue
	 */
	public static void returnToBank(int refundValue) {
		balance += refundValue;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int b) {
		balance = b;
	}
	
	
}
