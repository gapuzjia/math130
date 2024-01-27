/*
Jia Gapuz         
Math 130-603   
Instructor: Professor Mimi Rasky         
Date: 03/14/2023    
Lab #5
*/
package testing;

import java.util.*;

public class DiceGame
{
	
	public static void main (String[]args)
	{	
		
		//declare variables
		int i, unbiasedComp, unbiasedUser, loadedComp, loadedUser, userSum, compSum;
		int compWins = 0, userWins = 0, tieRounds = 0;
		
		//declare random class
		Random rand = new Random();
		
		//begin loop, this loop iterates 17 times
		for (i=1; i<=17; i++)
		{
			//COMPUTER'S TURN
			System.out.printf("Computer Turn Round #%d \n" , i );
			System.out.printf("-----------------------\n");
			
			//roll and display computer's regular die
			unbiasedComp = rand.nextInt(5)+1;
			System.out.printf("Normal Die: %4d\n", unbiasedComp);
			
			//roll computer's loaded die - will be adjusted based on probabilities
			loadedComp = rand.nextInt(100)+1;
			
			//assign and display computer's loaded die a value from 1-5
			if(loadedComp <= 67)
				loadedComp = 1;
			else if (loadedComp <= 74)
				loadedComp = 2;
			else if (loadedComp <= 82)
				loadedComp = 3;
			else if (loadedComp <= 90)
				loadedComp = 4;
			else
				loadedComp = 5;
			
			System.out.printf("Loaded Die: %4d\n", loadedComp);
			
			
			//calculate and display sum of computer's dice
			compSum = loadedComp + unbiasedComp;
			System.out.printf("       Sum: %4d\n", compSum);
			System.out.println();			
			
			
			
			
			//USER TURN
			System.out.printf("User Turn Round #%d \n" , i );
			System.out.printf("-----------------------\n");
			
			//roll and display user's regular die
			unbiasedUser = rand.nextInt(5)+1;
			System.out.printf("Normal Die: %4d\n", unbiasedUser);
			
			//roll user's loaded die - will be adjusted based on probabilities
			loadedUser = rand.nextInt(100)+1;
			
			//assign and display user's loaded die a value from 1-5
			if(loadedUser <= 67)
				loadedUser = 1;
			else if (loadedUser <= 74)
				loadedUser = 2;
			else if (loadedUser <= 82)
				loadedUser = 3;
			else if (loadedUser <= 90)
				loadedUser = 4;
			else
				loadedUser = 5;
			
			System.out.printf("Loaded Die: %4d\n", loadedUser);
			
			
			//calculate and display sum of user's dice
			userSum = loadedUser + unbiasedUser;
			System.out.printf("       Sum: %4d\n", userSum);
			System.out.println();
			
			
			//compare sums
			if (compSum > userSum)
			{
				System.out.println("The Computer wins this round!!!!!");
				compWins++;
			}
			else if (userSum > compSum)
			{
				System.out.println("The User wins this round!!!!!");
				userWins++;
			}
			else
			{
				System.out.println("It's a tie!!!!!");
				tieRounds++;
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			
		}
		
		
		//print results of all 17 rounds
		System.out.println("-----------------------------------");
		System.out.printf("Total number of Computer Wins: %3d\n" , compWins);
		System.out.printf("    Total number of User Wins: %3d\n" , userWins);
		System.out.printf("    Total number of tie games: %3d\n" , tieRounds);
		System.out.println();
		
		//print winner based on number of wins
		if(compWins == userWins)
			System.out.println("TIE GAME!!! Nobody wins this game, sorry.");
		else if(compWins > userWins)
			System.out.println("The Computer is the GRAND CHAMPION!!!!!");
		else
			System.out.println("The User is the GRAND CHAMPION!!!!!");
		
	}

}
