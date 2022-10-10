package streams;

import data.StudentDataBase;

public class StreamsMatchExample {
	
	public static boolean anyMatchExample() {
		return StudentDataBase.getAllStudents().stream()
				.anyMatch(stud -> stud.getGpa()>3.9);
	}
	
	public static boolean allMatchExample() {
		return StudentDataBase.getAllStudents().stream()
				.allMatch(stud -> stud.getNoteBooks()>10);
	}
	
	public static boolean noneMatchExample() {
		return StudentDataBase.getAllStudents().stream()
				.noneMatch(stud -> stud.getActivities().contains("cricket"));
	}
	
	public static void main(String[] args) {
		// Returns true, if any element in list matches the given condition(or Predicate)
		System.out.println("AnyMatch: "+anyMatchExample()); 
		
		// Returns true, if all elements of list matches the given condition(or Predicate)
		System.out.println("AllMatch: "+allMatchExample());
		
		// Returns true, if no elements matches the given condition
		System.out.println("NoneMatch: "+noneMatchExample());
	}

}
