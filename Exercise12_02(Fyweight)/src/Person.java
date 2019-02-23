
public class Person {
	private String name;
	private AbstractStarSign starSign;
	
	public Person(String name, String starSignName)
	{
		this.name=name;
		starSign=StarSignFactory.getStarSign(starSignName);
	}
	public String getName()
	{
		return name;
	}
	public AbstractStarSign getStarSign()
	{
		return starSign;
	}
	public String toString()
	{
		return name+" star sign: "+starSign;
	}
//	public void setStarSign(Calendar birthday, String location)
//	{
//		starSign
//	}
}
