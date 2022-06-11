package testFiles;

import org.junit.Before;
import org.junit.Test;
import sourceFiles.CreditCard;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class CreditCardTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		CreditCard c = new CreditCard();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, 5);
		assertEquals(16,String.valueOf(c.getCardNumber()).length());
		assertEquals(52,(c.getCardNumber()/100000000000000L));
		assertEquals(cal.getTime(),c.getExpiryDate());
		assertEquals(3,String.valueOf(c.getCVC()).length());
		assertTrue(c.isValid());
	}

}
