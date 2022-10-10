package functionalInterface;

import java.util.List;
import java.util.function.BiConsumer;

import data.Student;
import data.StudentDataBase;

/*
 * Consumer & BiConsumer FI don't return anything (they return void)
 */
public class BiDirectionalExample {
	
	public static void main(String[] args) {
		BiConsumer<Integer,Integer> biConsumer1 = (x,y) -> x+=y;
		
		int x = 3, y=2;
		biConsumer1.accept(x, y);
		System.out.println(x+" : "+y);
		
		List<Student> studs = StudentDataBase.getAllStudents();
		BiConsumer<String, List<String>> biCons2 = (name, activityLists) -> System.out.println(name+" : "+activityLists);
		
		studs.forEach(s -> biCons2.accept(s.getName(), s.getActivities()));	
	}

}
