package sourceFiles;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
	public enum TransactionType{
		DEPOSIT,WITHDRAWAL,PURCHASE,TRANSFER,BILL;
	}

	private String description;
	private TransactionType type;
	private double amount;
	private Date date;
	private double balance;

	public Transaction() {
		date= new Date();
	}

	public void setDescription(String s) {
		// TODO Auto-generated method stub
		this.description=s;

	}

	public void setType(int i) {
		// TODO Auto-generated method stub
		switch(i) {
			case 0:
				this.type=TransactionType.DEPOSIT;
				break;
			case 1:
				this.type=TransactionType.WITHDRAWAL;
				break;
			case 2:
				this.type=TransactionType.PURCHASE;
				break;
			case 3:
				this.type=TransactionType.TRANSFER;
				break;
			case 4: this.type=TransactionType.BILL;
		}



	}

	public void setAmount(double i) {
		// TODO Auto-generated method stub
		this.amount=i;

	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;

	}

	public TransactionType getType() {
		// TODO Auto-generated method stub
		return this.type;

	}

	public double getAmount() {
		// TODO Auto-generated method stub
		return this.amount;

	}

	public Date getDate() {
		// TODO Auto-generated method stub
		return this.date;

	}

	public Double getBalance(){
		return this.balance;
	}
	public void setBalance(UserAccount u){
		this.balance=u.checkBalance();
	}
}
