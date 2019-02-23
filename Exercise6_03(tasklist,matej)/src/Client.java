
public class Client {

	public static void main(String[] args) {
		TaskListClient taskListClient = new TaskListClient("localhost", 3000);
		taskListClient.execute();
		taskListClient.close();
	}
}
