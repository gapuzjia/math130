package testing;

import java.util.*;

public class Family 
{
	private double income;
	private int size;
	
	public static ArrayList<Double> list = new ArrayList<>(); 
	
	
	Family(double i, int s)
	{
		this.income = i;
		this.size = s;
		list.add(i);
	}
	
	public boolean isPoor(double housingCost, double foodCost)
	{
		if((housingCost + foodCost *this.size) > this.income / 2.0)
			return true;
		else
			return false;
	}
	
	public String toString()
	{
		return String.format("This family of size %d has an income of %.2f\n", this.size, this.income);
	}
	
	public static double showAverageIncome()
	{
		double sum = 0;
		
		for(int i = 0; i < list.size(); i++)
		{
			sum += list.get(i);
		}	
		return sum / list.size();
	}
}


