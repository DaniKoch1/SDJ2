package view;

import java.util.ArrayList;

public class Console {

	public void update(double taxPercentage, ArrayList<Double> taxes) {
		System.out.println("Updating...");
		String message = "Tax percentage:"+taxPercentage;
		for (Double e:taxes)
		{
			message += "\nTax: "+e;
		}
		System.out.println(message);
	}

}



