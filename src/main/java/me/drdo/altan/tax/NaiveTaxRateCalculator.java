package me.drdo.altan.tax;

import java.util.HashMap;
import java.util.Map;

import me.drdo.altan.beans.ReceiptItem;

/**
 * This is a very naive implementation, no database required.
 */
public class NaiveTaxRateCalculator implements TaxRateCalculator {
	
	public static double IMPORT_TAX = 0.05;
	public static double DEFAULT_TAX = 0.10;
	
	public static Map<String, Double> productTaxMap;
	
	static {
		productTaxMap = new HashMap<String, Double>();
		productTaxMap.put("book", 0d);
		productTaxMap.put("chocolate bar", 0d);
		productTaxMap.put("imported box of chocolates", 0d);
		productTaxMap.put("packet of headache pills", 0d);
		productTaxMap.put("box of imported chocolates", 0d);
	}
	

	public double getTaxRate(ReceiptItem item) {
		String product = item.getProduct();
		Double taxPercentage = productTaxMap.get(product);
		if (taxPercentage == null)
			taxPercentage = DEFAULT_TAX;
		
		if (product.contains("imported")){
			taxPercentage += IMPORT_TAX;
		}
		
		return taxPercentage;
	}

}
