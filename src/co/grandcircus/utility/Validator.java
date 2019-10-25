package co.grandcircus.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Note that Scanner seems to be discouraged for either multithreaded or
 * high-traffic applications--A. mentions that we can't use Scanner for webapps.
 * 
 * @author Antonella Solomon
 *
 */
public class Validator
{
   /**
    * Prompt for a boolean, with several different input values accepted.
    * 
    * @param prompt
    * @return
    * @author Kevin Flory
    */
   public static boolean promptForBoolean(Scanner scnr, String prompt) {
      boolean returnVal = false;
      
      System.out.println(prompt);
      
      String trueFalseString = scnr.nextLine();
      switch (trueFalseString.toLowerCase()) {
         case "true":
         case "t":
         case "1":
         case "y":
         case "yes":
         case "affirmative":
            returnVal |= true;
            break;
         case "false":
         case "f":
         case "0":
         case "n":
         case "no":
         case "negative":
            returnVal = false;
            break;
         case "get me out of here!":
            returnVal |= false;
            break;
         default:
            System.out.println("That's not a boolean value.");
            System.out.println(
                  "Acceptible values are \"true\", \"false\", \"t\", \"f\", \"1\", \"0\" and \"GET ME OUT OF HERE!.");
            System.out.println("Please try again.");
            returnVal |= promptForBoolean(scnr, prompt);
      }
      
      return returnVal;
   }
   
   /**
    * Use the specified labels to choose a boolean.
    * 
    * @author Kevin Flory
    */
   public static boolean getBooleanYN(Scanner scnr, String prompt, String yesLabel, String noLabel) {
      boolean returnVal = false;
      
      System.out.println(prompt + " (" + yesLabel + "/" + noLabel + ")");
      
      String trueFalseString = scnr.nextLine();
      if (trueFalseString.equalsIgnoreCase(yesLabel)) {
         returnVal = true;
      }
      else if (trueFalseString.equalsIgnoreCase(noLabel)) {
         returnVal = false;
      }
      else {
         System.out.println("That's not a " + yesLabel + "/" + noLabel + " value. Please try again.");
         returnVal = getBooleanYN(scnr, prompt, yesLabel, noLabel);
      }
      
      return returnVal;
   }
   
   /**
    * Get any valid integer.
    */
   public static int getInt(Scanner scnr, String prompt) {
      // This approach use "hasNext" look ahead.
      System.out.print(prompt);
      while (!scnr.hasNextInt()) {
         scnr.nextLine(); // clear bad line.
         System.out.println("Sorry, I can't read that. Enter a whole number, using digits.");
         System.out.println(prompt);
      }
      int result = scnr.nextInt();
      scnr.nextLine(); // clear for next line of input.
      return result;
   }
   
   /**
    * Prompts and waits until the user enters any valid double.
    */
   public static double getDouble(Scanner scnr, String prompt) {
      // This approach use "hasNext" look ahead.
      boolean isValid = false;
      do {
         System.out.print(prompt);
         isValid = scnr.hasNextDouble();
         if (!isValid) {
            scnr.nextLine(); // clear bad line.
            System.out.println("Sorry, I can't read that. Enter a number, using digits.");
         }
      } while (!isValid);
      
      double number = scnr.nextDouble();
      scnr.nextLine(); // clear for next line of input.
      return number;
   }
   
   /**
    * Get any string.
    */
   public static String getString(Scanner scnr, String prompt) {
      // This approach uses exception handling.
      System.out.print(prompt);
      return scnr.nextLine();
   }
   
   /**
    * Prompt and loop
    * until a valid integer between min and max is received.
    */
   public static int getInt(Scanner scnr, String prompt, int min, int max) {
      boolean isValid = false;
      int number = min - 1;
      
      do {
         number = getInt(scnr, prompt);
         
         if (number < min) {
            isValid = false;
            System.out.println("The number must be at least " + min);
         }
         else if (number > max) {
            isValid = false;
            System.out.println("The number must not be larger than " + max);
         }
         else {
            isValid = true;
         }
         
      } while (!isValid);
      return number;
   }
   
   /**
    * Get any valid double greater than or equal to min. 
    * 
    * If anything other than a
    * double is received by the scanner--or if the number is not greater than or
    * equal to min--loop until the user provides valid input. 
    */
   public static double getDoubleWithLowerBound(Scanner scnr, String prompt, double min) {
      boolean isValid = false;
      double number = min - 1;
      do {
         number = getDouble(scnr, prompt);
         
         if (number < min) {
            isValid = false;
            System.out.println("The number must be at least " + min);
         }
         else {
            isValid = true;
         }
         
      } while (!isValid);
      return number;
   }
   
   /**
    * Get any valid double between min and max. 
    */
   public static double getDouble(Scanner scnr, String prompt, double min, double max) {
      boolean isValid = false;
      double number = min - 1;

      do {
         number = getDouble(scnr, prompt);
         
         if (number < min) {
            isValid = false;
            System.out.println("The number must be at least " + min);
         }
         else if (number > max) {
            isValid = false;
            System.out.println("The number must not be larger than " + max);
         }
         else {
            isValid = true;
         }
         
      } while (!isValid);
      return number;
   }
   
   /**
    * Get a string of input from the user that must match the given regex.
    */
   public static String getStringMatchingRegex(Scanner scnr, String prompt, String regex) {
      boolean isValid = false;
      String input;
      do {
         input = getString(scnr, prompt);
         
         if (input.matches(regex)) {
            isValid = true;
         }
         else {
            System.out.println("Input must match the appropriate format.");
            isValid = false;
         }
         
      } while (!isValid);
      return input;
   }
   
}