package testFiles;

import org.junit.Before;
import org.junit.Test;
import sourceFiles.Bank;
import sourceFiles.Item;
import sourceFiles.Transaction;
import sourceFiles.UserAccount;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserAccountTest {
	UserAccount user;
	Bank bank;

	@Before
	public void setUp() throws Exception {
		bank = new Bank();
		user= new UserAccount();
		user.setFirstName("Ahmed");
		user.setLastName("Mohamed");
		user.setUserName("ahmed113");
		user.setPassword("123456");
		user.deposit(1000);
		bank.addAccount(user);
	}

	@Test
	public void test1() {
		assertEquals("Ahmed",user.getFirstName());
		assertEquals("Mohamed",user.getLastName());
		assertEquals("ahmed113",user.getUserName());
		assertEquals("123456",user.getPassword());
		assertEquals(1,user.getAccountNumber());
		UserAccount user2= new UserAccount();
		assertEquals(2,user2.getAccountNumber());
		
		
	}
	@Test
	public void test2() {
		assertEquals(1000,user.checkBalance(),0);
		user.deposit(100.1);
		assertEquals(1100.1,user.checkBalance(),0);
		
	}
	@Test
	public void test3() {
		user.withdraw(500);
		assertEquals(500,user.checkBalance(),0);
		user.withdraw(50.1);
		assertEquals(449.9,user.checkBalance(),0);
		
	}
	@Test
	public void test4() {
		UserAccount user2 = new UserAccount();
		user2.setUserName("mohamed123");
		bank.addAccount(user2);
		user.transferMoney(bank,"mohamed123",200);
		user2.transferMoney(bank, user.getUserName(), 100);
		assertEquals(900,user.checkBalance(),0);
		assertEquals(100,user2.checkBalance(),0);
		
	}
	@Test
	public void test5() {
		List<Transaction> t = new ArrayList<Transaction>();
		Transaction e = new Transaction();
		e.setAmount(1000);
		e.setDescription("NONE");
		e.setType(0);
		t.add(e);
		assertEquals(t.get(0).getType(),user.getStatement().get(0).getType());
	}
	@Test
	public void test6() {
		Item item = new Item(1000);
		user.purchase(item);
		assertEquals(item.getPrice(),user.getPurchases().get(0).getPrice(),0);
	}
	@Test
	public void test7() {
		assertTrue(user.getCard().isValid());
		assertTrue(user.hasCard());
	}

}
