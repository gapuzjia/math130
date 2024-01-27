/*
Jia Gapuz     
Math 130-603  
Instructor: Professor Mimi Rasky         
04/07/2023      
Lab #7 
*/

package testing;

import java.io.*;
import java.util.*;

public class Lab7 
{
	
	public static void main (String []args) throws IOException
	{
		//declare variables
		int size, newSize, x;
		
		//declare arrays
		int[] myArray;
		int[] newArray;
		
		//declare scanner
		Scanner scnr = new Scanner (System.in);
		
		//declare file object and open file
		File file = new File ("C:\\Users\\Jia Gapuz\\Desktop\\dataLab7Spring23-1.txt");
		
		//check if file exists, program will terminate if file does not exist
		if (!file.exists())
		{
			System.out.println ("The file cannot be found.");
			System.exit(0);
		}
		
		//declare second scanner to read file data
		Scanner inputFile = new Scanner (file);
		
		//read size of array from first value in file
		size = inputFile.nextInt();
		
		//complete declaration and allocate memory for array
		myArray = new int[size];
		
		//populating the array from file read
		for(int i = 0; i < size; i++)
		{
			myArray[i] = inputFile.nextInt();
		}
		
		//close file
		inputFile.close();
		
		
		//invoke printArray method
		System.out.println("Here is a printout of the original array:");
		printArray(myArray, size);
		System.out.println();
		
		//invoke getTotal method and print
		System.out.println("The sum of all the elements in the array is: " + getTotal(myArray, size));
		
		//invoke getAverage method and print
		System.out.printf("The average of all the elements in the array is: %.2f\n" , getAverage(myArray, size));		
		
		//invoke getHighest method and print
		System.out.println("The max of all elements in the array is: " + getHighest(myArray, size));
		
		//invoke getLowest method and print
		System.out.println("The min of all elements in the array is: " + getLowest(myArray, size));
		System.out.println();
		
		//prompt user for value that they want removed from array
		System.out.print("What value would you like to see removed? ");
		x = scnr.nextInt();
		
		//count and print number of occurrences of user's value in array
		System.out.print("The number of occurrences of " + x + " in the array is: " + countOccurrences(myArray, x, size));
		System.out.println();
		
		//assign a new size for the new array
		newSize = size - countOccurrences(myArray, x, size);
		
		//allocate memory for new array
		newArray = new int[size - countOccurrences(myArray, x, size)];
		
		//populate new array with values from removeAll method
		newArray = removeAll(newArray, myArray, x, size);
		
		//invoke printArray method on new array
		System.out.println("Here is a printout of the new array with the number " + x + " removed: ");
		printArray(newArray, newSize);
		System.out.print("\n\n");
		
		//invoke printAverage method on new array
		System.out.printf("The average of all the elements in the new array is: %.2f\n" , getAverage(newArray, newSize));
		
		//invoke haveSeven method on original array
		System.out.println("The result of invoking haveSeven on my array is: " + haveSeven(myArray, size));
		System.out.println();
		
		//invoke Arrays.sort method on original array
		System.out.println("Here is a printout of the sorted original array:");
		Arrays.sort(myArray);
		printArray(myArray, size);
		System.out.println();
		
		//invoke and print getMedian method on original sorted array
		System.out.printf("The median of the original array is: %.2f\n" , getMedian(myArray, size));
	}
	
	//method printArray prints the contents of the array with 6 elements on each line
	public static void printArray(int [] myArray, int size)
	{
		//print out the contents
		for(int i = 0; i < size; i++)
		{

			System.out.printf("%5d", myArray[i]);
					
			//a new line will be forced after every sixth digit
			//i+1 was added so the condition will start counting from 1 (first digit) and not 0
			if ((i+1)%6 == 0)
				System.out.println();
		}
	}
	
	//method getTotal returns sum of all elements in array
	public static int getTotal(int [] myArray, int size)
	{
		int sum = 0;
		
		for(int i = 0; i < size; i++)
		{
			sum += myArray[i];
		}
		
		return sum;
	}
	
	//method getAverage returns average of all elements in array
	public static double getAverage (int []myArray, int size)
	{
		return getTotal(myArray,size)/(double)(size);
	}
	
	//method getHighest returns the max value of all elements in array
	public static int getHighest(int [] myArray, int size)
	{
		int max = myArray[0];
		
		//loop goes through all elements in the array
		for(int i = 1; i < size; i++)
		{
			//replaces the value of max if current element is greater than current max
			if (max < myArray[i])
				max = myArray[i];
		}
		
		return max;
	}
	
	//method getLowest returns the min value of all elements in array
	public static int getLowest(int [] myArray, int size)
	{
		int min = myArray[0];
		
		//loop goes through all elements in the array
		for(int i = 1; i < size; i++)
		{
			//replaces the value of min if current element is less than current max
			if (min > myArray[i])
				min = myArray[i];
		}
		
		return min;	
	}
	
	//method countOccurrences counts all instances of a target value in the array
	public static int countOccurrences(int [] a, int x, int size)
	{
		int count = 0;
		
		//loop goes through all elements in the array
		for(int i = 0; i < size; i++)
		{
			//if the current element is the same as the target value, update counter
			if (a[i] == x)
				count++;
		}
		
		return count;
	}
	
	//method removeAll removes all instances of a target value in the array
	public static int [] removeAll(int [] newArray, int[] myArray, int x, int size)
	{
		int j = 0;
		
		//loop goes through all elements in the original array
		for(int i = 0; i < size; i++)
		{
			//if current element is not the same as the target value, current element will copy into new array
			if(myArray[i] != x)
			{
				//copy element and update index of new array
				newArray[j] = myArray[i];
				j++;
			}
		}
		
		return newArray;
	}
	
	//method haveSeven returns true if array has exactly three instances of the number seven,
	//given that the 7 is not beside another 7 in the array
	public static boolean haveSeven(int[]myArray, int size)
	{
		int sevens = 0;
		
		//checks all except last element in array to avoid out of bounds error
		for(int i = 0; i < size - 1; i++)
		{
			//checks if current digit is a 7, updates counter if true
			if(myArray[i] == 7)
			{
				sevens++;
				
				//checks if next digit is also a 7, if true, return false
				if (myArray[i+1] == 7)
					return false;
			}
		}
		
		//if 7 appears alone exactly three times, return true, else return false
		if(sevens == 3)
			return true;
		else
			return false;
	}
	
	//method getMedian returns the median of the array
	public static double getMedian(int [] myArray, int size)
	{
		//if the array has an even number of elements, return the average of the two middle elements
		if(size % 2 == 0)
			return (myArray[size/2] + myArray[size/2-1])/2.0;
		
		//else, return the middle element
		else
			return myArray[size/2];
	}

}
