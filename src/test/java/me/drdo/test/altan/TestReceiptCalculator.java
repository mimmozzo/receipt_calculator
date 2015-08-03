package me.drdo.test.altan;

import junit.framework.TestCase;
import me.drdo.altan.ReceiptCalculator;

public class TestReceiptCalculator extends TestCase {
	
	private ReceiptCalculator calculator;
	
    protected void setUp() {
    	calculator = new ReceiptCalculator();        
    }
	
	public void testFirstReceipt() {
	
		String input = 
				"1 book at 12.49\n" + 
				"1 music CD at 14.99\n" + 
				"1 chocolate bar at 0.85";
	
		String output = calculator.calculate(input);
		String expected =   "1 book : 12.49\n" +
							"1 music CD: 16.49\n" +
							"1 chocolate bar: 0.85\n" +
							"Sales Taxes: 1.50\n" +
							"Total: 29.83";
		assertEquals(expected , output);
	}

}
