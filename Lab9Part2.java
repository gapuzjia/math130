/*
Jia Gapuz
Math 130-603    
Instructor: Professor Mimi Rasky         
Date 04/21/23  
Lab #9 Part 2
*/

package testing;

import javax.swing.*;

public class Lab9Part2 
{
	
	public static void main (String[]args)
	{
		String password;
		
		//dialog box for user input
		password = JOptionPane.showInputDialog("Please enter a password that is at least 7 characters where:\n "
				+ "- The first two are digits \n"
				+ "- The third character is one is one of the following symbols: '∼', '&', '*', '(', or a ')'\n "
				+ "- The remaining characters are anything you like, with at least one uppercase and one lowercase letter.");
		
		
		//invoke isValid method and display dialogue box if password is valid or not
		if(isValid(password))
			JOptionPane.showMessageDialog(null, "Your password: " + password + " is a valid password.");
		else
			JOptionPane.showMessageDialog(null, "Your password: " + password + " is not a valid password.");
		
		
	}
	
	//isValid method validates password
	public static boolean isValid(String password)
	{
		//declare variables
		boolean goodSoFar = true;
		int i = 0;
		int upperCtr = 0;
		int lowerCtr = 0;
		
		//check if password is at least 7 characters long, else set flag to false
		if (password.length() < 6)
			goodSoFar = false;
		
		//check if first two characters are digits, else set flag to false
		{
			if(!Character.isDigit(password.charAt(i)))
				goodSoFar = false;
			i++;
		}
		
		//check if third character is one of the specified special characters,  else set flag to false
		if(password.charAt(2) != '∼' && password.charAt(2) != '&' && password.charAt(2) != '*' 
				&& password.charAt(2) != '(' && password.charAt(2) != ')')
			goodSoFar = false;
		
		//check if remaining character contain uppercase or lowercase letters
		for(i = 3; i < password.length(); i++)
		{
			if(Character.isUpperCase(password.charAt(i)))
				upperCtr++;
			
			if(Character.isLowerCase(password.charAt(i)))
				lowerCtr++;
		}
		
		//if there are no uppercase or no lowercase letters, set flag to false
		if(upperCtr == 0 || lowerCtr == 0)
			goodSoFar = false;
		
		return goodSoFar;
	}

}
