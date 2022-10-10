package streams;

import java.util.Optional;

import data.Student;
import data.StudentDataBase;

public class FindAnyFindFirstExample {
	
	/*
	 * findAny() will return value as soon as it is found
	 * i.e, if there is a condition provided in the filter() then any element 
	 * which matches that condition first is returned and further iteration of
	 * list is stopped.
	 */
	public static Optional<Student> findAnyExample() {
//		return StudentDataBase.getAllStudents().stream()
//				.filter(stud -> stud.getGpa()>=3.9)
//				.findAny();
		
		return StudentDataBase.getAllStudents().parallelStream()
				.filter(stud -> stud.getGpa()>=3.9)
				.findAny();
	}
	
	/*
	 * findFirst() will iterate the collection and return the first element 
	 * matching the given condition in filter()
	 */
	public static Optional<Student> findFirstExample() {
//		return StudentDataBase.getAllStudents().stream()
//				.filter(stud -> stud.getGpa()>=3.9)
//				.findFirst();
		
		return StudentDataBase.getAllStudents().parallelStream()
				.filter(stud -> stud.getGpa()>=3.9)
				.findFirst();
//		return StudentDataBase.getAllStudents().stream()
//				.filter(stud -> stud.getGender().equals("female"))
//				.findFirst();
	}
	
	public static void main(String[] args) {
		/*
		 * The difference in the output is seen if you stream in parallel
		 */
		System.out.println("findAny: "+findAnyExample().get());
		
		System.out.println("findFirst: "+findFirstExample().get());
	}

}
