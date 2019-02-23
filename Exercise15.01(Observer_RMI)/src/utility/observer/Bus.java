package utility.observer;



public class Bus extends AbstractRemoteSubject<String> implements RemoteSubject<String>{
	private String info;

	public Bus() {
		this.info = "eXpress " + hashCode() % 100;
	}

	public void passengerGettingIn(BusPassenger p) {
		notifyObservers("Enter:" + p.getName());
		
	}

	public void passengerGettingOut(BusPassenger p) {
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