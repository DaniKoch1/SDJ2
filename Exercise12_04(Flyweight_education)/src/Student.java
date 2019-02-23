
public class Student {
	private String name;
	private Education education;
	
	public Student(String name, String educationCode)
	{
		this.name=name;
		education=EducationFactory.getEducation(educationCode);
	}

	public String getName() {
		return name;
	}

	public Education getEducation() {
		return education;
	}
	public String toString()
	{
		return name+"\nEducation: "+education;
	}
}
