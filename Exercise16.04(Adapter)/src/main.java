
public class main {
	public static void main(String[] args) {
		BlockingQueue<String> one=new BlockingQueue<>(5);
		BlockingQueue<String> two=new BlockingQueue<>(3);
		
		System.out.println(one.isEmpty());
		one.put("Hi");
		System.out.println(one.take());
		
		two.put("Hey");
		System.out.println(two.take());
	}
}
