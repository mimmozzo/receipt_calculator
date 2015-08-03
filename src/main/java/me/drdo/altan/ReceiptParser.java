package me.drdo.altan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class ReceiptParser {

	public Receipt parse(String receiptInput) throws IOException {
		Receipt receipt = new Receipt();
		BufferedReader bufReader = new BufferedReader(new StringReader(receiptInput));
		String line=null;
		while( (line=bufReader.readLine()) != null ){
			ReceiptItem item = parseLine(line);
			receipt.add(item);
		}
		return receipt;
	}

	public ReceiptItem parseLine(String line) {
		String trimmedLine = line.trim();
		ReceiptItem item = new ReceiptItem();
		String[] tokens = trimmedLine.split(" ");
		int quantity = Integer.parseInt(tokens[0]);
		item.setQuantity(quantity);
		double unitPrice = Double.parseDouble(tokens[tokens.length-1]);
		item.setUnitPrice(unitPrice);
		String productName = StringUtils.join(Arrays.asList(tokens).subList(1, tokens.length-2), " ");
		item.setProduct(productName);
		return item;
	}

}
