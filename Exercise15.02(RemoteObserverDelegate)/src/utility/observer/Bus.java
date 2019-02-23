package utility.observer;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;

public class Bus implements RemoteSubject<String>{
	private String info;
	private RemoteSubjectDelegate<String> delegate;

	public Bus() {
		this.info = "eXpress " + hashCode() % 100;
		delegate=new RemoteSubjectDelegate<>(this);
	}

	public void passengerGettingIn(BusPassenger p) {
		delegate.notifyObservers("Enter:" + p.getName());
		
	}

	public void passengerGettingOut(BusPassenger p) {
		delegate.notifyObservers("Leave:" + p.getName());
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

	@Override
	public void addObserver(RemoteObserver<String> o) throws RemoteException {
		delegate.addObserver(o);
		
	}

	@Override
	public void deleteObserver(RemoteObserver<String> o) throws RemoteException {
		delegate.deleteObserver(o);
		
	}
}