
public class Main {

	public static void main(String[] args) {

		Door door = new Door();
		System.out.println("Start up, the door is "+door.status());
		door.click();
		System.out.println("Clicked, the door is "+door.status());
		door.click();
		System.out.println("Clicked, the door is "+door.status());
		door.complete();
		System.out.println("Completed, the door is "+door.status());
		door.click();
		System.out.println("Clicked, the door is "+door.status());
		door.click();
		System.out.println("Clicked, the door is "+door.status());
		door.complete();
		System.out.println("Completed, the door is "+door.status());
		door.click();
		System.out.println("Clicked, the door is "+door.status());
		door.click();
		System.out.println("Clicked, the door is "+door.status());
		door.complete();
		System.out.println("Completed, the door is "+door.status());
		door.timeout();
		System.out.println("Timeout at illegal state, the door is "+door.status());
		door.click();
		System.out.println("Clicked, the door is "+door.status());
		door.complete();
		System.out.println("Completed, the door is "+door.status());
		door.timeout();
		System.out.println("Timeout, the door is "+door.status());
		door.complete();
		System.out.println("Completed, the door is "+door.status());		
	}

}
