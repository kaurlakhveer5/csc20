public class Fraction{
	
	//instance variable
	private int numerator;
	private int denominator;

	// default constructor
	public Fraction() {
		
		numerator = 0;
		this.denominator = 0;
		
	}
	// constructors
	public Fraction(int num, int denom) {
		numerator = num;
		denominator = denom;
		
		
		
	}
	
	// mutators
	public void setNumerator(int newNumerator){
		numerator = newNumerator;
		
		
	}
	
	public boolean setDenominator(int newDenominator){
		boolean success = true;
		
		if(newDenominator != 0) {
		denominator = newDenominator;
		}
		else {
			success = false;
			
		}

		return success;
		
	}
	
	//Accessors
	public int getNumerator() {
		
		return numerator;
		
		
	}
	
	public int getDenominator() {
		
		return denominator;
		
		
	}
	
	public double getDoubleFraction() {
		
		return (double)((double)numerator/(double)denominator);
		
	}
	
	
	public int getReducedFraction() {
		
		int common = gcd();
		//if(denominator != 0) {
		numerator = numerator/common;
		denominator = denominator/common;
		//else denominator  = denominator;
		return (this.numerator & this.denominator);
	}
	
	public int gcd() {
		int x = numerator;
		int y = denominator;
		 int r;
		    while (y!=0) {
		        r = x%y;
		        x = y;
		        y = r;
		    }		    
		  return x;
	}
	
	
	
	
	
	
	 public boolean equall(Fraction otherFraction)
	   {
		 boolean success = false;
		if(this.numerator == otherFraction.numerator && this.denominator == otherFraction.denominator) {
			success = true;
		}
		else success = false;
		return success;
		
	   }

	
	
	  public String toString()
	   {
	      String s = "";
	     s = s+ numerator + "/"+denominator;
	      return s;
	   }


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}