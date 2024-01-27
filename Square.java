/*
Jia Gapuz      
Math 130-603  
Instructor: Professor Mimi Rasky         
Date 05/19/2023
Lab #12
*/
package testing;

public class Square extends Rectangle implements Area
{
	public Square()
	{
		super();
	}
	
	//half-custom constructor
	public Square(double side)
	{
		super(side,side);
	}
	
	//fill custom constructor
	public Square(double s, String c, boolean f)
	{
		super(s,s);
		this.color = c;
		this.filled = f;
	}
	
	//getter method for side
	public double getSide()
	{
		return this.getLength();
	}
	
	//setter method for sides
	public void setSide(double side)
	{
		super.setWidth(side);
		super.setLength(side);		
	}
	
	//setter method for width
	//if width is changed, length will also change to maintain square property
	public void setWidth(double side)
	{
		super.setWidth(side);
		super.setLength(side);
	}
	
	//setter method for length
	//if length is changed, width will also change to maintain square property
	public void setLength(double side)
	{
		super.setWidth(side);
		super.setLength(side);
	}
	
	//toString method formats the object's information into a string 
	public String toString()
	{
		return String.format("A Square with size = %.2f, which is a subclass of %s", this.getSide(), super.toString());
	}
	
}
