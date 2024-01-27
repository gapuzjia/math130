/*
Jia Gapuz         
Math 130-603   
Instructor: Professor Mimi Rasky         
Date: 03/30/2023 
Java Project 3
*/

package testing;

import java.util.*;

public class Project3 
{
	
	public static void main (String[]args)
	{
		//declare final variables
		final int ZERO = 0;
		final int MONTHS = 12;
		final int CONVERT = 100;
		final int CYCLE = 31;
		
		// declare variables
		double currBalance, paymentAmount, annInterestRate;
		int paymentDay;
		
		
		
		//declare calculated values
		double monthlyInterestRate, balanceByDays, paymentByStatementDate, subtractStep3fromStep2; 
		double avgDailyBalance, interestAmt, principalPart, endingBalance;
		
		//declare and initialize accumulators
		double accCurrBalance = ZERO, accPaymentAmount = ZERO, accAvgDailyBalance = ZERO;
		double accPrincipalPart = ZERO, accInterestAmt = ZERO, accEndingBalance = ZERO;
		
		//declare and initialize cycle counter
		int counter = ZERO;
		
		
		
		//input current balance, that is, the priming read
		currBalance = getCurrBalance();
				
		while (currBalance > ZERO)
		{
			paymentAmount = getPaymentAmount();
			paymentDay = getPaymentDay();
			annInterestRate = getAnnInterestRate();

			
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
			
			
			//readjustments if interest is greater than payment amount
			if (interestAmt > paymentAmount)
			{
				endingBalance = currBalance + (interestAmt - paymentAmount);
				principalPart = ZERO;
			}
			
			
			//update accumulators and cycle counter
			accCurrBalance += currBalance; 
			accPaymentAmount += paymentAmount; 
			accAvgDailyBalance += avgDailyBalance;
			accPrincipalPart += principalPart; 
			accInterestAmt += interestAmt; 
			accEndingBalance += endingBalance;
			counter++;
			
			//invoke print calculations method
			printCalculations(annInterestRate, currBalance, paymentAmount, paymentDay, 
					avgDailyBalance, principalPart, interestAmt, endingBalance);
			
			
			//ask user for current balance of new cycle, loop will terminate if 0
			currBalance = getCurrBalance();
			
		}
		
		//invoke print accumulators method
		printAccumulators(accCurrBalance, accPaymentAmount, accAvgDailyBalance, accPrincipalPart, 
						accInterestAmt,accEndingBalance, counter);
		
		
	}
	//END OF MAIN METHOD
	
	
	
	//method captures current balance
	public static double getCurrBalance()
	{
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("Enter current balance in dollars and cents: ");
		return scnr.nextDouble();
	}
	
	
	//method captures payment amount
	public static double getPaymentAmount()
	{
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("Enter the payment made in dollars and cents: ");
		return scnr.nextDouble();
	}
	
	
	//method captures days before statement
	public static int getPaymentDay()
	{
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("Enter the days before statement date: ");
		return scnr.nextInt();
	}
	
	
	//method captures annual interest rate
	public static double getAnnInterestRate()
	{
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("Enter annual interest rate in percent form (ex: 8.75): ");
		return scnr.nextDouble();
	}
	
	//method prints calculations
	public static void printCalculations(double annInterestRate, double currBalance, double paymentAmount, int paymentDay, 
							double avgDailyBalance, double principalPart, double interestAmt, double endingBalance)
	{
		
		//declare strings for calculation outputs
		String outputAnnInt = "Annual Interest Rate:";
		String outputBegBal = "Beginning Balance:";
		String outputAmtPay = "Amount of payment:";
		String outputNumDays = "Number of days payment made before statement:";
		String outputAvgBal = "Average Daily Balance:";
		String outputAmtPrinc = "Amount applied to principal:";
		String outputAmtInt = "Amount applied to interest:";
		String outputEndBal = "Ending balance:";
		
		String dollar = "$";
		
		//print calculation outputs
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
	}
	
	//method prints accumulated values
	public static void printAccumulators(double accCurrBalance, double accPaymentAmount, double accAvgDailyBalance, 
					double accPrincipalPart, double accInterestAmt, double accEndingBalance, int counter)
	{
		//declare strings for accumulators' outputs
		String outputAccCurrBalance = "Total of beginning balances:"; 
		String outputAccPaymentAmount = "Total of payments:";
		String outputAccAvgDailyBalance = "Total of average daily balances:";
		String outputAccPrincipalPart = "Total of average daily balances:";
		String outputAccInterestAmt = "Total of amounts applied to principal:";
		String outputAccEndingBalance = "Total of ending balances:";
		String outputNumCardsProcessed = "Number of credit card statements processed:";
		String dollar = "  $";
		
		//print accumulations
		System.out.println();
		System.out.printf("%38s%3s%11.2f\n", outputAccCurrBalance, dollar, accCurrBalance);
		System.out.printf("%38s%3s%11.2f\n", outputAccPaymentAmount, dollar, accPaymentAmount);
		System.out.printf("%38s%3s%11.2f\n", outputAccAvgDailyBalance, dollar, accAvgDailyBalance);
		System.out.printf("%38s%3s%11.2f\n", outputAccPrincipalPart, dollar, accPrincipalPart);
		System.out.printf("%38s%3s%11.2f\n", outputAccInterestAmt, dollar, accInterestAmt);
		System.out.printf("%38s%3s%11.2f\n", outputAccEndingBalance, dollar, accEndingBalance);
		System.out.println();
		System.out.printf("%43s%9d\n", outputNumCardsProcessed, counter);
	}	
}
