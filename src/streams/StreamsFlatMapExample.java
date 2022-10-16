package streams;

import java.util.List;

import data.Student;
import data.StudentDataBase;

import static java.util.stream.Collectors.toList;

public class StreamsFlatMapExample {

    public static List<String> printStudentActivities(){

//        List<String> studentActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
//                .map(Student::getActivities) //Stream<List<String>
//                .flatMap(List::stream) //Stream<String>
//                .distinct()
//                .sorted()
//                .collect(toList());
//
//        return studentActivities;
    	
    	/*
    	 * Or you can pass "(e)->e.stream()" inside flatmap() to flatten anytype of collection
    	 */
    	
    	List<String> studentActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) //Stream<List<String>
                .flatMap(e->e.stream()) //Stream<String>
                .distinct()
                .sorted()
                .collect(toList());

        return studentActivities;
    }

    public static long getStudentActivitiesCount(){

        long noOfStudentActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) //Stream<List<String>
                .flatMap(List::stream) //Stream<String>
                .distinct() //Stream<String> -> with distinct function performed
                .count();

        return noOfStudentActivities;
    }


    public static void main(String[] args) {

        System.out.println("printStudentActivities : " + printStudentActivities());
        System.out.println("getStudentActivitiesCount : " + getStudentActivitiesCount());
    }
}
