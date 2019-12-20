package com.tax.model;

import java.util.List;
import java.util.stream.Stream;

import com.tax.service.impl.MathUtils;

public class RequestObject {

	private List<String> input;
	private String name;
	private int quantity;
	private double basePrice;
	private double basicSalesTaxAmount;
	private double additionalSalesTaxAmount;

	public RequestObject(String quantity, String name, String basePrice) {
		this.name = name;
		this.quantity = Integer.valueOf(quantity);
		this.basePrice = Double.valueOf(basePrice);
	}

	public double getFinalPrice() {
		return MathUtils.roundOffAmount(quantity * basePrice + getTaxAmount());
	}

	public double getTaxAmount() {
		return quantity * (basicSalesTaxAmount + additionalSalesTaxAmount);
	}

	public boolean isImported() {
		return name.contains("imported");
	}

	public boolean isExempted() {
		return Stream.of("book", "chocolate", "pill").anyMatch(exemptedItem -> name.contains(exemptedItem));
	}

	public void setBasicSalesTaxAmount(double factor) {
		basicSalesTaxAmount = basePrice * factor;
	}

	public void setAdditionalSalesTax(double additionalSalesTaxPercent) {
		additionalSalesTaxAmount = MathUtils.roundOffTax(basePrice * additionalSalesTaxPercent);
	}

	public String toString() {
		return String.valueOf(quantity) + " " + name + " : " + getFinalPrice();
	}


	public List<String> getInput() {
		return input;
	}

	public void setInput(List<String> input) {
		this.input = input;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getAdditionalSalesTaxAmount() {
		return additionalSalesTaxAmount;
	}

	public void setAdditionalSalesTaxAmount(double additionalSalesTaxAmount) {
		this.additionalSalesTaxAmount = additionalSalesTaxAmount;
	}

	public double getBasicSalesTaxAmount() {
		return basicSalesTaxAmount;
	}
	
	
}
