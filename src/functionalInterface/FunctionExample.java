package functionalInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import data.Student;
import data.StudentDataBase;

public class FunctionExample {
	
	// In Function, 1st parameter is Input type and 2nd paramter is output type
	static Function<String, String> fun1 = (str) -> str.toUpperCase();
	static Function<String, String> fun2 = str -> str.toUpperCase().concat("new");
	static Function<String,String> addSomeString = (name) -> name.toUpperCase().concat("default");
	
	// Student using Function : 
			static Function<List<Student>, Map<String,Double>> funStudent = (students -> {
				
				Map<String,Double> hm = new HashMap<>();
				students.forEach(stud -> {
					if(PredicateAndConsumerExample.p1.test(stud)) {
						hm.put(stud.getName(), stud.getGpa());
					}
				});
				return hm;
			});
	
	/*
	 * BiFunction and Student Example :
	 * In BiFunction there are total 3 paramters, 1st two parameters are Input type and 
	 * third parameter is output type
	 * 
	 */
	
	static BiFunction<List<Student>,Predicate<Student>,Map<String,Double>> biFunction = ((students, studentPredicate) -> {

        Map<String,Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if(studentPredicate.test(student)){
                studentGradeMap.put(student.getName(),student.getGpa());
            }
        });
        return  studentGradeMap;
    });
	
	public static void main(String[] args) {
		String str = "java8";
		String ans = "";
//		ans = fun1.apply(str);
//		ans = fun1.andThen(fun2).apply(str);
		
		/*
		 * andThen will execute Left to Right functions & 
		 * compose will execute Right to Left functions
		 */
		ans = fun1.compose(fun2).apply(str);
	
		System.out.println(ans);
		
		System.out.println(funStudent.apply(StudentDataBase.getAllStudents()));
		
		System.out.println("\n *** Bi Function*** ");
		System.out.println(biFunction.apply(StudentDataBase.getAllStudents(),PredicateAndConsumerExample.p1));
				
	}

}
