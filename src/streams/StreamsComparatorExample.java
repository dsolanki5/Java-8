package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDataBase;

public class StreamsComparatorExample {
	
	public static List<Student> getStudentSortedByName() {
		return StudentDataBase.getAllStudents().stream()
		.sorted(Comparator.comparing(Student::getName))
		.collect(Collectors.toList());
		
	}
	
	public static List<Student> getStudentByGpaDesc() {
		return StudentDataBase.getAllStudents().stream()
				.sorted(Comparator.comparing(Student::getGpa).reversed())
				.collect(Collectors.toList());
	}
	
	public static List<String> getStudentActivitiesByGpaDesc() {
		return StudentDataBase.getAllStudents()
				.stream()
				.sorted(Comparator.comparing(Student::getGpa).reversed())
				.map(Student::getActivities)
				.flatMap(List::stream)
				.distinct()
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		System.out.println("Sorted by name : "+getStudentSortedByName());
		
		System.out.println("Sorted in Desc order of GPA : "+getStudentByGpaDesc());
		
		System.out.println("Display Activities in order of top GPA(desc): "+getStudentActivitiesByGpaDesc());
	}

}
