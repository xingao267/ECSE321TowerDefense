package TempModels;

public class Bank {

	private static int balance = 30;
	
	public Bank(int balance){
		this.balance = balance;
	}
	
	public static void returnToBank(int refundValue) {
		balance += refundValue;
	}

	public static int getBalance() {
		return balance;
	}

	public static void setBalance(int b) {
		balance = b;
	}
}
