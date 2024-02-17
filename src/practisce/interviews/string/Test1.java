package practisce.interviews.string;

class Student extends Person1 {
	private int rollno;
	private String name;
	private float mathMarks;
	private float computerMarks;
	private static final float TOTALMARK = 200;
	
	public void setRollNo(int rollno) {
		this.rollno=rollno;
	}
	
	public void setName(String name ) {
		this.name=name;
		
	}
	
	public void setMathMarks(float MathMarks)
	{
		this.mathMarks=MathMarks;
	}
	
	public void setComputerMarks(float computerMarks) {
		this.computerMarks=computerMarks;
	}
	
	public int getRollno() {
		return rollno;
	}
	
	public String getName() {
		return name;
	}
	
	public float getMathMarks() {
		return mathMarks;
	}
	
	public float getComputerMarks( ) {
		return computerMarks;
	}
	
	public double calcPercentage(float mathMarks,float computerMarks) {
		float marks= mathMarks+computerMarks;
		double percentage=(marks/TOTALMARK)*100;
		return percentage;
	}

	@Override
	void method3() {
		System.out.println("m3");
	}	
	
}

abstract class Person1 {
	
	Person1(){
		System.out.println("abst Constructor");
	}
	
	void method1() {
		System.out.println("m1");
	}
	
	void method2() {
		System.out.println("m2");
	}
	
	abstract void method3();
}

public class Test1 {
	public static void main(String[] args) {
		Student marks = new Student();        
//		marks.setRollNo(1);
//		marks.setName("jeeni");
//		marks.setMathMarks(70);
//		marks.setComputerMarks(80);
//		
//		int mark_rollno=marks.getRollno();
//		System.out.println(mark_rollno);
//		
//		String mark_name=marks.getName();
//		System.out.println(mark_rollno);
//		
//		float math_mark=marks.getMathMarks();
//		System.out.println(math_mark);
//		
//		float computer_marks=marks.getComputerMarks();
//		System.out.println(computer_marks);
//		
//		double d=marks.calcPercentage(math_mark, computer_marks);
//		System.out.println(d);
		
//		marks.method3();
//		
//		String str = "knowledge";
//		String s = str;
//		
//		str = str.concat(" base");
//		
//		System.out.println(str);
//		System.out.println(s);
		
		String prodNo = "adc123#xyz";
		
		if(prodNo.contains("#")) {
			prodNo = prodNo.substring(0,prodNo.indexOf('#'));
		}
		System.out.println("prodNo:: "+prodNo);
		
		
	}

}
