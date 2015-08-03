package me.drdo.altan;

import java.util.HashMap;
import java.util.Map;

public class TaxesPercentages {
	
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
	

	public static double getPercentage(ReceiptItem item) {
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
