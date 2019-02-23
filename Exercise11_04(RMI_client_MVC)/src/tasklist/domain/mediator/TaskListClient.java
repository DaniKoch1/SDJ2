package tasklist.domain.mediator;
import java.io.*;
import java.net.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;


import tasklist.domain.model.Task;

public class TaskListClient implements TaskListModel {

	private RemoteTaskList list;
	
	public TaskListClient (String host, int port)
	{
		try {
			list=(RemoteTaskList) Naming.lookup("rmi://localhost:1099/server");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connected to server: "+host+" at port "+port);
	}

	@Override
	public void add(Task task) {
		try {
			list.add(task);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Task get() {
		try {
			return list.get();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int size() {
		try {
			return list.size();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
