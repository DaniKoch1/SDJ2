import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock {
	private int hour;
	private int minute;
	private int second;
	
	public Clock()
	{
		Calendar cal = GregorianCalendar.getInstance();
		hour = cal.get(GregorianCalendar.HOUR);
		minute = cal.get(GregorianCalendar.MINUTE);
		second = cal.get(GregorianCalendar.SECOND);
	}
	public void set(int hour, int minute, int second)
	{
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
	public String toString()
	{
		String time=hour+":";
		if(minute<10)
			time+="0"+minute+":";
		else
			time+=minute+":";
		if(second<10)
			time+="0"+second;
		else
			time+=second;
		return time;
	}
}
