package methodReference;

import java.util.function.Predicate;

import data.Student;
import data.StudentDataBase;

public class MethodReferenceRefactorPredicate {
	/*
	 * As we know we can't convert below predicate code to method reference directly
	 * Predicate<Student> predicate1 = (stud) -> stud.getGradeLevel() >= 3;
	 * We will instead create method in this class which will return this predicate
	 * and use Method Refernce to call this method :
	 */

//	static Predicate<Student> predicate1 = (stud) -> stud.getGradeLevel() >= 3;
	
	static Predicate<Student> predicateMethodRef = MethodReferenceRefactorPredicate::predicateMethod;
	
	static boolean predicateMethod(Student stud) {
		return stud.getGradeLevel() >= 3;
	}
	
	public static void main(String[] args) {
//		System.out.println(predicate1.test(StudentDataBase.studentSupplier.get()));
		
		System.out.println(predicateMethodRef.test(StudentDataBase.studentSupplier.get()));
			
	}
}
