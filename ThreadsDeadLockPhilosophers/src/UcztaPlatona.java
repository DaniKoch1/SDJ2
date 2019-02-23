
public class UcztaPlatona {
	public static void main(String[] args) {
		Fork[] forks=new Fork[5];
		for(int i=0;i<forks.length;i++)
			forks[i]=new Fork(i, 5);
		Thread[] philosophers=new Thread[forks.length];
		for(int i=0;i<philosophers.length;i++) {
			Philosopher phil=new Philosopher(i, forks[i], forks[(i+1)%forks.length]);
			philosophers[i]=new Thread(phil, "Philosopher"+i);
			philosophers[i].start();
		}
	}
}
