/*
 Jia Gapuz     
Math 130-603  
Instructor: Professor Mimi Rasky         
04/11/2023      
Lab #8 
*/
package testing;

import java.io.*;
import java.util.*;

public class Lab8 {
	
	public static void main(String[]args) throws IOException
	{
		//declare variables
		int rows, columns;
		
		//declare array
		int [][] gradeBook;
		
		//declare file object and open file
		File file = new File ("C:\\Users\\Jia Gapuz\\Desktop\\dataLab8Spring23.txt");
			
		//check if file exists, program will terminate if file does not exist
		if (!file.exists())
		{
			System.out.println ("The file cannot be found.");
			System.exit(0);
		}
				
		//declare scanner to read file data
		Scanner inputFile = new Scanner (file);
		
		//read number of rows of array from first value in file
		rows = inputFile.nextInt();
		
		//read number of columns of array from second value in file
		columns = inputFile.nextInt();
		
		//allocate memory for array
		gradeBook = new int [rows][columns];
		
		//populate array with values from file read
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
				gradeBook[i][j] = inputFile.nextInt();
		}
		
		//close file
		inputFile.close();
		
		//invoke printArray method
		printArray(gradeBook, rows, columns);
		System.out.println();
		
		//invoke and print results of getClassAvg method
		System.out.printf("The class average of all the grades is: %.1f\n",getClassAvg(gradeBook, rows, columns));
		
		//invoke and print results of getRande method
		System.out.println("The range of all grades is: " + getRange(gradeBook, rows, columns));
		System.out.println();
		
		//invoke and print results of getRowAverage method for all rows of the array
		for(int i = 0; i < rows; i++)
			System.out.printf("The average for student #%d is: %.1f\n" , i+1 , getRowAverage(gradeBook, i, columns));
		System.out.println();
		
		//invoke and print results of getColumnAverage method for all columns of the array
		for(int j = 0; j < columns; j++)
			System.out.printf("The average for test #%d is: %.1f\n" , j+1 , getColumnAverage(gradeBook, j, rows));
		System.out.println();
		
		//invoke and print results of getHighestInRow method for all rows of the array
		for(int i = 0; i < rows; i++)
			System.out.printf("The highest test grade for student #%d is: %3d\n" , i+1 , getHighestInRow(gradeBook, i, columns));
		System.out.println();
	
		//invoke and print results of getLowestInRow for all rows of the array
		for(int i = 0; i < rows; i++)
			System.out.printf("The lowest exam grade for student #%d is: %3d\n" , i+1 , getLowestInRow(gradeBook, i, columns));
		System.out.println();
		
		//invoke and print results of getStandardDeviation method for all columns of the array
		for(int j = 0; j < columns; j++)
			System.out.printf("The standard deviation for test #%d is: %.1f\n" , j+1 , getStandardDeviation(gradeBook, j, rows));
		System.out.println();
		
		//invoke getGrades method
		getGrades(gradeBook);
		
	}
	//END OF MAIN METHOD
	
	
	
	//method printArray prints the contents of the array
	public static void printArray (int [][] gradeBook, int rows, int columns)
	{
		//additional padding for top row alignment
		System.out.print("          ");
		
		//print exam numbers on top row 
		for (int i = 0; i <= columns-1; i++)
			System.out.printf("   Exam #%d" , i+1);
		System.out.println();
			
		//print contents of array
		for (int i = 0; i < rows; i++)
		{
			//print student number on each row
			System.out.printf("Student #%d", i+1);
			for (int j = 0; j < columns; j++)
			{
				//print contents of the row
				System.out.printf("%10d" ,gradeBook[i][j]);
				
				//forces a next line every sixth element to have only six elements per row
				if((j+ 1) % 6 == 0)
					System.out.println();
			}
		}
	}
	
	
	//method getClassAvg returns the average of all scores in the class
	public static double getClassAvg(int [][]gradeBook, int rows, int columns)
	{
		int sum = 0;
		
		//nested loop goes through all elements of the 2-d array
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
				sum += gradeBook [i][j];	
		}
		
		//return the sum of all elements divided by the total number of scores
		return sum/(double)(rows*columns);
	}
	
	
	//method getRange returns the range of all scores in the class
	public static int getRange(int [][] gradeBook, int rows, int columns)
	{
		
		int max = gradeBook[0][0];
		int min = gradeBook[0][0];
		
		//nested loop goes through all elements of the 2-d array
		for (int i = 1; i < rows; i++)
		{
			for (int j = 1; j < columns; j++)
			{
				//update max if element is greater than current max
				if(gradeBook [i][j] > max)
					max = gradeBook[i][j];
				
				//update min if element is less than the current min
				if (gradeBook[i][j] < min)
					min = gradeBook[i][j];
			}
		}
		
		//return the difference of the max and the min
		return max - min;
		
	}
	
	
	//method getRowAverage returns the average of a given row
	public static double getRowAverage(int [][]gradeBook, int i, int columns)
	{
		int sum = 0;
		
		//loop goes through all elements in a given row
		for(int j = 0; j < columns; j++)
		{
			sum += gradeBook[i][j];
		}
		
		//return the sum of all elements in the row divided by the number of columns
		return sum/(double)columns;
	}
	
	
	//method getColumnAverage returns the average of a given column
	public static double getColumnAverage(int [][]gradeBook, int j, int rows)
	{
		int sum = 0;
		
		//loop goes through all elements in a given column
		for(int i = 0; i < rows; i++)
		{
			sum += gradeBook[i][j];
		}
		
		//return the sum of all elements in the column divided by the number of rows
		return sum/(double)rows;
	}
	
	
	//method getHighestInRow returns the highest test score in a given row
	public static int getHighestInRow(int [][]gradeBook, int i, int columns)
	{
		int max = gradeBook[i][0];
		
		//loop goes through all elements in a given row
		for(int j = 1; j < columns; j++)
		{
			//update max if element is greater than current max
			 if( max < gradeBook[i][j])
				 max = gradeBook[i][j];
		}
		
		//return the max value
		return max;
	}
	
	
	//method getLowestInRow returns the lowest test score in a given row
	public static int getLowestInRow(int [][]gradeBook, int i, int columns)
	{
		int min = gradeBook[i][0];
		
		//loop goes through all elements in a given row
		for(int j = 1; j < columns; j++)
		{
			//update min if element is less than current min
			 if( min > gradeBook[i][j])
				 min = gradeBook[i][j];
		}
		
		//return the min value
		return min;
	}
	
	
	//method getStandardDeviation returns the standard deviation of all scores in a given column
	public static double getStandardDeviation(int [][]gradeBook, int j, int rows)
	{
		double sum = 0;
		double avg;
		
		//invoke getColumnAverage to calculate average of the column
		avg = getColumnAverage(gradeBook, j, rows);
		
		//loop goes through all elements of the column
		for(int i = 0; i < rows; i++)
		{
			//find the difference of the column average and the current test score
			//square this value
			//add this value to the total
			sum += Math.pow((gradeBook[i][j] - avg),2);
		}
		
		//return the square root of the total sum
		return Math.sqrt(sum/rows);
	}
	
	
	//method getGrades drops the student's lowest score, recalculates the average of their test scores,
	//and prints out the equivalent letter grade
	public static void getGrades(int[][]gradeBook)
	{
		int rows = gradeBook.length;
		int columns = gradeBook[0].length;
		double sum = 0;
		double avg;
		
		//loop goes through all rows
		for(int i = 0; i < rows; i++)
		{
			//loop goes through all columns
			//find sum of all test scores in given column
			for (int j = 0; j < columns; j++)
				sum += gradeBook [i][j];	
			
			//subtract lowest test score from total of test scores
			sum -= getLowestInRow(gradeBook, i, columns);
			
			//recalculate average after dropping the lowest test score by:
			//dividing the sum (minus the lowest score) by one less the original number of test scores
			avg = sum / (columns - 1);
			
			//print student's new average
			System.out.printf("Student #%d had an average of %.1f (after dropping lowest score).\n", i+1, avg);
			
			//print equivalent letter grade
			if(avg >= 90)
				System.out.println("This student received a grade of A in the class.");
			else if (avg >= 80)
				System.out.println("This student received a grade of B in the class.");
			else if (avg >= 70)
				System.out.println("This student received a grade of C in the class.");
			else if (avg >= 60)
				System.out.println("This student received a grade of D in the class.");
			else 
				System.out.println("This student received a grade of F in the class.");
			
			System.out.println();
			
			//reinitialize the sum to 0 for the next row
			sum = 0;
		}
	}
}
