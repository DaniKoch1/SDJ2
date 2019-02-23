import model.TaxCalculation;
import view.View;

public class Main {

	public static void main(String[] args) {

		TaxCalculation calculator = new TaxCalculation(30);
		View console = new View(calculator);
		double income1 = 4000;
		double income2 = 10000;
		double income3 = 8500;
		calculator.addIncome(income1);
		calculator.addIncome(income2);
		calculator.addIncome(income3);
		calculator.setTaxPercentage(50);
	}
}



