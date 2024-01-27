/*
Jia Gapuz
Math 130-603    
Instructor: Professor Mimi Rasky         
Date 04/21/23  
Lab #9 Part 1
*/

package testing;

import java.io.*;
import java.util.*;

public class Lab9Part1 
{
	
	public static void main(String[]args)throws IOException
	{
		
		//declare variables
		int x;
		
		//declare scanner
		Scanner scnr = new Scanner (System.in);
				
		//declare the array list
		ArrayList <Integer> list = new ArrayList <>();
		ArrayList <Integer> newList = new ArrayList <>();
		ArrayList <Integer> replacedList = new ArrayList <>();
				
		//declare file object and open file
		File file = new File ("C:\\Users\\Jia Gapuz\\Desktop\\dataLab9Spring23.txt");
				
		//check if file exists, program will terminate if file does not exist
		if (!file.exists())
		{
			System.out.println ("The file cannot be found.");
			System.exit(0);
		}
		
		//declare scanner to read file data
		Scanner inputFile = new Scanner (file);
				
		//populate array list
		while (inputFile.hasNext())
			list.add(inputFile.nextInt());
				
		//close file
		inputFile.close();
				
		//declare file write
		PrintWriter outputFile = new PrintWriter("C:\\Users\\Jia Gapuz\\Desktop\\JiaGapuzLab9Part1Output.txt");
		
		//invoke printArray method
		outputFile.println("Here is a print out of your ArrayList:");
		printArray(list, outputFile);
		outputFile.println();

		//invoke and print getTotal method
		outputFile.println("The sum of all the elements in the ArrayList is: " + getTotal(list));
		outputFile.println();
		
		//invoke and print getAverage method
		outputFile.printf("The average of all the elements in the ArrayList is: %.2f\n" , getAverage(list));
		outputFile.println();
		
		//invoke and print getHighest method
		outputFile.println("The max of all the elements in the ArrayList is: " + getHighest(list));
		outputFile.println();
				
		//invoke and print getLowest method
		outputFile.println("The min of all the elements in the ArrayList is: " + getLowest(list));
		outputFile.println();
		
		//invoke and print zeroMax method
		outputFile.println("Invoking the zeroMax method and creating a brand new ArrayList...");
		outputFile.println();
		outputFile.println("Printing out this brand new ArrayList created from the zeroMax method:");
		outputFile.println();
		printArray(zeroMax(list, newList),outputFile);
		outputFile.println();
		
		//invoke and print getAverage method
		outputFile.printf("The average of all the elements in the new zeroMax ArrayList is: %.2f\n" , getAverage(newList));
		outputFile.println();
		
		//prompt user for target value and display user's entered value to console
		outputFile.println("Prompting the user at the keyboard for the target value to search for...");
		System.out.print("Enter the number you would like to look for in the original ArrayList: ");
		x = scnr.nextInt();
		outputFile.println("The value you entered to search for is: " + x);
		
		//invoke and print countOccurences method
		outputFile.println("The number of times the number " + x + " occurs is: " + countOccurences(list, x));
		outputFile.println();
		
		//invoke and print results of first replaceAll method call
		outputFile.println("Now invoking...replaceAll(list, target value you requested)");
		
		//array after replaceAll will display if target value occurs in the array
		if (replaceAll(list,replacedList,x))
		{
			outputFile.println("Here is a printout of the original array with the number " + x + " removed, and replaced with zeroes:");
			printArray(replacedList, outputFile);
		}
		
		//if target value does not exist, array does not print
		else
			outputFile.println("The value of " + x + " was not found in the ArrayList.");
		
		
		//prompt user for target value and display user's entered value to console
		outputFile.println();
		outputFile.println("Prompting the user at the keyboard for the target value to search for...");
		System.out.print("Enter the number you would like to look for in the original ArrayList: ");
		x = scnr.nextInt();
		outputFile.println("The value you entered to search for is: " + x);
		
		//invoke and print countOccurences method
		outputFile.println("The number of times the number " + x + " occurs is: " + countOccurences(list, x));
		outputFile.println();
				
		//invoke and print results of second replaceAll method call
		outputFile.println("Now invoking...replaceAll(list, target value you requested)");
				
		//array after replaceAll will display if target value occurs in the array
		if (replaceAll(list,replacedList,x))
		{
			outputFile.println("Here is a printout of the original array with the number " + x + " removed, and replaced with zeroes:");
			printArray(replacedList, outputFile);
			
		}
				
		//if target value does not exist, array does not print
		else
			outputFile.println("The value of " + x + " was not found in the ArrayList.");
		
		//invoke and print sort method
		outputFile.println();
		Collections.sort(list);
		outputFile.println("Here is a printout of the sorted original ArrayList:");
		printArray(list, outputFile);
		outputFile.println();
		
		//invoke and print getMedian method
		outputFile.printf("The median of the original array is: %.2f" , getMedian(list));
		
		//close output file
		outputFile.close();
				
		//print to console that data was written to file
		System.out.println("Data written to file.");
	}
	
	//method printArray prints all contents of the array
	public static void printArray(ArrayList <Integer> list, PrintWriter p)
	{
		//loop goes through all elements of the array list
		for(int i = 0; i < list.size(); i++)
		{
			p.printf("%5d",list.get(i));
			if ((i+1)%6 == 0)
				p.println();
		}
	}
	
	//method getTotal returns the sum of all elements of the array
	public static int getTotal(ArrayList <Integer> list)
	{
		int sum = 0;
		
		//loop goes through all elements of the array and accumulates to sum
		for(int i = 0; i < list.size(); i++)
			sum += (list.get(i));
		
		return sum;
	}
	
	//method getAverage calculates and returns the average of all elements of the array
	public static double getAverage(ArrayList <Integer> list)
	{
		int sum = 0;
		int ctr = 0;
		
		//loop goes through all elements of the array
		for(int i = 0; i < list.size(); i++)
		{
			//accumulates all numbers to sum, counter keeps track of how many elements are in the array
			sum += (list.get(i));
			ctr++;
		}
		
		//return the average
		return sum / (double)ctr;
	}
	
	//method getHighest return the highest value of all contents of the array
	public static int getHighest(ArrayList <Integer> list)
	{
		//initialize max to first vale of array
		int max = list.get(0);
		
		//loop goes through all elements of the array
		//updates max if current digit is larger than current max
		for(int i = 1; i < list.size(); i++)
		{
			if(list.get(i) > max)
				max = list.get(i);
		}
		
		return max;
		
	}
	
	//method getHighest return the lowest value of all contents of the array
	public static int getLowest (ArrayList <Integer> list)
	{
		//initialize min to first vale of array
		int min = list.get(0);
		
		//loop goes through all elements of the array
		//updates min if current digit is smaller than current min
		for (int i = 1; i < list.size(); i++)
		{
			if(list.get(i) < min)
				min = list.get(i);
		}
		
		return min;
	}
	
	//method zeroMax replaces zeroes with highest odd digit to the right
	//if no odd digits exist, digit will remain zero
	public static ArrayList <Integer> zeroMax (ArrayList <Integer> a, ArrayList <Integer> newList)
	{
		int oddNum;
		
		//loop goes through all elements of the array
		for(int i = 0; i < a.size(); i++)
		{
			//check if current digit is 0
			if(a.get(i) == 0)
			{
				//set oddNum to 0
				oddNum = 0;
				
				//loop goes through the remaining elements in the array
				for(int j = i + 1; j < a.size(); j++)
				{
					//if digit is odd and larger than 0, oddNum is replaced
					if(a.get(j) % 2 == 1 && a.get(j) > oddNum)
						oddNum = a.get(j);
				}
				
				//add oddNum to the new array
				newList.add(oddNum);
			}
			
			//if digit is not 0, copy digit to new array
			else
				newList.add(a.get(i));
		}
		
		//return new array
		return newList;
	}
	
	//method counts how many times a given value occurs in the array
	public static int countOccurences(ArrayList <Integer> a, int x)
	{
		int ctr = 0;
		
		//loop goes through all elements of the array
		for (int i = 1; i < a.size(); i++)
		{
			//if current element is target value, counter is updated
			if(a.get(i) == x)
				ctr++;
		}
		
		return ctr;
	}
	
	//method replaceAll replaces all occurrences of target value with zeroes
	//method returns true if target exists in array, else returns false
	public static boolean replaceAll(ArrayList<Integer> a, ArrayList<Integer> replacedList, int x)
	{
		//populate new array with contents of old array
		for(int i = 0; i < a.size(); i++)
			replacedList.add(a.get(i));
		
		//check if target digit exists in array, if so return true
		if (countOccurences(a, x) > 0)
		{
			//loop goes through all elements of the array
			for (int i = 0; i < a.size(); i++)
			{
				//if current element is the same as target value, replace with zero
				if(a.get(i) == x)
					replacedList.set(i, 0);
			}
			return true;	
		}
		
		//if target digit does not exist in the array, return false
		else
			return false;
	}
	
	//method getMedian returns the median of the array
	public static double getMedian(ArrayList<Integer> list)
	{
		//if number of elements is odd, median is n/2th term
		if (list.size() % 2 == 1)
			return list.get(list.size() / 2 - 1);
		
		//if number of elements is even, median is average of two middle terms
		else
			return (list.get(list.size() / 2-1) + list.get(list.size() / 2)) / 2.0;
	}
}
