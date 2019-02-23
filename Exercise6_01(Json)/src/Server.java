import java.io.IOException;

public class Server {
	public static void main(String[] args) throws IOException {
		ChatServer chat=new ChatServer(2018);
		chat.execute();
	}
}
