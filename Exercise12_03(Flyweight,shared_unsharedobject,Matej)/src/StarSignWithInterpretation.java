import java.util.Calendar;

public class StarSignWithInterpretation extends AbstractStarSign {

	private String location;
	private Calendar birthday;
	
	public StarSignWithInterpretation (String name, Calendar bday, String location)
	{
		super(name);
		this.location = location;
		this.birthday = bday;
	}
	
	public String getInterpretation()
	{
		return location+" "+birthday;
	}
	
	public String toString()
	{
		return super.toString()+getInterpretation();
	}
}
