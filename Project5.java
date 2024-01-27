/*
Jia Gapuz        
Math 130-603 
Instructor: Professor Mimi Rasky         
Date: 05/05/2023  
Java Project #5
*/

package testing;

import java.io.*;
import java.util.*;

public class Project5 
{
	public static void main(String[]args) throws IOException
	{
		//declare Array list of credit cards
		ArrayList <CreditCard> card = new ArrayList<CreditCard>();
		
		//invoke getInput method
		getInput(card);
		
		//invoke printOut method
		printOut(card);
	
	}
	
	//method getInput takes input from file read and stores info in array of credit card objects
	public static void getInput(ArrayList <CreditCard> card)throws IOException
	{
		//declare variables
		double currentBal, payment, interestRate;
		int numDays;
		
		//declare file object and open file
		File file = new File ("C:\\Users\\Jia Gapuz\\Desktop\\creditCardDataProject5.txt");
		
		//check if file exists, program will terminate if file does not exist
		if (!file.exists())
		{
			System.out.println ("The file cannot be found.");
			System.exit(0);
		}	
		
		//declare scanner to read file data
		Scanner inputFile = new Scanner (file);
				
		//loop takes in information from file read
		while (inputFile.hasNext())
		{
		currentBal = inputFile.nextDouble();
		payment = inputFile.nextDouble();
		numDays = inputFile.nextInt();
		interestRate = inputFile.nextDouble();
		
		//creates a new credit card object and adds to array list
		card.add(new CreditCard(currentBal, payment, numDays, interestRate));
		}
		
		//close file
		inputFile.close();
	}
	
	//method printOut writes information to file
	public static void printOut(ArrayList <CreditCard> card)throws IOException
	{
		//declare variables
		double accCurrentBal = 0,accPayment = 0, accAvgDailyBal = 0; 
		double accPrinPart = 0, accInterestAmt = 0, accEndingBal = 0;
		
		//declare strings 
		String outputAccCurrBalance = "Total of beginning balances:"; 
		String outputAccPaymentAmount = "Total of payments:";
		String outputAccAvgDailyBalance = "Total of average daily balances:";
		String outputAccPrincipalPart = "Total of average daily balances:";
		String outputAccInterestAmt = "Total of amounts applied to principal:";
		String outputAccEndingBalance = "Total of ending balances:";
		String outputNumCardsProcessed = "Number of credit card statements processed: ";
		String dollar = "  $";
		
		//declare file write
		PrintWriter outputFile = new PrintWriter("C:\\Users\\Jia Gapuz\\Desktop\\JiaGapuzJavaProject5Output.txt");
		
		//loop traverses the array list of credit cards
		//all "print" comments refer to writing to file
		for(int i = 0; i < card.size(); i++)
		{
			//print header for credit card statement
			outputFile.println("Credit Card Statement #" + (i + 1));
			outputFile.println();
			
			//invoke printCard method on current credit card
			card.get(i).printCard(outputFile);
			outputFile.println();
			
			//update accumulators
			accCurrentBal += card.get(i).currentBal;
			accPayment += card.get(i).payment;
			accAvgDailyBal += card.get(i).avgDailyBal;
			accPrinPart  += card.get(i).prinPart;
			accInterestAmt += card.get(i).interestAmt;
			accEndingBal += card.get(i).endingBal;
		}
		
		//print values from accumulators
		outputFile.println();
		outputFile.printf("%43s%3s%11.2f\n", outputAccCurrBalance, dollar, accCurrentBal);
		outputFile.printf("%43s%3s%11.2f\n", outputAccPaymentAmount, dollar, accPayment);
		outputFile.printf("%43s%3s%11.2f\n", outputAccAvgDailyBalance, dollar, accAvgDailyBal);
		outputFile.printf("%43s%3s%11.2f\n", outputAccPrincipalPart, dollar, accPrinPart);
		outputFile.printf("%43s%3s%11.2f\n", outputAccInterestAmt, dollar, accInterestAmt);
		outputFile.printf("%43s%3s%11.2f\n", outputAccEndingBalance, dollar, accEndingBal);
		outputFile.printf("%43s%13d\n", outputNumCardsProcessed, card.size());
		
		//close output file
		outputFile.close();	
		
		//print message to console
		System.out.println("Data written to file.");
	}
}
