package testing;

import java.util.*;


public class midterm3practice 
{
	public static void main (String[]args)
	{
		ArrayList <String> ralist = new ArrayList <String>();
		
		String target;
		
		Scanner scnr = new Scanner(System.in);
		
		ralist.add("apple");
		ralist.add("banana");
		ralist.add("dates");
		ralist.add("elderberries");
		ralist.add("figs");
		ralist.add("grapes");
		ralist.add("honeydew");
		ralist.add("lemons");
		ralist.add("mangos");
		ralist.add("nectarines");
		
		System.out.print("enter target: ");
		target = scnr.nextLine();
		
		moveIt(ralist, target);
		
		System.out.println(ralist);
		
	}
	
	public static void moveIt(ArrayList<String> list, String target)
	{
		int x;
		
		x = list.indexOf(target);
		
		if(x - 2 < 0)
			x = 0;
		else
			x -= 2;
		
		list.remove(target);
		
		list.add(x, target);
		
	}
	
	


}
