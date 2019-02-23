package tasklist.domain.mediator;

import java.rmi.RemoteException;

import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;

public class TaskListModelManager implements TaskListModel {
	private TaskList list;
	
	public TaskListModelManager()
	{
		list=new TaskList();
		try {
			RemoteTaskList server = new TaskListServer(this, 1099);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
