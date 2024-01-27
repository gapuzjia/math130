/*
Jia Gapuz         
Math 130-603   
Instructor: Professor Mimi Rasky         
Date 5/11/2023
Lab #11
*/
package testing;

import java.util.*;


public class Lab11TestDriver 
{
     public static void main(String[] args)
    {
    	 Random random = new Random();
         int  nNumCircle = random.nextInt(10)+ 1;
         int   nNumRectangle = random.nextInt(10)+ 1;
         int   nNumSquare = random.nextInt(10)+ 1;
         int nNumShape = random.nextInt(10)+ 1;
         int  totalNum = nNumCircle + nNumRectangle + nNumSquare + nNumShape;

      Shape[]  shapeList = new Shape[totalNum];
	  Shape s0 = new Shape();
	  System.out.println(s0);
	  s0.setColor("blue");
	  s0.setFilled(false);
      System.out.println(s0);
	  System.out.println("s0.getColor(): " +  s0.getColor());
      System.out.println("s0.isFilled(): " + s0.isFilled());

	  Shape s1 = new Circle(5.5, "red", false);  // Upcast Circle to Shape
          System.out.println(s1);                    
          System.out.println("s1.getArea(): " +    ((Circle)s1).getArea());     //cast s1 as a Circle to access getArea method
          System.out.println("s1.getColor(): " +   s1.getColor());
          System.out.println("s1.isFilled(): " +   s1.isFilled());
          System.out.println("s1.getRadius(): " +  ((Circle)s1).getRadius());   //cast s1 as a Circle to access geRadius method

	  Circle c1 = (Circle)s1;                   // Downcast back to Circle
	  System.out.println(c1);
	  System.out.println("c1.getArea(): " +   c1.getArea());
	  System.out.println("c1.getColor():" +   c1.getColor());
	  System.out.println("c1.isFilled(): " +  c1.isFilled());
	  System.out.println("c1.getRadius(): " + c1.getRadius());
          c1.setRadius(-2);

	  Shape s2 = new Shape();

	  Shape s3 = new Rectangle(1.0, 2.0, "red", false);   // Upcast
	  System.out.println(s3);
	  System.out.println("s3.getArea(): " +    ((Rectangle)s3).getArea());  //cast s3 as a Rectangle to access getArea method
	  System.out.println("s3.getColor(): " +   s3.getColor());
	  System.out.println("s3.getLength(): " +  ((Rectangle)s3).getLength());  //cast s3 as a Rectangle to access getLength method

	  Rectangle r1 = (Rectangle)s3;   // downcast
	  System.out.println(r1);
	  System.out.println("r1.getArea(): "   + r1.getArea());
	  System.out.println("r1.getColor): "   + r1.getColor());
	  System.out.println("r1.getLength(): " + r1.getLength());

	  Shape s4 = new Square(6.6);     // Upcast
	  System.out.println(s4);
	  System.out.println("s4.getArea(): " +  ((Square)s4).getArea());  //cast s4 as a Square to access getArea method
	  System.out.println("s4.getColor(): " + s4.getColor());
	  System.out.println("s4.getSide(): " +  ((Square)s4).getSide());	 //cast s4 as a Square to access getSide method

	  // Take note that we downcast Shape s4 to Rectangle,
	  //  which is a superclass of Square, instead of Square
	  Rectangle r2 = (Rectangle)s4;
	  System.out.println(r2);
	  System.out.println("r2.getArea(): " +  r2.getArea());
	  System.out.println("r2.getColor(): " + r2.getColor());
	  System.out.println("r2.getSide(): " +  ((Square)r2).getSide());	 //cast r2 as a Square to access getSide method

	  System.out.println("r2.getLength(): " + r2.getLength());
	  // Downcast Rectangle r2 to Square
		  Square sq1 = (Square)r2;
		  System.out.println(sq1);
		  System.out.println("sq1.getArea(): " + sq1.getArea());
		  System.out.println("sq1.getColor(): " + sq1.getColor());
		  System.out.println("sq1.getSide(): " + sq1.getSide());
		  System.out.println("sq1.getLength(): " + sq1.getLength());
	          System.out.println("Invoking sq1.setSide(4.0): ");

		  sq1.setSide(4.0);
		  System.out.println("sq1.getSide(): " + sq1.getSide());
		  System.out.println("sq1.getLength(): " + sq1.getLength());
	          System.out.println("Invoking sq1.setLength(-2.0): ");
	          sq1.setLength(-2.0);
	          System.out.println("sq1.getLength(): " + sq1.getLength());
	          System.out.println("Invoking sq1.setLength(11.0): ");
	          sq1.setLength(11.0);
	          System.out.println("sq1.getLength(): " + sq1.getLength());
	          System.out.println("Invoking sq1.setWidth(-3.0): ");
	          sq1.setWidth(-3.0);
	          System.out.println("sq1.getWidth(): " + sq1.getWidth());
	          System.out.println("Invoking sq1.setWidth(6.0): ");
	          sq1.setWidth(6.0);
	          System.out.println("sq1.getWidth(): " + sq1.getWidth());

	         //populate the array with some Circles
	          for ( int i = 0 ; i < nNumCircle ; i++ )
	          {
	            shapeList[i] = new Circle(Math.random() * 5.0);
	          }
	            //populate the array with some Rectangles
	          for ( int j = nNumCircle ; j < (totalNum - nNumSquare - nNumShape); j++ )
	          {
	            shapeList[j] = new Rectangle(Math.random()*4.0, Math.random()*6.0);
	          }
	           //populate the array with some Squares
	          for ( int k = totalNum - nNumSquare - nNumShape ; k < totalNum - nNumShape; k++ )
	          {
	            shapeList[k] = new Square(Math.random()*5.0);
	          }
	          for(int m = totalNum - nNumShape; m < totalNum; m++)
	          {
	            shapeList[m] = new Shape("red", true);
	          }
	          System.out.println();
	          printList(shapeList);
	          System.out.println();

	          System.out.println("Invoking the printType() method: ");
	          printType(shapeList); //you need to write the code for this method

	    }//end main
	    public static void printList(Shape[] list)
	    {
	           System.out.printf("===List===:\n");
	           for ( int i = 0 ; i < list.length ; i++ )
	           {
	                 System.out.printf("%d: %s\n",  i, list[i]);//invoke .toString for each element
	           }
	     }
		
	    //printType method traverses the array of Shapes and prints the class of shape and its color
		public static void printType(Shape[] list)
	 	{
			for(int i = 0; i < list.length; i++)
			{
				if(list[i] instanceof Square)
					System.out.printf("It's a %s Square!\n", list[i].getColor());
				
				else if (list[i] instanceof Rectangle)
					System.out.printf("It's a %s Rectangle!\n", list[i].getColor());
				
				else if (list[i] instanceof Circle)
					System.out.printf("It's a %s Circle!\n", list[i].getColor());
				
				else
					System.out.printf("It's a %s Shape!\n", list[i].getColor());
			}
	    }
		
	}//end class

