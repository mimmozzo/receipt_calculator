package me.drdo.altan.rounding;

import me.drdo.altan.beans.Money;

public class PointFiveRoundingStrategy implements RoundingStrategy {

	public Money round(Money m) {
		long cents = m.getCents();
		
		long remainder = cents % 10;
		
		long toAdd = 0;
		if (remainder <= 2)
			toAdd = 0;
		else if (remainder > 2 && remainder <= 7)
			toAdd = 5;
		else
			toAdd = 10;
		
		long toReturn = (cents / 10)*10 + toAdd;
			
		return new Money(toReturn);
	}

}
