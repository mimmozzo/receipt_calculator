package me.drdo.altan.tax;

import me.drdo.altan.beans.ReceiptItem;

public interface TaxRateCalculator {
	
	double getTaxRate(ReceiptItem item);

}
