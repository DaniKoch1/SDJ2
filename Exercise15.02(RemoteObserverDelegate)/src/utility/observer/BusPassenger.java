package utility.observer;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

public class BusPassenger implements RemoteObserver<String>{
	private String name;
	private Bus bus;
	private boolean newPassenger;

	public BusPassenger(String name) {
		this.name = name;
		this.bus = null;
		this.newPassenger = false;
	}

	public String getName() {
		return name;
	}

	public boolean isNewPassenger() {
		return newPassenger;
	}

	public Bus getBus() {
		return bus;
	}

	public void getIn(Bus bus) throws RemoteException {
		if (this.bus != null)
			getOut();
		this.bus = bus;
		newPassenger = true;
		bus.passengerGettingIn(this);
		bus.addObserver(this);
	}

	public void getOut() throws RemoteException {
		newPassenger = false;
		bus.deleteObserver(this);
		bus.passengerGettingOut(this);
		
	}

	public String toString() {
		return name;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof BusPassenger))
			return false;
		BusPassenger p = (BusPassenger) obj;
		return name.equals(p.name) && ((bus == null & p.bus == null) || bus.equals(p.bus))
				&& newPassenger == p.newPassenger;
	}

	public void showMessage(String message) {
		String reply = "";
		String[] split = message.split(":");
		if (split.length != 2) {
			reply = "I don't understand";
		} else {
			if (split[0].equalsIgnoreCase("Enter"))
				reply = "Hello ";
			else
				reply = "Bye Bye ";
			reply += split[1];
		}
		System.out.println(name + "> " + reply);
	}

	@Override
	public void update(RemoteSubject<String> subject, String updateMsg) throws RemoteException {
		showMessage(updateMsg);
		
	}
}
