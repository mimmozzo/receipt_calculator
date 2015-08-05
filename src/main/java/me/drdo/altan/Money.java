package me.drdo.altan;

import java.util.Locale;

public class Money {
		
	private long cents;

	public Money() {
		cents = 0;
	}
	
	public Money(long cents) {
		this.cents = cents;		
	}
	
	public Money(String decimalString) throws NumberFormatException{
		String stripped = decimalString.replace(".", "");
		cents = Long.parseLong(stripped);
	}
	
	public Money(Money m){
		this.cents = m.cents;
	}
	
	public Money multiply(int quantity) {
		return new Money(cents * quantity);
	}

	public Money multiply(double percentage) {
		return new Money(Math.round(cents * percentage)); 
	}

	public Money add(Money m) {
		return new Money(cents + m.cents);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Money)){
			return false;
		}
		return cents == ((Money) obj).cents;
	}
	
	@Override
	public String toString() {
		double realValue = cents / 100.0;
		return String.format(Locale.ENGLISH, "%.2f", realValue );
	}

	public long getCents() {
		return cents;
	}
}
