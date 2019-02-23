import java.util.ArrayList;

public class Sale {
	private ArrayList<SalesLineItem> lineItems;
	
	public Sale(SalesLineItem item)
	{
		lineItems=new ArrayList<>();
		lineItems.add(item);
	}
	public void updatePriceFor(ProductDescription description)
	{
		//update
	}
}
