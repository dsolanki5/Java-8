package functionalInterface;

import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDataBase;

/*
 * Consumer & BiConsumer FI don't return anything (they return void)
 */
public class ConsumerExample {
	
	static List<Student> studs = StudentDataBase.getAllStudents();
	
	static Consumer<Student> studConsumer = (s)-> System.out.println(s);
	static Consumer<Student> studName = (s) -> System.out.println(s.getName());
	static Consumer<Student> studActivities = (s) -> System.out.println(s.getActivities()); 
	
	
	public static void printStudName() {
		List<Student> studs = StudentDataBase.getAllStudents();		
		studs.forEach(s -> System.out.println(s));
	}
	
	public static void printNameAndActivitiesUsingCondition() {
		System.out.println("printNameAndActivitiesUsingCondition: ");
		
		studs.forEach((stud -> {
			if(stud.getGpa() > 3.9) {
				studName.andThen(studActivities).accept(stud);
			}
		}));
	}
	
	public static void main(String[] args) {
		
		
		/*
		 * Get All Students
		 */
		
//		studs.forEach(studConsumer);
//		printStudName();
		
		/*
		 * Print Student Names
		 */
		
//		studs.forEach(studName); 
		    // OR
//		studs.forEach(s-> System.out.println(s.getName()));
		
		/*
		 * Print Student Name & Activites 
		 */
		studs.forEach(studName.andThen(studActivities));
		
		System.out.println();
		printNameAndActivitiesUsingCondition();
	}

}
