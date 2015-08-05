package me.drdo.altan;

import java.util.List;

public class TaxesCalculationStrategy implements CalculationStrategy {
	
	private RoundingStrategy roundingStrategy;

	public void setRoundingStrategy(RoundingStrategy roundingStrategy) {
		this.roundingStrategy = roundingStrategy;
	}
	
	public void calculate(Receipt receipt) {
		Money totalWithoutTaxes = new Money();
		Money taxes = new Money();
		List<ReceiptItem> receiptEntries = receipt.getReceiptEntries();
		for (ReceiptItem item : receiptEntries){
			double percentage = TaxesPercentages.getPercentage(item);
			Money priceWithoutTaxes = item.getUnitPrice().multiply(item.getQuantity());
			Money productTaxes = priceWithoutTaxes.multiply(percentage);
			Money roundedProductTaxes = roundingStrategy.round(productTaxes);
			item.setFullPrice(item.getUnitPrice().add(roundedProductTaxes));
			totalWithoutTaxes = totalWithoutTaxes.add(priceWithoutTaxes);
			taxes = taxes.add(roundedProductTaxes);
		}
		receipt.setSalesTaxes(taxes);
		receipt.setTotal(totalWithoutTaxes.add(taxes));		
	}

}
