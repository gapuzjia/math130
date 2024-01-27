/*
Jia Gapuz      
Math 130-603  
Instructor: Professor Mimi Rasky         
Date 05/19/2023
Lab #12
*/

package testing;

public class Sphere extends Circle implements Volume
{
	Sphere()
	{
		super();
	}
	
	Sphere(double r)
	{
		super(r);
	}
	
	Sphere(double r, String s, boolean f)
	{
		super(r, s, f);
	}
	
	public double getVolume()
	{
		return (double) 4 / 3 * Math.PI * Math.pow(super.getRadius(),3);
	}
	
	public String toString()
	{
		return String.format("A sphere with radius %.2f, which is a subclass of %s", getRadius(), super.toString());
	}
	
}
