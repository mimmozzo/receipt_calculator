package me.drdo.test.altan;

import me.drdo.altan.ReceiptItem;
import me.drdo.altan.ReceiptParser;
import junit.framework.TestCase;

public class TestReceiptParser extends TestCase {
	
	private ReceiptParser parser;

	@Override
	protected void setUp() throws Exception {
		parser = new ReceiptParser();
	}
	
	public void testItem(){
		String inputLine = "1 imported box of chocolates at 10.00\n";
		ReceiptItem item = parser.parseLine(inputLine);
		assertEquals(item.getQuantity(), 1);
		assertEquals(item.getProduct(), "imported box of chocolates");
		assertEquals(item.getUnitPrice(), 10.00);
	}

}
