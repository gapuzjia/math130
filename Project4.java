/*
Jia Gapuz        
Math 130-603   
Instructor: Professor Mimi Rasky         
Date: 04/13/2023  
Java Project #4
*/
package testing;

import java.io.*;
import java.util.*;

public class Project4 {
	
	public static void main(String[]args) throws IOException
	{
		//declare final variables
		final int ZERO = 0;
		final int MONTHS = 12;
		final int CONVERT = 100;
		final int CYCLE = 31;
		
		//declare and initialize counter
		int ctr = ZERO;
		
		//declare calculated values
		double monthlyInterestRate, balanceByDays, paymentByStatementDate, subtractStep3fromStep2; 
		
		//declare arrays and allocate a length of 50
		double currentBal[] = new double [50], payment[] = new double [50], interestRate[] = new double [50];
		double avgDailyBal[] = new double [50], prinPart[] = new double [50];
		double interestAmt[] = new double [50], endingBal[] = new double [50];
		int numDays[] = new int [50];
		
		//declare strings
		String outputAccCurrBalance = "Total of beginning balances:"; 
		String outputAccPaymentAmount = "Total of payments:";
		String outputAccAvgDailyBalance = "Total of average daily balances:";
		String outputAccPrincipalPart = "Total of average daily balances:";
		String outputAccInterestAmt = "Total of amounts applied to principal:";
		String outputAccEndingBalance = "Total of ending balances:";
		String outputNumCardsProcessed = "Number of credit card statements processed: ";
		String dollar = "  $";
		String outputHeader1 = "Int Rate          Begin            Pmt     Average Daily";
		String outputHeader2 = "Days Before       Princ       Interest         EndBal";
		String outputTotals = "Totals: ";
		
		//invoke method getData which populates the arrays and returns the number of cycles in the file
		ctr = getData(currentBal, payment, interestRate, numDays);
		
		//CALCULATIONS
		for (int i = 0; i < ctr; i++)
		{
			//calculate monthly decimal interest rate
			monthlyInterestRate = (interestRate[i] / CONVERT) / MONTHS; 
			
			//multiply current balance by number of days
			balanceByDays = currentBal[i] * CYCLE;
			
			//multiply payment received by number of days
			paymentByStatementDate = payment[i] * numDays[i];
			
			//subtract step 3 from step 2
			subtractStep3fromStep2 = balanceByDays - paymentByStatementDate;
			
			//calculate average daily balance
			avgDailyBal[i] = subtractStep3fromStep2 / CYCLE;
			
			//calculate amount from payment that is to applied to interest
			interestAmt[i] = avgDailyBal[i] * monthlyInterestRate;
			
			//calculate principal part
			prinPart[i] = payment[i] - interestAmt[i];
			
			//calculate final balance
			endingBal[i] = currentBal[i] - prinPart[i];
			
			//readjustments if payment is greater than current balance
			if (payment[i] > currentBal[i])
			{
				payment[i] = currentBal[i] + interestAmt[i];
				prinPart[i] = currentBal[i];
				endingBal[i] = ZERO;
			}
			
			//readjustments if interest is greater than payment amount
			if (interestAmt[i] > payment[i])
			{
				endingBal[i] = currentBal[i] + (interestAmt[i] - payment[i]);
				prinPart[i] = ZERO;
			}
			
			//ACCUMULATORS
			currentBal[ctr] += currentBal[i];
			payment[ctr] += payment[i];
			avgDailyBal[ctr] += avgDailyBal[i];
			prinPart[ctr] += prinPart[i];
			interestAmt[ctr] += interestAmt[i];
			endingBal[ctr] += endingBal[i];
			
		}
		
		//call print totals method
		printTotals(outputAccCurrBalance, outputAccPaymentAmount, outputAccAvgDailyBalance,
				outputAccPrincipalPart, outputAccInterestAmt, outputAccEndingBalance, outputNumCardsProcessed, dollar,
				currentBal, payment, avgDailyBal, prinPart, interestAmt, endingBal, ctr);
		
		//call print report method
		printReport(currentBal, payment, avgDailyBal, prinPart, interestAmt, endingBal, ctr, interestRate, numDays,
				outputHeader1, outputHeader2, outputTotals, outputNumCardsProcessed);
	}
	//END OF MAIN METHOD
	
	
	//method getData populates arrays with data from file and returns the number of credit card cycles in the file
	public static int getData(double currentBal[], double payment[], double interestRate[], int numDays[]) throws IOException
	{
		int i = 0;
		
		//declare file object and open file
		File file = new File ("C:\\Users\\Jia Gapuz\\Desktop\\creditCardDataProject4.txt");
		
		//check if file exists, program will terminate if file does not exist
		if (!file.exists())
		{
			System.out.println ("The file cannot be found.");
			System.exit(0);
		}	
				
		//declare scanner to read file data
		Scanner inputFile = new Scanner (file);
		
		//loop populates the arrays
		while (inputFile.hasNext())
		{
			currentBal[i] = inputFile.nextDouble();
			payment[i] = inputFile.nextDouble();
			numDays[i] = inputFile.nextInt();
			interestRate[i] = inputFile.nextDouble();
		
			i++;
		}
		
		//close file
		inputFile.close();
		
		//return number of cycles
		return i;
	}
	
	//method printTotals prints values of accumulators
	public static void printTotals(String outputAccCurrBalance, String outputAccPaymentAmount, String outputAccAvgDailyBalance,
		String outputAccPrincipalPart, String outputAccInterestAmt, String outputAccEndingBalance, String outputNumCardsProcessed,
		String dollar, double currentBal[], double payment[], double avgDailyBal[], double prinPart[], 
		double interestAmt[], double endingBal[], int ctr)
	{
		
		System.out.printf("%38s%3s%11.2f\n", outputAccCurrBalance, dollar, currentBal[ctr]);
		System.out.printf("%38s%3s%11.2f\n", outputAccPaymentAmount, dollar, payment[ctr]);
		System.out.printf("%38s%3s%11.2f\n", outputAccAvgDailyBalance, dollar, avgDailyBal[ctr]);
		System.out.printf("%38s%3s%11.2f\n", outputAccPrincipalPart, dollar, prinPart[ctr]);
		System.out.printf("%38s%3s%11.2f\n", outputAccInterestAmt, dollar, interestAmt[ctr]);
		System.out.printf("%38s%3s%11.2f\n", outputAccEndingBalance, dollar, endingBal[ctr]);
		System.out.println();
		System.out.printf("%43s%8d\n", outputNumCardsProcessed, ctr);
		
	}
	
	//method printReport 
	public static void printReport(double currentBal[], double payment[], double avgDailyBal[], double prinPart[], 
			double interestAmt[], double endingBal[], int ctr, double interestRate[], int numDays[],
			String outputHeader1, String outputHeader2, String outputTotals, String outputNumCardsProcessed) throws IOException
	{
		//declare file write
		PrintWriter outputFile = new PrintWriter("C:\\Users\\Jia Gapuz\\Desktop\\JiaGapuzProject4OutputFile.txt");
		
		//print header for first table of values
		outputFile.println(outputHeader1);
		
		//print contents of table (interest rates, current balances, payment amounts, and average daily balances)
		for (int i = 0; i < ctr; i++)
			outputFile.printf("%8.2f%15.2f%15.2f%15.2f\n", interestRate[i], currentBal[i], payment[i],avgDailyBal[i]);

		//print accumulator values (current balances, payment amounts, and average daily balances)
		outputFile.printf("%-8s%15.2f%15.2f%15.2f\n",  outputTotals, currentBal[ctr], payment[ctr],avgDailyBal[ctr]);
		outputFile.println();
		
		//print header for next table of values
		outputFile.println(outputHeader2);
		
		//print contents of table (number of days, principal part, interest amounts, and ending balances)
		for (int i = 0; i < ctr; i++)
			outputFile.printf("%5d%18.2f%15.2f%15.2f\n", numDays[i], prinPart[i], interestAmt[i], endingBal[i]);
		
		//print accumulator values (principal part, interest amounts, ending balances)
		outputFile.printf("%5s%15.2f%15.2f%15.2f\n",  outputTotals, prinPart[ctr], interestAmt[ctr], endingBal[ctr]);
		outputFile.println();
		
		//print number of cards processed
		outputFile.println(outputNumCardsProcessed + ctr);
		
		//close output file
		outputFile.close();
	}
}