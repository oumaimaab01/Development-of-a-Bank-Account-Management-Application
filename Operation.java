/**
 * 
 */
package tp_bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * @author A. EL FAKER
 *
 */
public class Operation {
	public static final String DEPOSIT = "DEPOSIT";
	public static final String WITHDRAW = "WITHDRAW";
	//attributes
	private String type;
	private double amount;
	private LocalDate date;
	//constructor
	public Operation(String type, double amount,LocalDate date) {
		super();
		this.type = type;
		this.amount = amount;
		this.date = date;
	}
	//methods
	@Override
	public String toString() {
		String res = "\n "
				+ date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"\t"
				+ type;
		if(type == Operation.DEPOSIT) res +="\t\t\t";
		else res +="\t";
		res += String.format("%.2f", amount);
		return res;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) 	return false;
		if (this == obj) 	return true;
		if(obj instanceof Operation ) {
			Operation operation = (Operation) obj;
			return (type == operation.type &&  
					amount == operation.amount && 
					date.equals(operation.date) );
		}else 	return false;
	}
	//accessors
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


}
