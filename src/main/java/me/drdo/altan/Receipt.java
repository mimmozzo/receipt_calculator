package me.drdo.altan;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	
	private double total;
	private double salesTaxes;
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
			builder.append(" :");
			builder.append(item.getUnitPrice());
			builder.append("\n");
		}
		
		builder.append("Sales Taxes: " + getSalesTaxes());
		builder.append("\nTotal: " + getTotal());
		
		return builder.toString();
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(double salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	public List<ReceiptItem> getReceiptEntries() {
		return receiptEntries;
	}

	public void setReceiptEntries(List<ReceiptItem> receiptEntries) {
		this.receiptEntries = receiptEntries;
	}	

}
