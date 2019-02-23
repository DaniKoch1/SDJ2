import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote{
	public void addMessage(Message msg, ClientInterface who) throws RemoteException;
}
