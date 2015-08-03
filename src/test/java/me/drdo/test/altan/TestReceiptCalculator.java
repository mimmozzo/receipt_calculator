package me.drdo.test.altan;

import static org.junit.Assert.*;
import me.drdo.altan.ReceiptCalculator;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestReceiptCalculator {
	
	private static ReceiptCalculator calculator;
	
	@BeforeClass
	public static void init() {
		calculator = new ReceiptCalculator();
	}	

	@Test
	public void test1() {
	
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
