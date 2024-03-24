package tp_bank;


/*Exception thrown if the current account balance is insufficient
*/
public class InsufficientFundException extends Exception {
	private static final long serialVersionUID = 1L;
	Account account;
	Double amount;
	//
	public InsufficientFundException(Account account, Double amount) {
		super();
		this.account = account;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return 	String.format(
				"InsufficientFundException : credit limit exceeded (%s %.2f)", 
				account.getName(),amount);
	}
}
