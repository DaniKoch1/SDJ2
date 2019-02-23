
public class Main {
	public static void main(String[] args) {
		Student one=new Student(001, "Dani", "Koch", "999", "Poland");
		Student two=new Student(002, "Miœka", "Kubicz", "999", "Poland");
		Student three=new Student(003, "Reme", "Pastor", "134", "Spain");
		Student four=new Student(001, "Dani", "Koch", "999", "Poland");
		
		System.out.println(one+"\n"+two+"\n"+three+"\n"+four);
		CountryFactory.updateCountry("999", "Denmark");
		Student five=new Student(004, "Micha³", "Pompa", "999", "Denmark");
		
		System.out.println(one);
		if(one.equals(two))
			System.out.println("Dani equals Miœka");
		else
			System.out.println("Dani equals not Miœka");
		if(one.equals(one))
			System.out.println("Dani equals Dani");
		else
			System.out.println("Dani equals not Dani");
	
		System.out.println(one+"\n"+two+"\n"+three+"\n"+four+"\n"+five);
	}
}
