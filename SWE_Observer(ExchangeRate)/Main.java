
public class Main {
	public static void main(String[] args) {
		Bank bank=new Bank(66.5);
		bank.attach(new Stock("Miœka"));
		bank.attach(new Stock("Dani"));
		System.out.println(bank);
		bank.setRate(88.23);
		System.out.println(bank);
	}
}
