package tasklist.domain.mediator;
import java.io.IOException;
import java.net.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;

public class TaskListServer extends UnicastRemoteObject implements RemoteTaskList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TaskListModel taskList;
	
	public TaskListServer (TaskListModel taskList, int port) throws RemoteException
	{
		super();
		try {
			Registry reg=LocateRegistry.createRegistry(port);
			Naming.rebind("server", this);
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Starting server...");
		this.taskList=taskList;
	}

	@Override
	public void add(Task task) throws RemoteException {
		taskList.add(task);
		
	}

	@Override
	public Task get() throws RemoteException {
		return taskList.get();
	}

	@Override
	public int size() throws RemoteException {
		return taskList.size();
	}
	
	
}
