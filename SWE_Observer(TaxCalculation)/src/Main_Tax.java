import model.TaxCalculation;
import view.View;

public class Main_Tax {

	public static void main(String args[])
	{
		View view=new View();
		TaxCalculation calculator = new TaxCalculation(12.5);
		calculator.setView(view);
		calculator.setIncome(3000);
		view.displayTaxAmount();
		view.displayTaxPercentage();
		calculator.setIncome(1000);
		view.displayTaxAmount();
		view.displayTaxPercentage();
		calculator.setTax(10);
		view.displayTaxAmount();
		view.displayTaxPercentage();
	}
}
