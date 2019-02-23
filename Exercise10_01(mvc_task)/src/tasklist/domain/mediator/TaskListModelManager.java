package tasklist.domain.mediator;

import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;

public class TaskListModelManager implements TaskListModel {
	private TaskList list;
	
	public TaskListModelManager()
	{
		list=new TaskList();
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
