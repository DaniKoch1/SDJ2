
public class ServicesFactory {
	
	private static ServicesFactory instance;
	
	private ServicesFactory()
	{
		
	}
	public static ServicesFactory getInstance()
	{
		if(instance==null)
			instance=new ServicesFactory();
		return instance;
	}
}
