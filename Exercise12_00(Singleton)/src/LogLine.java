
public class LogLine {
	private String text;
	private DateTime time;
	
	public LogLine(String text)
	{
		this.text=text;
		time=new DateTime();
	}
	public String getLogText()
	{
		return text;
	}
	public DateTime getDateTime()
	{
		return time;
	}
	public String getTimestamp()
	{
		//Code by Miœka :D
		return time.getTimestamp();
	}
	public String toString()
	{
		return text+"\n"+getTimestamp()+"\n";
	}
}
