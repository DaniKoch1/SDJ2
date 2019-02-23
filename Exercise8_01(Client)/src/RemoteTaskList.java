import java.rmi.Remote;
import java.rmi.RemoteException;

import javafx.concurrent.Task;

public interface RemoteTaskList extends Remote {
	public void add(Task task) throws RemoteException;
	public Task remove() throws RemoteException;
	public int size() throws RemoteException;
}
