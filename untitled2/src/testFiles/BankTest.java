package testFiles;

import org.junit.Before;
import org.junit.Test;
import sourceFiles.Bank;
import sourceFiles.UserAccount;

import static org.junit.Assert.*;

public class BankTest {
	Bank bank;
	Bank bank2;
	UserAccount user;

	@Before
	public void setUp() throws Exception {
		bank = new Bank();
		user = new UserAccount();
		user.setUserName("ahmed113");
		user.deposit(2000);
		bank.addAccount(user);
	}

	@Test
	public void test() {
		assertEquals(2000,bank.getAccount("ahmed113").checkBalance(),0);
	}
	@Test
	public void test2() throws Exception {
		bank2= new Bank();
		bank.serializeDataOut();
		bank2.serializeDataIn();
		assertEquals(2000,bank2.getAccount("ahmed113").checkBalance(),0);
	}


}
