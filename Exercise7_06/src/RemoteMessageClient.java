import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RemoteMessageClient extends UnicastRemoteObject implements ClientInterface{
	
	private static final long serialVersionUID = 2L;
	private RemoteMessageList list;
	
	public RemoteMessageClient() throws MalformedURLException, RemoteException, NotBoundException {
		list=(RemoteMessageList) Naming.lookup("rmi://localhost:1099/addMessage");
		Scanner in=new Scanner(System.in);
		String text="";
		System.out.println("What's your message?\nTo quit type 'quit'.");
		text=in.nextLine();
		while(!(text.toLowerCase().equals("quit")))
		{
			list.addMessage(new Message(text), this);
			System.out.println("What's your message?\nTo quit type 'quit'.");
			text=in.nextLine();
		}
		
		
	}
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		RemoteMessageClient client=new RemoteMessageClient();
		
		
	}
	@Override
	public void show(String message) {
		System.out.println(message);
		
	}
}
