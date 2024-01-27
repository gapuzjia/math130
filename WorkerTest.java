/*Jia Gapuz        
Math 130-603  
Instructor: Professor Mimi Rasky         
Date 04/28/23        
Lab #10 
 */
package testing;

import java.util.*;

public class WorkerTest {
	
	public static void main(String[]args)
	{
		String worker, workerID, position;
		double salary;
		
		//declare scanner and random class
		Scanner scnr = new Scanner(System.in);
		Random rand = new Random();
		
		//declare worker array
		Worker [] workerArray = new Worker[rand.nextInt(15)+5];
		
		
		//populate array with default workers
		for(int i = 0; i < workerArray.length; i++)
			workerArray[i] = new Worker();
		
		
		
		//prompt user for FIRST worker's name and ID
		System.out.print("Input the first worker's name: ");
		worker = scnr.nextLine();
		workerArray[0].name = worker;
		
		System.out.print("Input the first worker's ID: ");
		workerID = scnr.nextLine();
		workerArray[0].setID(workerID);
		
		System.out.println();
		
		//prompt user for SECOND worker's name, ID, position, and salary
		System.out.print("Input the worker's name: ");
		worker = scnr.nextLine();
		workerArray[1].name = worker;
		
		System.out.print("Input the worker's ID: ");
		workerID = scnr.nextLine();
		workerArray[1].setID(workerID);
		
		System.out.print("Input the worker's position: ");
		position = scnr.nextLine();
		workerArray[1].position = position;
		
		System.out.print("Input the worker's salary: ");
		salary = scnr.nextDouble();
		workerArray[1].setSalary(salary);
		scnr.nextLine();
		
		System.out.println();
		
		//prompt user for THIRD AND FOURTH worker's name, ID, position, and salary
		System.out.print("Input the worker's name: ");
		worker = scnr.nextLine();
		workerArray[2].name = worker;
		workerArray[3].name = worker;
		
		System.out.print("Input the worker's ID: ");
		workerID = scnr.nextLine();
		workerArray[2].setID(workerID);
		workerArray[3].setID(workerID);
		
		System.out.print("Input the worker's position: ");
		position = scnr.nextLine();
		workerArray[2].position = position;
		workerArray[3].position = position;
		
		System.out.print("Input the worker's salary: ");
		salary = scnr.nextDouble();
		workerArray[2].setSalary(salary);
		workerArray[3].setSalary(salary);
		System.out.println();
		
		//display the fields last two new workers
		System.out.println("workerArray[2] name: " + workerArray[2].name);
		System.out.println("workerArray[3] name: " + workerArray[3].name);
		System.out.println("workerArray[2] workerID: " + workerArray[2].getID());
		System.out.println("workerArray[3] workerID: " + workerArray[3].getID());
		System.out.println("workerArray[2] position: " + workerArray[2].position);
		System.out.println("workerArray[3] position: " + workerArray[3].position);
		System.out.println("workerArray[2] salary: " + workerArray[2].getSalary());
		System.out.println("workerArray[3] salary: " + workerArray[3].getSalary());
		
		//invoke showTotalSalaries method
		System.out.println();
		Worker.showTotalSalaries();
		System.out.println();
		
		//prompt user to change FIRST worker's name and position
		System.out.print("Give the first worker a new position: ");
		scnr.nextLine();
		position = scnr.nextLine();
		workerArray[0].position = position;
		
		System.out.print("Give the first worker a new salary: ");
		salary = scnr.nextDouble();
		workerArray[0].setSalary(salary);
		
		//print info of FIRST worker
		System.out.println("workerArray[0] name: " + workerArray[0].name);
		System.out.println("workerArray[0] workerID: " + workerArray[0].getID());
		System.out.println("workerArray[0] position: " + workerArray[0].position);
		System.out.println("workerArray[0] salary: " + workerArray[0].getSalary());
		scnr.nextLine();
		System.out.println();
		
		//ask user to change FIRST worker's id (first prompt)
		System.out.print("Give the first worker a new workerID: ");
		workerID = scnr.nextLine();
		workerArray[0].setID(workerID);
		System.out.println("You entered " + workerArray[0].getID());
		System.out.println();
		
		//ask user to change FIRST worker's id (second prompt)
		System.out.print("Give the first worker a new workerID: ");
		workerID = scnr.nextLine();
		workerArray[0].setID(workerID);
		System.out.println("You entered " + workerArray[0].getID());
		System.out.println();
		
		//invoke and print getNumWorkers method
		System.out.println("The number of workers is: " + Worker.getNumWorkers());
		System.out.println();
		
		//invoke and print .equals method for duplicate workers
		System.out.println("worker2.equals(worker3): " + workerArray[2].equals(workerArray[3]));
			
		//invoke and print equals method for not duplicate workers
		System.out.println("worker1.equals(worker4): " + workerArray[1].equals(workerArray[4]));
		System.out.println();
		
		//invoke .speak method with all workers
		for(int i = 0; i < 4; i++)
			workerArray[i].speak();
		
		//invoke showTotalSalaries method
		System.out.println();
		Worker.showTotalSalaries();
		System.out.println();
	
		//print out information of all workers
		System.out.println("Name            WorkerID        Position        Salary");
		for(int i = 0; i < workerArray.length; i++)
			System.out.println(workerArray[i].toString());
		
	}

}
