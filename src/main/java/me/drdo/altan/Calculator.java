package me.drdo.altan;

import java.util.List;

public class Calculator {

	private static double ROUND_VALUE = 0.05;
	
	public void calculate(Receipt receipt) {
		double totalWithoutTaxes = 0;
		double taxes = 0;
		List<ReceiptItem> receiptEntries = receipt.getReceiptEntries();
		for (ReceiptItem item : receiptEntries){
			double percentage = TaxesPercentages.getPercentage(item);
			double priceWithoutTaxes = item.getQuantity() * item.getUnitPrice();
			totalWithoutTaxes += priceWithoutTaxes;
			double productTaxes = percentage * priceWithoutTaxes;
			double roundedProductTaxes = round(productTaxes);
			item.setUnitPrice(item.getUnitPrice()+roundedProductTaxes);
			taxes += roundedProductTaxes;
		}
		receipt.setSalesTaxes(taxes);
		receipt.setTotal(totalWithoutTaxes + taxes);		
	}

	private double round(double productTaxes) {
		double value = 1 / ROUND_VALUE;
		double rounded = Math.round(productTaxes * value) / value;
		return rounded;
	}

}
