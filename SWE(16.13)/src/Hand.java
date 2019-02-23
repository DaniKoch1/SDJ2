import java.util.ArrayList;

public class Hand {
	private ArrayList<Finger> fingers;
	
	public Hand()
	{
		fingers=new ArrayList<>();
	}
	public boolean isFull()
	{
		if(fingers.size()==7)
			return true;
		else
			return false;
	}
	public void addFinger()
	{
		fingers.add(new Finger());
	}
}
