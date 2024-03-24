package tp_bank;

import java.util.List;

import java.util.Random;
import java.util.Scanner;

public class Main {
	private Authorization authorization;

	public Main(Authorization authorization) {
		this.authorization = authorization;
	}
	/**
	 * Ask the user for username and password
	 * Uses authorization.authorize(username, password) to access
	 * the bank accounts 
	 */
	public boolean grantAccess() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();
		scanner.close();

		if (authorization.authorize(username, password)) {
			System.out.println("Authentication successful. Access granted.\n");
			// Proceed to account operations
			return true;
		} else {
			System.out.println("Authentication failed. Access denied.");
			// Exit or prompt user to try again
			return false;
		}
	}
/**
 * Cette m�thode fait une simulation des op�rations bancaires avec 2 comptes
 */
	private void proceed() {
		List<Account> accounts = 
				List.of(
						new CurrentAccount("Karim", 2000,1000),	
						new SavingAccount("Nora", 2000,0.05)
						);
		Random random = new Random();

		for (int i = 0; i < 5; i++) {
			int i1 = random.nextInt(accounts.size());//get an account from accounts
			var account1 = accounts.get(i1);  //0,1
			var account2 = accounts.get(1-i1);//1,0
			int operation = random.nextInt(3);
			double amount = random.nextDouble(2000.0);
			switch(operation){
			case 0: //DEPOSIT
				try {
					account1.deposit(amount);
				} catch (NegativeAmountException e) {
					System.out.println(e);
				}
				break;
			case 1: //WITHDRAW
				try {
					account1.withdraw(amount);
				} catch (InsufficientFundException | NegativeAmountException e) {
					System.out.println(e);
				}
				break;
			case 2: //TRANSFER 
					account1.transfer(amount,account2);
				break;
			default :
				throw new IllegalArgumentException("Operation not considered!");
			}
		}
		// Print the statements (operations) of the accounts
		
		for(Account account : accounts) {
			System.out.println(account.bankStatement());
		}
	}//end of proceed
	public static void main(String[] args) {
        Authorization simpleAuth = 
        	(name, pwd)-> (name.equals("admin") && pwd.equals("123"));
        var test = new Main(simpleAuth);
        boolean granted = test.grantAccess();
        if(granted) test.proceed();
        else 	System.exit(0);
    }
}
