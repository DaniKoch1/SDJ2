package View;

public class Rectangle extends Shape{
	protected double height;
	protected double width;
	
	public Rectangle(int xPos, int yPos, double height, double width)
	{
		super(xPos, yPos);
		this.height=height;
		this.width=width;
	}
	public void draw() {}
	public void erase() {}
	public double getHeight()
	{
		return height;
	}
	public double getWidth()
	{
		return width;
	}
	
}
