package me.drdo.altan.beans;


public class ReceiptItem {

	private int quantity;
	private String product;
	private Money unitPrice;
	private Money fullPrice;
	
	public int getQuantity() {
		return quantity;
	}

	public String getProduct() {
		return product;
	}

	public Money getUnitPrice() {
		return unitPrice;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setUnitPrice(Money unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Money getFullPrice() {
		return fullPrice;
	}
	
	public void setFullPrice(Money money) {
		this.fullPrice = money;
	}

}
