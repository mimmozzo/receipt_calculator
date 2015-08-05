package me.drdo.altan;

import me.drdo.altan.beans.Receipt;
import me.drdo.altan.calc.CalculationStrategy;
import me.drdo.altan.calc.TaxesCalculationStrategy;
import me.drdo.altan.input.ReceiptParser;
import me.drdo.altan.rounding.PointFiveRoundingStrategy;
import me.drdo.altan.tax.NaiveTaxRateCalculator;

public class ReceiptCalculator {
	
	private ReceiptParser parser;
	private CalculationStrategy calculator;
	
	public ReceiptCalculator() {
		parser = new ReceiptParser();
		calculator = new TaxesCalculationStrategy();
		calculator.setRoundingStrategy(new PointFiveRoundingStrategy());
		calculator.setTaxCalculator(new NaiveTaxRateCalculator());
	}
	
	public String calculate(String receiptInput) {
		Receipt receipt;
		try {
			receipt = parser.parse(receiptInput);
			calculator.calculate(receipt);
			return receipt.toString();
		} catch (Exception e) {
			return "Error calculating: " + e.getMessage();
		}
	}

}
