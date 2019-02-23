import java.util.HashMap;

public class CountryFactory {

	private static HashMap<String,Country> countries = new HashMap<>();
	
	public static Country getNationality(String countryCode, String country)
	{
		Country item = countries.get(countryCode);
		if (item==null || !(item.getCountry().equals(country)))
		{
			item = new Nationality(countryCode,country);
			countries.put(countryCode,item);
		}
		return item;
	}
	
	public static void updateCountry(String countryCode,String country)
	{
		Country item = countries.get(countryCode);
		if (item!=null)
		{
			countries.replace(countryCode, item, new Nationality(countryCode, country));
		}
	}
}
