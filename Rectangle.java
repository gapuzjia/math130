/*
Jia Gapuz      
Math 130-603  
Instructor: Professor Mimi Rasky         
Date 05/19/2023
Lab #12
*/
package testing;

public class Rectangle extends Shape implements Area
{
	private double width;
	private double length;
	
	//default constructor
	public Rectangle()
	{
		this.width = 1.0;
		this.length = 1.0;
	}
	
	//half-custom constructor
	public Rectangle(double width, double length)
	{
		setWidth(width);
		setLength(length);
	}
	
	//full custom constructor
	public Rectangle(double width, double length, String c, boolean f)
	{
		super(c, f);
		setWidth(width);
		setLength(length);
	}
	
	//getter method for width
	public double getWidth()
	{
		return this.width;
	}
	
	//setter method for width
	public void setWidth(double width)
	{
		if(width <= 0)
		{
			System.out.println("Illegal width, cancelling...");
			this.width = 1;
		}
			
		else
			this.width = width;
	}
	
	//getter method for length
	public double getLength()
	{
		return this.length;
	}
	
	//setter method for length
	public void setLength(double length)
	{
		if(length <= 0)
		{
			System.out.println("Illegal length, cancelling...");
			this.length = length;
		}
			
		else
			this.length = length;
	}
	
	//getArea method calculates the area of the shape
	public double getArea()
	{
		return this.width * this.length;
	}
	
	//toString method formats the object's information into a string 
	public String toString()
	{
		return String.format("A Rectangle with width = %.2f and length = %.2f, which is a subclass of %s", this.width, this.length, super.toString());
	}
}
