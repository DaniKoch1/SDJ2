import java.util.jar.Attributes.Name;

public class Student {

	private int studentNumber;
	private String name;
	private Country country;
	
	public Student(int studentNumber,String firstName, String lastName, String countryCode, String country)
	{
		this.studentNumber = studentNumber;
		this.name = firstName+", "+lastName;
		this.country = CountryFactory.getNationality(countryCode,country);
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getNationality() {
		return country;
	}

	public void setNationality(String countryCode, String country) {
		CountryFactory.updateCountry(countryCode,country);
	}
	
	public String toString()
	{
		return "Student\nNumber: "+studentNumber+"\nName: "+name+"\n"+country.toString();
	}
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Student))
		{
			return false;
		}
		Student other = (Student) obj;
		return other.getStudentNumber()==studentNumber && other.getName().equals(name) && other.getNationality().equals(country);
	}
}
