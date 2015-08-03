package me.drdo.altan;

public class ReceiptCalculator {
	
	private ReceiptParser parser;
	private Calculator calculator;
	
	public ReceiptCalculator() {
		parser = new ReceiptParser();
		calculator = new Calculator();
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
