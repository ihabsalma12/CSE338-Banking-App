package testFiles;

import org.junit.Before;
import org.junit.Test;
import sourceFiles.Transaction;

import java.util.Date;

import static org.junit.Assert.*;

public class TransactionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Transaction t = new Transaction();
		t.setDescription("PAYROLL");
		t.setType(0);
		t.setAmount(100);
		assertEquals("PAYROLL",t.getDescription());
		assertEquals("DEPOSIT",t.getType().toString());
		assertEquals(100,t.getAmount(),0);
		assertEquals(new Date(),new Transaction().getDate());
	}


}
