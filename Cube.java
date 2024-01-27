/*
Jia Gapuz      
Math 130-603  
Instructor: Professor Mimi Rasky         
Date 05/19/2023
Lab #12
*/
package testing;

public class Cube extends Square implements Volume
{
	Cube()
	{
		super();
	}
	
	Cube(double s)
	{
		super(s);
	}
	
	Cube(double s, String c, boolean f)
	{
		super(s, c, f);
	}
	
	public double getVolume()
	{
		return Math.pow(getLength(), 3);
	}
	
	public String toString()
	{
		return String.format("A Cube with size = %.2f, which is a subclass of %s", this.getSide(), super.toString());
	}
}
