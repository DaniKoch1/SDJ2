import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RemoteMessageClient extends UnicastRemoteObject implements Serializable, ReplyTo{
	
	private static final long serialVersionUID = 1L;
	private RemoteMessageList list;
	
	public RemoteMessageClient(String msg) throws Exception{
		super();
		list=(RemoteMessageList) Naming.lookup("rmi://localhost:1099/addMessage");
		list.addMessage(msg, this);
	}
	public void replyMessage(String msg)
	{
		System.out.println("Reply: "+msg);
	}
	public static void main(String[] args) throws Exception {
		Scanner in=new Scanner(System.in);
		String text=in.nextLine();
		while(!(text.equals("quit")))
		{
			RemoteMessageClient client=new RemoteMessageClient(text);
			text=in.nextLine();
		}
	}
}
