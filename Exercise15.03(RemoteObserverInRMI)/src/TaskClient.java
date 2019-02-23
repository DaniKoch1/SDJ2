import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

public class TaskClient implements Serializable, RemoteObserver<String>{

	private RemoteTaskList list;
	
	public TaskClient () throws RemoteException, MalformedURLException, NotBoundException
	{
		super();
		list=(RemoteTaskList) Naming.lookup("rmi://localhost:1099/server");
		list.add("Hey");
		list.size();
		list.add("ahoj");
	}
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		new TaskClient();
	}
	@Override
	public void update(RemoteSubject<String> subject, String updateMsg) throws RemoteException {
		System.out.println(updateMsg);
		
	}
}
