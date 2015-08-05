package me.drdo.altan;

public interface CalculationStrategy {

	void calculate(Receipt receipt);
	
	void setRoundingStrategy(RoundingStrategy roundingStrategy);
}
