import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		RMITaskClient client = new RMITaskClient();
	}

}
