import java.io.*;
import java.util.*;
public class CalculatorTester{
   public static void main(String[] args) throws FileNotFoundException{
      Scanner input = new Scanner(new File("data.txt"));
      
      while(input.hasNextLine()){
         String text = input.nextLine();
         processLine(text);
      }
      
      double a = Calculator.absValue(-6);
      System.out.println("absolute value of -6 is " + a);
   }
   
   
   public static void processLine(String text){
      Scanner data = new Scanner(text);
      while (data.hasNext())
      {
        double num1 = data.nextDouble();     
        double num2 = data.nextDouble();   
        char op =  data.next().charAt(0); 
        Calculator c = new Calculator(num1,num2,op); 
        double result = c.evaluate();
        System.out.println(c.toString());
       }   
   }      
         
 } 
	
