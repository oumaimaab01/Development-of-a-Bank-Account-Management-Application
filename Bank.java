package tp_bank;
import java.util.ArrayList;

import java.util.List;


import javax.swing.JFrame;


public class Bank {
	String name;
	List<Account> accounts = new ArrayList<Account>();

	public Bank() {
		
	}


	// rechercher un compte à partir de son numéro

	Account lookFor(String number)
	{   
		for(Account a : this.accounts)
		{if(a.getName()==number)
		{return a;}

		}
		return null;
	}
	// créer une instance de la classe Bank

	public static Bank getInstance() {

		Bank  instance = new Bank();
		return instance;
	}

	void setName(String name)
	{
		this.name=name;
	}


	public String getName() {
		return name;
	}

	// ajouter un compte à la liste "accounts"
	public boolean add(Account e) 
	{
		return accounts.add(e); 
	}


	// simuler des transactions bancaires
	void simulate() throws NegativeAmountException
	{
           Account c3=new SavingAccount("rose",0.05,2000);
		Account c1=new CurrentAccount("ilham", 1000,2000);
		Account c2=new CurrentAccount("ines", 1000,2000);
		
		try {
			c3.withdraw(50);
		} catch (InsufficientFundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			c3.deposit(50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(c1);
		this.add(c2);
		this.add(c3);

	}
	
	public static void main(String[] args) {
		Bank bank = Bank.getInstance(); bank.setName("BMCDE Bank"); 
		try {
			bank.simulate();
		} catch (NegativeAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame frame = new AuthFrame(); //Authorization
		frame.setVisible(true);
		}
		}
	



