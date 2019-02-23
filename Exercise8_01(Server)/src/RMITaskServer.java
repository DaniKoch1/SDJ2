import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMITaskServer extends UnicastRemoteObject implements RemoteTaskList, Serializable {

	private static final long serialVersionUID = 1L;
	private TaskList list;
	
	public RMITaskServer () throws RemoteException, MalformedURLException 
	{
		super();
		list = new TaskList();
		startRegistry();
		startServer();
	}
	
	private void startRegistry() throws RemoteException {
		Registry reg = LocateRegistry.createRegistry(1099);			
	}
	
	private void startServer() throws RemoteException, MalformedURLException {
		Naming.rebind("server", this);
		System.out.println("Server is up");
	}

	@Override
	public void add(Task task) throws RemoteException {
		list.add(task);
	}

	@Override
	public Task remove() throws RemoteException {
		return list.getAndRemoveNextTask();
	}

	@Override
	public int size() throws RemoteException {
		return list.size();
	}
}
