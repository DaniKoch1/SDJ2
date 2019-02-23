import java.util.ArrayList;

public class Bank implements Subject{
	private double exchangeRate;
	private ArrayList<Observer> observers;	
	
	public Bank(double exchangeRate) {
		this.exchangeRate = exchangeRate;
		observers=new ArrayList<Observer>();
	}
	public double getRate()
	{
		return exchangeRate;
	}
	public void setRate(double rate)
	{
		exchangeRate=rate;
		notifyObservers();
	}
	public void attach(Observer obs) {
		observers.add(obs);
		obs.update(exchangeRate);
	}
	public void detach(Observer obs) {
		for(Observer o:observers)
			if(o.equals(obs))
				observers.remove(o);
	}
	public void notifyObservers() {
		for(Observer o:observers)
			o.update(exchangeRate);
	}
	public String toString()
	{
		String print= "Exchange rate: "+exchangeRate+"\nStocks:\n";
		for(Observer o:observers)
			print+=o.toString()+"\n";
		return print;
	}
}
