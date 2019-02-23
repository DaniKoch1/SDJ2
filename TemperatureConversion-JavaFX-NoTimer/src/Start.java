import javafx.application.Application;

public class Start implements Runnable {
	
	private TemperatureView view;
	
	

	public Start(TemperatureView view) {
		this.view = view;
	}



	public void run()
	{
		Application.launch(view.getClass());
	}
}
