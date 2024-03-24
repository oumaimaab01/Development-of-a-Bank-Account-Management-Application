package tp_bank;


/*Exception thrown if the current account balance is insufficient
*/
public class NegativeAmountException extends Exception {
	private static final long serialVersionUID = 1L;

	Account account;
	Double amount;
	//
	public NegativeAmountException(Account account, Double amount) {
		super();
		this.account = account;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return String.format(
				"NegativeAmountException : deposit (account '%s', amount '%.2f' must be positive)", 
				account.getName(),amount);
	}

}
