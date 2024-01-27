/*
Jia Gapuz      
Math 130-603  
Instructor: Professor Mimi Rasky         
Date 05/19/2023
Lab #12
*/
package testing;

import java.util.*;
import java.io.*;

public class Lab12TestDriver
{
     public static void main(String[] args)
     {
    	 ArrayList<Shape> sList = new ArrayList<Shape>();
         ArrayList<Volume> vList = new ArrayList<Volume>();
         ArrayList<Area> aList = new ArrayList<Area>();
         
         Volume v1 = new Sphere(5, "Purple", true);     // upcast
         vList.add(v1);
         sList.add((Shape)v1);   //cast v1 as a Shape to add to the array of Shapes
         System.out.println(v1);
         System.out.printf("v1.getVolume(): %.2f\n", v1.getVolume());
         
         Area c0 = new Circle(10.5, "Pink", false);  // upcast
         aList.add(c0);
         sList.add((Circle)c0);  //cast c0 as a Circle to add to the array of Shapes
         System.out.println(c0);
         System.out.printf("c0.getArea(): %.2f\n", c0.getArea());
         
         Shape s0 = new Shape();
         System.out.println(s0);
	  sList.add(s0);
	  Shape s1 = new Circle(5.5, "red", false);  // Upcast Circle to Shape
         sList.add(s1);

	  Circle c1 = (Circle)s1;                   // Downcast back to Circle

	   Cube cube1 = new Cube(3.6);
	   System.out.println(cube1);
         System.out.printf("cube1.getVolume(): %.2f\n", cube1.getVolume());
         sList.add(cube1);
         

   	  Shape s3 = new Rectangle(1.0, 2.0, "red", false);   // Upcast
   	  System.out.println(s3);
   	  sList.add(s3);

   	  Rectangle r1 = (Rectangle)s3;   // downcast
   	  System.out.println(r1);
   	  sList.add(r1);

   	  Shape s4 = new Square(6.6);     // Upcast
   	  System.out.println(s4);
   	  sList.add(s4);
   	  
   	 Cylinder cyl1 = new Cylinder(2.3, 13.5);
     
   	 
   	 //sList.add(cyl1); //this causes an error because a Cylinder is not a subclass of Shape
     
   	 
   	 vList.add(cyl1);
     aList.add((Area)cyl1);
     System.out.printf("cyl1.toString(): %s\n" , cyl1);
     System.out.printf("cyl1.getArea(): %.2f\n", cyl1.getArea());
     System.out.printf("cyl1.getVolume(): %.2f\n", cyl1.getVolume());
   	  
     //FIX: declare r2 as a Rectangle pointing to a Square
     Rectangle r2 = new Square(4, "Yellow", true);

	 //Downcast Rectangle r2 to Square, what happens? May need to fix it....
     Square sq1 = (Square)r2;
        
	  sList.add(sq1);
        //populate the Area arrayList with some Circles
         for ( int i = 0 ; i < 5 ; i++ )
         {
           aList.add(new Circle(Math.random() * 5.0));
         }
           //populate the Area arrayList with some Rectangles    
         for ( int j = 0 ; j < 3; j++ )
         {
           aList.add(new Rectangle(Math.random()*4.0, Math.random()*6.0));
         }
          //populate the Area arrayList with some Squares
         for ( int k = 0; k < 4; k++ )
         {
           aList.add(new Square(Math.random()*5.0));
         }	
         
       //YOU must put some code *HERE* in order to add a few (say5) Cylinders into your 
        //aList right now:
         
         for(int m = 0; m < 5; m++)
         {
        	 aList.add(new Cylinder(Math.random()*4, Math.random()*4));
         }
         
       //populate the Volume arrayList with some cubes
         for(int m = 0; m < 5; m++)
         {
           vList.add(new Cube(Math.random()*4));
         }
         //populate the Volume arrayList with some spheres
         for(int m = 0; m < 5; m++)
         {
           vList.add(new Sphere(Math.random()*9));
         }
         System.out.println();
         printList(sList);
         System.out.println();
          System.out.printf("===List of Volume Interface Objects ===:\n");
         for(int i = 0; i < vList.size(); i++)
              System.out.printf("%d: %s\n",  i, vList.get(i));
          System.out.println();
          System.out.printf("===List of Area Interface Objects ===:\n");
         for(int i = 0; i < aList.size(); i++)
              System.out.printf("%d: %s\n",  i, aList.get(i));
         System.out.println();
         System.out.println("Invoking the printType() method: ");
	  printType(sList);
         
     }//end main
     
     public static void printList(ArrayList<Shape> list)
     {
            System.out.printf("===List of Shapes ===:\n");
            for(int i = 0; i < list.size(); i++)
            {
            	System.out.printf("%d: %s\n",  i, list.get(i));
            }


     }
     
     public static void printType(ArrayList<Shape> list)
  	 {

    	 for(int i = 0; i < list.size(); i++)
			{
    		 	if(list.get(i) instanceof Cube)
    		 		System.out.printf("It's a %s Cube!\n", list.get(i).getColor());
				
    		 	else if(list.get(i) instanceof Square)
					System.out.printf("It's a %s Square!\n", list.get(i).getColor());
				
				else if (list.get(i) instanceof Rectangle)
					System.out.printf("It's a %s Rectangle!\n", list.get(i).getColor());
				
				else if(list.get(i) instanceof Sphere)
					System.out.printf("It's a %s Sphere!\n", list.get(i).getColor());
    		 	
				else if (list.get(i) instanceof Circle)
					System.out.printf("It's a %s Circle!\n", list.get(i).getColor());
				
				else
					System.out.printf("It's a %s Shape!\n", list.get(i).getColor());
			}
     }
     
}
//end class
