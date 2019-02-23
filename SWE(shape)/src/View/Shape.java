package View;

public abstract class Shape {
	private Color color;
	protected int xPos, yPos;
	boolean isVisible=true;
	private static int noOfShapes=0;
	
	public Shape(int xPos, int yPos)
	{
		this.xPos=xPos;
		this.yPos=yPos;
		noOfShapes++;
	}
	public abstract void draw();
	public abstract void erase();
	public void show()
	{}
	public void hide()
	{}
	public Color getColor()
	{
		return color;
	}
	public static int getNoOfShapes()
	{
		return noOfShapes;
	}
}
