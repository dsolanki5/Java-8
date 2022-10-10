package constructorReference;

import java.util.function.Function;
import java.util.function.Supplier;

import data.Student;

public class ConstructorReferenceExample {
	
	//calling default constructor
//	Supplier<Student> studSupplier = () -> new Student();	
	static Supplier<Student> studSupplier = Student::new;
	
	//calling parameter constructor
//	static Function<String, Student> fun1 = (studName) -> new Student(studName);
	static Function<String, Student> fun1 = Student::new;
	
	
	public static void main(String[] args) {
		System.out.println("Calling default constructor :s"+studSupplier.get());
		
		System.out.println("Calling parameterised constructor :  "+fun1.apply("Deepak"));
	}

}
