import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TaskServer extends UnicastRemoteObject implements RemoteTaskList{

	private TaskList tasks;
	
	public TaskServer() throws RemoteException
	{
		tasks = new TaskList();
	}
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Registry reg= LocateRegistry.createRegistry(1099);
		RemoteTaskList rmiServer=new TaskServer();
		Naming.rebind("server", rmiServer);
		System.out.println("Starting server...");
	}

	@Override
	public void add(String task) throws RemoteException {
		tasks.addTask(task);
		System.out.println(task+" added");
	}

	@Override
	public void remove() throws RemoteException {
		System.out.println(tasks.getAndRemoveNextTask());
		tasks.getAndRemoveNextTask();
	}

	@Override
	public int size() throws RemoteException {
		return tasks.size();
	}
}
