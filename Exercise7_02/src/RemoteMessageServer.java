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
		super();
		list=new ArrayList<>();
	}
	public void addMessage(String msg, ReplyTo who) throws RemoteException
	{
		System.out.println("Adding "+msg+" to the list.");
		list.add(msg);
		who.replyMessage("Thank you");
	}
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Registry reg= LocateRegistry.createRegistry(1099);
		RemoteMessageList rmiServer=new RemoteMessageServer();
		Naming.rebind("addMessage", rmiServer);
		System.out.println("Starting server...");
	}
}
