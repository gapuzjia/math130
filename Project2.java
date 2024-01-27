/*
Jia Gapuz
Math 130-603
Instructor: Professor Mimi Rasky
02/09/2023
JavaProject2
*/
package testing;

import java.util.Scanner;

public class Project2 
{
	public static void main (String[]args)
	{
		// declare initial values from user input
		double currBalance, paymentAmount, annInterestRate;
		int paymentDay;
		
		//declare strings
		String inputCurrBalance = "Enter current balance in dollars and cents: ";
		String inputPayment = "Enter the payment made in dollars and cents: ";
		String inputDays = "Enter the days before statement date: ";
		String inputInterest = "Enter annual interest rate in percent form (ex: 8.75): ";
		String outputAnnInt = "Annual Interest Rate:";
		String outputBegBal = "Beginning Balance:";
		String outputAmtPay = "Amount of payment:";
		String outputNumDays = "Number of days payment made before statement:";
		String outputAvgBal = "Average Daily Balance:";
		String outputAmtPrinc = "Amount applied to principal:";
		String outputAmtInt = "Amount applied to interest:";
		String outputEndBal = "Ending balance:";
		String outputNumProcessed = "Number of credit card statements processed:";
		
		String dollar = "$";
		
		//declare final variables
		final int ZERO = 0;
		final int MONTHS = 12;
		final int CONVERT = 100;
		final int CYCLE = 31;
		
		//declare calculated values
		double monthlyInterestRate, balanceByDays, paymentByStatementDate, subtractStep3fromStep2; 
		double avgDailyBalance, interestAmt, principalPart, endingBalance;
		
		//scanner
		Scanner scnr = new Scanner(System.in);
		
		//counter
		int counter = ZERO;
		
		
		//USER INPUT
		//input current balance, that is, the  priming read
		System.out.print(inputCurrBalance);
		currBalance = scnr.nextDouble();
		
		while (currBalance > ZERO) 
		{
			//input payment amount
			System.out.print(inputPayment);
			paymentAmount = scnr.nextDouble();
			
			//input payment day
			System.out.print(inputDays);
			paymentDay = scnr.nextInt();
			
			//input annual interest rate
			System.out.print(inputInterest);
			annInterestRate = scnr.nextDouble();
			
			//update counter
			counter++;
			
			
			//CALCULATIONS
			//calculate monthly decimal interest rate
			monthlyInterestRate = (annInterestRate / CONVERT) / MONTHS; 
			
			//multiply current balance by number of days
			balanceByDays = currBalance * CYCLE;
			
			//multiply payment received by number of days
			paymentByStatementDate = paymentAmount * paymentDay;
			
			//subtract step 3 from step 2
			subtractStep3fromStep2 = balanceByDays - paymentByStatementDate;
			
			//calculate average daily balance
			avgDailyBalance = subtractStep3fromStep2 / CYCLE;
			
			//calculate amount from payment that is to applied to interest
			interestAmt = avgDailyBalance * monthlyInterestRate;
			
			//calculate principal part
			principalPart = paymentAmount - interestAmt;
			
			//calculate final balance
			endingBalance = currBalance - principalPart;
			
			//readjustments if payment is greater than current balance
			if (paymentAmount > currBalance)
			{
				paymentAmount = currBalance + interestAmt;
				principalPart = currBalance;
				endingBalance = ZERO;
			}
			
			//PRINT FINAL OUTPUTS
			System.out.println();
			System.out.printf("%45s%15.2f%%\n" , outputAnnInt, annInterestRate);
			System.out.printf("%45s%4s%11.2f\n", outputBegBal, dollar, currBalance);
			System.out.printf("%45s%4s%11.2f\n", outputAmtPay, dollar, paymentAmount);
			System.out.printf("%45s%15d\n", outputNumDays, paymentDay); 
			System.out.printf("%45s%4s%11.2f\n", outputAvgBal, dollar, avgDailyBalance);
			System.out.printf("%45s%4s%11.2f\n", outputAmtPrinc, dollar, principalPart);
			System.out.printf("%45s%4s%11.2f\n", outputAmtInt, dollar, interestAmt);
			System.out.printf("%45s%4s%11.2f\n", outputEndBal, dollar, endingBalance);
			System.out.println();
			
			//input current balance 
			System.out.print(inputCurrBalance);
			currBalance = scnr.nextDouble();
		}
		
		System.out.printf("%42s%17d",outputNumProcessed, counter);
		
	}
}
