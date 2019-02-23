
public class Stock implements Observer{

	private double rate;
	private String name;
	
	public Stock(String name)
	{
		this.name=name;
	}
	public void update(double rate) {
		this.rate=rate;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Stock))
			return false;
		Stock other=(Stock) obj;
		if(name.equals(other.name)&&rate==other.rate)
			return true;
		else
			return false;
	}
	public String toString()
	{
		return name+"; rate: "+rate;
	}
	 
}
