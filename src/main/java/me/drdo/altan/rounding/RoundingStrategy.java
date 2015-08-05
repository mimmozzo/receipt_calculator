package me.drdo.altan.rounding;

import me.drdo.altan.beans.Money;

public interface RoundingStrategy {
	
	Money round(Money m);

}
