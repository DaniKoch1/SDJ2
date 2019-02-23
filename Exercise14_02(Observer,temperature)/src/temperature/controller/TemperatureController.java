package temperature.controller;

import java.util.Observable;

import temperature.domain.mediator.TemperatureModel;
import temperature.domain.model.Temperature;
import temperature.view.TemperatureView;

public class TemperatureController {
	private TemperatureModel model;
	private TemperatureView view;

	public TemperatureController(TemperatureModel model, TemperatureView view) {
		this.model = model;
		this.view = view;
		Observable obs = (Observable)model;
		obs.addObserver(view); 
	}

	public void execute(String what) {
		if (what.equalsIgnoreCase("update")) {
			Temperature t = model.getLastInsertedTemperature();
			view.show(t.toString());
		}
	}
}