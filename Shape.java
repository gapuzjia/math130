/*
Jia Gapuz      
Math 130-603  
Instructor: Professor Mimi Rasky         
Date 05/19/2023
Lab #12
*/

package testing;

public class Shape 
{
	protected String color;
	protected boolean filled;
	
	//default constructor
	public Shape()
	{
		this.color = "green";
		this.filled = true;
	}
	
	//custom constructor
	public Shape(String c, boolean f)
	{
		this.color = c;
		this.filled = f;
	}
	
	//getter method for the shape's color
	public String getColor()
	{
		return this.color;
	}
	
	//getter method for fill of color
	public boolean isFilled()
	{
		return this.filled;
	}
	
	//setter method for color
	public void setColor(String c)
	{
		this.color = c;
	}
	
	//setter method for fill
	public void setFilled(boolean f)
	{
		this.filled = f;
	}
	
	//toString method formats the object's information into a string 
	public String toString()
	{
		if(this.filled)
			return String.format("A Shape with color of %s and filled", this.color);
		else
			return String.format("A Shape with color of %s and not filled", this.color);
	}
}
