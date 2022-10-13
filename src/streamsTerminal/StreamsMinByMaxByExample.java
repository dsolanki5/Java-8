package streamsTerminal;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDataBase;

public class StreamsMinByMaxByExample {
	
	/*
	 * below returns only min Gpa of student.
	 * Returns Optional<Double> 
	 */
	public static Optional<Double> getMinGpa() {
		return StudentDataBase.getAllStudents().stream()
				.reduce((s1,s2) -> s1.getGpa() < s2.getGpa() ? s1:s2)
				.map(Student::getGpa);
	}
	
	/*
	 * below returns Student with min Gpa
	 * Returns Optional<Student>
	 */
	public static Optional<Student> getStudentWithMinGpa() {
		return StudentDataBase.getAllStudents().stream()
				.collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
	}
	
	public static void main(String[] args) {
		System.out.println("Get min gpa : "+getMinGpa());
		
		System.out.println("Get Student having Min Gpa: "+getStudentWithMinGpa());
	}

}
