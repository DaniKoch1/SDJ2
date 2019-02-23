
public class LogLine {

	private DateTime time;
	private String text;
	
	public LogLine(String text)
	{
		this.text = text;
		time = new DateTime();
	}
	
	public String getLogText()
	{
		return text;
	}
	
	public DateTime getDateTime()
	{
		return time;
	}
	
	public String getTimeStamp()
	{
		return time.getTimestamp();
	}
	
	public String toString()
	{
		return text+"\n"+getTimeStamp()+"\n";
	}
}
