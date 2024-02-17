package streamsTerminal;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.collectingAndThen;

import java.util.Comparator;
import java.util.LinkedHashMap;

import data.Student;
import data.StudentDataBase;

public class StreamGroupingByExample {
	
	public static void groupStudentsByGender(){

	       Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
	                .stream()
	                .collect(groupingBy(Student::getGender));

	        System.out.println(studentMap);
	    }

	    public static void customizedGroupingBy(){

	        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
	                .stream() //Stream<Students>
	                .collect(groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" : "AVERAGE"));

	        System.out.println(studentMap);
	    }

	    public static void twoLevelGrouping_1(){

	        Map<Integer,Map<String,List<Student>>> studentMap = StudentDataBase.getAllStudents()
	                .stream()
	                .collect(groupingBy(Student::getGradeLevel,
	                        groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" : "AVERAGE")));

	        System.out.println(studentMap);
	    }

	    public static void twoLevelGrouping_2(){

	        Map<String,Integer> studentMap = StudentDataBase.getAllStudents()
	                .stream()
	                .collect(groupingBy(Student::getName, 
	                        summingInt(Student::getNoteBooks)));

	        System.out.println(studentMap);
	    }

	    public static void threeArgumentGroupBy(){

	       LinkedHashMap<String,Set<Student>> studentLinkedHashmap = StudentDataBase.getAllStudents()
	                .stream()
	                .collect(groupingBy(Student::getName,LinkedHashMap::new,toSet()));

	        System.out.println(studentLinkedHashmap);
	    }

	    /**
	     * Below are some examples of using grouping with minBy/maxBy
	     */
	    public static void calculateTopGpa(){

	        Map<Integer,Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents()
	                .stream()
	                .collect(groupingBy(Student::getGradeLevel,
	                        maxBy(Comparator.comparing(Student::getGpa))));

	       // System.out.println(studentMapOptional);

	        Map<Integer,Student> studentMapOptional1 = StudentDataBase.getAllStudents()
	                .stream()
	                .collect(groupingBy(Student::getGradeLevel,
	                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa))
	                        ,Optional::get)));

	        System.out.println(studentMapOptional1);
	    }
	    
	    public static void getCountAsPerGender() {
	    	Map<String,Long> noOfMaleFemaleMap = StudentDataBase.getAllStudents().stream()
	    			.collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
	    	
	    	System.out.println(noOfMaleFemaleMap);
	    }

	    public static void calculateleastGpa(){

	        Map<Integer,Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents()
	                .stream()
	                .collect(groupingBy(Student::getGradeLevel,
	                        minBy(Comparator.comparing(Student::getGpa))));

	        // System.out.println(studentMapOptional);

	        Map<Integer,Student> studentMapOptional1 = StudentDataBase.getAllStudents()
	                .stream()
	                .collect(groupingBy(Student::getGradeLevel,
	                        collectingAndThen(minBy(Comparator.comparing(Student::getGpa))
	                                ,Optional::get)));

	        System.out.println(studentMapOptional1);
	    }

	    public static void main(String[] args) {

//	        groupStudentsByGender();
//	        customizedGroupingBy();
	        twoLevelGrouping_1();
//	        twoLevelGrouping_2();
	        threeArgumentGroupBy();
//	        getCountAsPerGender();
	        calculateTopGpa();
//	        calculateleastGpa();

	    }

}
