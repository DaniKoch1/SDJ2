import java.rmi.*;

import utility.observer.RemoteSubject;

public interface RemoteTaskList extends RemoteSubject<String> {

	public void add(String task) throws RemoteException;
	public String remove() throws RemoteException;
	public int size() throws RemoteException;
}
