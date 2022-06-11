package testFiles;

import org.junit.Before;
import org.junit.Test;
import sourceFiles.Item;

import static org.junit.Assert.*;

public class ItemTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Item item = new Item(1000);
		item.setName("Pillow");
		assertEquals(1000,item.getPrice(),0);
		assertEquals("Pillow",item.getName());
	}

}
