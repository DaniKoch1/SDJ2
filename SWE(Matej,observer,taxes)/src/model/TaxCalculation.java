package model;
import java.util.ArrayList;
import view.Console;

public class TaxCalculation {

	private ArrayList<Double> incomes;
	private double taxPercentage;
	private Console console;

	public TaxCalculation(double taxPercentage, Console console) {
		incomes = new ArrayList<>();
		this.taxPercentage = taxPercentage;
		this.console = console;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
		console.update(getTaxPercentage(), getTaxes());
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void addIncome(double income) {
		incomes.add(income);
		console.update(getTaxPercentage(), getTaxes());
	}

	public ArrayList<Double> getTaxes() {
		ArrayList<Double> taxes = new ArrayList<>();
		for (Double e : incomes) {
			taxes.add(e * (taxPercentage / 100));
		}
		return taxes;
	}
}




