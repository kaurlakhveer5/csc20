public class Calculator{
	private double op1;
	private double op2;
	private char operation;
	
	
	//default construstator
	public  Calculator(){
		op1 = 0; 
		op2 = 0;
		operation = 'o';	
	}
	
	public Calculator(double first, double second, char c ){
		op1 = first;
		op2 = second;
		operation = c;		
	}
   
	public static double absValue(double a){
		return Math.abs(a);	
	}

	public  Calculator(double first){
		op1 = first;
		
	}
	
	//accessor
	public double getOp1(){
		return op1;
	}
	
	public double getOp2(){
		return op2;
	}
	
	public char getOperation(){
		return operation;
	}
	
	//mutator
	public void setOp1(double first){
		op1 = first;
	}
	public void setOp2(double second){
		op2 = second;
	}
	public void setOperation(double op){
		op = operation;
	}
	
	//Equals
	public boolean equals(Calculator other){
		if (this.op1 == other.op1 && this.op2 == other.op2 && this.operation == other.operation)
			return true;
		else 
			return false;
	}
   public double evaluate()
   {
      if (operation == '+'){
         return addition();
      } 
      else if (operation == '-'){
         return subtraction();
      }  
      else if (operation == '*'){
         return  multiplication();
      }
      else if(operation == '^'){
         return expo();
      }   
      else if(operation == '/'){
         return division();
      }
      else if (operation == '%'){
         return remainder();
      }  
      else{
         return -1;
      }    
   }
	//add functions
   //addition
	public double addition(){
		return op1 + op2;
	}
	
	// subtraction
	public double subtraction(){
		return op1-op2;
	}
	
	//multiplication
	public double multiplication(){
		return op1*op2;
	}
	
	//division
	public double division(){
		if(op2 == 0)
			return 0;
		else
			return op1/op2;
	}
	
	//remainder
	public double remainder(){
		return op1%op2;
	}
	
	//exponent
	public double expo(){
		return Math.pow(op1,op2);
	}
	
		
	//toString
	public String toString(){
		String s = "";
		s = op1 + " " + operation + " " + op2 + ": " + String.format("%.2f", this.evaluate());	
	   return s;
	}
	
		
	}