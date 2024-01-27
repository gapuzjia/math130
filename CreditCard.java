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

public class CreditCard 
{
	//declare variables
	public double currentBal;
	public double payment;
	public double paymentByStatementDate;
	public double avgDailyBal;
	public double interestRate;
	public double prinPart;
	public double interestAmt;
	public double endingBal;
	public int numDays;
	public int cycles;
	
	//custom constructor
	public CreditCard(double newCurrentBal, double newPayment, int newNumDays, double newInterestRate)
	{
		this.currentBal = newCurrentBal;
		this.payment = newPayment;
		this.numDays = newNumDays;
		this.interestRate = newInterestRate;
	
		//invoke setOthers method
		setOthers();
	}
	
	//method setOthers calculates all other values 
	public void setOthers()
	{
		//declare variables
		final int ZERO = 0;
		final int MONTHS = 12;
		final int CONVERT = 100;
		final int CYCLE = 31;
		
		double monthlyInterestRate, balanceByDays, paymentByStatementDate, subtractStep3fromStep2; 
		
		//calculate monthly decimal interest rate
		monthlyInterestRate = (this.interestRate / CONVERT) / MONTHS; 
		
		//multiply current balance by number of days
		balanceByDays = this.currentBal * CYCLE;
		
		//multiply payment received by number of days
		paymentByStatementDate = this.payment * this.numDays;
		
		//subtract step 3 from step 2
		subtractStep3fromStep2 = balanceByDays - paymentByStatementDate;
		
		//calculate average daily balance
		this.avgDailyBal = subtractStep3fromStep2 / CYCLE;
		
		//calculate amount from payment that is to applied to interest
		this.interestAmt = this.avgDailyBal * monthlyInterestRate;
		
		//calculate principal part
		this.prinPart = this.payment- this.interestAmt;
		
		//calculate final balance
		this.endingBal = this.currentBal - this.prinPart;
		
		//readjustments if payment is greater than current balance
		if (this.payment > this.currentBal)
		{
			this.payment = this.currentBal + this.interestAmt;
			this.prinPart = this.currentBal;
			this.endingBal = ZERO;
		}
		
		//readjustments if interest is greater than payment amount
		if (this.interestAmt > this.payment)
		{
			this.endingBal = this.currentBal + (this.interestAmt - this.payment);
			this.prinPart = ZERO;
		}
	}
	
	//method printCard prints out information of credit card cycle
	public void printCard(PrintWriter p)
	{
		String outputBalance = "Beginning balance:"; 
		String outputPayment = "Payment made:";
		String outputNumDays = "Number of Days before statement:";
		String outputInterestRate = "Annual Interest Rate:";
		String outputAvgDailyBalance = "Average daily balance:";
		String outputPrincipalPart = "Principal:";
		String outputInterestAmt = "Interest:";
		String outputEndingBalance = "Ending balance:";
		String dollar = "  $";
		
		p.printf("%38s%3s%11.2f\n", outputBalance, dollar, this.currentBal);
		p.printf("%38s%3s%11.2f\n", outputPayment, dollar, this.payment);
		p.printf("%38s%3s%11d\n", outputNumDays, dollar, this.numDays);
		p.printf("%38s%3s%11.2f%%\n", outputInterestRate, dollar, this.interestRate);
		p.printf("%38s%3s%11.2f\n", outputAvgDailyBalance, dollar, this.avgDailyBal);
		p.printf("%38s%3s%11.2f\n", outputPrincipalPart, dollar, this.prinPart);
		p.printf("%38s%3s%11.2f\n", outputInterestAmt, dollar, this.interestAmt);
		p.printf("%38s%3s%11.2f\n", outputEndingBalance, dollar, this.endingBal);
	}
}
