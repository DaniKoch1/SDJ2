import java.util.ArrayList;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageServer extends UnicastRemoteObject implements RemoteMessageList {

	private static final long serialVersionUID = 1L;
	private ArrayList<Message> list;


	public RemoteMessageServer() throws RemoteException, MalformedURLException, NotBoundException {
		super();
		list = new ArrayList<>();
	}

	public void addMessage(Message msg, ClientInterface who) throws RemoteException {
		System.out.println("Adding " + msg + " to the list.");
		list.add(msg);
		who.show("Message " + msg.getBody() + " has been added.");
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		Registry reg = LocateRegistry.createRegistry(1099);
		RemoteMessageList rmiServer = new RemoteMessageServer();
		Naming.rebind("addMessage", rmiServer);
		System.out.println("Starting server...");
	}
}
