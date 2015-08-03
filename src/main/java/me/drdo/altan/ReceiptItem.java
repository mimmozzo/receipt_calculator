package me.drdo.altan;

public class ReceiptItem {

	private int quantity;
	private String product;
	private double unitPrice;
	
	public int getQuantity() {
		return quantity;
	}

	public String getProduct() {
		return product;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	

}
