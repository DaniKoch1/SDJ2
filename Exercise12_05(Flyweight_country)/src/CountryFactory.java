import java.util.HashMap;

public class CountryFactory {
	private static HashMap <String, Country> countries=new HashMap<String, Country>();
	
	public static Country getNationality(String code, String country)
	{
		Country item=countries.get(code);
		if(item==null)
		{
			item=new Nationality(code, country);
			countries.put(code, item);
		}
		return item;
	}
	public static void updateCountry(String countryCode, String country)
	{
		Country item=countries.get(countryCode);
		if(item==null)
		{
			item=new Nationality(countryCode, country);
			countries.put(countryCode, item);
		}
		else
		{
			item.setCountry(country);
			countries.put(countryCode, item);
		}
	}
	
}
