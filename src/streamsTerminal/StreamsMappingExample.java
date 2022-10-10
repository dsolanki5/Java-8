package streamsTerminal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDataBase;

public class StreamsMappingExample {
	
	public static List<String> getAllStudNamesUsingMapping() {
		return StudentDataBase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName, Collectors.toList()));
	}
	
	public static Set<String> getAllStudActUsingMapping() {
//		return StudentDataBase.getAllStudents().stream()
//				.map(Student::getActivities)
//				.flatMap(List::stream)
//				.collect(Collectors.toSet());
		
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getActivities)
				.collect(Collectors.flatMapping(List::stream, Collectors.toSet()));
				
	}
	
	public static void main(String[] args) {
		
		System.out.println("get List of Stud Names : "+getAllStudNamesUsingMapping());
		
		System.out.println("get distinct Activities: "+getAllStudActUsingMapping());
		
	}

}
