package functionalInterface;

import java.util.function.Supplier;

import data.Student;

public class SupplierExample {
	
	/*
	 * Supplier is exactly opposite to Consumer
	 * Consumer accepts input parameters but returns void. accept() method is used
	 * While Supplier dont accept any input parameters but return some value/object. get() is used
	 * 
	 */
	static Supplier<String> supplier1 = () -> "Java8";
	static Supplier<Student> supplier2 = () -> new Student("Deepak");
	
	public static void main(String[] args) {
		System.out.println("Simple supplier: "+supplier1.get());
		
		System.out.println("Supplier returning Student Object : "+supplier2.get());
	}

}
