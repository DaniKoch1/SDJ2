import java.util.Calendar;

public class Person {
	private String name;
	private AbstractStarSign starSign;

	public Person(String name, StarSign starSignName) {
		this.name = name;
		starSign = StarSignFactory.getStarSign(starSignName.getName());
	}

	public String getName() {
		return name;
	}

	public AbstractStarSign getStarSign() {
		return starSign;
	}

	public String toString() {
		return name + ", " + starSign;
	}
	
	public void setStarSign (Calendar birthday, String location)
	{
		starSign = new StarSignWithInterpretation(name, birthday, location);
	}
	
}