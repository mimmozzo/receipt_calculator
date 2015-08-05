package me.drdo.altan.calc;

import me.drdo.altan.beans.Receipt;
import me.drdo.altan.rounding.RoundingStrategy;
import me.drdo.altan.tax.TaxRateCalculator;

public interface CalculationStrategy {

	void calculate(Receipt receipt);
	
	void setRoundingStrategy(RoundingStrategy roundingStrategy);
	
	void setTaxCalculator(TaxRateCalculator taxCalculator);
}
