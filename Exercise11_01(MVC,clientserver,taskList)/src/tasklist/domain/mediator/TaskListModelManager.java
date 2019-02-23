package tasklist.domain.mediator;

import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;

public class TaskListModelManager implements TaskListModel {
	private TaskList list;
	private TaskListServer server;
	
	public TaskListModelManager()
	{
		list=new TaskList();
		server = new TaskListServer(this, 3000);
		Thread thread = new Thread(server);
		thread.start();
	}
	public synchronized void add(Task task)
	{
		list.add(task);
	}
	public synchronized Task get()
	{
		return list.getAndRemoveNextTask();
	}
	public synchronized int size()
	{
		return list.size();
	}
}
