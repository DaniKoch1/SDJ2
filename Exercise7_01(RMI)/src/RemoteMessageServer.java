import java.util.ArrayList;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageServer extends UnicastRemoteObject implements RemoteMessageList {
	
	private ArrayList<String> list;
	
	public RemoteMessageServer () throws RemoteException
	{
		list=new ArrayList<>();
	}
	@Override
	public void addMessage(String msg) throws RemoteException {
		System.out.println("Adding "+msg+" to the list.");
		list.add(msg);
	}
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Registry reg= LocateRegistry.createRegistry(1099);
		RemoteMessageList rmiServer=new RemoteMessageServer();
		Naming.rebind("server", rmiServer);
		System.out.println("Starting server...");
	}
}
