package me.drdo.test.altan;

import me.drdo.altan.beans.Money;
import me.drdo.altan.rounding.PointFiveRoundingStrategy;
import me.drdo.altan.rounding.RoundingStrategy;
import junit.framework.TestCase;

public class TestPointFiveRoundingStrategy extends TestCase {

	private RoundingStrategy strategy;

	@Override
	protected void setUp() throws Exception {
		strategy = new PointFiveRoundingStrategy();
	}
	
	public void test1() {
		Money m = new Money("10.00");
		Money rounded = strategy.round(m);
		assertEquals("10.00", rounded.toString());
	}
	public void test2() {
		Money m = new Money("10.01");
		Money rounded = strategy.round(m);
		assertEquals("10.00", rounded.toString());
	}
	public void test3() {
		Money m = new Money("10.02");
		Money rounded = strategy.round(m);
		assertEquals("10.00", rounded.toString());
	}
	
	public void test4() {
		Money m = new Money("10.03");
		Money rounded = strategy.round(m);
		assertEquals("10.05", rounded.toString());
	}
	
	public void test5() {
		Money m = new Money("10.04");
		Money rounded = strategy.round(m);
		assertEquals("10.05", rounded.toString());
	}
	
	public void test6() {
		Money m = new Money("10.05");
		Money rounded = strategy.round(m);
		assertEquals("10.05", rounded.toString());
	}
	
	public void test7() {
		Money m = new Money("10.06");
		Money rounded = strategy.round(m);
		assertEquals("10.05", rounded.toString());
	}
	
	public void test8() {
		Money m = new Money("10.07");
		Money rounded = strategy.round(m);
		assertEquals("10.05", rounded.toString());
	}
	
	public void test9() {
		Money m = new Money("10.08");
		Money rounded = strategy.round(m);
		assertEquals("10.10", rounded.toString());
	}
	
	public void test10() {
		Money m = new Money("10.09");
		Money rounded = strategy.round(m);
		assertEquals("10.10", rounded.toString());
	}
	
	public void test11() {
		Money m = new Money("10.10");
		Money rounded = strategy.round(m);
		assertEquals("10.10", rounded.toString());
	}
	
}
