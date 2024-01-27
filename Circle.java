/*
Jia Gapuz      
Math 130-603  
Instructor: Professor Mimi Rasky         
Date 05/19/2023
Lab #12
*/
package testing;

import java.util.*;

public class Circle extends Shape implements Area
{
	private double radius = 1.0;
	
	//default constructor
	public Circle()
	{
		super();
		this.radius = 1.0;
	}
	
	//half-custom constructor
	public Circle(double r)
	{
		super();
		setRadius(r);
	}
	
	//full custom constructor
	public Circle(double r, String c, boolean f)
	{
		super(c, f);
		setRadius(r);
	}
	
	//getter method for radius 
	public double getRadius()
	{
		return this.radius;
	}
	
	//setter method for radius
	public void setRadius(double r)
	{
		if(r <= 0)
			System.out.println("Illegal radius, cancelling...");
		else
			this.radius = r;
	}
	
	//getArea method calculates the area of the circle
	public double getArea()
	{
		return Math.pow(this.radius, 2)*Math.PI;
	}
	
	//toString method formats the object's information into a string 
	public String toString()
	{
		return String.format("A circle with radius %.2f, which is a subclass of %s", this.radius, super.toString());
	}

}
