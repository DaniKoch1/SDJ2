
public class Main {
	public static void main(String[] args) {
		Log log=Log.getInstance();
		log.add(new LogLine("Danieeeeeela"));
		log.add(new LogLine("Miiiiiiiiœka"));
		log.add(new LogLine("Reeeeeeme"));
		//System.out.println(log.getAll());
		
		Log log2=Log.getInstance();
		System.out.println(log2.getAll());
	}
}
