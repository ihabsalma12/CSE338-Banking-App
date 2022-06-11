package sourceFiles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserAccount implements Serializable {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private double balance;
	private static int accountNumber;
	private List<Transaction> bankStatement;
	private List<Item> purchases;
	private CreditCard card;
	private boolean hasCard;

	public UserAccount() {
		bankStatement=new ArrayList<Transaction>();
		purchases = new ArrayList<Item>();
		accountNumber++;
		hasCard=false;
	}

	public void setFirstName(String string) {
		// TODO Auto-generated method stub
		this.firstName=string;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}

	public void setLastName(String string) {
		// TODO Auto-generated method stub
		this.lastName=string;

	}

	public void setUserName(String string) {
		// TODO Auto-generated method stub
		this.userName=string;

	}

	public void setPassword(String string) {
		// TODO Auto-generated method stub
		this.password=string;

	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	public void deposit(double i) {
		// TODO Auto-generated method stub
		Transaction t = new Transaction();
		t.setBalance(this);
		t.setAmount(i);
		t.setDescription("NONE");
		t.setType(0);
		this.balance+=i;
		this.bankStatement.add(t);

	}

	public double checkBalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}

	public void withdraw(double i) {
		// TODO Auto-generated method stub
		Transaction t = new Transaction();
		t.setBalance(this);
		this.balance-=i;
		t.setAmount(i);
		t.setDescription("NONE");
		t.setType(1);
		this.bankStatement.add(t);

	}

	public void transferMoney(Bank bank, String string, double i) {
		// TODO Auto-generated method stub
		this.balance-=i;
		bank.getAccount(string).deposit(i);
		Transaction t = new Transaction();
		t.setBalance(this);
		t.setAmount(i);
		t.setDescription("NONE");
		t.setType(3);
		this.bankStatement.add(t);

	}

	public List<Transaction> getStatement() {
		// TODO Auto-generated method stub
		return this.bankStatement;

	}

	public void purchase(Item item) {
		// TODO Auto-generated method stub
		Transaction t = new Transaction();
		t.setBalance(this);
		t.setAmount(item.getPrice());
		t.setDescription("Item purchase");
		t.setType(2);
		this.balance-=item.getPrice();
		this.purchases.add(item);

		this.bankStatement.add(t);


	}
	public void payBill(String name, double amount){
		Transaction t = new Transaction();
		t.setBalance(this);
		t.setAmount(amount);
		t.setDescription(name);
		t.setType(4);
		this.balance-=amount;
		this.bankStatement.add(t);
	}

	public int getAccountNumber() {
		// TODO Auto-generated method stub
		return this.accountNumber;
	}

	public List<Item> getPurchases() {
		// TODO Auto-generated method stub
		return this.purchases;
	}

	public CreditCard getCard() {
		// TODO Auto-generated method stub
		if(!this.hasCard) {
			this.card = new CreditCard();
			this.hasCard = true;
		}
		return this.card;

	}
	public boolean hasCard() {
		return this.hasCard;
	}

}
