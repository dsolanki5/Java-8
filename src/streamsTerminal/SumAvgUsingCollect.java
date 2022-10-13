package streamsTerminal;

import java.util.stream.Collectors;

import data.Student;
import data.StudentDataBase;

public class SumAvgUsingCollect {
	
	public static int getTotalNotebooks() {
		return StudentDataBase.getAllStudents().stream()
				.collect(Collectors.summingInt(Student::getNoteBooks));
	}
	
	public static double getAvgNotebooks() {
		return StudentDataBase.getAllStudents().stream()
				.collect(Collectors.averagingInt(Student::getNoteBooks));
	}
	
	public static void main(String[] args) {
		System.out.println("Total Notebooks : "+getTotalNotebooks());
		
		System.out.println("Avg Notebooks: "+getAvgNotebooks());
	}

}
