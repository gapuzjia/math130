/*
Jia Gapuz
Math 130-603
Instructor: Professor Mimi Rasky
02/17/2023
Lab #2
*/

package testing;

import java.util.*;

public class Lab2
{
	public static void main (String[]args)
	{
		//declare initial values from user input - radii
		int rad1;
		int rad2;
		int rad3;
		int rad4;
		int rad5;
		
		//declare initial values from user input - angles
		int ang1;
		int ang2;
		int ang3;
		int ang4;
		int ang5;
		
		//declare calculated values - angles in radians
		double angRad1;
		double angRad2;
		double angRad3;
		double angRad4;
		double angRad5;
		
		//declare calculated values - arc length
		double arc1;
		double arc2;
		double arc3;
		double arc4;
		double arc5;
		
		//declare calculated values - polar area
		double pol1;
		double pol2;
		double pol3;
		double pol4;
		double pol5;
		
		//scanner
		Scanner scnr = new Scanner(System.in);
		
		
		
		//USER INPUT
		
		//circle 1
		System.out.print("Please enter an integer radius measurement: ");
		rad1 = scnr.nextInt();
		
		System.out.print("Please enter an integer angle (in degrees, between 0 and 360): ");
		ang1 = scnr.nextInt();
		
		
		//circle 2
		System.out.print("Please enter an integer radius measurement: ");
		rad2 = scnr.nextInt();
		
		System.out.print("Please enter an integer angle (in degrees, between 0 and 360): ");
		ang2 = scnr.nextInt();
		
		
		//circle 3
		System.out.print("Please enter an integer radius measurement: ");
		rad3 = scnr.nextInt();
		
		System.out.print("Please enter an integer angle (in degrees, between 0 and 360): ");
		ang3 = scnr.nextInt();
		
		
		//circle 4
		System.out.print("Please enter an integer radius measurement: ");
		rad4 = scnr.nextInt();
		
		System.out.print("Please enter an integer angle (in degrees, between 0 and 360): ");
		ang4 = scnr.nextInt();
		
		
		//circle 5
		System.out.print("Please enter an integer radius measurement: ");
		rad5 = scnr.nextInt();
		
		System.out.print("Please enter an integer angle (in degrees, between 0 and 360): ");
		ang5 = scnr.nextInt();
		
		
		//convert degree values to radians
		angRad1 = (double)ang1 *(Math.PI/180);
		angRad2 = (double)ang2 *(Math.PI/180);
		angRad3 = (double)ang3 *(Math.PI/180);
		angRad4 = (double)ang4 *(Math.PI/180);
		angRad5 = (double)ang5 *(Math.PI/180);
		
		
		//calculate arclength
		arc1 = rad1 * angRad1;
		arc2 = rad2 * angRad2;
		arc3 = rad3 * angRad3;
		arc4 = rad4 * angRad4;
		arc5 = rad5 * angRad5;
		
		
		//calculate polar area
		pol1 = (Math.pow(rad1,2)*angRad1) / 2;
		pol2 = (Math.pow(rad2,2)*angRad2) / 2;
		pol3 = (Math.pow(rad3,2)*angRad3) / 2;
		pol4 = (Math.pow(rad4,2)*angRad4) / 2;
		pol5 = (Math.pow(rad5,2)*angRad5) / 2;

		
		
		//print all final outputs
		System.out.println();
		System.out.printf("%-17s %-17s %-17s %-17s\n" , "Radius (in.)", "Angle (radians)","Arclength (in.)","Polar Area (sq. in.)");
		System.out.println("**************************************************************************");
		System.out.printf("%8d%18.1f%18.1f%18.1f\n", rad1, (double)angRad1, arc1, pol1 );
		System.out.printf("%8d%18.1f%18.1f%18.1f\n", rad2, (double)angRad2, arc2, pol2 );
		System.out.printf("%8d%18.1f%18.1f%18.1f\n", rad3, (double)angRad3, arc3, pol3 );
		System.out.printf("%8d%18.1f%18.1f%18.1f\n", rad4, (double)angRad4, arc4, pol4 );
		System.out.printf("%8d%18.1f%18.1f%18.1f\n", rad5, (double)angRad5, arc5, pol5 );
		System.out.println("**************************************************************************");
		System.out.printf("The average of all the radii is: %.1f inches",(rad1 + rad2 + rad3 + rad4 + rad5) / (double)5);
		
	}
	
}
