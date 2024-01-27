/*
Jia Gapuz
Math 130-603
Instructor: Professor Mimi Rasky
Date: 03/02/2023
Lab #3
*/
package testing;


import java.util.*;

public class WeirdSum {
	
	public static void main (String[] args)
	{	
		//declare variables
		long num;
		
		int counter = 0, sum = 0, digit;
		
		boolean isNegative = false;
		
		
		//scanner
		Scanner scnr = new Scanner(System.in);
		
		
		
		//prompt user for integer
		System.out.print("Please enter an integer: ");
		num = scnr.nextLong();
		
		//confirm integer input by user
		System.out.println("You entered: " + num);
		
		
		
		//check if input value is negative, calculate absolute value if true
		if (num < 0)
		{
			isNegative = true;
			num = Math.abs(num);
		}
			
		
		//start of loop, keeps going while there are still digits to strip from the integer
		do
		{	//take ones digit
			digit = (int)(num % 10);
			 
			//if current ones digit is odd
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
				
				
				//update counter to reflect how many odd digits are in the user's input
				counter++;
			}
			
			//strip off current ones digit
			num /= 10;
			
		}while (num > 0);
		//end of loop
		
		
		
		//adjust final output, if input was negative, output will also be negative
		if (isNegative == true)
			sum *= -1;
			
		
		//print final sum and number of odd digits
		System.out.println("Your weird odd digit sum is: " + sum);
		System.out.println("The total number of odd digits in your integer is: " + counter);
		
	}

}
