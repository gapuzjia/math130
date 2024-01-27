/*
Jia Gapuz
Math 130-603
Instructor: Professor Mimi Rasky
02/09/2023
JavaProject1
*/

package testing;

import java.util.*;

public class Project1
{
	public static void main (String[]args)
	{
		// declare initial values from user input
		double currBalance;
		double paymentAmount; 
		double annInterestRate;
		int paymentDay;
		
		//declare calculated values
		double monthlyInterestRate; 
		double balanceByDays;
		double paymentByStatementDate; 
		double subtractStep3fromStep2; 
		double avgDailyBalance; 
		double interestAmt; 
		double principalPart; 
		double endingBalance;
		
		//scanner
		Scanner scnr = new Scanner(System.in);

		
		
		//USER INPUT
		//input current balance
		System.out.print("Enter current balance in dollars and cents: ");
		currBalance = scnr.nextDouble();
		
		//input payment amount
		System.out.print("Enter the payment made in dollars and cents: ");
		paymentAmount = scnr.nextDouble();
		
		//input payment day
		System.out.print("Enter the days before statement date: ");
		paymentDay = scnr.nextInt();
		
		//input annual interest rate
		System.out.print("Enter annual interest rate in percent form (ex: 8.75): ");
		annInterestRate = scnr.nextDouble();
		
		
		
		//CALCULATIONS
		//calculate monthly decimal interest rate
		monthlyInterestRate = (annInterestRate / 100) / 12; 
		
		//multiply current balance by number of days
		balanceByDays = currBalance * 31;
		
		//multiply payment received by number of days
		paymentByStatementDate = paymentAmount * paymentDay;
		
		//subtract step 3 from step 2
		subtractStep3fromStep2 = balanceByDays - paymentByStatementDate;
		
		//calculate average daily balance
		avgDailyBalance = subtractStep3fromStep2 / 31;
		
		//calculate amount from payment that is to applied to interest
		interestAmt = avgDailyBalance * monthlyInterestRate;
		
		//calculate principal part
		principalPart = paymentAmount - interestAmt;
		
		//calculate final balance
		endingBalance = currBalance - principalPart;
		
		
		
		//PRINT FINAL OUTPUTS
		System.out.println();
		System.out.printf("%49s%11.2f%%\n" , "Annual Interest Rate:    ", annInterestRate);
		System.out.printf("%49s%11.2f\n", "Beginning Balance:   $", currBalance);
		System.out.printf("%49s%11.2f\n", "Amount of payment:   $",  paymentAmount);
		System.out.printf("%49s%11d\n", "Number of days payment made before statement:    ", paymentDay);
		System.out.printf("%49s%11.2f\n", "Average Daily Balance:   $", avgDailyBalance);
		System.out.printf("%49s%11.2f\n", "Amount applied to principal:   $", principalPart);
		System.out.printf("%49s%11.2f\n", "Amount applied to interest:   $", interestAmt);
		System.out.printf("%49s%11.2f\n", "Ending balance:   $", endingBalance);
		
	}

}
