package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.TaxCalculation;

public class View implements Observer {

	private TaxCalculation calculator;
	
	public View (TaxCalculation calculator)
	{
		this.calculator = calculator;
		calculator.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Updating...");
		String message = "Tax percentage:"+calculator.getTaxPercentage();
		ArrayList<Double> taxes = (ArrayList<Double>) arg;
		for (int i = 0; i<taxes.size();i++)
		{
			message += "\nTax of income"+(i+1)+": "+taxes.get(i);
		}
		System.out.println(message);
		System.out.println("-----------------------");
	}

}
