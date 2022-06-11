package sourceFiles;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class CreditCard implements Serializable {

	private Date expiryDate;
	private int CVC;
	private boolean isValid;
	private long cardNumber;

	public CreditCard() {
		long first14 = (long) (Math.random() * 100000000000000L);
		cardNumber = 5200000000000000L + first14;
		CVC=(int) (1000L*Math.random());
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, 5);
		expiryDate = cal.getTime();
		isValid=true;
	}

	public long getCardNumber() {
		// TODO Auto-generated method stub
		return this.cardNumber;

	}

	public Date getExpiryDate() {
		// TODO Auto-generated method stub
		return this.expiryDate;
	}

	public int getCVC() {
		// TODO Auto-generated method stub
		return this.CVC;

	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return this.isValid;
	}

}
