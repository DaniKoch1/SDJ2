package tasklist.domain.mediator;

import tasklist.domain.model.Task;

public class ClientTaskListModelManager implements TaskListModel {
	private TaskListClient list;
	
	public ClientTaskListModelManager()
	{
		list=new TaskListClient("localhost",3000);
	}
	public void add(Task task)
	{
		list.add(task);
	}
	public Task get()
	{
		return list.get();
	}
	public int size()
	{
		return list.size();
	}
}
