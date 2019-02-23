
public class Server {

	public static void main(String[] args) {
		TaskList taskList = new TaskList();
		TaskListServer taskListServer = new TaskListServer(taskList, 3000);
		taskListServer.execute();
	}
}
