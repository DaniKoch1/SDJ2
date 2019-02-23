
public class School extends Education{
	private String type;
	
	public School(String code, String title, String type)
	{
		super(code, title);
		this.type=type;
	}

	public String getType() {
		return type;
	}
	public String toString()
	{
		return super.toString()+"; type: "+type;
	}

}
