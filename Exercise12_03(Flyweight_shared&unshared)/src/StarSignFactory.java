import java.util.Calendar;
import java.util.HashMap;

public class StarSignFactory {
	private static HashMap <String, StarSign> signs=new HashMap<String, StarSign>();
	
	public static AbstractStarSign getStarSign(String name)
	{
		name = Character.toUpperCase(name.charAt(0))
						+ name.substring(1).toLowerCase();
		StarSign item=signs.get(name);
		
		if(item==null)
		{
			item= new StarSign(name);
			signs.put(name, item);
		}
		return item;
	}
	public static AbstractStarSign getStarSign(String name, Calendar birthday, String location)
	{
		
	}
}
