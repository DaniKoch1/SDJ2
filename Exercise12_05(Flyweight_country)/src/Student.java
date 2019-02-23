

public class Student {
	private int studyNumber;
	private String name;
	private Country nationality;
	
	public Student(int studyNumber, String firstName, String lastName, String countryCode, String country)
	{
		this.studyNumber=studyNumber;
		name=firstName+" "+lastName;
		nationality=CountryFactory.getNationality(countryCode, country);
	}

	public int getStudyNumber() {
		return studyNumber;
	}

	public void setStudyNumber(int studyNumber) {
		this.studyNumber = studyNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}
	public String toString()
	{
		return name+": study number: "+studyNumber+", nationality: "+nationality;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			return false;
		Student other=(Student) obj;
		if(other.name.equals(name)&&other.studyNumber==studyNumber&&other.nationality.equals(nationality))
			return true;
		return false;
	}
}
