
public abstract class Education {

	private String code;
	private String title;
	
	public Education(String code, String title) {
		this.code = code;
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}
	
	public String toString ()
	{
		return "Code: "+code+"\nTitle: "+title;
	}
	
}
