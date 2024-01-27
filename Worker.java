/*Jia Gapuz        
Math 130-603  
Instructor: Professor Mimi Rasky         
Date 04/28/23        
Lab #10 
 */

package testing;
import java.util.*;
import java.util.ArrayList;

public class Worker 
{
	
	public String name;
	private String workerID;
	public String position;
	private double salary;
	
	private static ArrayList <Double> list = new ArrayList <Double>();
	
	Random rand = new Random();
	
	//create default constructor
	public Worker()
	{
		name = "";
		workerID = "";
		position = "";
		salary = 30000;
		list.add(salary);
	}
	
	//create custom constructor
	public Worker(String newName, String newWorkerID)
	{
		name = newName;
		setID(newWorkerID);
		position = "";
		salary = 30000;
		list.add(salary);
	}
	
	//create full custom constructor
	public Worker(String newName, String newWorkerID, String newPosition, double newSalary)
	{
		name = newName;
		setID(newWorkerID);
		position = newPosition;
		salary = newSalary;
		list.add(salary);
	}
	
	public String getID()
	{
		return workerID;
	}
	
	public void setID(String newWorkerID)
	{
		int charCtr = 0;
		int digitCtr = 0;
		
		//check if worker ID is exactly 5 characters in length, else set ID to default
		if(newWorkerID.length() == 5)
		{
			//update counters if current character is a digit or a lowercase letter
			for(int i = 0; i < newWorkerID.length(); i++)
			{
				if (Character.isDigit(newWorkerID.charAt(i)))
					digitCtr++;
				
				if(Character.isLowerCase(newWorkerID.charAt(i)))
					charCtr++;
			}
			
			//if ID has less that 2 digits or less than 1 character, else set ID to default
			if(digitCtr < 1 || charCtr < 0)
				this.workerID = "a0000";
			
			else
				this.workerID = newWorkerID;
		}
		
		else
			this.workerID = "a0000";
			
	}
	
	public double getSalary()
	{
		return this.salary;
	}
	
	public void setSalary(double newSalary)
	{
		boolean removed = false;
		int i = 0;
		
		//remove first instance of old salary (value 30000)
		do {
			if(list.get(i) == 30000)
			{
				list.remove(i);
				removed = true;
			}
			
			i++;
		}while(removed = false);
		
		list.add(newSalary);
		this.salary = newSalary;
	}
	
	public String toString()
	{
		return String.format("%-15s %-15s %-15s $%-15.2f", name, getID(), position, getSalary());
	}
	
	public boolean equals(Object obj)
	{
		boolean flag = true;
		
		if (obj == null)
			return false;
		
		if(this.getClass() != obj.getClass())
			return false;
		
		if(!this.name.equals(((Worker)obj).name))
			return false;
		
		if(!this.workerID.equals(((Worker)obj).workerID))
			return false;
		
		if(!this.position.equals(((Worker)obj).position))
			return false;
		
		if(this.salary != ((Worker)obj).salary)
			return false;
		
		return flag;
	}
	
	public void speak()
	{
		int x;
		
		x = rand.nextInt(4);
		
		if(x == 0)
			System.out.println("It's 5 o'clock somewhere!");
		else if(x == 1)
			System.out.println("Why did the programmer quit his job? "
								+ "Because he didnt get arrays(a raise)!");
		else if (x == 2)
			System.out.println("The boss said from now on, we get paid in pizza parties.");
		else
			System.out.println("Do you think the boss will let me take a 24 month vacation?");
		
		System.out.println();
	}
	
	public static int getNumWorkers()
	{
		return list.size();
	}
	
	public static void showTotalSalaries()
	{
		double sum = 0;
		
		for(int i = 0; i < list.size(); i++)
		{
			System.out.printf("$ %.2f\n", list.get(i));
			sum += list.get(i);
		}
		
		System.out.printf("Average salary: $%.2f", sum / list.size());
		System.out.println();
	}
	
}
