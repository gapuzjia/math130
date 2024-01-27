/*
Jia Gapuz         
Math 130-603   
Instructor: Professor Mimi Rasky         
Date: 03/08/2023    
Lab #4
*/


package testing;

public class MultTable 
{
	public static void main (String[]args)
	{	
		
		//declare variables
		final int MAX = 15;
		int row, i, column;

		
		
		//additional padding for factors on top row for alignment
		System.out.print("    ");
		
		//print factors on top row 
		for(i = 0; i <= MAX; i++)
			System.out.printf("%4d" , i);
		
		//new line
		System.out.println();
		
		
		
		//print dashes for border on top row 
				for(i = 0; i <= MAX+1; i++)
					System.out.printf("----");
		
		//new line
		System.out.println();
		
		
		
		//outer loop, ends when the max factor (in this case, 15) is reached
		for (row = 0; row <= MAX; row++)
		{
			//print the factors and border in the first column
			System.out.printf("%2d |",row);
			
			//print the spaces before the products
			for(i = 0; i < row; i++)
				System.out.print("    ");
			
			//set the first value of the column to the current row value
			column = row;
			
			//print products ranging from current row to 15
			for(i = row; i <= MAX; i++)
			{	
				System.out.printf("%4d" , row * column);
				column++;
			}
			
			//new line
			System.out.println();
			
		}
		//end of outer loop
		
	}

}
