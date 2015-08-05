package me.drdo.altan;

public class ReceiptCalculator {
	
	private ReceiptParser parser;
	private CalculationStrategy calculator;
	
	public ReceiptCalculator() {
		parser = new ReceiptParser();
		calculator = new TaxesCalculationStrategy();
		calculator.setRoundingStrategy(new PointFiveRoundingStrategy());
	}
	
	public String calculate(String receiptInput) {
		
		Receipt receipt;
		try {
			receipt = parser.parse(receiptInput);
			calculator.calculate(receipt);
			return receipt.toString();
		} catch (Exception e) {
			return "";
		}
	}

}
