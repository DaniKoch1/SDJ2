import java.util.HashMap;

public class EducationFactory {
	private static HashMap<String, Education> educationMap=new HashMap<String, Education>();
	
	public static Education getEducation(String educationCode)
	{
		Education item=educationMap.get(educationCode);
		if(item==null)
		{
			if(educationCode.equals("ICT"))
				item=new Programme(educationCode, "ICT Engineering", "SEK");
			else if(educationCode.equals("HJS"))
				item=new School(educationCode, "Horsens Junior School", "Elementary School");
			else if(educationCode.equals("ME"))
				item=new Programme(educationCode, "Mechanical Engineering", "MEK");
			else if(educationCode.equals("ALO"))
				item=new School(educationCode, "Akademickie Liceum Ogólnokszta³c¹ce", "High School");
			else if(educationCode.equals("eNTe"))
				item=new School(educationCode, "niepubliczna szko³a jê¿ykowa eNTe", "Elementary School");
			
			educationMap.put(educationCode, item);
		}
		return item;	
	}
}
