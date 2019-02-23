
public class ShowTimeUpdater implements Runnable {
	
	private TemperatureView view;
	private String time;

	public ShowTimeUpdater(TemperatureView view, String clock) {
		this.view = view;
		time = clock;
	}
	
	public void run() 
	{
		view.showTime(time);
	}
}
