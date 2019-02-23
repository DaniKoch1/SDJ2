import java.io.IOException;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient chat=new ChatClient("localhost", 2018);
		chat.execute();
	}
}
