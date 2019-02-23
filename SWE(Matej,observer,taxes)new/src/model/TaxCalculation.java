package model;
import java.util.ArrayList;
import java.util.Observable;

public class TaxCalculation extends Observable {

	private ArrayList<Double> incomes;
	private double taxPercentage;

	public TaxCalculation(double taxPercentage) {
		incomes = new ArrayList<>();
		this.taxPercentage = taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
		setChanged();
		notifyObservers(getTaxes());
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void addIncome(double income) {
		incomes.add(income);
		setChanged();
		notifyObservers(getTaxes());
	}

	public ArrayList<Double> getTaxes() {
		ArrayList<Double> taxes = new ArrayList<>();
		for (Double e : incomes) {
			taxes.add(e * (taxPercentage / 100));
		}
		return taxes;
	}
}
