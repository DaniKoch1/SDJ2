import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.sound.sampled.DataLine;

import utility.observer.AbstractRemoteSubject;
import utility.observer.RemoteObserver;

public class TaskServer extends AbstractRemoteSubject<String> implements RemoteTaskList{

	private TaskList tasks;
	
	public TaskServer() throws RemoteException
	{
		tasks = new TaskList();
	}
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Registry reg= LocateRegistry.createRegistry(1099);
		RemoteTaskList rmiServer=new TaskServer();
		UnicastRemoteObject.exportObject(rmiServer, 0);
		Naming.rebind("server", rmiServer);
		System.out.println("Starting server...");
	}

	@Override
	public void add(String task) throws RemoteException {
		tasks.addTask(task);
		notifyObservers(task);
		System.out.println(task+" added");
	}

	@Override
	public String remove() throws RemoteException {
		String sth=tasks.getAndRemoveNextTask();
		System.out.println(sth);
		notifyObservers(sth);
		return sth;
	}

	@Override
	public int size() throws RemoteException {
		return tasks.size();
	}
}
