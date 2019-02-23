package view;

import model.TaxCalculation;

public class View implements Observer {
	private double taxPercentage;
	private double taxAmount;
	
	public View(){
		taxPercentage = 0;
		taxAmount = 0;
	}
	public void displayTaxPercentage(){
		System.out.println("Tax percentage: " + taxPercentage);
	}
	public void displayTaxAmount(){
		System.out.println("Amount of tax: " + taxAmount);
	}
	public void update(TaxCalculation tax) {
		taxPercentage = tax.getTax();
		taxAmount = tax.getIncome() * taxPercentage /100;
	}
}
