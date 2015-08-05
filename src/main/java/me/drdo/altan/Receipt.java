package me.drdo.altan;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	
	private Money total;
	private Money salesTaxes;
	private List<ReceiptItem> receiptEntries;
	
	public Receipt() {
		receiptEntries = new ArrayList<ReceiptItem>();
	}
	
	public void add(ReceiptItem item){
		receiptEntries.add(item);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(ReceiptItem item: receiptEntries){
			builder.append(item.getQuantity());
			builder.append(" ");
			builder.append(item.getProduct());
			builder.append(": ");
			builder.append(item.getFullPrice());
			builder.append("\n");
		}
		
		builder.append("Sales Taxes: " + getSalesTaxes());
		builder.append("\nTotal: " + getTotal());
		
		return builder.toString();
	}

	public Money getTotal() {
		return total;
	}

	public void setTotal(Money money) {
		this.total = money;
	}

	public Money getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(Money taxes) {
		this.salesTaxes = taxes;
	}

	public List<ReceiptItem> getReceiptEntries() {
		return receiptEntries;
	}

	public void setReceiptEntries(List<ReceiptItem> receiptEntries) {
		this.receiptEntries = receiptEntries;
	}	

}
