import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import utility.collection.ArrayQueue;
import utility.collection.QueueADT;

public class Log {
	private QueueADT<LogLine> queue;
	private File file;
	private static Log instance;

	private Log() {
		Calendar cal = GregorianCalendar.getInstance();
		int day = cal.get(GregorianCalendar.DAY_OF_MONTH);
		int month = cal.get(GregorianCalendar.MONTH) + 1;
		int year = cal.get(GregorianCalendar.YEAR);
		file = new File(day + "_" + month + "_" + year+".txt");
		queue = new ArrayQueue<LogLine>();
	}
	
	public static Log getInstance()
	{
		if (instance == null)
		{
			instance = new Log();
		}
		return instance;
	}

	public void add(LogLine logLine) {
		queue.enqueue(logLine);
		addToFile(logLine);
	}

	public void addToFile(LogLine logLine) {
		if (logLine == null) {
			return;
		}
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file, true));
			out.write(logLine + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public QueueADT<LogLine> getAll() {
		return queue;
	}
}
