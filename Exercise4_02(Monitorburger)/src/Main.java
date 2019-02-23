
public class Main {

	public static void main(String[] args) {
		BurgerBar bar = new BurgerBar(10);
		BurgerBarEmployee emp1 = new BurgerBarEmployee("Kate", bar);
		BurgerBarEmployee emp2 = new BurgerBarEmployee("John", bar);
		BurgerBarCostumer cost1 = new BurgerBarCostumer(1, "Ginny", bar);
		BurgerBarCostumer cost2 = new BurgerBarCostumer(3, "Harry", bar);
		BurgerBarCostumer cost3 = new BurgerBarCostumer(4, "Hermione", bar);
		BurgerBarCostumer cost4 = new BurgerBarCostumer(5, "Ron", bar);
		BurgerBarCostumer cost5 = new BurgerBarCostumer(5, "Luna", bar);
	
		Thread thd1 = new Thread(emp1);
		Thread thd2 = new Thread(emp2);
		Thread thd3 = new Thread(cost1);
		Thread thd4 = new Thread(cost2);
		Thread thd5 = new Thread(cost3);
		Thread thd6 = new Thread(cost4);
		Thread thd7 = new Thread(cost5);
		thd1.start();
		thd2.start();
		thd3.start();
		thd4.start();
		thd5.start();
		thd6.start();
		thd7.start();
		
	}
}
