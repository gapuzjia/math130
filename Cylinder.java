/*
Jia Gapuz      
Math 130-603  
Instructor: Professor Mimi Rasky         
Date 05/19/2023
Lab #12
*/
package testing;

public class Cylinder implements Volume, Area
{
	private Circle base;
	private double height;
	
	public Cylinder ()
	{
		this.base = new Circle();
		this.height = 1.0;
	}
	
	public Cylinder (double radius, double height)
	{
		this.base = new Circle(radius);
		this.height = height;
	}
	
	public void setHeight(double h)
	{
		if(h <= 0)
			this.height = 1.0;
		
		else
			this.height = h;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	public String toString()
	{
		return String.format("A Cylinder with radius = %.2f, and height %.2f that has a Circle", base.getRadius(), this.height);	
	}
	
	public double getVolume()
	{
		return Math.PI * Math.pow(base.getRadius(), 2)* this.height;
	}
	
	public double getArea()
	{
		return 2 * Math.PI * base.getRadius() * this.height + 2 * Math.PI * Math.pow(base.getRadius(), 2);
	}
}
