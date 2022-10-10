package functionalInterface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import data.Student;
import data.StudentDataBase;

public class PredicateAndConsumerExample {
	
	static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;
    static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    BiConsumer<String,List<String>> studentBiConsumer = (name,activities) -> System.out.println(name + " : " + activities);
    BiPredicate<Integer, Double> biPredicate1 = (gradeLevel, gpa) -> gradeLevel >=3 && gpa >= 3.9;

    Consumer<Student> studentConsumer =(student -> {

        if(p1.and(p2).test(student)){
            studentBiConsumer.accept(student.getName(),student.getActivities());
        }
    });
    
    Consumer<Student> studConsumer2 = (stud -> {
    	if(biPredicate1.test(stud.getGradeLevel(), stud.getGpa())) {
    		studentBiConsumer.accept(stud.getName(), stud.getActivities());
    	}
    });


    public void printNameAndActivities(List<Student> students){

        students.forEach(studentConsumer);
    }
    
    public void printAsPerGradeAndGpa(List<Student> students) {
//    	students.forEach(studConsumer2);
    	
    	students.forEach(stud -> {
    		if(biPredicate1.test(stud.getGradeLevel(), stud.getGpa())) {
    			System.out.println(stud.getName()+" "+ stud.getActivities());
    			System.out.println(stud.getGradeLevel()+" | "+stud.getGpa());
    		}
    	});
    }

    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();

//        new PredicateAndConsumerExample().printNameAndActivities(studentList);
        
        new PredicateAndConsumerExample().printAsPerGradeAndGpa(studentList);
    }

}
