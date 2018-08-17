public class Grades{
	
	//instances variables
	private String id;
	private double[] grades;
   private double sum = 0;
   private double low = Integer.MAX_VALUE;
   private double high = Integer.MIN_VALUE;
   
   //default construstator
   public Grades(){
	   id = "";
	   grades =  new double []{};
  }
   
   
	//construstatiors
	public Grades(String id, double[] g){
		this.id  = id;
      grades = g;
	}
	
	public double getGrades(int index){
		return grades[index-1];
	}
	
		
	public String getId(){
		return this.id;
	}
	public void setID(String newId){
		this.id = newId;
	}
	public void setGrades(int index, double newGrade){
		this.grades[index-1] = newGrade;
	}
		public boolean equals(Grades other){
		if(this.id == other.id)
         return true;
      else 
         return false;
	}
	public double getAvg(){
		double grade = 0;
      for(int i = 0; i < grades.length; i++){
         grade = grade + grades[i];
      }
      sum = grade;
      return sum/(grades.length);
	   
	}
	public double getLowest(){
		for(int i = 0; i <grades.length; i++)
         if(grades[i] < low)
            low = grades[i];
            return low;
	}
	public double getHeighest(){
		for(int i = 0; i<grades.length; i++)
         if(grades[i] > high)
            high = grades[i];
         return high;
	}
	
	public double getPercentage(){
		
		return (sum/(grades.length * 40)*100);
	}
	
	public char getLetterGrade(){
		if(getPercentage() >= 90)
			return 'A';
		else if (getPercentage() >= 80)
			return 'B';
		else if(getPercentage() >= 70)
			return 'C';
		else if(getPercentage() >= 60)
			return 'D';
		else
			return 'F';
	}
   
   public String toString(){
		String s = "\nID: " + id+ "\t";
		s = s+ " Grads are ";
		for (int i = 0; i <grades.length; i++){
			s = s + grades[i] + ", ";}
		s = s + "\t Average: " + getAvg() + " \t Lowest: " + getLowest() + " \t Heighest: " + getHeighest()
                  + "\nPercentage: " + getPercentage() + "%" +"\t Grade: " + getLetterGrade();
	
		return s;
	}

	
}