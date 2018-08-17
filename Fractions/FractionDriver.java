import java.util.*;

public class FractionDriver{
	
	public static void main(String[] args) {
		Fraction f1 = new Fraction();
		System.out.println("Tetsting mutator and toString method");
		System.out.println("After using setNumerator(12)\n");
		f1.setNumerator(12);
		System.out.println("and the toString method returned " +f1.toString());
		System.out.println("After using setDenominator(8)");
		f1.setDenominator(8);
		System.out.println("setDenominator method returned " + f1.setDenominator(8));
		System.out.println("and the tostring method returned "+f1.toString());
		
		
		System.out.println("\n\nTesting Accessor methods");
		System.out.println("Numerator = " +f1.getNumerator());
		System.out.println("Denominator = " +f1.getDenominator());
		System.out.println("Fraction = "+f1.getDoubleFraction());
		f1.getReducedFraction();
		System.out.println("Reduced Fraction = " + f1 );
		
		System.out.println("\n\nTesting equal method");
		System.out.println("f1 = 15/5 \n" +
							"f2 = 6/7\r\n" + 
							"f3 = 3/1\r\n" + 
							"f4 = 6/7\n\n ");
		f1 = new Fraction(15,5);
		Fraction f2 = new Fraction(6,7);
		Fraction f3 = new Fraction(3,1);
		Fraction f4 = new Fraction(6,8);
		f1.getReducedFraction();
		
		f2.getReducedFraction();
		f3.getReducedFraction();
		f4.getReducedFraction();
		if(f1.equall(f2))
			System.out.println("f1 is equal to f2");
		else System.out.println("f1 is NOT equal to f2");
		
		if(f1.equall(f3))
			System.out.println("f1 is equal to f3");
		else System.out.println("f1 is NOT equal to f3");
		
		if(f2.equall(f4))
			System.out.println("f2 is equal to f4");
		else System.out.println("f2 is NOT equal to f4");
		if(f3.equall(f4))
			System.out.println("f3 is equal to f4");
		else System.out.println("f3 is NOT equal to f4");
		
		

		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}