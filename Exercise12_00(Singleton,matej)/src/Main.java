import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Log log = new Log();
		Scanner in = new Scanner(System.in);
		System.out.println("Add a logline or write exit");
		String logLine = in.nextLine();
		while (!logLine.equals("exit"))
		{
			log.add(new LogLine(logLine));
			System.out.println("Add a logline or write exit");
			logLine = in.nextLine();			
		}
		in.close();
		System.out.println(log.getAll());
	}

}
