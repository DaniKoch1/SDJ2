import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;

public class Bus extends Observable{
	private String info;

	public Bus() {
		this.info = "eXpress " + hashCode() % 100;
	}

	public void passengerGettingIn(BusPassenger p) {
		setChanged();
		notifyObservers("Enter:" + p.getName());
		
	}

	public void passengerGettingOut(BusPassenger p) {
		setChanged();
		notifyObservers("Leave:" + p.getName());
	}

	public String getInfo() {
		return info;
	}
	public String toString()
	 {
	 return getInfo();
	 }

	public boolean equals(Object obj) {
		if (!(obj instanceof Bus))
			return false;
		Bus b = (Bus) obj;
		return info.equals(b.info);
	}
}