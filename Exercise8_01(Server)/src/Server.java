import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		RMITaskServer server = new RMITaskServer();
	}

}
