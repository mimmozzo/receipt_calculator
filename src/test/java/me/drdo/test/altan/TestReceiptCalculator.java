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
		String expected =   "1 book: 12.49\n" +
							"1 music CD: 16.49\n" +
							"1 chocolate bar: 0.85\n" +
							"Sales Taxes: 1.50\n" +
							"Total: 29.83";
		assertEquals(expected , output);
	}
	

	public void testSecondReceipt() {
	  
	    String input = 
	      "1 imported box of chocolates at 10.00\n" +
	      "1 imported bottle of perfume at 47.50";

	    String output = calculator.calculate(input);
	    String expected =   
	      "1 imported box of chocolates: 10.50\n" +
	      "1 imported bottle of perfume: 54.65\n" +
	      "Sales Taxes: 7.65\n" +
	      "Total: 65.15";
	    assertEquals(expected , output);
	}

	public void testThirdReceipt() {
	  
	    String input = 
	      "1 imported bottle of perfume at 27.99\n" +
	      "1 bottle of perfume at 18.99\n" +
	      "1 packet of headache pills at 9.75\n" +
	      "1 box of imported chocolates at 11.25";
	  
	    String output = calculator.calculate(input);
	    String expected =   
	      "1 imported bottle of perfume: 32.19\n" +
	      "1 bottle of perfume: 20.89\n" +
	      "1 packet of headache pills: 9.75\n" +
	      // 11.85 is wrong: according to the specifications 11.25 leads to a 0.56 tax, rounded to 0.55, not to 0.60
	      // "1 imported box of chocolates: 11.85\n" +
	      "1 box of imported chocolates: 11.80\n" +
	      "Sales Taxes: 6.65\n" +
	      "Total: 74.63";
	    assertEquals(expected , output);
	}

}
