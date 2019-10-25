package co.grandcircus;

import java.util.LinkedList;
import java.util.Scanner;

import co.grandcircus.utility.Validator;

public class CircleApp
{
   
   public static void main(String[] args) {
      System.out.println("Welcome...to the Circle Tester!!");
      
      try (Scanner scnr = new Scanner(System.in)) {
         LinkedList<Circle> circleList = new LinkedList<>();
         
         boolean doContinue = true;
         do {
            // ● Prompt the user to enter a radius.
            double radius = Validator.getDoubleWithLowerBound(scnr, "Enter a radius: ", 0.0);
            // ● When the user enters valid data, calculate the area and circumference of
            // the
            // circle and rounds to the nearest 2 decimal places.
            circleList.add(new Circle(radius));
            // IMPLICIT: Print the circle.
            System.out.println(circleList.getLast());
            
            // ● Ask if the user wants to continue.
            doContinue = Validator.getBooleanYN(scnr, "Continue? ", "y", "n");
            
         } while (doContinue);
         
         // ● When the user quits, display a “goodbye” message that also indicates the
         // number of circles the user built.
         System.out.println("You built " + circleList.size() + " circles.");
         System.out.println("Goodbye!");
      }
   }
}
