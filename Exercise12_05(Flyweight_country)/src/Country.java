
public abstract class Country {
	private String countryCode;
	private String country;
	
	public Country(String code, String country)
	{
		countryCode=code;
		this.country=country;
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
		return country+", "+countryCode;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Country))
			return false;
		Country other=(Country) obj;
		if(other.country.equals(country) && other.countryCode.equals(countryCode))
			return true;
		else
			return false;
	}
}
