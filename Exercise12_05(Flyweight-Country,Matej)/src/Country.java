
public abstract class Country {
	
	private String countryCode;
	private String country;
	public Country(String countryCode, String country) {
		this.countryCode = countryCode;
		this.country = country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString()
	{
		return "Country code :"+countryCode+"\nCountry: "+country;
	}
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Country))
		{
			return false;
		}
		Country other = (Country) obj;
		return other.getCountry().equals(country) && other.getCountryCode().equals(countryCode);
	}
}
