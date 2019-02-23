import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import utility.collection.ArrayQueue;
import utility.collection.QueueADT;

public class Log {
	private static Log instance;
	private File file;
	private QueueADT<LogLine> q;
	
	private Log()
	{
		file=new File("21_03_18.txt");
		q=new ArrayQueue<LogLine>();
	}
	public static Log getInstance()
	{
		if(instance==null)
			instance=new Log();
		return instance;
	}
	public void add(LogLine logLine)
	{
		q.enqueue(logLine);
		BufferedWriter out = null;
		try
		 {
			 out = new BufferedWriter(new FileWriter(file, true));
			 out.write(logLine + "\n");
		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 try
			 {
				 out.close();
			 }
			 catch (Exception e)
			 {
				 e.printStackTrace();
			 }
		 }
	}
	public QueueADT<LogLine> getAll()
	{
		return q;
	}
}
