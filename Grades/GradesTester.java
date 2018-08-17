public class GradesTester{
	public static void main(String[] args){
		String id1 = "12345";
		String id2 = "98765";
		double[] points1 = {35, 23, 39, 33, 66};
		double[] points2 = {33, 25, 19, 36, 20};
		Grades s1 = new Grades(id1, points1);
		Grades s2 = new Grades(id2, points2);
      System.out.println("The Lowest Grade is: " + s1.getLowest()); 
      System.out.println("The Heighest Grade is: " + s1.getHeighest());
      System.out.println("The Average is: " + s1.getAvg());
      System.out.println("The Percentage is: " + s1.getPercentage() + "%");
      System.out.println("the gardes is: " + s1.getGrades(2));
      s1.setID("55555");
      System.out.println("The new ID for s1 is: " + s1.getId());
      System.out.println("Comparing data from s1 to s2: " + s1.equals(s2));
      s1.setGrades(2,  33);			 // To change the exam 2 score to 33
      System.out.println("Now the exam 2 score are  " + s1.getGrades(2));
      System.out.println("The Letter Grade is: " + s1.getLetterGrade());
      System.out.println(s1.toString());

	}
}