import java.util.ArrayList;

public class TaskList {

	private ArrayList<String> tasks;
	
	public TaskList()
	{
		tasks = new ArrayList<>();
	}
	
	public synchronized void addTask(String task)
	{
		tasks.add(task);
	}
	public synchronized int size()
	{
		return tasks.size();
	}
	public synchronized String getAndRemoveNextTask ()
	{
		String first;
		if(size()>0)
		{
			first = tasks.get(0);
			tasks.remove(0);
		}
		else
			throw new IllegalStateException();
		return first;
		
	}
}
