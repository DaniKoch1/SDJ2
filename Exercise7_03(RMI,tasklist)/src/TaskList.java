import java.util.ArrayList;

public class TaskList {

	private ArrayList<String> tasks;
	
	public TaskList()
	{
		tasks = new ArrayList<>();
	}
	
	public void addTask(String task)
	{
		tasks.add(task);
	}
	public int size()
	{
		return tasks.size();
	}
	public String getAndRemoveNextTask ()
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
