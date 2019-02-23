package model;
import view.Observer;
public class TaxCalculation implements Subject {
	private double tax;
	private double income;
	private Observer view;
	
	public TaxCalculation(double tax){
		this.tax=tax;
		income = 0 ;
		view = null;
	}
	public void setView(Observer obs) {
		view=obs;
	}
	public double getTax(){
		return tax;
	}
	public double getIncome(){
		return income;
	}
	public void setTax(double percent){
		tax = percent;
		notifyObserver();
	}
	public void setIncome(double amount){
		income = amount;
		notifyObserver();
	}
	public void notifyObserver(){
		view.update(this);
	}
}
