package me.drdo.altan.calc;

import java.util.List;

import me.drdo.altan.beans.Money;
import me.drdo.altan.beans.Receipt;
import me.drdo.altan.beans.ReceiptItem;
import me.drdo.altan.rounding.RoundingStrategy;
import me.drdo.altan.tax.TaxRateCalculator;

public class TaxesCalculationStrategy implements CalculationStrategy {
	
	private RoundingStrategy roundingStrategy;
	private TaxRateCalculator taxCalculator;

	public void setRoundingStrategy(RoundingStrategy roundingStrategy) {
		this.roundingStrategy = roundingStrategy;
	}
	
	public void setTaxCalculator(TaxRateCalculator taxCalculator) {
		this.taxCalculator = taxCalculator;
	}
	
	public void calculate(Receipt receipt) {
		Money totalWithoutTaxes = new Money();
		Money taxes = new Money();
		List<ReceiptItem> receiptEntries = receipt.getReceiptEntries();
		for (ReceiptItem item : receiptEntries){
			double percentage = taxCalculator.getTaxRate(item);
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
