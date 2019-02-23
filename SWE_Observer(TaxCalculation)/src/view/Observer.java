package view;
import model.TaxCalculation;

public interface Observer {
	public void update(TaxCalculation tax);
}
