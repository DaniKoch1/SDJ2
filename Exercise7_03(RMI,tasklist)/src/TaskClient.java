import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TaskClient implements Serializable{

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
		TaskClient client=new TaskClient();
	}
}
