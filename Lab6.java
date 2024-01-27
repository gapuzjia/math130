/*
Jia Gapuz         
Math 130-603  
Instructor: Professor Mimi Rasky         
Date: 3/24/2023      
Lab #6
*/

package testing;

import java.util.*;

public class Lab6 
{
	
	
	public static void main (String [] args)
	{	
		//declare variables
		long num;
		
		//declare scanner
		Scanner scnr = new Scanner(System.in);
		
		
		
		//priming read
		System.out.print("Please enter a long integer (0 to quit): ");
		num = scnr.nextLong();
		
		
		//MAIN LOOP
		while (num != 0)
		{	
			//print user's input
			System.out.println("You entered: " + num);
			
			//invoke and print results of myDifference method
			System.out.println("myDifference(num): " + myDifference(num));
			
			//invoke and print results of nonDecreasing method
			System.out.println("nonDecreasing(num): " + nonDecreasing(num));
			
			System.out.println();
			
			
			//ask for input again, program terminates if user inputs 0
			System.out.print("Please enter a long integer (0 to quit): ");
			num = scnr.nextLong();	
		
		}
		
		
	}
	
	
	public static long myDifference(long num)
	{
		int digit;
		int sum = 0;
		long product = 1;
		
		//should product be declared as a long??????!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		boolean isNegative = false;
		
		//calculate absolute value of num if negative
		if (num < 0)
		{
			isNegative = true;
			num = Math.abs(num);
		}
		
				//start of loop, keeps going while there are still digits to strip from the integer
				do
				{	//take ones digit
					digit = (int)(num % 10);
					 
					//executes if current ones digit is odd
					if (digit % 2 == 1)
					{	
						//if digit is less than 5, multiply by 10 and add to sum
						if (digit < 5)
							sum += digit * 10;
						
						//if digit is exactly 5, add 5 to sum
						else if (digit == 5)
							sum += 5;
						
						//if digit is greater than 5, square the value and add to sum
						else 
							sum += (int)(Math.pow(digit, 2));
					}
					
					//strip off current ones digit
					num /= 10;
					
					//multiply current digit to running product of all digits if digit is non-zero
					if(digit != 0)
						product *= digit;
					
				}while (num > 0);
				//end of loop
		
		//re-adjust product, if original input is negative, product will be negative
		if (isNegative == true)
			product *= -1;
		
		
		//return the difference of the sum and product of num
		return Math.abs(sum - product);
		
	}
	
	public static boolean nonDecreasing(long num)
	{
		int digit;
		
		//return false if input is a single digit
		if (num / 10 == 0)
			return false;
		
		do {
			//strip ones digit
			digit = (int)(num % 10);
			
			//chop off ones digit
			num /= 10;
			

			//compare current ones place digit to succeeding ones place digit
			if (digit < num % 10)
				return false;
		
		} while (num > 0);
		
		
		//will return true if return false is never flagged, meaning the digit is non-decreasing
		return true;
		
	}

}
