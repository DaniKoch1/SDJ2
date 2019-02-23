import java.util.ArrayList;

public class Sale {
	private ArrayList<SalesLineItem> items;
	
	public Sale()
	{
		items=new ArrayList<>();
		items.add(new SalesLineItem());
	}
	public void addItem()
	{
		items.add(new SalesLineItem());
	}
}
